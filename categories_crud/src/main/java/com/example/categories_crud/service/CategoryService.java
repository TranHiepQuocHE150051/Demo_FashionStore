package com.example.categories_crud.service;

import com.example.categories_crud.model.categories;
import com.example.categories_crud.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository repo;
    public List<categories> getAllCategory() {
        return repo.findAll();
    }

    public void saveCate(categories cate) {
        repo.save(cate);
    }

    public categories getCatebyId(int id) {
        return repo.getById(id);
    }

    public void deleteCate(int id) {
        repo.deleteById(id);
    }
}
