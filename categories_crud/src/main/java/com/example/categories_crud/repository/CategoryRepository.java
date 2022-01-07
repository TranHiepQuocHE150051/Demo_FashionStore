package com.example.categories_crud.repository;

import com.example.categories_crud.model.categories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<categories,Integer> {
}
