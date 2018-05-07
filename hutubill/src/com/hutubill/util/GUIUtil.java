package com.hutubill.util;

import com.hutubill.gui.panel.CenterPanel;

import javax.swing.*;
import java.awt.*;
import java.io.File;

/**
 * @Author: Jaye
 * @Description:
 * @Date:Created in 23:24 2018/4/14
 * @Modify By:
 */
public class GUIUtil {

    private static String imageFolder = "G:\\WorkSpace\\IdeaProjectsWorkSpace\\hutubill\\resources\\images";

    public static void setImageIcon(JButton jButton, String fileName, String tip) {
        ImageIcon imageIcon = new ImageIcon(new File(imageFolder, fileName).getAbsolutePath());
        jButton.setIcon(imageIcon);
        jButton.setPreferredSize(new Dimension(61, 81));
        jButton.setToolTipText(tip);
        jButton.setVerticalTextPosition(JButton.BOTTOM);
        jButton.setHorizontalTextPosition(JButton.CENTER);
        jButton.setText(tip);
    }

    public static void setColor(Color color, JComponent... jComponents) {
        for (JComponent jComponent : jComponents) {
            jComponent.setForeground(color);
        }
    }

    /**
     * @param jPanel
     * @param strechRate 拉伸比例1表示满屏幕
     */
    public static void showPanel(JPanel jPanel, double strechRate) {
        GUIUtil.useLNF();
        JFrame jFrame = new JFrame();
        jFrame.setSize(500, 500);
        jFrame.setLocationRelativeTo(null);
        CenterPanel centerPanel = new CenterPanel(strechRate);
        jFrame.setContentPane(centerPanel);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
        centerPanel.show(jPanel);
    }

    public static void showPanel(JPanel jPanel) {
        showPanel(jPanel, 0.85);
    }

    public static boolean checkNumber(JTextField jTextField, String input) {
        if (checkEmpty(jTextField, input)) {
            return false;
        }
        String text = jTextField.getText().trim();
        try {
            Integer.parseInt(text);
            return true;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, input + "需要是整数");
            jTextField.grabFocus();
            return false;
        }
    }

    public static boolean checkZero(JTextField jTextField, String input) {
        if (!checkNumber(jTextField, input)) {
            return false;
        }
        String text = jTextField.getText().trim();

        if (0 == Integer.parseInt(text)) {
            JOptionPane.showMessageDialog(null, input + "不能为零");
            jTextField.grabFocus();
            return false;
        }
        return true;
    }

    public static boolean checkEmpty(JTextField jTextField, String input) {
        String text = jTextField.getText().trim();
        if (0 == text.length()) {
            JOptionPane.showMessageDialog(null, input + "不能为空");
            jTextField.grabFocus();
            return  false;
        }
        return true;
    }

    public static int getInt(JTextField jTextField) {
        return Integer.parseInt(jTextField.getText());
    }

    public static void useLNF() {
        try {
            UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
    }
}
