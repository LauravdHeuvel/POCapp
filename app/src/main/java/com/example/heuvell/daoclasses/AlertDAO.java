package com.example.heuvell.daoclasses;

/**
 * Created by HeuvelL on 18-2-2015.
 */
import com.example.heuvell.domainclasses.Alert;
import com.example.heuvell.exceptions.SQLIntegrityConstraintViolationException;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class AlertDAO implements Serializable {
    private Connection conn = null;
    private PreparedStatement ptmt = null;
    private ResultSet resultset = null;

    public AlertDAO() {
    }
    private Connection getConnection() throws SQLException {
        Connection conn = null;
        conn = ConnectionFactory.getInstance().getConnection();
        return conn;
    }

    public void add(Alert alert) {

        try {
            String query = "insert into nurse values (?,?,?,?,?)";
            conn = getConnection();
            ptmt = conn.prepareStatement(query);
            ptmt.setInt(1, alert.getAlertNumber());
            ptmt.setInt(2, alert.getNurseNumber());
            ptmt.setDate(3, (java.sql.Date) alert.getDate());
            ptmt.setString(4, alert.getTime());
            ptmt.setString(5, alert.getContent());
            ptmt.executeUpdate();
        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("Duplicate key" + alert.getAlertNumber());
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            try {
                if (ptmt!= null){
                    ptmt.close();
                }
                if (conn!= null){
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public Alert findAlert(int alertNumber) {
        Alert alert = null;
        int rowcount = 0;
        try {
            String query = "select * from alert where alertNumber=?";
            conn = getConnection();
            ptmt = conn.prepareStatement(query);
            ptmt.setInt(1, alertNumber);
            resultset = ptmt.executeQuery();
            if (resultset.last()) {
                rowcount = resultset.getRow();
            }
            if (rowcount == 0) {
                return alert;
            } else {
                resultset.first();
                alert = new Alert();
                alert.setAlertNumber(resultset.getInt(1));
                alert.setNurseNumber(resultset.getInt(2));
                alert.setDate(resultset.getDate(3));
                alert.setTime(resultset.getString(4));
                alert.setContent(resultset.getString(5));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ptmt != null) {
                    ptmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return alert;
    }


    public void delete(Alert alert){
        String query = "delete from alert where alertNumber=?";
        try {
            conn = getConnection();
            ptmt = conn.prepareStatement(query);
            ptmt.setInt(1, alert.getAlertNumber());
            ptmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            try {
                if (ptmt!= null){
                    ptmt.close();
                }
                if (conn!= null){
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}