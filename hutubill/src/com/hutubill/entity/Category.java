package com.hutubill.entity;

public class Category {
    public int id;
    public String name;
    public int recordNumber;

    public Category() {
    }

    public Category(int id, String name, int recordNumber) {
        this.id = id;
        this.name = name;
        this.recordNumber = recordNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRecordNumber() {
        return recordNumber;
    }

    public void setRecordNumber(int recordNumber) {
        this.recordNumber = recordNumber;
    }

    @Override
    public String toString() {
        return "Category{" +
                "name='" + name + '\'' +
                '}';
    }
}
