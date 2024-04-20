package com.tn.reponsitory;

import com.tn.CrudCategory;
import org.hibernate.query.criteria.JpaCoalesce;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CrudCategoryReponsitory extends JpaRepository<CrudCategory, Integer> {
}
