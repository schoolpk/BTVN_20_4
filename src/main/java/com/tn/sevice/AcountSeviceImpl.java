package com.tn.sevice;

import com.tn.CrudAccount;
import com.tn.reponsitory.CrudAccountReponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class AcountSeviceImpl implements AccountSevice{
    @Autowired
    public CrudAccountReponsitory accountRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        CrudAccount crudAccount = accountRepo.findByUsername(username);
        if (crudAccount == null){
            throw new UsernameNotFoundException("Not Found Account");
        }

        return new User(username, crudAccount.getPassword(), Collections.emptyList());
    }
}
