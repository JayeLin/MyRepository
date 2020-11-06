package com.hutubill.service.impl;

import com.hutubill.dao.RecordDAO;
import com.hutubill.dao.impl.RecordDAOImpl;
import com.hutubill.entity.Category;
import com.hutubill.entity.Record;
import com.hutubill.service.RecordService;

import java.util.Date;

/**
 * @Author: Jaye
 * @Description:
 * @Date:Created in 22:49 2018/4/11
 * @Modify By:
 */
public class RecordServiceImpl implements RecordService {
    RecordDAO recordDAO = new RecordDAOImpl();
    @Override
    public void add(int spend, Category category, String comment, Date date) {
        Record record = new Record();
        record.spend = spend;
        record.cid = category.id;
        record.comment = comment;
        record.date = date;

        recordDAO.add(record);
    }

    @Override
    public Record inquiry(int id, int spend, Category category, String comment, Date date) {
        Record record = new Record();
        record.id = id;
        record.spend = spend;
        record.cid = category.id;
        record.comment = comment;
        record.date = date;
        recordDAO.inquiry(record);

        return record;
    }
}
