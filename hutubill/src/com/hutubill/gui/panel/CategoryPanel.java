package com.hutubill.gui.panel;

import com.hutubill.entity.Category;
import com.hutubill.gui.listener.CategoryListener;
import com.hutubill.gui.model.CategoryTableModel;
import com.hutubill.service.CategoryService;
import com.hutubill.service.impl.CategoryServiceImpl;
import com.hutubill.util.ColorUtil;
import com.hutubill.util.GUIUtil;

import javax.swing.*;
import java.awt.*;

/**
 * @Author: Jaye
 * @Description:
 * @Date:Created in 17:58 2018/4/15
 * @Modify By:
 */
public class CategoryPanel extends WorkingPanel{
    static {
        GUIUtil.useLNF();
    }

    public static CategoryPanel instance = new CategoryPanel();

    public JButton bAdd = new JButton("新增");
    public JButton bEdit = new JButton("编辑");
    public JButton bDelete = new JButton("删除");
    public JButton bInquiry = new JButton("查询");
    String columnNames[] = new String[] {"分类名称", "消费次数"};

    public CategoryTableModel categoryTableModel = new CategoryTableModel();
    public JTable jTable = new JTable(categoryTableModel);

    public CategoryPanel() {
        GUIUtil.setColor(ColorUtil.blueColor, bAdd, bEdit, bDelete, bInquiry);
        JScrollPane jScrollPane = new JScrollPane(jTable);
        JPanel pSubmit = new JPanel();
        pSubmit.add(bAdd);
        pSubmit.add(bEdit);
        pSubmit.add(bInquiry);

        this.setLayout(new BorderLayout());
        this.add(jScrollPane, BorderLayout.CENTER);
        this.add(pSubmit, BorderLayout.SOUTH);

        addListener();
    }

    public Category getSelectedCategory() {
        int index = jTable.getSelectedRow();
        return categoryTableModel.categoryList.get(index);
    }

    @Override
    public void updateData() {
        CategoryService categoryServic = new CategoryServiceImpl();
        categoryTableModel.categoryList = categoryServic.list();
        jTable.updateUI();
        jTable.getSelectionModel().setSelectionInterval(0, 0);

        if (0 == categoryTableModel.categoryList.size()) {
            bEdit.setEnabled(false);
            bDelete.setEnabled(false);
            bInquiry.setEnabled(false);
        } else {
            bEdit.setEnabled(true);
            bDelete.setEnabled(true);
            bInquiry.setEnabled(true);
        }
    }

    @Override
    public void addListener() {
        CategoryListener categoryListener = new CategoryListener();
        bAdd.addActionListener(categoryListener);
        bEdit.addActionListener(categoryListener);
        bDelete.addActionListener(categoryListener);
        bInquiry.addActionListener(categoryListener);
    }

    public static void main(String[] args) {
        GUIUtil.showPanel(CategoryPanel.instance);
    }
}
