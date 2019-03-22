package com.module.user.common;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class InitServletContextListener
        implements ServletContextListener {
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        InitAction.init();
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {
    }
}