package com.gxa.service.impl;

import com.gxa.service.UserService;

public class UserServiceImpl implements UserService {

    @Override
    public void add() {
        System.out.println("用户添加");
    }

    @Override
    public void delete() {
        System.out.println("用户删除");
    }

    @Override
    public void update() {
        System.out.println("用户修改");
    }

}
