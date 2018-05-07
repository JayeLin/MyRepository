package com.hutubill.dao;

import com.hutubill.entity.Config;
import com.hutubill.entity.Record;

import java.util.List;

public interface ConfigDAO {

    public int getTotal();

    public void add(Config config);

    public void update(Config config);

    public void delete(int id);

    public Config get(int id);

    public List<Config> list();

    public List<Config> list(int start, int count);

    public Config getByKey(String key);

}
