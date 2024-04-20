package com.tn.controller;

import com.tn.CrudAccount;
import com.tn.CrudProduct;
import com.tn.reg.productReg;
import com.tn.reponsitory.CrudProductReponsitory;
import jakarta.persistence.PersistenceUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("crudproduct")
public class crudProductController {
    @Autowired
    public CrudProductReponsitory productRepo;

    @GetMapping("getAll")
    public ResponseEntity<?> getAll() {
        List<CrudProduct> crudProducts = productRepo.findAll();
        return new ResponseEntity<>(crudProducts, HttpStatus.OK);
    }

    @PostMapping("createPr")
    public ResponseEntity<?> createPr (@RequestBody CrudProduct crudProduct) {
        productRepo.save(crudProduct);
        return new ResponseEntity<>("Create success" + crudProduct, HttpStatus.OK);
    }

    @PutMapping("updatePr/{id}")
    public ResponseEntity<?> updatePr (@PathVariable Integer id,
                                       @RequestBody productReg productReg) {
        CrudProduct crudProduct = productRepo.findById(id).orElse(null);
        if (crudProduct != null) {
            crudProduct.setTen_sanpham(productReg.getTen_sanpham());
            crudProduct.setPrice(productReg.getPrice());
            crudProduct.setSo_luong(productReg.getSo_luong());
            crudProduct.setChat_luong(productReg.getChat_luong());
            productRepo.save(crudProduct);
            return new ResponseEntity<>("Update success" + crudProduct, HttpStatus.OK);
        }
        return new ResponseEntity<>("Fail", HttpStatus.OK);
    }

    @DeleteMapping("deletePr/{id}")
    public ResponseEntity<?> deletePr (@PathVariable Integer id) {
        productRepo.deleteById(id);
        return new ResponseEntity<>("Delete success", HttpStatus.OK);
    }
}
