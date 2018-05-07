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
public class RecoverListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        BackupPanel backupPanel = BackupPanel.instance;
        ConfigService configService = new ConfigServiceImpl();
        String mysqlPath = configService.get(ConfigServiceImpl.mysqlPath);
        if (0 == mysqlPath.length()) {
            JOptionPane.showMessageDialog(backupPanel, "恢复前请事先配置好mysql的路径");
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

        int returnVal = jFileChooser.showOpenDialog(backupPanel);
        File file = jFileChooser.getSelectedFile();
        System.out.println(file);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            try {
                MysqlUtil.recover(mysqlPath, file.getAbsolutePath());
                JOptionPane.showMessageDialog(backupPanel, "恢复成功");
            } catch (Exception el) {
                el.printStackTrace();
                JOptionPane.showMessageDialog(backupPanel, "恢复失败\r\n，错误：\r\n" + el.getMessage());
            }
        }
    }
}
