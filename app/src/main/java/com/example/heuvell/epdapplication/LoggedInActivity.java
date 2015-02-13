package com.example.heuvell.epdapplication;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.heuvell.daoclasses.NurseDAO;
import com.example.heuvell.daoclasses.PatientDAO;
import com.example.heuvell.daoclasses.PatientEPDDAO;
import com.example.heuvell.domainclasses.Nurse;
import com.example.heuvell.domainclasses.Patient;
import com.example.heuvell.domainclasses.PatientEPD;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by HeuvelL on 12-2-2015.
 */
public class LoggedInActivity extends Activity implements View.OnClickListener {


    private Nurse nurse;
    private NurseDAO nurseDAO;
    private PatientDAO patientDAO;
    private Patient patient;
    private PatientEPD patientEPD;
    private PatientEPDDAO patientEPDDAO;
    private String name;
    private int number;
    private int roomNumber;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int loggedInNurseNumber = Integer.parseInt(getIntent().getStringExtra("loggedInNurse"));
        nurse = nurseDAO.findNurse(loggedInNurseNumber);
        List patients = new ArrayList();
        List nursesPatients = new ArrayList();
        patients = patientEPDDAO.findAll();

        for (int i = 0; i < patients.size(); i++) {
            PatientEPDDAO EPDtoSearch = new PatientEPDDAO();

            PatientEPD rightPatientEPD = new PatientEPD();
            rightPatientEPD = EPDtoSearch.findPatientEPD(i);
            if (rightPatientEPD.getNurseNumber() == loggedInNurseNumber) {
                nursesPatients.add(rightPatientEPD);
            }
        }

        List roomNumbersForThisNurse = new ArrayList();

        for (int x = 0; x < nursesPatients.size(); x++) {
            PatientEPDDAO patientToWriteDownDAO = new PatientEPDDAO();
            PatientEPD patientToWriteDown = new PatientEPD();
            patientToWriteDown = (PatientEPD) nursesPatients.get(x);

            roomNumber = patientToWriteDown.getRoomNumber();
            roomNumbersForThisNurse.add(roomNumber);

        }

        List uniqueRoomNumbers = new ArrayList();

        for (int z = 0; z < roomNumbersForThisNurse.size(); z++){
            if (!uniqueRoomNumbers.contains(roomNumbersForThisNurse.get(z))){
                uniqueRoomNumbers.add(roomNumbersForThisNurse.get(z));
            }
        }

        Collections.sort(uniqueRoomNumbers);


        for (int j = 0; j < uniqueRoomNumbers.size(); j++){
            //Kamernummers opschrijven
        }


    }

    @Override
    public void onClick(View v) {

    }

}
