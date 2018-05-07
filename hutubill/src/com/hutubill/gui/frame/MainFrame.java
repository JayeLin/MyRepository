package com.hutubill.gui.frame;

import javax.swing.*;

public class MainFrame extends JFrame {
    public static MainFrame instance = new MainFrame();

    private MainFrame(){
        this.setSize(500,450);
//        this.setSize(500,450);
        this.setTitle("小巧记账本");
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args){
        instance.setVisible(true);
    }
}
