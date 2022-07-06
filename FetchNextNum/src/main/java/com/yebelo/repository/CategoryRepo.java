package com.yebelo.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.yebelo.table.CategoryTable;

@Repository
public interface CategoryRepo extends JpaRepository<CategoryTable, String>{

	@Transactional
	@Modifying
	@Query(value="update category c set c.value = :value where c.category_code = :category_code", nativeQuery = true)
	void updateValue(@Param("category_code") String category_code, @Param("value") String value);
	
}
