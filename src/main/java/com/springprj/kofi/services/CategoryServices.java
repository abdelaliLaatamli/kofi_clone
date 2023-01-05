package com.springprj.kofi.services;

import com.springprj.kofi.Repositories.CategoryRepository;
import com.springprj.kofi.models.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServices {

    private CategoryRepository categoryRepository;
    public List<Category> getCategories(){
        return categoryRepository.findAll();
    }
}
