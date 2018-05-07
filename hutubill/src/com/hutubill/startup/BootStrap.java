package com.hutubill.startup;

import com.hutubill.gui.frame.MainFrame;
import com.hutubill.gui.panel.MainPanel;
import com.hutubill.gui.panel.SpendPanel;
import com.hutubill.util.GUIUtil;

import javax.swing.*;
import java.lang.reflect.InvocationTargetException;

/**
 * @Author: Jaye
 * @Description:
 * @Date:Created in 15:48 2018/4/16
 * @Modify By:
 */
public class BootStrap {
    public static void main(String[] args) {
        GUIUtil.useLNF();
        try {
            SwingUtilities.invokeAndWait(new Runnable() {
                @Override
                public void run() {
                    MainFrame.instance.setVisible(true);
                    MainFrame.instance.setContentPane(MainPanel.instance);
                    MainPanel.instance.workingPanel.show(SpendPanel.instance);
                }
            });
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
