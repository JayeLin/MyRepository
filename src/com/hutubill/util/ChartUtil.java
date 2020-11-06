package com.hutubill.util;

import com.hutubill.entity.Record;
import com.objectplanet.chart.BarChart;
import com.objectplanet.chart.Chart;


import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * @Author: Jaye
 * @Description:
 * @Date:Created in 23:07 2018/4/14
 * @Modify By:
 */
public class ChartUtil {
    private static String[] sampleLables(List<Record> recordList) {
        String[] sampleLables = new String[recordList.size()];
        for (int i = 0; i < sampleLables.length; i++) {
            if (0 == i % 5) {
                sampleLables[i] = String.valueOf(i + 1 + "日");
            }
        }
        return sampleLables;
    }

    public static double[] sampleValues(List<Record> recordList) {
        double[] sampleValues = new double[recordList.size()];
        for (int i = 0; i < sampleValues.length; i++) {
            sampleValues[i] = recordList.get(i).spend;
        }
        return sampleValues;
    }
    public static Image getImage(List<Record> recordList, int width, int height) {
        //根据消费记录得到的样本数据
        double[] sampleValues = sampleValues(recordList);
        //根据消费记录得到的下文日期文本
        String[] sampleLables = sampleLables(recordList);
        //样本中的最大值
        int max = max(sampleValues);
        //数据颜色
        Color[] sampleColors = new Color[] {
                ColorUtil.blueColor
        };
        //柱状图
        BarChart barChart = new BarChart();
        //设置样本个数
        barChart.setSampleCount(sampleValues.length);
        //设置样本数据
        barChart.setSampleValues(0, sampleValues);
        //设置文字
        barChart.setSampleLabels(sampleLables);
        //设置样本颜色
        barChart.setSampleColors(sampleColors);
        //设置取值范围
        barChart.setRange(0, max * 1.2);
        //显示背景横线
        barChart.setValueLabelsOn(true);
        //显示文字
        barChart.setSampleLabelsOn(true);
        //把文字显示在下方
        barChart.setSampleLabelStyle(Chart.BELOW);
        //样本值的字体
        barChart.setFont("rangeLabelFont", new Font("Arial", Font.BOLD, 12));
        //显示图例说明
        barChart.setLegendOn(true);
        //把图例说明放在左侧
        barChart.setLegendPosition(Chart.LEFT);
        //图例说明中的文字
        barChart.setLegendLabels(new String[] {"月消费报表"});
        //图例说明的字体
        barChart.setFont("legendFont", new Font("Dialog", Font.BOLD, 13));
        //下方文字的字体
        barChart.setFont("sampleLabelFont", new Font("Dialog", Font.BOLD, 13));
        //图表中间背景颜色
        barChart.setChartBackground(Color.white);
        //图表整体背景颜色
        barChart.setBackground(ColorUtil.backgroundColor);
        //把图表转换为Image类型
        Image image = barChart.getImage(width, height);
        return image;
    }

    public static int max(double[] sampleValues) {
        int max = 0;
        for (double value : sampleValues) {
            if (value > max) {
                max = (int) value;
            }
        }
        return max;
    }

    private static String[] sampleLables() {
        String[] sampleLables = new String[30];

        for (int i = 0; i < sampleLables.length; i++) {
            if (0 == i % 5) {
                sampleLables[i] = String.valueOf(i + 1 + "日");
            }
        }
        return sampleLables;
    }

    public static Image getImage(int width, int height) {
        //模拟样本数据
        double[] sampleValues = sampleValues();
        //下方显示的文字
        String[] sampleLables = sampleLables();
        //样本中的最大值
        int max = max(sampleValues);
        //数据颜色
        Color[] sampleColors = new Color[] {ColorUtil.blueColor};
        //柱状图
        BarChart barChart = new BarChart();
        //设置样本个数
        barChart.setSampleCount(sampleValues.length);
        //设置样本数据
        barChart.setSampleValues(0, sampleValues);
        //设置文字
        barChart.setSampleLabels(sampleLables);
        //设置样本颜色
        barChart.setSampleColors(sampleColors);
        //设置取值范围
        barChart.setRange(0, max * 1.2);
        //显示背景横线
        barChart.setValueLinesOn(true);
        //显示文字
        barChart.setSampleLabelsOn(true);
        //把文字显示在下方
        barChart.setSampleLabelStyle(Chart.BELOW);
        //样本值的文字
        barChart.setFont("rangeLabelFont", new Font("Arial", Font.BOLD, 12));
        //显示图例说明
        barChart.setLegendOn(true);
        //把图例说明放在左侧
        barChart.setLegendPosition(Chart.LEFT);
        //图例说明中的文字
        barChart.setLegendLabels(new String[] {"月消费报表"});
        //图例说明的字体
        barChart.setFont("legendlFont", new Font("Dialog", Font.BOLD, 13));
        //下方文字的字体
        barChart.setFont("sampleLabelFont", new Font("Dialog", Font.BOLD, 13));
        //图表中间背景颜色
        barChart.setChartBackground(Color.white);
        //图表整体背景颜色
        barChart.setBackground(ColorUtil.backgroundColor);
        //把图标转换为Image类型
        Image image = barChart.getImage(width, height);
        return image;
    }

    private static double[] sampleValues() {
        double[] result = new double[30];
        for (int i = 0; i < result.length; i++) {
            result[i] = (int) (Math.random() * 300);
        }
        return result;
    }

    public static void main(String[] args) {
        JPanel jPanel = new JPanel();
        JLabel jLabel = new JLabel();
        Image image = ChartUtil.getImage(400, 400);
        Icon icon = new ImageIcon(image);
        jLabel.setIcon(icon);
        jPanel.add(jLabel);
        GUIUtil.showPanel(jPanel);
    }
}
