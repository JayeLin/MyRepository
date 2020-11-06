package com.hutubill.gui.panel;

import com.hutubill.entity.Category;
import com.hutubill.gui.listener.RecordListener;
import com.hutubill.gui.model.CategoryComboxModel;
import com.hutubill.service.CategoryService;
import com.hutubill.service.impl.CategoryServiceImpl;
import com.hutubill.util.ColorUtil;
import com.hutubill.util.GUIUtil;
import org.jdesktop.swingx.JXDatePicker;

import javax.swing.*;
import java.awt.*;
import java.util.Date;

/**
 * @Author: Jaye
 * @Description:
 * @Date:Created in 23:00 2018/4/15
 * @Modify By:
 */
public class RecordPanel extends WorkingPanel {
    static {
        GUIUtil.useLNF();
    }
    public static RecordPanel instance = new RecordPanel();

    JLabel lSpend = new JLabel("花费（￥）");
    JLabel lCategory = new JLabel("分类");
    JLabel lComment = new JLabel("备注");
    JLabel lDate = new JLabel("日期");

    public JTextField tfSpend = new JTextField("0");

    public CategoryComboxModel categoryComboxModel = new CategoryComboxModel();
    public JComboBox<Category> categoryJComboBox = new JComboBox<>(categoryComboxModel);
    public JTextField tfComment = new JTextField();
    public JXDatePicker jxDatePicker = new JXDatePicker(new Date());

    JButton bSubmit = new JButton("记一笔");

    public RecordPanel() {
        GUIUtil.setColor(ColorUtil.grayColor, lSpend, lCategory, lComment, lDate);
        GUIUtil.setColor(ColorUtil.blueColor, bSubmit);
        JPanel pInput = new JPanel();
        JPanel pSubmit = new JPanel();
        int gap = 40;
        pInput.setLayout(new GridLayout(4, 2, gap, gap));

        pInput.add(lSpend);
        pInput.add(tfSpend);
        pInput.add(lCategory);
        pInput.add(categoryJComboBox);
        pInput.add(lComment);
        pInput.add(tfComment);
        pInput.add(lDate);
        pInput.add(jxDatePicker);

        pSubmit.add(bSubmit);

        this.setLayout(new BorderLayout());
        this.add(pInput, BorderLayout.NORTH);
        this.add(pInput, BorderLayout.CENTER);


    }
    public Category getSelectedCategory() {
        return (Category) categoryComboxModel.getSelectedItem();
    }

    public void resetInput() {
        tfSpend.setText("0");
        tfComment.setText("");
        if (0 != categoryComboxModel.categoryList.size()) {
            categoryComboxModel.setSelectedItem(0);
        }
        jxDatePicker.setDate(new Date());
    }
    @Override
    public void updateData() {
        CategoryService categoryService = new CategoryServiceImpl();
        categoryComboxModel.categoryList = categoryService.list();
        categoryJComboBox.updateUI();
        resetInput();
        tfSpend.grabFocus();
    }

    @Override
    public void addListener() {
        RecordListener recordListener = new RecordListener();
        bSubmit.addActionListener(recordListener);
    }

    public static void main(String[] args) {
        GUIUtil.showPanel(RecordPanel.instance);
    }
}
