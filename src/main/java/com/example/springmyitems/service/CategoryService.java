package com.example.springmyitems.service;


import com.example.springmyitems.entity.Category;
import com.example.springmyitems.repository.CategoryRepasitory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

  private final CategoryRepasitory categoryRepasitory;



    public Category save(Category category) {
        return categoryRepasitory.save(category);
    }

    public void deleteById(int id) {
        categoryRepasitory.deleteById(id);
    }


    public Category findById(int id){
        return categoryRepasitory.getById(id);
    }

    public List<Category> findAll() {
        return categoryRepasitory.findAll();
    }

//
//    public List<Category> findAllByUser(User user) {
//        return categoryRepasitory.findAllByUser(user);
//    }


}
