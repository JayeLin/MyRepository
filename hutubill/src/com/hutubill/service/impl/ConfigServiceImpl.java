package com.hutubill.service.impl;

import com.hutubill.dao.ConfigDAO;
import com.hutubill.dao.impl.ConfigDAOImpl;
import com.hutubill.entity.Config;
import com.hutubill.service.ConfigService;

/**
 * @Author: Jaye
 * @Description:
 * @Date:Created in 22:49 2018/4/11
 * @Modify By:
 */
public class ConfigServiceImpl implements ConfigService {
    public static final String budget = "budget";
    public static final String mysqlPath = "mysqlPath";
    public static final String default_budget = "500";

    static ConfigDAO configDAO = new ConfigDAOImpl();
    static {
        init();
    }

    public static void init() {
        init(budget, default_budget);
        init(mysqlPath, "");
    }

    private static void init(String key, String value) {
        Config config = configDAO.getByKey(key);
        if (config == null) {
            config = new Config();
            config.setKey(key);
            config.setValue(value);
            configDAO.add(config);
        }
    }
    @Override
    public String get(String key) {
        Config config = configDAO.getByKey(key);
        return config.getValue();
    }

    @Override
    public void update(String key, String value) {
        Config config = configDAO.getByKey(key);
        config.setValue(value);
        configDAO.update(config);
    }

    @Override
    public int getIntBudget() {
        return Integer.parseInt(get(budget));
    }
}
