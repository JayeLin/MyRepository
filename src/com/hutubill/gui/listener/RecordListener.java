package com.hutubill.gui.listener;

import com.hutubill.entity.Category;
import com.hutubill.gui.panel.CategoryPanel;
import com.hutubill.gui.panel.MainPanel;
import com.hutubill.gui.panel.RecordPanel;
import com.hutubill.gui.panel.SpendPanel;
import com.hutubill.service.impl.RecordServiceImpl;
import com.hutubill.util.GUIUtil;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

/**
 * @Author: Jaye
 * @Description:
 * @Date:Created in 16:12 2018/4/15
 * @Modify By:
 */
public class RecordListener implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e) {
        RecordPanel recordPanel = RecordPanel.instance;
        if (0 == recordPanel.categoryComboxModel.categoryList.size()) {
            JOptionPane.showMessageDialog(recordPanel, "暂无消费分类，无法添加，请先增加消费分类");
            MainPanel.instance.workingPanel.show(CategoryPanel.instance);
            return;
        }
        if (!GUIUtil.checkZero(recordPanel.tfSpend, "花费金额")) {
            return;
        }
        int spend = Integer.parseInt(recordPanel.tfSpend.getText());
        Category category = recordPanel.getSelectedCategory();
        String comment = recordPanel.tfComment.getText();
        Date date = recordPanel.jxDatePicker.getDate();
        new RecordServiceImpl().add(spend, category, comment, date);
        JOptionPane.showMessageDialog(recordPanel, "添加成功");

        MainPanel.instance.workingPanel.show(SpendPanel.instance);
    }
}
