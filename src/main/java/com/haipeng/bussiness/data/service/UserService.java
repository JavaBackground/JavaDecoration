package com.haipeng.bussiness.data.service;

import com.haipeng.bussiness.data.model.response.ResponseUser;

public interface UserService {
    Iterable<ResponseUser> getAllSuperUser();
}
