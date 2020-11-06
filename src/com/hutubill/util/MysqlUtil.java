package com.hutubill.util;

import java.io.*;

/**
 * @Author: Jaye
 * @Description:
 * @Date:Created in 23:23 2018/4/14
 * @Modify By:
 */
public class MysqlUtil {
    public static void backup(String mysqlPath,String backupFile) throws  Exception{
        String commandFormat = "\"%s/bin/mysqldump.exe\" -u%s -p%s -hlocalhost -p%d %s -r \"%s\"";
        String command = String.format(commandFormat, mysqlPath, DBUtil.userName, DBUtil.password, DBUtil.port,
                DBUtil.database, backupFile);
        Runtime.getRuntime().exec(command);
    }

    public static void recover(String mysqlPath, String recoverFile) {

        try {
            String commandFormat = "\"%s/bin/mysql.exe\" -u%s -p%s %s ";
            String command = String.format(commandFormat, mysqlPath, DBUtil.userName, DBUtil.password,
                    DBUtil.database);
            Process process = Runtime.getRuntime().exec(command);
            OutputStream outputStream = process.getOutputStream();
            String inString;
            StringBuffer stringBuffer = new StringBuffer("");
            String outString;
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(
                    new FileInputStream(recoverFile), "utf8"));
            while ((inString = bufferedReader.readLine()) != null) {
                stringBuffer.append(inString + "\r\n");
            }
            outString = stringBuffer.toString();

            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, "utf8");
            outputStreamWriter.write(outString);
            outputStreamWriter.flush();
            outputStream.close();
            bufferedReader.close();
            outputStreamWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        String mysqlPath = "C:\\Program Files\\MySQL\\MySQL Server 5.5";
        String file = "G:\\sql\\hutubill.sql";

        //backup(mysqlPath, file);
        recover(mysqlPath, file);
    }
}
