package com.hutubill.util;

import com.hutubill.dao.RecordDAO;
import com.hutubill.dao.impl.RecordDAOImpl;
import com.hutubill.entity.Record;
import com.hutubill.gui.model.RecordTableModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

/**
 * @Author: Jaye
 * @Description:
 * @Date:Created in 23:22 2018/4/14
 * @Modify By:
 */
public class RecordUtil extends JDialog{
    static {
        GUIUtil.useLNF();
    }
    static RecordTableModel recordTableModel = new RecordTableModel();
    static JTable jTable = new JTable(recordTableModel);
//    static JButton bFirst = new JButton("首页");
//    static JButton bPre = new JButton("上一页");
//    static JButton bNext = new JButton("下一页");
//    static JButton bLast = new JButton("最后一页");
//    static int number = 10;//每页显示10个
//    static int start = 0;//开始的页码
    static JButton bDelete = new JButton("删除");
    static JButton bUpdate = new JButton("修改");
    static JButton bSubmit = new JButton("提交");
    public RecordUtil() {
        JFrame jFrame = new JFrame();
        this.setSize(400, 360);
        this.setLocation(200, 200);
//        this.setModal(true);
        this.setLayout(new BorderLayout());
        jTable.getSelectionModel().setSelectionInterval(0, 0);
        GUIUtil.setColor(ColorUtil.blueColor, bDelete, bUpdate);

        JPanel pDelete = new JPanel();
        pDelete.add(bDelete);
        pDelete.add(bUpdate);

        this.setVisible(true);
        bDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //判断是否选中
                int index = jTable.getSelectedRow();
                if (index == -1) {
                    JOptionPane.showMessageDialog(null, "删除前需要先选择一行");
                    return;
                }

                //进行确认是否需要删除
                if (JOptionPane.OK_OPTION != JOptionPane.showConfirmDialog(null, "确认要删除？")) {
                    return;
                }
                //获取id
                Record record = recordTableModel.recordList.get(index);
                int id = record.id;

                //删除
                new RecordDAOImpl().delete(id);
                updateTable();
            }
        });
        bUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //判断是否选中
                int index = jTable.getSelectedRow();
                if (index == -1) {
                    JOptionPane.showMessageDialog(pDelete, "编辑前需要先选中一行");
                    return;
                }
                //获取选中的对象
                Record record = recordTableModel.recordList.get(index);

                //显示编辑Dialog
                addDialog ed = new addDialog(jFrame);
                ed.tfspend.setText(String.valueOf((int) record.spend));
                ed.tfcid.setText(String.valueOf((int) record.cid));
                ed.tfcomment.setText(record.comment);

                ed.setVisible(true);
            }
        });
        JScrollPane jScrollPane = new JScrollPane(jTable);

        this.add( jScrollPane, BorderLayout.CENTER);
        this.add(pDelete, BorderLayout.SOUTH);
    }
    public static void updateTable() {
        RecordDAO recordDAO = new RecordDAOImpl();
        recordTableModel.recordList = recordDAO.list();
        jTable.updateUI();
        if (!recordTableModel.recordList.isEmpty()) {
            jTable.getSelectionModel().setSelectionInterval(0, 0);
        }
    }
    static class addDialog extends JDialog {
        JLabel lspend = new JLabel("消费");
        JLabel lcid = new JLabel("外键");
        JLabel lcomment = new JLabel("备注：");
        JTextField tfspend = new JTextField("");
        JTextField tfcid = new JTextField("");
        JTextField tfcomment = new JTextField("");

        addDialog(JFrame jFrame) {
            super(jFrame);
            this.setModal(true);
            int gap = 30;
            this.setLayout(new BorderLayout());

            JPanel pInput = new JPanel();
            JPanel pSubmit = new JPanel();
            pInput.setLayout(new GridLayout(3, 3, gap, gap));
            pInput.add(lspend);
            pInput.add(tfspend);
            pInput.add(lcid);
            pInput.add(tfcid);
            pInput.add(lcomment);
            pInput.add(tfcomment);
            pInput.add(bSubmit);
            GUIUtil.setColor(ColorUtil.blueColor, bSubmit);

            this.add(pInput, BorderLayout.NORTH);
            this.add(pSubmit, BorderLayout.CENTER);

            this.setSize(360, 320);
            this.setLocationRelativeTo(jFrame);
            bSubmit.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (GUIUtil.checkNumber(tfspend, "spend")) {
                        if (GUIUtil.checkNumber(tfcid, "cid")) {
                            if (GUIUtil.checkEmpty(tfcomment, "comment")) {
                                int index = jTable.getSelectedRow();
                                int id = recordTableModel.recordList.get(index).id;
                                int spend = Integer.parseInt(tfspend.getText());
                                int cid = Integer.parseInt(tfcid.getText());
                                String comment = tfcomment.getText();
                                Date date = DateUtil.today();
                                Record record = new Record();
                                record.spend = spend;
                                record.cid = cid;
                                record.comment = comment;
                                record.id = id;
                                record.date = date;
                                new RecordDAOImpl().update(record);
                                JOptionPane.showMessageDialog(jFrame, "提交成功");
                                addDialog.this.setVisible(false);
                                updateTable();
                            }
                        }
                    }
                }
            });
        }
    }
}
