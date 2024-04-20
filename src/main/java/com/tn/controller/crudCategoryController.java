package com.tn.controller;


import com.tn.CrudCategory;
import com.tn.reg.categoryReg;
import com.tn.reponsitory.CrudCategoryReponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("crudcategory")
public class crudCategoryController {
    @Autowired
    public CrudCategoryReponsitory categoryRepo;

    @GetMapping("getAll")
    public ResponseEntity<?> getAll () {
        List<CrudCategory> crudCategories = categoryRepo.findAll();
        return new ResponseEntity<>(crudCategories, HttpStatus.OK);
    }

    @PostMapping("createCg")
    public ResponseEntity<?> createCg (@RequestBody CrudCategory crudCategory) {
        categoryRepo.save(crudCategory);
        return new ResponseEntity<>("Create success" + crudCategory, HttpStatus.OK);
    }

    @PutMapping("updateCg/{id}")
    public ResponseEntity<?> updateCg (@PathVariable Integer id,
                                       @RequestBody categoryReg categoryReg) {
        CrudCategory crudCategory = categoryRepo.findById(id).orElse(null);
        if (crudCategory != null) {
            crudCategory.setCategoryName(categoryReg.getCategoryName());
            categoryRepo.save(crudCategory);
            return new ResponseEntity<>("Update success" + crudCategory, HttpStatus.OK);
        }
        return new ResponseEntity<>("Fail", HttpStatus.OK);
    }

    @DeleteMapping("deleteCg/{id}")
    public ResponseEntity<?> deleteCg (@PathVariable Integer id) {
        categoryRepo.deleteById(id);
        return new ResponseEntity<>("Delete success", HttpStatus.OK);
    }
}
