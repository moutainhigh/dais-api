package com.dais.websocket;

import com.common.pojo.ResultModel;
import com.common.utils.JsonUtils;
import com.dais.bean.ChatRoomQueueBean;
import com.dais.storage.ChatRoomMsgStorage;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ServerEndpoint 注解是一个类层次的注解，它的功能主要是将目前的类定义成一个websocket服务器端,
 * 注解的值将被用于监听用户连接的终端访问URL地址,客户端可以通过这个URL来连接到WebSocket服务器端
 */
@ServerEndpoint("/websocketchatroom/{param}")
public class WebSocketChatRoom {
	private static int onlineCount = 0;
	private static CopyOnWriteArraySet<WebSocketChatRoom> webSocketSet = new CopyOnWriteArraySet<WebSocketChatRoom>();
	private Session session;

	//异步发送所有在线用户消息
	private static Queue<ChatRoomQueueBean> chatRoomQueue = new ConcurrentLinkedQueue<>();
	private ExecutorService fixedThreadPool = Executors.newFixedThreadPool(8);
	private ChatRoomQueueBean chatRoomQueueBean = null;

	/**
	 * 连接建立成功调用的方法
	 * @param session  可选的参数。session为与某个客户端的连接会话，需要通过它来给客户端发送数据
	 */
	@OnOpen
	public void onOpen(Session session){
		this.session = session;
		webSocketSet.add(this);     //加入set中
		addOnlineCount();           //在线数加1
		System.out.println("有新连接加入！当前在线人数为" + getOnlineCount());
	}

	/**
	 * 连接关闭调用的方法
	 */
	@OnClose
	public void onClose(){
		webSocketSet.remove(this);  //从set中删除
		subOnlineCount();           //在线数减1
		System.out.println("有一连接关闭！当前在线人数为" + getOnlineCount());
	}

	/**
	 * 收到客户端消息后调用的方法
	 * @param message 客户端发送过来的消息
	 * @param session 可选的参数
	 */
	@OnMessage
	public void onMessage(@PathParam(value="param") String token,String message, Session session) {
		System.out.println("来自客户端的消息:" + message);
		ResultModel resultModel = ChatRoomMsgStorage.ckeckMsg(token,message);
		try {
			session.getBasicRemote().sendText(JsonUtils.objectToJson(resultModel));
			if(resultModel.getStatus() != 444 && resultModel.getStatus() != 401){
				chatRoomQueueBean = new ChatRoomQueueBean();
				chatRoomQueueBean.setSession(session);
				chatRoomQueueBean.setResultModel(resultModel);
				chatRoomQueue.add(chatRoomQueueBean);
            }
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 发生错误时调用
	 * @param session
	 * @param error
	 */
	@OnError
	public void onError(Session session, Throwable error){
		System.out.println("发生错误");
		error.printStackTrace();
	}

	/**
	 * 这个方法与上面几个方法不一样。没有用注解，是根据自己需要添加的方法。
	 * @param message
	 * @throws IOException
	 */
	public synchronized void sendMessage(String message) throws IOException{
		this.session.getBasicRemote().sendText(message);
		//this.session.getAsyncRemote().sendText(message);
	}

	public void send(){
		for (int i = 0; i < 8; i++) {
			fixedThreadPool.execute(new Runnable() {
				public void run() {
					try {
						ChatRoomQueueBean chatRoomQueueBean = null;
						while (true){
							if((chatRoomQueueBean = chatRoomQueue.poll()) != null){
								for(WebSocketChatRoom item: webSocketSet){
									try {
										if(chatRoomQueueBean.getSession() != item.session){
											item.sendMessage(JsonUtils.objectToJson(chatRoomQueueBean.getResultModel()));
										}
									} catch (IOException e) {
										e.printStackTrace();
										continue;
									}
								}
							}
							Thread.sleep(100);
						}
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			});
		}
	}

	public static synchronized int getOnlineCount() {
		return onlineCount;
	}

	public static synchronized void addOnlineCount() {
		WebSocketChatRoom.onlineCount++;
	}

	public static synchronized void subOnlineCount() {
		WebSocketChatRoom.onlineCount--;
	}
}
