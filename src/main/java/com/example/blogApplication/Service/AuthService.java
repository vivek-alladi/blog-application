package com.example.blogApplication.Service;

import com.example.blogApplication.Payload.LoginDto;
import com.example.blogApplication.Payload.RegisterDto;

public interface AuthService {
    String login(LoginDto loginDto);

    String register(RegisterDto registerDto);
}
