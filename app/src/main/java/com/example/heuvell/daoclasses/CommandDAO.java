package com.example.heuvell.daoclasses;

/**
 * Created by HeuvelL on 12-2-2015.
 */
import com.example.heuvell.domainclasses.Command;
import com.example.heuvell.exceptions.SQLIntegrityConstraintViolationException;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class CommandDAO implements Serializable {
    private Connection conn = null;
    private PreparedStatement ptmt = null;
    private ResultSet resultset = null;

    public CommandDAO() {
    }
    private Connection getConnection() throws SQLException {
        Connection conn = null;
        conn = ConnectionFactory.getInstance().getConnection();
        return conn;
    }

    public void add(Command command) {

        try {
            String query = "insert into command values (?,?,?,?,?)";
            conn = getConnection();
            ptmt = conn.prepareStatement(query);
            ptmt.setInt(1, command.getCommandNumber());
            ptmt.setInt(2, command.getNurseNumber());
            ptmt.setInt(3, command.getEmployeeNumber());
            ptmt.setString(4, command.getContent());
            ptmt.setDate(5, command.getDate());
            ptmt.executeUpdate();
        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("Duplicate key" + command.getCommandNumber());
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
    public Command findCommand(int commandNumber) {
        Command command = null;
        int rowcount = 0;
        try {
            String query = "select * from command where commandNumber=?";
            conn = getConnection();
            ptmt = conn.prepareStatement(query);
            ptmt.setInt(1, commandNumber);
            resultset = ptmt.executeQuery();
            if (resultset.last()) {
                rowcount = resultset.getRow();
            }
            if (rowcount == 0) {
                return command;
            } else {
                resultset.first();
                command = new Command();
                command.setCommandNumber(resultset.getInt(1));
                command.setNurseNumber(resultset.getInt(2));
                command.setEmployeeNumber(resultset.getInt(3));
                command.setContent(resultset.getString(4));
                command.setDate(resultset.getDate(4));
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
        return command;
    }


    public void delete(Command command){
        String query = "delete from command where commandNumber=?";
        try {
            conn = getConnection();
            ptmt = conn.prepareStatement(query);
            ptmt.setInt(1, command.getCommandNumber());
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

