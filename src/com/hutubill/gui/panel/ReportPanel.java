package com.hutubill.gui.panel;

import com.hutubill.entity.Record;
import com.hutubill.service.ReportService;
import com.hutubill.service.impl.ReportServiceImpl;
import com.hutubill.util.ChartUtil;
import com.hutubill.util.GUIUtil;

import javax.swing.*;
import java.awt.*;
import java.util.List;


/**
 * @Author: Jaye
 * @Description:
 * @Date:Created in 23:03 2018/4/13
 * @Modify By:
 */
public class ReportPanel extends WorkingPanel{
    public static ReportPanel instance = new ReportPanel();

    JLabel jLabel = new JLabel();

    public ReportPanel() {
        this.setLayout(new BorderLayout());
        ReportService reportService = new ReportServiceImpl() ;
        List<Record> recordList = reportService.listThisMonthRecordList();
        Image image = ChartUtil.getImage(recordList, 400, 300);
        ImageIcon imageIcon = new ImageIcon(image);
        jLabel.setIcon(imageIcon);
        this.add(jLabel);
        addListener();
    }

    @Override
    public void updateData() {
        ReportService reportService = new ReportServiceImpl();
        List<Record> recordList = reportService.listThisMonthRecordList();
        Image image = ChartUtil.getImage(recordList, 350, 250);
        ImageIcon imageIcon = new ImageIcon(image);
        jLabel.setIcon(imageIcon);
    }

    @Override
    public void addListener() {

    }

    public static void main(String[] args) {
        GUIUtil.showPanel(ReportPanel.instance);
    }
}
