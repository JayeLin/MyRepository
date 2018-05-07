package com.hutubill;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HutuMainFrame {
    public static void main(String[] args){
        JFrame jFrame = new JFrame();
        jFrame.setSize(500,450);
        jFrame.setTitle("我的账本");
        jFrame.setLocationRelativeTo(null);
        jFrame.setResizable(false);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JToolBar jToolBar = new JToolBar();
        JButton bSpend = new JButton("消费一览");
        JButton bRecord = new JButton("记一笔");
        JButton bCategory = new JButton("消费分类");
        JButton bReport = new JButton("月消费报表");
        JButton bConfig = new JButton("设置");
        JButton bBackup = new JButton("备份");
        JButton bRcover = new JButton("恢复");

        jToolBar.add(bSpend);
        jToolBar.add(bRecord);
        jToolBar.add(bCategory);
        jToolBar.add(bReport);
        jToolBar.add(bConfig);
        jToolBar.add(bBackup);
        jToolBar.add(bRcover);

        jFrame.setLayout(new BorderLayout());
        jFrame.add(jToolBar,BorderLayout.NORTH);
        jFrame.add(new JPanel(), BorderLayout.CENTER);

        jFrame.setVisible(true);

        bSpend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        bRecord.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        bCategory.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        bConfig.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        bBackup.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        bRcover.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
