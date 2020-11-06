package com.hutubill.gui.model;

import com.hutubill.dao.RecordDAO;
import com.hutubill.dao.impl.RecordDAOImpl;
import com.hutubill.entity.Record;

import javax.swing.table.AbstractTableModel;
import java.util.List;

/**
 * @Author: Jaye
 * @Description:
 * @Date:Created in 22:30 2018/4/13
 * @Modify By:
 */
public class RecordTableModel extends AbstractTableModel{
    String[] columnNames = new String[] {"id", "spend", "cid", "comment", "date"};

    //使用从DAO返回的List作为TableModel的数据
    RecordDAO recordDAO = new RecordDAOImpl();
    public List<Record> recordList = recordDAO.list();

    //recordList.size()返回一共有多少行
    @Override
    public int getRowCount() {
        return recordList.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    public String getColumnName(int columnIndex) {
        return columnNames[columnIndex];
    }

    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return  false;
    }
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Record record = recordList.get(rowIndex);
        if (0 == columnIndex) {
            return record.id;
        }
        if (1 == columnIndex) {
            return record.spend;
        }
        if (2 == columnIndex) {
            return  record.cid;
        }
        if (3 == columnIndex) {
            return  record.comment;
        }
        if (4 == columnIndex) {
            return record.date;
        }
        return null;
    }
}
