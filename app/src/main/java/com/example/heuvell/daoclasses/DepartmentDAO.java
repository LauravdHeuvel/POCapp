package com.example.heuvell.daoclasses;

/**
 * Created by HeuvelL on 18-2-2015.
 */
import com.example.heuvell.domainclasses.Department;
import com.example.heuvell.exceptions.SQLIntegrityConstraintViolationException;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDAO implements Serializable {
    private Connection conn = null;
    private PreparedStatement ptmt = null;
    private ResultSet resultset = null;

    public DepartmentDAO() {
    }
    private Connection getConnection() throws SQLException {
        Connection conn = null;
        conn = ConnectionFactory.getInstance().getConnection();
        return conn;
    }

    public void add(Department department) {

        try {
            String query = "insert into department values (?,?,?)";
            conn = getConnection();
            ptmt = conn.prepareStatement(query);
            ptmt.setInt(1, department.getDepartmentNumber());
            ptmt.setString(2, department.getDepartmentName());
            ptmt.setString(3, department.getLocation());
            ptmt.executeUpdate();
        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("Duplicate key" + department.getDepartmentNumber());
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
    public Department findDepartment(int departmentNumber) {
        Department department = null;
        int rowcount = 0;
        try {
            String query = "select * from department where departmentNumber=?";
            conn = getConnection();
            ptmt = conn.prepareStatement(query);
            ptmt.setInt(1, departmentNumber);
            resultset = ptmt.executeQuery();
            if (resultset.last()) {
                rowcount = resultset.getRow();
            }
            if (rowcount == 0) {
                return department;
            } else {
                resultset.first();
                department = new Department();
                department.setDepartmentNumber(resultset.getInt(1));
                department.setDepartmentName(resultset.getString(2));
                department.setLocation(resultset.getString(3));

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
        return department;
    }

    public void updateDepartment(Department department) {
        String query = "update department set departmentName=?, location=? where departmentNumber =?";
        try {
            conn = getConnection();
            ptmt = conn.prepareStatement(query);
            ptmt.setInt(1, department.getDepartmentNumber());
            ptmt.setString(2, department.getDepartmentName());
            ptmt.setString(3, department.getLocation());

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

    public void delete(Department department){
        String query = "delete from department where departmentNumber=?";
        try {
            conn = getConnection();
            ptmt = conn.prepareStatement(query);
            ptmt.setInt(1, department.getDepartmentNumber());
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

    public List findAll(){
        List departments = new ArrayList();
        Department department=  null;
        try{
            final String query = "select * from department";
            conn = getConnection();
            ptmt = conn.prepareStatement(query);
            resultset = ptmt.executeQuery();
            while(resultset.next()){
                department = new Department();
                department = new Department();
                department.setDepartmentNumber(resultset.getInt(1));
                department.setDepartmentName(resultset.getString(2));
                department.setLocation(resultset.getString(3));

                departments.add(department);
            }

        }catch (SQLException e) {
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
        return departments;
    }
}

