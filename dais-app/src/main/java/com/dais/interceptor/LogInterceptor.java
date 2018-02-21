package com.dais.interceptor;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author GanZhen
 * @version 2017- 04- 20 10:07
 * @description
 * @copyright www.zhgtrade.com
 */
public class LogInterceptor implements HandlerInterceptor {

    private Logger accessLogger = Logger.getLogger("accessLog");

    private Long TIME_FLAG = 1L;
    /**
     * 起始时间的变量
     * 使用TreadLocal做线程隔离
     */
    private ThreadLocal<Long> startTimeThreadLocal = new ThreadLocal<>();
    private ThreadLocal<Long> uriThreadLocal = new ThreadLocal<>();
    private ThreadLocal<Long> ipThreadLocal = new ThreadLocal<>();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods",
                "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with");

        Long startTime = System.currentTimeMillis();
        startTimeThreadLocal.set(startTime);

        accessLogger.info("From " + request.getRemoteAddr() + " access " + request.getRequestURI());
        return true;
    }


    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }


    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        Long endTime = System.currentTimeMillis();
        Long startTime = startTimeThreadLocal.get();
        Long consumeTime = endTime - startTime;
        if(consumeTime > TIME_FLAG){
            accessLogger.info("From " + request.getRemoteAddr() + " access " + request.getRequestURI() + " consume " + consumeTime + " millis");
        }
    }
}
