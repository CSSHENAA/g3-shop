package com.soft.service;

import com.soft.entity.Manager;

public interface BackLoginService
{
    public Manager login(String user, String pass) throws Exception;

}
