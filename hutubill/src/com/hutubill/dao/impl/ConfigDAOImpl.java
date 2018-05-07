package com.hutubill.dao.impl;

import com.hutubill.dao.ConfigDAO;
import com.hutubill.entity.Config;
import com.hutubill.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Jaye
 * @Description:
 * @Date:Created in 21:04 2018/4/10
 * @Modify By:
 */
public class ConfigDAOImpl implements ConfigDAO {
    @Override
    public int getTotal() {
        int total = 0;
        String sql = "select count(*) from config";
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
    public void add(Config config) {
        String sql = "insert into config values(null, ?, ?)";
        String sql1 = "select * from config";

        try {
            Connection conn = DBUtil.getConnection();
            PreparedStatement pre = conn.prepareStatement(sql);
            PreparedStatement pre1 = conn.prepareStatement(sql1);
            pre.setString(1, config.key);
            pre.setString(2, config.value);
            pre.executeUpdate();

            ResultSet result = pre1.executeQuery();
            if (result.next()) {
                int id = result.getInt(1);
                config.id = id;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Config config) {
        String sql = "update config set key_ = ?, value = ? where id = ?";
        try {
            Connection conn = DBUtil.getConnection();
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, config.key);
            pre.setString(2, config.value);
            pre.setInt(3, config.id);

            pre.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String sql = "delete from config where id = " + id;

        try {
            Connection conn = DBUtil.getConnection();
            Statement statement = conn.createStatement();
            statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Config get(int id) {
        Config config = null;
        String sql = "select * from config where id = " + id;

        try {
            Connection conn = DBUtil.getConnection();
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);
            if (result.next()) {
                config = new Config();
                String key = result.getString("key_");
                String value = result.getString("value");
                config.key = key;
                config.value = value;
                config.id = id;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return config;
    }

    @Override
    public List<Config> list() {
        return list(0, Short.MAX_VALUE);
    }

    @Override
    public List<Config> list(int start, int count) {

        List<Config> configList = new ArrayList<Config>();
        String sql = "select * from config order by id desc limit ?, ?";

        try {
            Connection conn = DBUtil.getConnection();
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, start);
            pre.setInt(2, count);
            ResultSet result = pre.executeQuery();

            while (result.next()) {
                Config config = new Config();
                int id = result.getInt(1);
                String key = result.getString("key_");
                String value = result.getString("value");
                configList.add(config);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return configList;
    }

    @Override
    public Config getByKey(String key) {
        Config config = null;
        String sql = "select * from config where key_ = ?";

        try {
            Connection conn = DBUtil.getConnection();
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, key);
            ResultSet result = pre.executeQuery();

            if (result.next()) {
                config = new Config();
                int id = result.getInt("id");
                String value = result.getString("value");
                config.key = key;
                config.value = value;
                config.id = id;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return config;
    }
}
