package com.hutubill.gui.model;

import com.hutubill.entity.Category;
import com.hutubill.service.CategoryService;
import com.hutubill.service.impl.CategoryServiceImpl;

import javax.swing.table.AbstractTableModel;
import java.util.List;

/**
 * @Author: Jaye
 * @Description:
 * @Date:Created in 22:32 2018/4/13
 * @Modify By:
 */
public class CategoryTableModel extends AbstractTableModel{

    String[] columnNames = new String[] {"分类名称", "消费次数"};

    //使用从service返回List作为TableModel的数据
    CategoryService categoryService = new CategoryServiceImpl();
    public List<Category> categoryList = categoryService.list();

    @Override
    public int getRowCount() {
        return categoryList.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    public String getColumnName(int columnIndex) {
        return  columnNames[columnIndex];
    }

    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return  false;
    }

    //先通过 category.get(rowIndex)获取行对应的Category对象
    //然后根据columnIndex返回对应的属性
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Category category = categoryList.get(rowIndex);
        if (0 == columnIndex) {
            return category.name;
        }
        if (1 == columnIndex) {
            return category.recordNumber;
        }
        return null;
    }
}
