package com.hutubill.service;

/**
 * @Author: Jaye
 * @Description:
 * @Date:Created in 22:47 2018/4/11
 * @Modify By:
 */
public interface ConfigService {

    public String get(String key);

    public void update(String key, String value);

    public int getIntBudget();
}
