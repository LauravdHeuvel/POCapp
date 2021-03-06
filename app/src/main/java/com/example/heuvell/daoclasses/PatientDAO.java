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
import java.util.ArrayList;
import java.util.List;

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
            String query = "insert into patient values (?,?,?,?,?,?,?,?)";
            conn = getConnection();
            ptmt = conn.prepareStatement(query);
            ptmt.setInt(1, patient.getPatientNumber());
            ptmt.setString(2, patient.getName());
            ptmt.setString(3, patient.getAddress());
            ptmt.setString(4, patient.getRecidence());
            ptmt.setString(5, patient.getDiagnosis());
            ptmt.setInt(6, patient.getReanimate());
            ptmt.setInt(7, patient.getRoomNumber());
            ptmt.setInt(8, patient.getDepartment());
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
                patient.setDiagnosis(resultset.getString(5));
                patient.setReanimate(resultset.getInt(6));
                patient.setRoomNumber(resultset.getInt(7));
                patient.setDepartment(resultset.getInt(8));
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
        String query = "update patient set  name=?,address=?, recidence=?, diagnosis=?," +
                "reanimate=?,roomNumber=?,department=? where patientNumber =?";
        try {
            conn = getConnection();
            ptmt = conn.prepareStatement(query);
            ptmt.setInt(1, patient.getPatientNumber());
            ptmt.setString(2, patient.getName());
            ptmt.setString(3, patient.getAddress());
            ptmt.setString(4, patient.getRecidence());
            ptmt.setString(5, patient.getDiagnosis());
            ptmt.setInt(6, patient.getReanimate());
            ptmt.setInt(7, patient.getRoomNumber());
            ptmt.setInt(8, patient.getDepartment());
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

    public List findAll(){
        List patients = new ArrayList();
        Patient patient=  null;
        try{
            final String query = "select * from patient";
            conn = getConnection();
            ptmt = conn.prepareStatement(query);
            resultset = ptmt.executeQuery();
            while(resultset.next()){
                patient = new Patient();
                patient.setPatientNumber(resultset.getInt(1));
                patient.setDepartment(resultset.getInt(2));
                patient.setName(resultset.getString(3));
                patient.setAddress(resultset.getString(4));
                patient.setRecidence(resultset.getString(5));
                patient.setDiagnosis(resultset.getString(6));
                patient.setReanimate(resultset.getInt(7));
                patient.setRoomNumber(resultset.getInt(8));


                patients.add(patient);
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
        return patients;
    }
}

