package com.hutubill.service.impl;

import com.hutubill.dao.CategoryDAO;
import com.hutubill.dao.RecordDAO;
import com.hutubill.dao.impl.CategoryDAOImpl;
import com.hutubill.dao.impl.RecordDAOImpl;
import com.hutubill.entity.Category;
import com.hutubill.entity.Record;
import com.hutubill.service.CategoryService;

import java.util.List;

/**
 * @Author: Jaye
 * @Description:
 * @Date:Created in 20:06 2018/4/11
 * @Modify By:
 */
public class CategoryServiceImpl implements CategoryService {

    CategoryDAO categoryDAO = new CategoryDAOImpl();
    RecordDAO recordDAO = new RecordDAOImpl();

    @Override
    public List<Category> list() {
        List<Category> categoryList = categoryDAO.list();
        for (Category category : categoryList) {
            List<Record> recordList = recordDAO.list(category.id);
            category.recordNumber = recordList.size();
        }
        return categoryList;
    }

    @Override
    public void add(String name) {
        Category category = new Category();
        category.setName(name);
        categoryDAO.add(category);
    }

    @Override
    public void update(int id, String name) {
        Category category = new Category();
        category.setId(id);
        category.setName(name);
        categoryDAO.update(category);
    }

    @Override
    public void delete(int id) {
        categoryDAO.delete(id);
    }
}
