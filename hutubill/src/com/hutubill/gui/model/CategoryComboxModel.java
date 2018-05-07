package com.hutubill.gui.model;

import com.hutubill.entity.Category;
import com.hutubill.service.CategoryService;
import com.hutubill.service.impl.CategoryServiceImpl;

import javax.swing.*;
import javax.swing.event.ListDataListener;
import java.util.List;

public class CategoryComboxModel implements ComboBoxModel<Category> {

    CategoryService categoryService = new CategoryServiceImpl();
    public List<Category> categoryList = categoryService.list();

    public Category category;

    public CategoryComboxModel() {
        if (!categoryList.isEmpty()) {
            category = categoryList.get(0);
        }
    }

    @Override
    public void setSelectedItem(Object anItem) {

    }

    @Override
    public Object getSelectedItem() {
        if (!categoryList.isEmpty()) {
            return category;
        } else {
            return null;
        }
    }

    @Override
    public int getSize() {
        return categoryList.size();
    }

    @Override
    public Category getElementAt(int index) {
        return categoryList.get(index);
    }

    @Override
    public void addListDataListener(ListDataListener l) {

    }

    @Override
    public void removeListDataListener(ListDataListener l) {

    }
}
