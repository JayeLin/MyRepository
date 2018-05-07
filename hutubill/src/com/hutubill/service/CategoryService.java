package com.hutubill.service;

import com.hutubill.entity.Category;

import java.util.List;

/**
 * @Author: Jaye
 * @Description:
 * @Date:Created in 22:49 2018/4/11
 * @Modify By:
 */
public interface CategoryService {

    public List<Category> list();

    public void add(String name);

    public void update(int id, String name);

    public void delete(int id);
}
