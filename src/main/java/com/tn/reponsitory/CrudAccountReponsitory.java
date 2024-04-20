package com.tn.reponsitory;


import com.tn.CrudAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CrudAccountReponsitory  extends JpaRepository<CrudAccount, Integer> {

    List<CrudAccount> findById(int id);

    CrudAccount findByUsername(String username);


}
