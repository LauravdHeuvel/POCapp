package com.example.heuvell.epdapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.heuvell.daoclasses.EmployeeDAO;
import com.example.heuvell.daoclasses.PatientDAO;
import com.example.heuvell.daoclasses.PatientEPDDAO;
import com.example.heuvell.domainclasses.Employee;
import com.example.heuvell.domainclasses.Patient;
import com.example.heuvell.domainclasses.PatientEPD;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by HeuvelL on 16-2-2015.
 */
public class EPDsPerPersonActivity extends Activity implements View.OnClickListener {

    private int thisPatient;
    private PatientEPDDAO patientEPDDAO = new PatientEPDDAO(), EPDtoSearch = new PatientEPDDAO();
   private Button button1, button2;
   private PatientEPD pEPD = new PatientEPD(), rightPatientEPD = new PatientEPD();
    List patientsInThisRoom = new ArrayList(), thisPatientsEPDs = new ArrayList();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thispersonsepds_screen);


        button1 = (Button) findViewById(R.id.backERDButton);
        button2 = (Button) findViewById(R.id.addERDButton);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        thisPatient = Integer.parseInt(getIntent().getStringExtra("patientNumber"));

        patientsInThisRoom = patientEPDDAO.findAll();


        for (int i = 0; i < patientsInThisRoom.size(); i++) {

            rightPatientEPD = EPDtoSearch.findPatientEPD(i);

            if (!rightPatientEPD.equals(null) && rightPatientEPD.getPatientNumber() == thisPatient) {
                thisPatientsEPDs.add(rightPatientEPD);
            }

        }

        Collections.sort(thisPatientsEPDs, new Comparator<PatientEPD>() {
            public int compare(PatientEPD m1, PatientEPD m2) {
                return m1.getDate().compareTo(m2.getDate());
            }
        });


        final TableLayout table = (TableLayout) findViewById(R.id.my_table);
        final TableRow tr = (TableRow) getLayoutInflater().inflate(R.layout.table_row_item, null);

        TextView tv;

        PatientDAO patientDAOforTable = new PatientDAO();
        Patient patientForTable = new Patient();
        EmployeeDAO employeeDAOForTable = new EmployeeDAO();
        Employee employeeForTable = new Employee();

        for (int x = 0; x < thisPatientsEPDs.size(); x++) {

            pEPD = (PatientEPD) thisPatientsEPDs.get(x);

            patientForTable = patientDAOforTable.findPatient(pEPD.getPatientNumber());
            employeeForTable = employeeDAOForTable.findEmployee(pEPD.getEmployeeNumber());


            tv = (TextView) tr.findViewById(R.id.patientNameInERD1);
             tv.setText(patientForTable.getName()+ " ");

            tv = (TextView) tr.findViewById(R.id.patientDateInERD1);
             tv.setText(String.valueOf(pEPD.getDate())+ " ");

            tv = (TextView) tr.findViewById(R.id.patientDoctorInERD1);
              tv.setText(employeeForTable.getName()+ " ");

            tv = (TextView) tr.findViewById(R.id.DiagnosisTxtView);
              tv.setText(patientForTable.getDiagnosis()+ " ");

            tv = (TextView) tr.findViewById(R.id.patientTempInERD1);
              tv.setText(pEPD.getTemperature()+ " ");



            tv = (TextView) tr.findViewById(R.id.patientReanimateInERD1);
            if(patientForTable.getReanimate() == 1){
                tv.setText("Ja ") ;
            }
            else{
                tv.setText("Nee ");
            }

            tv = (TextView) tr.findViewById(R.id.patientBloodPressureInERD1);
            tv.setText(pEPD.getBloodPressure()+ " ");

            tv = (TextView) tr.findViewById(R.id.patientBreathingInERD1);
            tv.setText(pEPD.getBreathing()+ " ");

            tv = (TextView) tr.findViewById(R.id.patientPainEPD1);
            tv.setText(pEPD.getPain()+ " ");

            tv = (TextView) tr.findViewById(R.id.patientEatenEPD1);

            tv.setText("X");
            tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View arg0) {
                    Intent myIntent = new Intent(arg0.getContext(), EPDsPerPersonActivity.class);
                    myIntent.putExtra("patientNumberForFood", pEPD.getPatientNumber());
                    startActivityForResult(myIntent, 0);

                }
            });


            // Draw separator
            tv = new TextView(this);

            tv.setHeight(2);
            table.addView(tv);

        }

    }



    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.backERDButton:
                new RoomActivity();
                break;
            case R.id.addERDButton:
                Intent myIntent = new Intent(v.getContext(), EPDsPerPersonActivity.class);
                myIntent.putExtra("patientNumberForFood", pEPD.getPatientNumber());
                startActivityForResult(myIntent, 0);
                new NewEPDActivity();
                break;

        }


    }
}
