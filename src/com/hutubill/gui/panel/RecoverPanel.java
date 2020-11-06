package com.hutubill.gui.panel;

import com.hutubill.gui.listener.RecoverListener;
import com.hutubill.util.ColorUtil;
import com.hutubill.util.GUIUtil;

import javax.swing.*;

/**
 * @Author: Jaye
 * @Description:
 * @Date:Created in 21:48 2018/4/15
 * @Modify By:
 */
public class RecoverPanel extends WorkingPanel{
    static {
        GUIUtil.useLNF();
    }

    public static RecoverPanel instance = new RecoverPanel();

    JButton bRecover = new JButton("恢复");

    public RecoverPanel() {
        GUIUtil.setColor(ColorUtil.blueColor, bRecover);
        this.add(bRecover);
        addListener();
    }

    @Override
    public void updateData() {

    }

    @Override
    public void addListener() {
        RecoverListener recoverListener = new RecoverListener();
        bRecover.addActionListener(recoverListener);
    }

    public static void main(String[] args) {
        GUIUtil.showPanel(RecoverPanel.instance);
    }
}
