package com.khudnitski.library.service.factory.impl;

public class ServiceFactoryImpl {

    private static final ServiceFactoryImpl instance = new ServiceFactoryImpl();

    public static ServiceFactoryImpl getInstance(){
        return instance;
    }

    private ServiceFactoryImpl() {
    }
}
