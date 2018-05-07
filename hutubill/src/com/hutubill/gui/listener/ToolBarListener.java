package com.hutubill.gui.listener;

import com.hutubill.gui.panel.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @Author: Jaye
 * @Description:
 * @Date:Created in 16:13 2018/4/15
 * @Modify By:
 */
public class ToolBarListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        MainPanel mainPanel = MainPanel.instance;
        JButton jButton = (JButton) e.getSource();
        if (jButton == mainPanel.bReport) {
            mainPanel.workingPanel.show(ReportPanel.instance);
        }
        if (jButton == mainPanel.bCategory) {
            mainPanel.workingPanel.show(CategoryPanel.instance);
        }
        if (jButton == mainPanel.bSpend) {
            mainPanel.workingPanel.show(SpendPanel.instance);
        }
        if (jButton == mainPanel.bRecord) {
            mainPanel.workingPanel.show(RecordPanel.instance);
        }
        if (jButton == mainPanel.bConfig) {
            mainPanel.workingPanel.show(ConfigPanel.instance);
        }
        if (jButton == mainPanel.bBackup) {
            mainPanel.workingPanel.show(BackupPanel.instance);
        }
        if (jButton == mainPanel.bRecover) {
            mainPanel.workingPanel.show(RecoverPanel.instance);
        }
    }
}
