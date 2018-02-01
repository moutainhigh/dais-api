package com.dais.websocket;


import com.common.utils.SpringContextUtils;
import com.dais.model.AddressPool;
import com.dais.storage.PrivateChatMsgStorage;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @ServerEndpoint 注解是一个类层次的注解，它的功能主要是将目前的类定义成一个websocket服务器端,
 * 注解的值将被用于监听用户连接的终端访问URL地址,客户端可以通过这个URL来连接到WebSocket服务器端
 */
@ServerEndpoint("/websocketprivatechat/{param}")
public class WebSocketPrivateChat {

	private static int onlineCount = 0;
	private  static ConcurrentMap<String,Session> webSocketMap = new ConcurrentHashMap<>();

	/**
	 * 连接建立成功调用的方法
	 * @param session  可选的参数。session为与某个客户端的连接会话，需要通过它来给客户端发送数据
	 */
	@OnOpen
	public void onOpen(@PathParam(value="param") String token , Session session){
		webSocketMap.put(token,session);
		addOnlineCount();//在线数加1
		System.out.println("有新连接加入！当前在线人数为," + getOnlineCount()+" token:"+token);
		SpringContextUtils.getBean(PrivateChatMsgStorage.class).ckeckPushErrorMsg(token);
	}

	/**
	 * 连接关闭调用的方法
	 */
	@OnClose
	public void onClose(@PathParam(value="param") String token, Session session){
		webSocketMap.remove(token);  //从map中删除
		subOnlineCount();           //在线数减1
		System.out.println("有一连接关闭！当前在线人数为" + getOnlineCount()+" token:"+token);
	}

	/**
	 * 收到客户端消息后调用的方法
	 * @param jsonMessage 客户端发送过来的消息
	 * @param session 可选的参数
	 */
	@OnMessage
	public void onMessage(String jsonMessage, @PathParam(value="param") String token,Session session) {
		webSocketMap.put(token,session);
		SpringContextUtils.getBean(PrivateChatMsgStorage.class).ckeckMsg(token,jsonMessage);
		System.out.println("来自客户端的消息:" + jsonMessage);
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
	public static boolean sendMessage(String token, String message){
		try {
			Session session = webSocketMap.get(token);
			if(session != null){
				session.getBasicRemote().sendText(message);
				return true;
			}
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}

	public static synchronized int getOnlineCount() {
		return onlineCount;
	}

	public static synchronized void addOnlineCount() {
		WebSocketPrivateChat.onlineCount = webSocketMap.size();
	}

	public static synchronized void subOnlineCount() {
		WebSocketPrivateChat.onlineCount = webSocketMap.size();
	}
}
