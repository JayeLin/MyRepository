package com.hutubill.gui.listener;

import com.hutubill.gui.panel.ConfigPanel;
import com.hutubill.service.ConfigService;
import com.hutubill.service.impl.ConfigServiceImpl;
import com.hutubill.util.GUIUtil;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * @Author: Jaye
 * @Description:
 * @Date:Created in 16:14 2018/4/15
 * @Modify By:
 */
public class ConfigListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        ConfigPanel configPanel = ConfigPanel.instance;
        JButton jButton = (JButton) e.getSource();

        if (jButton == configPanel.bSubmit) {
            if (!GUIUtil.checkNumber(configPanel.tfBudget, "本月预算")) {
                String test = configPanel.tfBudget.getText();
                System.out.println(test);
                return;
            }

            String mysqlPath = configPanel.tfMysqlPqth.getText();
//        System.out.println(mysqlPath);
            if (0 != mysqlPath.length()) {
                File commandFile = new File(mysqlPath, "bin/mysql.exe");
                System.out.println(commandFile.toString());
                if (!commandFile.exists()) {
                    JOptionPane.showMessageDialog(configPanel, "Mysql路径不正确");
                    configPanel.tfMysqlPqth.grabFocus();
                    return;
                }
            }


            ConfigService configService = new ConfigServiceImpl();
            configService.update(ConfigServiceImpl.budget, configPanel.tfBudget.getText());
            configService.update(ConfigServiceImpl.mysqlPath, mysqlPath);


            JOptionPane.showMessageDialog(configPanel, "设置修改成功");
        }
    }

}
