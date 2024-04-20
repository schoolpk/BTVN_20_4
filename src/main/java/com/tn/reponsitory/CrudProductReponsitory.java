package com.tn.reponsitory;

import com.tn.CrudProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CrudProductReponsitory extends JpaRepository<CrudProduct, Integer> {
}
