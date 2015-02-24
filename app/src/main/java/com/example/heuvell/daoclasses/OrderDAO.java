package com.example.heuvell.daoclasses;

/**
 * Created by HeuvelL on 18-2-2015.
 */
import com.example.heuvell.domainclasses.Order;
import com.example.heuvell.exceptions.SQLIntegrityConstraintViolationException;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class OrderDAO implements Serializable {
    private Connection conn = null;
    private PreparedStatement ptmt = null;
    private ResultSet resultset = null;

    public OrderDAO() {
    }
    private Connection getConnection() throws SQLException {
        Connection conn = null;
        conn = ConnectionFactory.getInstance().getConnection();
        return conn;
    }

    public void add(Order order) {

        try {
            String query = "insert into order values (?,?,?,?,?)";
            conn = getConnection();
            ptmt = conn.prepareStatement(query);
            ptmt.setInt(1, order.getOrderNumber());
            ptmt.setInt(2, order.getFoodNumber());
            ptmt.setInt(3, order.getPatientNumber());
            ptmt.setDate(4, (java.sql.Date) order.getDate());
            ptmt.setInt(5, order.getEaten());
            ptmt.executeUpdate();
        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("Duplicate key" + order.getOrderNumber());
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
    public Order findOrder(int orderNumber) {
        Order order = null;
        int rowcount = 0;
        try {
            String query = "select * from order where orderNumber=?";
            conn = getConnection();
            ptmt = conn.prepareStatement(query);
            ptmt.setInt(1, orderNumber);
            resultset = ptmt.executeQuery();
            if (resultset.last()) {
                rowcount = resultset.getRow();
            }
            if (rowcount == 0) {
                return order;
            } else {
                resultset.first();
                order = new Order();
                order.setOrderNumber(resultset.getInt(1));
                order.setFoodNumber(resultset.getInt(2));
                order.setPatientNumber(3);
                order.setDate(resultset.getDate(4));
                order.setEaten(resultset.getInt(5));
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
        return order;
    }

    public void updateOrder(Order order) {
        String query = "update order set foodNumber=?, patientNumber=?, date=?, eaten=? where orderNumber =?";
        try {
            conn = getConnection();
            ptmt = conn.prepareStatement(query);
            ptmt.setInt(1, order.getOrderNumber());
            ptmt.setInt(2, order.getFoodNumber());
            ptmt.setInt(3, order.getPatientNumber());
            ptmt.setDate(4, (java.sql.Date) order.getDate());
            ptmt.setInt(5, order.getEaten());
            ptmt.executeUpdate();
        } catch (SQLException e) {
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
    }

    public void delete(Order order){
        String query = "delete from order where orderNumber=?";
        try {
            conn = getConnection();
            ptmt = conn.prepareStatement(query);
            ptmt.setInt(1, order.getOrderNumber());
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

