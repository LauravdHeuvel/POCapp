package com.example.heuvell.daoclasses;

/**
 * Created by HeuvelL on 12-2-2015.
 */

import com.example.heuvell.domainclasses.PatientEPD;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.heuvell.exceptions.SQLIntegrityConstraintViolationException;
public class PatientEPDDAO implements Serializable {
    private Connection conn = null;
    private PreparedStatement ptmt = null;
    private ResultSet resultset = null;

    public PatientEPDDAO() {
    }
    private Connection getConnection() throws SQLException {
        Connection conn = null;
        conn = ConnectionFactory.getInstance().getConnection();
        return conn;
    }

    public void add(PatientEPD patientEPD) {

        try {
            String query = "insert into patientEPD values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            conn = getConnection();
            ptmt = conn.prepareStatement(query);
            ptmt.setInt(1, patientEPD.getPatientEPDNumber());
            ptmt.setInt(2, patientEPD.getPatientNumber());
            ptmt.setInt(3, patientEPD.getEmployeeNumber());
            ptmt.setInt(4, patientEPD.getNurseNumber());
            ptmt.setInt(5, patientEPD.getTemperature());
            ptmt.setString(6, patientEPD.getBloodPressure());
            ptmt.setInt(7, patientEPD.getBreathing());
            ptmt.setInt(8, patientEPD.getPain());
            ptmt.setDate(9, patientEPD.getDate());
            ptmt.setInt(10, patientEPD.getEggsToEat());
            ptmt.setInt(11, patientEPD.getEggsEaten());
            ptmt.setInt(12, patientEPD.getEggsContent());
            ptmt.setString(13, patientEPD.getDiagnosis());
            ptmt.setInt(14, patientEPD.getReanimate());
            ptmt.setInt(15, patientEPD.getRoomNumber());
            ptmt.executeUpdate();
        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("Duplicate key" + patientEPD.getPatientNumber());
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
    public PatientEPD findPatientEPD(int patientEPDNumber) {
        PatientEPD patientEPD = null;
        int rowcount = 0;
        try {
            String query = "select * from patientepd where patientEPDNumber=?";
            conn = getConnection();
            ptmt = conn.prepareStatement(query);
            ptmt.setInt(1, patientEPDNumber);
            resultset = ptmt.executeQuery();
            if (resultset.last()) {
                rowcount = resultset.getRow();
            }
            if (rowcount == 0) {
                return patientEPD;
            } else {
                resultset.first();
                patientEPD = new PatientEPD();
                patientEPD.setPatientEPDNumber(resultset.getInt(1));
                patientEPD.setPatientNumber(resultset.getInt(2));
                patientEPD.setEmployeeNumber(resultset.getInt(3));
                patientEPD.setNurseNumber(resultset.getInt(4));
                patientEPD.setTemperature(resultset.getInt(5));
                patientEPD.setBloodPressure(resultset.getString(6));
                patientEPD.setBreathing(resultset.getInt(7));
                patientEPD.setPain(resultset.getInt(8));
                patientEPD.setDate(resultset.getDate(9));
                patientEPD.setEggsToEat(resultset.getInt(10));
                patientEPD.setEggsEaten(resultset.getInt(11));
                patientEPD.setEggsContent(resultset.getInt(12));
                patientEPD.setDiagnosis(resultset.getString(13));
                patientEPD.setReanimate(resultset.getInt(14));
                patientEPD.setRoomNumber(resultset.getInt(15));

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
        return patientEPD;
    }




    public void updatePatientEPD(PatientEPD patientEPD) {
        String query = "update patientEPD set patientNumber=?, employeeNumber=?, nurseNumber=?,temperature=? " +
                ", bloodPressure=?, breathing=?, pain=?, date=?, eggsToEat=?, eggsContent=?," +
                "diagnosis=?, reanimate=?, roomNumber=? where patientEPDNumber = ?";
        try {
            conn = getConnection();
            ptmt = conn.prepareStatement(query);
            ptmt.setInt(1, patientEPD.getPatientEPDNumber());
            ptmt.setInt(2, patientEPD.getPatientNumber());
            ptmt.setInt(3, patientEPD.getEmployeeNumber());
            ptmt.setInt(4, patientEPD.getNurseNumber());
            ptmt.setInt(5, patientEPD.getTemperature());
            ptmt.setString(6, patientEPD.getBloodPressure());
            ptmt.setInt(7, patientEPD.getBreathing());
            ptmt.setInt(8, patientEPD.getPain());
            ptmt.setDate(9, patientEPD.getDate());
            ptmt.setInt(10, patientEPD.getEggsToEat());
            ptmt.setInt(11, patientEPD.getEggsEaten());
            ptmt.setInt(12, patientEPD.getEggsContent());
            ptmt.setString(13, patientEPD.getDiagnosis());
            ptmt.setInt(14, patientEPD.getReanimate());
            ptmt.setInt(15, patientEPD.getRoomNumber());
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

    public void delete(PatientEPD patientEPD){
        String query = "delete from patientEPD where patientEPDNumber=?";
        try {
            conn = getConnection();
            ptmt = conn.prepareStatement(query);
            ptmt.setInt(1, patientEPD.getPatientEPDNumber());
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
        List patientEPDs = new ArrayList();
        PatientEPD patientEPD=  null;
        try{
            final String query = "select * from patientepd";
            conn = getConnection();
            ptmt = conn.prepareStatement(query);
            resultset = ptmt.executeQuery();
            while(resultset.next()){
                patientEPD = new PatientEPD();
                patientEPD.setPatientEPDNumber(resultset.getInt(1));
                patientEPD.setPatientNumber(resultset.getInt(2));
                patientEPD.setEmployeeNumber(resultset.getInt(3));
                patientEPD.setNurseNumber(resultset.getInt(4));
                patientEPD.setTemperature(resultset.getInt(5));
                patientEPD.setBloodPressure(resultset.getString(6));
                patientEPD.setBreathing(resultset.getInt(7));
                patientEPD.setPain(resultset.getInt(8));
                patientEPD.setDate(resultset.getDate(9));
                patientEPD.setEggsToEat(resultset.getInt(10));
                patientEPD.setEggsEaten(resultset.getInt(11));
                patientEPD.setEggsContent(resultset.getInt(12));
                patientEPD.setDiagnosis(resultset.getString(13));
                patientEPD.setReanimate(resultset.getInt(14));
                patientEPD.setRoomNumber(resultset.getInt(15));
                patientEPDs.add(patientEPD);
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
        return patientEPDs;
    }
}

