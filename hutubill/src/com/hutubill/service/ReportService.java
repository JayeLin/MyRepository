package com.hutubill.service;

import com.hutubill.entity.Record;

import java.util.Date;
import java.util.List;

/**
 * @Author: Jaye
 * @Description:
 * @Date:Created in 22:53 2018/4/11
 * @Modify By:
 */
public interface ReportService {
    /**
     * @Description: Get the amount of money spent on a certain day
     * @param day
     * @param monthRawData
     * @return
     */
    public int getDaySpend(Date day, List<Record> monthRawData);


    /**
     * @Description: Get a monthly collection of purchase records
     *@return
     */
    public List<Record> listThisMonthRecordList();
}
