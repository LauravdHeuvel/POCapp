package com.example.heuvell.daoclasses;

/**
 * Created by HeuvelL on 18-2-2015.
 */
import com.example.heuvell.domainclasses.Food;
import com.example.heuvell.exceptions.SQLIntegrityConstraintViolationException;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class FoodDAO implements Serializable {
    private Connection conn = null;
    private PreparedStatement ptmt = null;
    private ResultSet resultset = null;

    public FoodDAO() {
    }
    private Connection getConnection() throws SQLException {
        Connection conn = null;
        conn = ConnectionFactory.getInstance().getConnection();
        return conn;
    }

    public void add(Food food) {

        try {
            String query = "insert into food values (?,?,?)";
            conn = getConnection();
            ptmt = conn.prepareStatement(query);
            ptmt.setInt(1, food.getFoodNumber());
            ptmt.setInt(2, food.getEggsNumber());
            ptmt.setString(3, food.getFoodName());
            ptmt.executeUpdate();
        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("Duplicate key" + food.getFoodNumber());
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
    public Food findFood(int foodNumber) {
        Food food = null;
        int rowcount = 0;
        try {
            String query = "select * from food where foodNumber=?";
            conn = getConnection();
            ptmt = conn.prepareStatement(query);
            ptmt.setInt(1, foodNumber);
            resultset = ptmt.executeQuery();
            if (resultset.last()) {
                rowcount = resultset.getRow();
            }
            if (rowcount == 0) {
                return food;
            } else {
                resultset.first();
                food = new Food();
                food.setFoodNumber(resultset.getInt(1));
                food.setEggsNumber(resultset.getInt(2));
                food.setFoodName(resultset.getString(3));

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
        return food;
    }

    public void updateFood(Food food) {
        String query = "update food set eggsNumber=?, foodName=? where foodNumber =?";
        try {
            conn = getConnection();
            ptmt = conn.prepareStatement(query);
            ptmt.setInt(1, food.getFoodNumber());
            ptmt.setInt(2, food.getEggsNumber());
            ptmt.setString(3, food.getFoodName());
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

    public void delete(Food food){
        String query = "delete from food where foodNumber=?";
        try {
            conn = getConnection();
            ptmt = conn.prepareStatement(query);
            ptmt.setInt(1, food.getFoodNumber());
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