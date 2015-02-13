package com.example.heuvell.daoclasses;

/**
 * Created by HeuvelL on 12-2-2015.
 */

import com.example.heuvell.domainclasses.Question;
import com.example.heuvell.exceptions.SQLIntegrityConstraintViolationException;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class QuestionDAO implements Serializable {
    private Connection conn = null;
    private PreparedStatement ptmt = null;
    private ResultSet resultset = null;

    public QuestionDAO() {
    }
    private Connection getConnection() throws SQLException {
        Connection conn = null;
        conn = ConnectionFactory.getInstance().getConnection();
        return conn;
    }

    public void add(Question question) {

        try {
            String query = "insert into question values (?,?,?,?,?,?)";
            conn = getConnection();
            ptmt = conn.prepareStatement(query);
            ptmt.setInt(1, question.getQuestionNumber());
            ptmt.setInt(2, question.getNurseNumber());
            ptmt.setInt(3, question.getEmployeeNumber());
            ptmt.setString(4, question.getContent());
            ptmt.setDate(5, question.getDate());
            ptmt.executeUpdate();
        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("Duplicate key" + question.getQuestionNumber());
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
    public Question findQuestion(int questionNumber) {
        Question question = null;
        int rowcount = 0;
        try {
            String query = "select * from question where questionNumber=?";
            conn = getConnection();
            ptmt = conn.prepareStatement(query);
            ptmt.setInt(1, questionNumber);
            resultset = ptmt.executeQuery();
            if (resultset.last()) {
                rowcount = resultset.getRow();
            }
            if (rowcount == 0) {
                return question;
            } else {
                resultset.first();
                question = new Question();
                question.setQuestionNumber(resultset.getInt(1));
                question.setNurseNumber(resultset.getInt(2));
                question.setEmployeeNumber(resultset.getInt(3));
                question.setContent(resultset.getString(4));
                question.setDate(resultset.getDate(5));
                question.setAnswer(resultset.getString(6));
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
        return question;
    }


    public void delete(Question question){
        String query = "delete from question where questionNumber=?";
        try {
            conn = getConnection();
            ptmt = conn.prepareStatement(query);
            ptmt.setInt(1, question.getQuestionNumber());
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

    public void updateQuestion(Question question) {
        String query = "update question set nurseNumber=?, employeeNumber=?, content=?, date=?, answer=? where questionNumber =?";
        try {
            conn = getConnection();
            ptmt = conn.prepareStatement(query);
            ptmt.setInt(1, question.getQuestionNumber());
            ptmt.setInt(2, question.getNurseNumber());
            ptmt.setInt(3, question.getEmployeeNumber());
            ptmt.setString(4, question.getContent());
            ptmt.setDate(5, question.getDate());
            ptmt.setString(6, question.getAnswer());

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
}