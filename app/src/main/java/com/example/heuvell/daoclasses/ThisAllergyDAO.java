package com.example.heuvell.daoclasses;

/**
 * Created by HeuvelL on 12-2-2015.
 */
import com.example.heuvell.domainclasses.ThisAllergy;
import com.example.heuvell.exceptions.SQLIntegrityConstraintViolationException;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class ThisAllergyDAO implements Serializable {
    private Connection conn = null;
    private PreparedStatement ptmt = null;
    private ResultSet resultset = null;

    public ThisAllergyDAO() {
    }
    private Connection getConnection() throws SQLException {
        Connection conn = null;
        conn = ConnectionFactory.getInstance().getConnection();
        return conn;
    }

    public void add(ThisAllergy thisAllergy) {

        try {
            String query = "insert into thisallergy values (?,?,?)";
            conn = getConnection();
            ptmt = conn.prepareStatement(query);
            ptmt.setInt(1, thisAllergy.getThisAllergyNumber());
            ptmt.setInt(2, thisAllergy.getAllergyNumber());
            ptmt.setInt(3, thisAllergy.getPatientNumber());
            ptmt.executeUpdate();
        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("Duplicate key" + thisAllergy.getThisAllergyNumber());
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
    public ThisAllergy findThisAllergy(int thisAllergyNumber) {
        ThisAllergy thisAllergy = null;
        int rowcount = 0;
        try {
            String query = "select * from thisAllergy where thisAllergyNumber=?";
            conn = getConnection();
            ptmt = conn.prepareStatement(query);
            ptmt.setInt(1, thisAllergyNumber);
            resultset = ptmt.executeQuery();
            if (resultset.last()) {
                rowcount = resultset.getRow();
            }
            if (rowcount == 0) {
                return thisAllergy;
            } else {
                resultset.first();
                thisAllergy = new ThisAllergy();
                thisAllergy.setThisAllergyNumber(resultset.getInt(1));
                thisAllergy.setAllergyNumber(resultset.getInt(2));
                thisAllergy.setPatientNumber(resultset.getInt(3));

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
        return thisAllergy;
    }

    public void updateThisAllergy(ThisAllergy thisAllergy) {
        String query = "update thisallergy set allergyNumber=?, patientNumber=? where thisAllergyNumber =?";
        try {
            conn = getConnection();
            ptmt = conn.prepareStatement(query);
            ptmt.setInt(1, thisAllergy.getThisAllergyNumber());
            ptmt.setInt(2, thisAllergy.getAllergyNumber());
            ptmt.setInt(3, thisAllergy.getPatientNumber());

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

    public void delete(ThisAllergy thisAllergy){
        String query = "delete from thisallergy where thisAllergyNumber=?";
        try {
            conn = getConnection();
            ptmt = conn.prepareStatement(query);
            ptmt.setInt(1, thisAllergy.getThisAllergyNumber());
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

