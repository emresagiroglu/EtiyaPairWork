package com.etiya.academy.repository;

import com.etiya.academy.entity.Category;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryCategoryRepository implements CategoryRepository{

    List<Category> categories = new ArrayList<>();
    @Override
    public List<Category> getAll() {
        return categories;
    }

    @Override
    public Category add(Category category) {
        categories.add(category);
        return category;
    }

    @Override
    public Category getById(int id) {
        for(Category category : categories){
            if(category.getId() == id){
                return category;
            }
        }
        return null;
    }

    @Override
    public void delete(int id) {
        categories.remove(getById(id));
    }

    @Override
    public Category update(Category category) {
        for(Category currentCategory: categories){
            if(currentCategory.getId() == category.getId()){
                currentCategory.setName(category.getName());
                return currentCategory;
            }
        }
        return null;
    }
}
