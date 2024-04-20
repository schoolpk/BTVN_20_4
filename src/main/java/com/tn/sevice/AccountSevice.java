package com.tn.sevice;

import org.apache.catalina.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public interface AccountSevice extends UserDetailsService {
}
