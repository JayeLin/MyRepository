package com.hutubill.service.impl;

import com.hutubill.dao.RecordDAO;
import com.hutubill.dao.impl.RecordDAOImpl;
import com.hutubill.entity.Record;
import com.hutubill.service.ReportService;
import com.hutubill.util.DateUtil;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @Author: Jaye
 * @Description:
 * @Date:Created in 22:53 2018/4/11
 * @Modify By:
 */
public class ReportServiceImpl implements ReportService {
    @Override
    public int getDaySpend(Date day, List<Record> monthRawData) {
        int daySpend = 0;
        for (Record record : monthRawData) {
            if (record.date.equals(day)) {
                daySpend += record.spend;
            }
        }
        return daySpend;
    }

    @Override
    public List<Record> listThisMonthRecordList() {
        RecordDAO recordDAO = new RecordDAOImpl();
        List<Record> monthRawData = recordDAO.listThisMonth();
        List<Record> result = new ArrayList<>();
        Date monthBegin = DateUtil.monthBegin();
        int monthTotalDay = DateUtil.thisMonthTotalDay();
        Calendar calendar = Calendar.getInstance();
        for (int i = 0; i < monthTotalDay; i++) {
            Record record = new Record();
            calendar.setTime(monthBegin);
            calendar.add(Calendar.DATE, i);
            Date eachDayOfThisMonth = calendar.getTime();
            int daySpend = getDaySpend(eachDayOfThisMonth, monthRawData);
            record.spend = daySpend;
            result.add(record);
        }
        return result;
    }
}
