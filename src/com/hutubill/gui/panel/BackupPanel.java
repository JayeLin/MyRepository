package com.hutubill.gui.panel;

import com.hutubill.gui.listener.BackupListener;
import com.hutubill.util.ColorUtil;
import com.hutubill.util.GUIUtil;

import javax.swing.*;

/**
 * @Author: Jaye
 * @Description:
 * @Date:Created in 18:00 2018/4/15
 * @Modify By:
 */
public class BackupPanel extends WorkingPanel{
    static {
        GUIUtil.useLNF();
    }

    public static BackupPanel instance = new BackupPanel();
    JButton bBackup = new JButton("备份");

    public BackupPanel() {
        GUIUtil.setColor(ColorUtil.blueColor, bBackup);
        this.add(bBackup);
        addListener();
    }
    @Override
    public void updateData() {

    }

    @Override
    public void addListener() {
        BackupListener backupListener = new BackupListener();
        bBackup.addActionListener(backupListener);
    }
    public static void main(String[] args) {
        GUIUtil.showPanel(BackupPanel.instance);
    }
}
