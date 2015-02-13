package com.example.heuvell.daoclasses;

/**
 * Created by HeuvelL on 12-2-2015.
 */
import com.example.heuvell.domainclasses.Patient;
import com.example.heuvell.exceptions.SQLIntegrityConstraintViolationException;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class PatientDAO implements Serializable {
    private Connection conn = null;
    private PreparedStatement ptmt = null;
    private ResultSet resultset = null;

    public PatientDAO() {
    }
    private Connection getConnection() throws SQLException {
        Connection conn = null;
        conn = ConnectionFactory.getInstance().getConnection();
        return conn;
    }

    public void add(Patient patient) {

        try {
            String query = "insert into patient values (?,?,?,?)";
            conn = getConnection();
            ptmt = conn.prepareStatement(query);
            ptmt.setInt(1, patient.getPatientNumber());
            ptmt.setString(2, patient.getName());
            ptmt.setString(3, patient.getAddress());
            ptmt.setString(4, patient.getRecidence());
            ptmt.executeUpdate();
        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("Duplicate key" + patient.getPatientNumber());
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
    public Patient findPatient(int patientNumber) {
        Patient patient = null;
        int rowcount = 0;
        try {
            String query = "select * from patient where patientNumber=?";
            conn = getConnection();
            ptmt = conn.prepareStatement(query);
            ptmt.setInt(1, patientNumber);
            resultset = ptmt.executeQuery();
            if (resultset.last()) {
                rowcount = resultset.getRow();
            }
            if (rowcount == 0) {
                return patient;
            } else {
                resultset.first();
                patient = new Patient();
                patient.setPatientNumber(resultset.getInt(1));
                patient.setName(resultset.getString(2));
                patient.setAddress(resultset.getString(3));
                patient.setRecidence(resultset.getString(4));
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
        return patient;
    }

    public void updatePatient(Patient patient) {
        String query = "update patient set recidence=?, name=?,address=? where patientNumber =?";
        try {
            conn = getConnection();
            ptmt = conn.prepareStatement(query);
            ptmt.setInt(1, patient.getPatientNumber());
            ptmt.setString(2, patient.getName());
            ptmt.setString(3, patient.getAddress());
            ptmt.setString(4, patient.getRecidence());
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

    public void delete(Patient patient){
        String query = "delete from patient where patientNumber=?";
        try {
            conn = getConnection();
            ptmt = conn.prepareStatement(query);
            ptmt.setInt(1, patient.getPatientNumber());
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

