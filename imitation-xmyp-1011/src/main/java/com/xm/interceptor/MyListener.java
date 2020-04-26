package com.xm.interceptor; /**
 * @description
 * @author: Specime
 * @date:2020/1/6
 */

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.ArrayList;
import java.util.List;

//登录
@WebListener
public class MyListener implements ServletContextListener,
        HttpSessionListener, HttpSessionAttributeListener {

    private ServletContext application;

    /**
     * @see，session创建时执行
     */
    public void sessionCreated(HttpSessionEvent arg0) {
        HttpSession session = arg0.getSession();
        session.setMaxInactiveInterval(2000);
        System.out.println("sessionCreated id:" + session.getId());
    }

    /**
     * @see，session销毁时执行
     */
    public void sessionDestroyed(HttpSessionEvent arg0) {
        HttpSession session = arg0.getSession();
        System.out.println("sessionDestroyed id:" + session.getId());

        //注销或session到期 1、从application中移除  2、改变数据库表列的值
        String username = (String) session.getAttribute("vsers");
        List<String> users = (List<String>) application.getAttribute("vsers");
        if (users.contains(username)) {
            users.remove(username);
        }
    }


    /**
     * @see，application创建时执行
     */
    public void contextInitialized(ServletContextEvent arg0) {
        System.out.println("application创建");
        this.application = arg0.getServletContext();
        //在线用户users
        application.setAttribute("vsers", new ArrayList<String>());
    }


    /**
     * @see，application销毁时执行
     */
    public void contextDestroyed(ServletContextEvent arg0) {
        System.out.println("application销毁");

    }
}
