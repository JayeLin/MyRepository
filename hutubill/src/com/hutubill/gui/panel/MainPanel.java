package com.hutubill.gui.panel;

import com.hutubill.gui.listener.ToolBarListener;
import com.hutubill.util.GUIUtil;

import javax.swing.*;
import java.awt.*;

/**
 * @Author: Jaye
 * @Description:
 * @Date:Created in 17:54 2018/4/15
 * @Modify By:
 */
public class MainPanel extends JPanel{
    static {
        GUIUtil.useLNF();
    }

    public static MainPanel instance = new MainPanel();
    public JToolBar jToolBar = new JToolBar();
    public JButton bSpend = new JButton();
    public JButton bRecord = new JButton();
    public JButton bCategory = new JButton();
    public JButton bReport = new JButton();
    public JButton bConfig = new JButton();
    public JButton bBackup = new JButton();
    public JButton bRecover = new JButton();

    public CenterPanel workingPanel;

    private MainPanel() {
        GUIUtil.setImageIcon(bSpend, "home.png", "消费一览");
        GUIUtil.setImageIcon(bRecord, "record.png", "记一笔");
        GUIUtil.setImageIcon(bCategory, "category.png", "消费分类");
        GUIUtil.setImageIcon(bReport, "report.png", "月消费报表");
        GUIUtil.setImageIcon(bConfig, "config.png", "设置");
        GUIUtil.setImageIcon(bBackup, "backup.png", "备份");
        GUIUtil.setImageIcon(bRecover, "recover.png", "恢复");

        jToolBar.add(bSpend);
        jToolBar.add(bRecord);
        jToolBar.add(bCategory);
        jToolBar.add(bReport);
        jToolBar.add(bConfig);
        jToolBar.add(bBackup);
        jToolBar.add(bRecover);
        jToolBar.setFloatable(false);

        workingPanel = new CenterPanel(0.8);

        setLayout(new BorderLayout());
        add(jToolBar, BorderLayout.NORTH);
        add(workingPanel, BorderLayout.CENTER);

        addListener();
    }

    private void addListener() {
        ToolBarListener toolBarListener = new ToolBarListener();

        bSpend.addActionListener(toolBarListener);
        bRecord.addActionListener(toolBarListener);
        bCategory.addActionListener(toolBarListener);
        bReport.addActionListener(toolBarListener);
        bConfig.addActionListener(toolBarListener);
        bBackup.addActionListener(toolBarListener);
        bRecover.addActionListener(toolBarListener);
    }

    public static void main(String[] args) {
        GUIUtil.showPanel(MainPanel.instance);
    }

}
