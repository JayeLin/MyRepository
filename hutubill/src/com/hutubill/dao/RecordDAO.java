package com.hutubill.dao;

import com.hutubill.entity.Record;
import com.hutubill.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public interface RecordDAO {

    public int getTotal();

    public void inquiry(Record record);

    public void add(Record record);

    public void update(Record record);

    public void delete(int id);

    public Record get(int id);

    public List<Record> list();

    public List<Record> list(int start, int count);

    public List<Record> list(int cid);

    public List<Record> listToday();

    public List<Record> list(Date day);

    public List<Record> listThisMonth();

    public List<Record> list(Date start, Date end);

}
