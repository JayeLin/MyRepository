package com.hutubill.gui.panel;

import jdk.internal.org.objectweb.asm.tree.MultiANewArrayInsnNode;

import javax.swing.*;
import java.awt.*;

/**
 * @Author: Jaye
 * @Description:
 * @Date:Created in 23:23 2018/4/14
 * @Modify By:
 */
public class CenterPanel extends JPanel {
    private double rate;//拉伸比例
    private JComponent jComponent;//显示的组件
    private boolean strech;//是否拉伸

    public CenterPanel(double rate, boolean strech) {
        this.setLayout(null);
        this.rate = rate;
        this.strech = strech;
    }

    public CenterPanel(double rate) {
        this(rate, true);
    }

    public void repaint() {
        if (null != jComponent) {
            Dimension containerSize = this.getSize();
            Dimension componentSize = jComponent.getPreferredSize();

            if (strech) {
                jComponent.setSize((int) (containerSize.width * rate), (int) (containerSize.height * rate));
            } else {
                jComponent.setSize(componentSize);
            }
            jComponent.setLocation(containerSize.width / 2 - jComponent.getSize().width / 2,
                    containerSize.height / 2 - jComponent.getSize().height / 2);
        }
        super.repaint();
    }
    public void show(JComponent jComponent1) {
        this.jComponent = jComponent1;
        Component[] components = getComponents();
        for (Component component : components) {
            remove(component);
        }
        add(jComponent1);

        if (jComponent1 instanceof  WorkingPanel) {
            ((WorkingPanel) jComponent1).updateData();
        }

        this.updateUI();
    }

    public static void main(String[] args) {
        JFrame jFrame = new JFrame();
        jFrame.setSize(200, 200);
        jFrame.setLocationRelativeTo(null);
        CenterPanel centerPanel = new CenterPanel(0.85, true);
        jFrame.setContentPane(centerPanel);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
        JButton jButton = new JButton("abc");
        centerPanel.show(jButton);
    }
}
