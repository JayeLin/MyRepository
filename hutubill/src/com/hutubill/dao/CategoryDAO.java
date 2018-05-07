package com.hutubill.dao;

import com.hutubill.entity.Category;

import java.util.List;

public interface CategoryDAO {

    public int getTotal();

    public void add(Category category);

    public void update(Category category);

    public void delete(int id);

    public Category get(int id);

    public List<Category> list();

    public List<Category> list(int start, int count);

}
