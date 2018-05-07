package com.hutubill.service;

import com.hutubill.entity.Category;
import com.hutubill.entity.Record;

import java.util.Date;

/**
 * @Author: Jaye
 * @Description:
 * @Date:Created in 22:48 2018/4/11
 * @Modify By:
 */
public interface RecordService {

    public void add(int spend, Category category, String comment, Date date);

    public Record inquiry(int id, int spend, Category category, String comment, Date date);
}
