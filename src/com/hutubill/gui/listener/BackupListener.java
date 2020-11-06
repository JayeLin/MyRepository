package com.hutubill.gui.listener;

import com.hutubill.gui.panel.BackupPanel;
import com.hutubill.gui.panel.ConfigPanel;
import com.hutubill.gui.panel.MainPanel;
import com.hutubill.service.ConfigService;
import com.hutubill.service.impl.ConfigServiceImpl;
import com.hutubill.util.MysqlUtil;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * @Author: Jaye
 * @Description:
 * @Date:Created in 16:13 2018/4/15
 * @Modify By:
 */
public class BackupListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        BackupPanel backupPanel = BackupPanel.instance;
        ConfigService configService = new ConfigServiceImpl();
        String mysqlPath = configService.get(ConfigServiceImpl.mysqlPath);
        if (0 == mysqlPath.length()) {
            JOptionPane.showMessageDialog(backupPanel, "备份前请事先配置mysql的路径");
            MainPanel.instance.workingPanel.show(ConfigPanel.instance);
            ConfigPanel.instance.tfMysqlPqth.grabFocus();
            return;
        }
        JFileChooser jFileChooser = new JFileChooser();
        jFileChooser.setSelectedFile(new File("hutubill.sql"));
        jFileChooser.setFileFilter(new FileFilter() {
            @Override
            public boolean accept(File f) {
                return f.getName().toLowerCase().endsWith(".sql");
            }

            @Override
            public String getDescription() {
                return ".sql";
            }
        });

        int returnVal = jFileChooser.showSaveDialog(backupPanel);
        File file = jFileChooser.getSelectedFile();
        System.out.println(file);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            //如果保存的文件名没有以.sql结尾，自动加上.sql
            System.out.println(file);
            if (!file.getName().toLowerCase().endsWith(".sql")) {
                file = new File(file.getParent(), file.getName() + ".sql");
            }
            System.out.println(file);

            try {
                MysqlUtil.backup(mysqlPath, file.getAbsolutePath());
                JOptionPane.showMessageDialog(backupPanel, "备份成功，备份文件位于：\r\n" + file.getAbsolutePath());
            } catch (Exception e1) {
                e1.printStackTrace();
                JOptionPane.showMessageDialog(backupPanel, "备份失败\r\n，错误：\r\n" + e1.getMessage());
            }
        }

    }
}
