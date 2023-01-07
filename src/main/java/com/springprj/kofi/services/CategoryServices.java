package com.springprj.kofi.services;

import com.springprj.kofi.Repositories.CategoryRepository;
import com.springprj.kofi.models.Category;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryServices {

    private final CategoryRepository categoryRepository;
    public List<Category> getCategories(){
        return categoryRepository.findAll();
    }

}
