package com.hutubill.service.impl;

import com.hutubill.dao.RecordDAO;
import com.hutubill.dao.impl.RecordDAOImpl;
import com.hutubill.entity.Record;
import com.hutubill.gui.page.SpendPage;
import com.hutubill.service.ConfigService;
import com.hutubill.service.SpendService;
import com.hutubill.util.DateUtil;

import java.util.List;

/**
 * @Author: Jaye
 * @Description:
 * @Date:Created in 22:54 2018/4/11
 * @Modify By:
 */
public class SpendServiceImpl implements SpendService {
    @Override
    public SpendPage getSpendPage() {
        RecordDAO recordDAO = new RecordDAOImpl();
        //本月数据
        List<Record> thisMonthRecordList = recordDAO.listThisMonth();

        //今日数据
        List<Record> todayRecordList = recordDAO.listToday();

        //本月总天数
        int thisMonthTotalDay = DateUtil.thisMonthTotalDay();

        int monthSpend = 0;
        int todaySpend = 0;
        int avgSpendPerDay = 0;
        int monthAvailable = 0;
        int dayAvgAvailable = 0;
        int monthLeftDay = 0;
        int usagePercentage = 0;

        //预算
        ConfigService configService = new ConfigServiceImpl();
        int monthBudget = configService.getIntBudget();

        //统计本月消费
        for (Record record : thisMonthRecordList) {
            monthSpend += record.getSpend();
        }

        //统计今日消费
        for (Record record : todayRecordList) {
            todaySpend += record.getSpend();
        }

        //计算日均消费
        avgSpendPerDay = monthSpend / thisMonthTotalDay;

        //计算本月剩余
        monthAvailable = monthBudget - monthSpend;

        //距离月末
        monthLeftDay = DateUtil.thisMonthLeftDay();

        //计算日均可用
        dayAvgAvailable = monthAvailable / monthLeftDay;

        //计算可用比例
        usagePercentage = monthSpend * 100 / monthBudget;

        //根据以上信息生成SpendPage对象
        return new SpendPage(monthSpend, todaySpend, avgSpendPerDay, monthAvailable,
                dayAvgAvailable, monthLeftDay, usagePercentage);
    }
}
