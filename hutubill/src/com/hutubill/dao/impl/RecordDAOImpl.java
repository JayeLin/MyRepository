package com.hutubill.dao.impl;

import com.hutubill.dao.RecordDAO;
import com.hutubill.entity.Record;
import com.hutubill.util.DBUtil;
import com.hutubill.util.DateUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author: Jaye
 * @Description:
 * @Date:Created in 23:31 2018/4/9
 * @Modify By:
 */
public class RecordDAOImpl implements RecordDAO {


    @Override
    public int getTotal() {
        int total = 0;
        String sql = "select count(*) from record";

        try {
            Connection conn = DBUtil.getConnection();
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);
            while (result.next()) {
                total = result.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return total;
    }

    @Override
    public void inquiry(Record record) {
        String sql = "select * from record";

        try {
            Connection conn = DBUtil.getConnection();
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);

            while (result.next()) {
                int id = result.getInt(1);
                int spend = result.getInt(2);
                int cid = result.getInt(3);
                String comment = result.getString(4);
                Date date = result.getDate(5);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void add(Record record) {
        String sql = "insert into record values(null, ?, ?, ?, ?)";

        try {
            Connection conn = DBUtil.getConnection();
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, record.spend);
            pre.setInt(2, record.cid);
            pre.setString(3, record.comment);
            pre.setDate(4, DateUtil.util2sql(record.date));

            pre.execute();

            ResultSet result = pre.getGeneratedKeys();
            if (result.next()) {
                int id = result.getInt(1);
                record.id = id;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Record record) {
        String sql = "update record set spend = ?, cid = ?, comment = ?, date = ? where id = ?";

        try {
            Connection conn = DBUtil.getConnection();
            PreparedStatement pre = conn.prepareStatement(sql);

            pre.setInt(1, record.spend);
            pre.setInt(2, record.cid);
            pre.setString(3, record.comment);
            pre.setDate(4, DateUtil.util2sql(record.date));
            pre.setInt(5, record.id);

            pre.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String sql = "delete from record where id = " + id;

        try {
            Connection conn = DBUtil.getConnection();
            Statement statement = conn.createStatement();
            statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Record get(int id) {
        Record record = null;
        String sql = "select * from record where id = " + id;
        try {
            Connection conn = DBUtil.getConnection();
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);

            if (result.next()) {
                record = new Record();
                int spend = result.getInt("spend");
                int cid = result.getInt("cid");
                String comment = result.getString("comment");
                Date date = result.getDate("date");

                record.spend = spend;
                record.cid = cid;
                record.comment = comment;
                record.date = date;
                record.id = id;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return record;
    }

    @Override
    public List<Record> list() {
        return list(0, Short.MAX_VALUE);
    }

    @Override
    public List<Record> list(int start, int count) {
        List<Record> recordList = new ArrayList<Record>();
        String sql = "select * from record order by id desc limit ?, ?";
        try {
            Connection conn = DBUtil.getConnection();
            PreparedStatement pre = conn.prepareStatement(sql);

            pre.setInt(1, start);
            pre.setInt(2, count);

            ResultSet result = pre.executeQuery();

            while (result.next()) {
                Record record = new Record();
                int id = result.getInt("id");
                int spend = result.getInt("spend");
                int cid = result.getInt("cid");
                String comment = result.getString("comment");
                Date date = result.getDate("date");

                record.id = id;
                record.spend = spend;
                record.cid = cid;
                record.comment = comment;
                record.date = date;

                recordList.add(record);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return recordList;
    }

    @Override
    public List<Record> list(int cid) {
        List<Record> recordList = new ArrayList<Record>();
        String sql = "select * from record where id = ?";

        try {
            Connection conn = DBUtil.getConnection();
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, cid);
            ResultSet result = pre.executeQuery();

            while (result.next()) {
                Record record = new Record();
                int id = result.getInt("id");
                int spend = result.getInt("spend");
                String comment = result.getString("comment");
                Date date = result.getDate("date");

                record.id = id;
                record.spend = spend;
                record.cid = cid;
                record.comment = comment;
                record.date = date;
                recordList.add(record);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return recordList;
    }

    @Override
    public List<Record> listToday() {
        return list(DateUtil.today());
    }

    @Override
    public List<Record> list(Date day) {
        List<Record> recordList = new ArrayList<Record>();
        String sql = "select * from record where date = ?";

        try {
            Connection conn = DBUtil.getConnection();
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setDate(1, DateUtil.util2sql(day));
            ResultSet result = pre.executeQuery();

            while (result.next()) {
                Record record = new Record();
                int id = result.getInt("id");
                int cid = result.getInt("cid");
                int spend = result.getInt("spend");
                String comment = result.getString("comment");
                Date date = result.getDate("date");

                record.id = id;
                record.spend = spend;
                record.cid = cid;
                record.comment = comment;
                record.date = date;

                recordList.add(record);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return recordList;
    }

    @Override
    public List<Record> listThisMonth() {
        return list(DateUtil.monthBegin(), DateUtil.monthEnd());
    }

    @Override
    public List<Record> list(Date start, Date end) {
        List<Record> recordList = new ArrayList<Record>();
        String sql = "select * from record where date >= ? and date <= ?";

        try {
            Connection conn = DBUtil.getConnection();
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setDate(1, DateUtil.util2sql(start));
            pre.setDate(2, DateUtil.util2sql(end));

            ResultSet result = pre.executeQuery();
            while (result.next()) {
                Record record = new Record();
                int id = result.getInt("id");
                int cid = result.getInt("cid");
                int spend = result.getInt("spend");
                String comment = result.getString("comment");
                Date date = result.getDate("date");

                record.id = id;
                record.spend = spend;
                record.cid = cid;
                record.comment = comment;
                record.date = date;

                recordList.add(record);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return recordList;
    }
}
