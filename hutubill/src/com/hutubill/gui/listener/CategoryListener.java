package com.hutubill.gui.listener;

import com.hutubill.entity.Category;
import com.hutubill.gui.panel.CategoryPanel;
import com.hutubill.service.impl.CategoryServiceImpl;
import com.hutubill.util.RecordUtil;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @Author: Jaye
 * @Description:
 * @Date:Created in 16:14 2018/4/15
 * @Modify By:
 */
public class CategoryListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        CategoryPanel categoryPanel = CategoryPanel.instance;
        JButton jButton = (JButton) e.getSource();
        if (jButton == categoryPanel.bAdd) {
            String name = JOptionPane.showInputDialog(null);
            if (name == null) {
                return;
            }
            if (0 == name.length()) {
                JOptionPane.showMessageDialog(categoryPanel, "分类名称不能为空");
                return;
            }
            new CategoryServiceImpl().add(name);
        }
        if (jButton == categoryPanel.bEdit) {
            Category category = categoryPanel.getSelectedCategory();
            int id = category.id;
            String name = JOptionPane.showInputDialog("修改分类名称", category.name);
            if (name == null) {
                return;
            }
            if (0 == name.length()) {
                JOptionPane.showMessageDialog(categoryPanel, "分类名称不能为空");
                return;
            }

            new CategoryServiceImpl().update(id, name);
        }

        if (jButton == categoryPanel.bDelete) {
            Category category = categoryPanel.getSelectedCategory();
            if (0 != category.recordNumber) {
                JOptionPane.showMessageDialog(categoryPanel, "本分类下有消费记录存在不能删除");
                return;
            }
            if (JOptionPane.OK_OPTION != JOptionPane.showConfirmDialog(categoryPanel, "确定要删除吗？")) {
                return;
            }
            int id = category.id;
            new CategoryServiceImpl().delete(id);
        }

        if (jButton == categoryPanel.bInquiry) {
            Category category = categoryPanel.getSelectedCategory();
            if (0 == category.recordNumber) {
                JOptionPane.showMessageDialog(categoryPanel, "本分类下没有消费记录存在，无法查询");
                return;
            }
            if (0 != category.recordNumber) {
                new RecordUtil().setVisible(true);
            }
            new CategoryServiceImpl().list();
        }
        categoryPanel.updateData();
    }
}
