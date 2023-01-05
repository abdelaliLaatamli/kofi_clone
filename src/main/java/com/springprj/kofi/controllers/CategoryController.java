package com.springprj.kofi.controllers;

import com.springprj.kofi.models.Category;
import com.springprj.kofi.responses.CategoryResponse;
import com.springprj.kofi.services.CategoryServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/category")
public class CategoryController {

    private CategoryServices categoryServices;

    private ResponseEntity<List<CategoryResponse>> getCategories(){
        List<Category> getCategories = categoryServices.getCategories();

        List<CategoryResponse> getCategoriesResponse = new ArrayList<CategoryResponse>();
        for( Category i : getCategories ){
            getCategoriesResponse.add( CategoryResponse.builder().id(i.getId()).name(i.getName()).build() );
        }

        return ResponseEntity.ok(getCategoriesResponse);
    }

}
