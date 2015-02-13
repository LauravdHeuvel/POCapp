package com.example.heuvell.daoclasses;

/**
 * Created by HeuvelL on 12-2-2015.
 */

import com.example.heuvell.domainclasses.ThisInfusion;
import com.example.heuvell.exceptions.SQLIntegrityConstraintViolationException;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class ThisInfusionDAO implements Serializable {
    private Connection conn = null;
    private PreparedStatement ptmt = null;
    private ResultSet resultset = null;

    public ThisInfusionDAO() {
    }

    private Connection getConnection() throws SQLException {
        Connection conn = null;
        conn = ConnectionFactory.getInstance().getConnection();
        return conn;
    }

    public void add(ThisInfusion thisinfusion) {

        try {
            String query = "insert into thisinfusion values (?,?,?,?)";
            conn = getConnection();
            ptmt = conn.prepareStatement(query);
            ptmt.setInt(1, thisinfusion.getThisInfusionNumber());
            ptmt.setInt(2, thisinfusion.getInfusionNumber());
            ptmt.setInt(3, thisinfusion.getPatientEPDNumber());
            ptmt.setInt(4, thisinfusion.getInfusionDuration());

            ptmt.executeUpdate();
        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("Duplicate key" + thisinfusion.getThisInfusionNumber());
            e.printStackTrace();
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

    public ThisInfusion findThisInfusion(int thisInfusionNumber) {
        ThisInfusion thisInfusion = null;
        int rowcount = 0;
        try {
            String query = "select * from thisinfusion where thisInfusionNumber=?";
            conn = getConnection();
            ptmt = conn.prepareStatement(query);
            ptmt.setInt(1, thisInfusionNumber);
            resultset = ptmt.executeQuery();
            if (resultset.last()) {
                rowcount = resultset.getRow();
            }
            if (rowcount == 0) {
                return thisInfusion;
            } else {
                resultset.first();
                thisInfusion = new ThisInfusion();
                thisInfusion.setThisInfusionNumber((resultset.getInt(1)));
                thisInfusion.setInfusionNumber(resultset.getInt(2));
                thisInfusion.setPatientEPDNumber(resultset.getInt(3));
                thisInfusion.setInfusionDuration(resultset.getInt(4));

            }
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
        return thisInfusion;
    }


    public void delete(ThisInfusion thisInfusion) {
        String query = "delete from thisinfusion where thisInfusionNumber=?";
        try {
            conn = getConnection();
            ptmt = conn.prepareStatement(query);
            ptmt.setInt(1, thisInfusion.getThisInfusionNumber());
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

    public void updateThisInfusion(ThisInfusion thisInfusion) {
        String query = "update thisinfusion set  infusionNumber=?, patientEPDNumber=?, infusionDuration=? where thisInfusionNumber =?";
        try {
            conn = getConnection();
            ptmt = conn.prepareStatement(query);
            ptmt.setInt(1, thisInfusion.getThisInfusionNumber());
            ptmt.setInt(2, thisInfusion.getInfusionNumber());
            ptmt.setInt(3, thisInfusion.getPatientEPDNumber());
            ptmt.setInt(4, thisInfusion.getInfusionDuration());


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