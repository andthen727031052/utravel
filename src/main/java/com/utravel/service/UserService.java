package com.utravel.service;

import com.utravel.common.JsonBean;
import com.utravel.domain.User;

public interface UserService {
    public User login(User user);

    public void refister(User user);
    public void updateUser(User user);
}
