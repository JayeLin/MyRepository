package com.hutubill.gui.panel;

import com.hutubill.gui.listener.ConfigListener;
import com.hutubill.service.ConfigService;
import com.hutubill.service.impl.ConfigServiceImpl;
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
public class ConfigPanel extends WorkingPanel{
    static {
        GUIUtil.useLNF();
    }

    public static ConfigPanel instance = new ConfigPanel();
    JLabel lBudget = new JLabel("本月预算（￥）");
    public JTextField tfBudget = new JTextField("0");

    JLabel lMysql = new JLabel("Mysql安装目录");
    public JTextField tfMysqlPqth = new JTextField("");

    public JButton bSubmit = new JButton("更新");

    public ConfigPanel() {
        GUIUtil.setColor(ColorUtil.grayColor, lBudget, lMysql);
        GUIUtil.setColor(ColorUtil.blueColor, bSubmit);

        JPanel pInput = new JPanel();
        JPanel pSubmit = new JPanel();
        int gap = 40;
        pInput.setLayout(new GridLayout(4, 1, gap, gap));

        pInput.add(lBudget);
        pInput.add(tfBudget);
        pInput.add(lMysql);
        pInput.add(tfMysqlPqth);

        pSubmit.add(bSubmit);

        this.setLayout(new BorderLayout());
        this.add(pInput, BorderLayout.NORTH);
        this.add(pSubmit, BorderLayout.CENTER);

        addListener();
    }
    @Override
    public void updateData() {
        ConfigService configService = new ConfigServiceImpl();
        String budget = configService.get(ConfigServiceImpl.budget);
        String mysqlPath = configService.get(ConfigServiceImpl.mysqlPath);
        tfBudget.setText(budget);
        tfMysqlPqth.setText(mysqlPath);
        tfBudget.grabFocus();
    }

    @Override
    public void addListener() {
        ConfigListener configListener = new ConfigListener();
        bSubmit.addActionListener(configListener);
    }

    public static void main(String[] args) {
        GUIUtil.showPanel(ConfigPanel.instance);
    }
}
