package com.hutubill.dao.impl;

import com.hutubill.dao.CategoryDAO;
import com.hutubill.entity.Category;
import com.hutubill.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAOImpl implements CategoryDAO {

    @Override
    public int getTotal() {

        String sql = "select count(*) from category";
        int total = 0;

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
    public void add(Category category) {

        String sql = "insert into category values(null, ?)";
        String sql1 = "select * from category";
        try  {
            Connection conn = DBUtil.getConnection();
            PreparedStatement pre = conn.prepareStatement(sql);
            PreparedStatement pre1 = conn.prepareStatement(sql1);
            pre.setString(1,category.name);
            pre.execute();
            ResultSet result = pre.getGeneratedKeys();

            if (result.next()) {
                int id = result.getInt(1);
                category.id = id;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Category category) {

        String sql = "update category set name = ? where id = ?";

        try {
            Connection conn = DBUtil.getConnection();
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, category.name);
            pre.setInt(2, category.id);
            pre.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {

        String sql = "delete from category where id = " + id;

        try {
            Connection conn = DBUtil.getConnection();
            Statement statement = conn.createStatement();
            statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Category get(int id) {
        Category category = null;
        String sql = "select * from category where id = " + id;
        try {
            Connection conn = DBUtil.getConnection();
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);

            if (result.next()) {
                category = new Category();
                String name = result.getString(2);
                category.name = name;
                category.id = id;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return category;
    }

    @Override
    public List<Category> list() {
        return list(0, Short.MAX_VALUE);
    }

    @Override
    public List<Category> list(int start, int count) {

        List<Category> categoryList = new ArrayList<Category>();
        String sql = "select * from category order by id desc limit ?, ?";

        try {
            Connection conn = DBUtil.getConnection();
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, start);
            pre.setInt(2, count);
            ResultSet result = pre.executeQuery();
            while (result.next()) {
                Category category = new Category();
                int id = result.getInt(1);
                String name = result.getString(2);
                category.id = id;
                category.name = name;
                categoryList.add(category);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categoryList;
    }
}
