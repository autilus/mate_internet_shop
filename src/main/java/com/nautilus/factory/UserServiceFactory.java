package com.nautilus.factory;

import com.nautilus.service.UserService;
import com.nautilus.service.UserServiceImpl;

public class UserServiceFactory {
    private static UserService instance;

    private UserServiceFactory() {
    }

    public static UserService getUserService() {
        if (instance == null) {
            instance = new UserServiceImpl();
        }
        return instance;
    }
}
