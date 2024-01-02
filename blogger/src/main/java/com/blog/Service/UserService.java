package com.blog.Service;

import com.blog.entity.User;
import com.blog.playload.UserDto;

public interface UserService {
    User Userdetails(UserDto userDto);
}
