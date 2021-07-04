package com.nautilus.factory;

import com.nautilus.service.GoodService;
import com.nautilus.service.GoodServiceImpl;

public class GoodServiceFactory {
    private static GoodService instance;

    public GoodServiceFactory() {
    }

    public static GoodService getProductService() {
        if (instance == null) {
            instance = new GoodServiceImpl();
        }
        return instance;
    }
}
