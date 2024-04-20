package com.tn.controller;


import com.tn.CrudAccount;
import com.tn.reg.accountReg;
import com.tn.reponsitory.CrudAccountReponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("crudaccount")

public class crudAccountController {
    @Autowired
    public CrudAccountReponsitory accountRepo;

    @GetMapping("getAll")
    public ResponseEntity<?> getAll() {
            List<CrudAccount> crudAccounts = accountRepo.findAll();
            return new ResponseEntity<>(crudAccounts, HttpStatus.OK);
    }

    @GetMapping("getById/{id}")
    public ResponseEntity<?> getId (@PathVariable Integer id) {
        CrudAccount crudAccount = accountRepo.findById(id).orElse(null);

        if (crudAccount == null){
            return  new ResponseEntity<>("Not found id", HttpStatus.OK);
        }
        return new ResponseEntity<>(crudAccount, HttpStatus.OK);
    }

    @PostMapping("createAt")
    public ResponseEntity<?> createAt (@RequestBody CrudAccount crudAccount) {
        String password = new BCryptPasswordEncoder().encode(crudAccount.getPassword());
        crudAccount.setPassword(password);
        accountRepo.save(crudAccount);
        return new ResponseEntity<>("Create success" + crudAccount, HttpStatus.OK);
    }

    @PutMapping("updateAt/{id}")
    public ResponseEntity<?> updateAt (@PathVariable Integer id,
                                       @RequestBody accountReg accountReg) {
        CrudAccount crudAccount = accountRepo.findById(id).orElse(null);
        if (crudAccount != null) {
            crudAccount.setFullName(accountReg.getFullName());
            crudAccount.setUsername(accountReg.getUsername());
            crudAccount.setPassword(accountReg.getPassword());
            String password = new BCryptPasswordEncoder().encode(crudAccount.getPassword());
            crudAccount.setPassword(password);
            crudAccount.setEmail(accountReg.getEmail());
            accountRepo.save(crudAccount);
            return new ResponseEntity<>("Success" + crudAccount, HttpStatus.OK);
        }
        return new ResponseEntity<>("Fail", HttpStatus.OK);
    }

    @DeleteMapping("deleteAt/{id}")
    public ResponseEntity<?> deleteAt (@PathVariable Integer id) {
        accountRepo.deleteById(id);
        return new ResponseEntity<>("Delete success", HttpStatus.OK);
    }

}
