package com.hutubill.gui.panel;

import com.hutubill.gui.page.SpendPage;
import com.hutubill.service.SpendService;
import com.hutubill.service.impl.SpendServiceImpl;
import com.hutubill.util.CircleProgressBar;
import com.hutubill.util.ColorUtil;
import com.hutubill.util.GUIUtil;
import com.objectplanet.chart.JpegEncoder;

import javax.swing.*;
import java.awt.*;

public class SpendPanel extends WorkingPanel{

    public static SpendPanel instance = new SpendPanel();

    JLabel lMonthSpend = new JLabel("本月消费");
    JLabel lTadaySpend = new JLabel("本日消费");
    JLabel lAvgSpendPerDay = new JLabel("日均消费");
    JLabel lMonthLeft = new JLabel("本月剩余");
    JLabel lDayAvgAvailable = new JLabel("日均可用");
    JLabel lMonthLeftDay = new JLabel("距离月末");


    JLabel vMonthSpend = new JLabel("￥2300");
    JLabel vTadaySpend = new JLabel("￥25");
    JLabel vAvgSpendPerDay = new JLabel("￥120");
    JLabel vMonthAvailable = new JLabel("￥2084");
    JLabel vDayAvgAvailable = new JLabel("￥389");
    JLabel vMonthLeftDay = new JLabel("15天");

    CircleProgressBar circleProgressBar;

    public SpendPanel() {
        this.setLayout(new BorderLayout());
        circleProgressBar = new CircleProgressBar();
        circleProgressBar.setBackgroundColor(ColorUtil.blueColor);

        GUIUtil.setColor(ColorUtil.grayColor, lMonthSpend, lTadaySpend, lAvgSpendPerDay, lMonthLeft, lDayAvgAvailable,
               lMonthLeftDay, vAvgSpendPerDay, vMonthAvailable, vDayAvgAvailable, vMonthLeftDay );
        GUIUtil.setColor(ColorUtil.blueColor, vMonthSpend, vTadaySpend);

        vMonthSpend.setFont(new Font("微软雅黑", Font.BOLD, 23));
        vTadaySpend.setFont(new Font("微软雅黑", Font.BOLD, 23));

        this.add(center(), BorderLayout.CENTER);
        this.add(south(), BorderLayout.SOUTH);
    }

    private JPanel center() {
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new BorderLayout());
        jPanel.add(west(), BorderLayout.WEST);
        jPanel.add(east());

        return jPanel;
    }

    private Component east() {
        return circleProgressBar;
    }

    private Component west() {
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new GridLayout(4, 1));
        jPanel.add(lMonthSpend);
        jPanel.add(vMonthSpend);
        jPanel.add(lTadaySpend);
        jPanel.add(vTadaySpend);

        return jPanel;
    }

    private JPanel south() {
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new GridLayout(2, 4));

        jPanel.add(lAvgSpendPerDay);
        jPanel.add(lMonthLeft);
        jPanel.add(lDayAvgAvailable);
        jPanel.add(lMonthLeftDay);
        jPanel.add(vAvgSpendPerDay);
        jPanel.add(vMonthAvailable);
        jPanel.add(vDayAvgAvailable);
        jPanel.add(vMonthLeftDay);

        return jPanel;
    }
    @Override
    public void updateData() {
        SpendService spendService = new SpendServiceImpl();
        SpendPage spendPage = spendService.getSpendPage();
        vMonthSpend.setText(spendPage.monthSpend);
        vTadaySpend.setText(spendPage.todaySpend);
        vAvgSpendPerDay.setText(spendPage.avgSpendPerDay);
        vMonthAvailable.setText(spendPage.monthAvailable);
        vDayAvgAvailable.setText(spendPage.dayAvgAvailable);
        vMonthLeftDay.setText(spendPage.monthLeftDay);

        circleProgressBar.setProgress(spendPage.usagePercentage);
        if (spendPage.isOverSpend) {
            vMonthAvailable.setForeground(ColorUtil.warningColor);
            vMonthSpend.setForeground(ColorUtil.blueColor);
            vTadaySpend.setForeground(ColorUtil.blueColor);
        } else {
            vMonthAvailable.setForeground(ColorUtil.grayColor);
            vMonthSpend.setForeground(ColorUtil.blueColor);
            vTadaySpend.setForeground(ColorUtil.blueColor);
        }
        circleProgressBar.setForegroundColor(ColorUtil.getByPercentage(spendPage.usagePercentage));
        addListener();
    }

    @Override
    public void addListener() {

    }
    public static void main(String[] args) {
        GUIUtil.showPanel(SpendPanel.instance);
    }
}
