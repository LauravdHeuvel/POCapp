package com.example.heuvell.epdapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
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
import java.util.Date;
import java.util.List;

/**
 * Created by HeuvelL on 16-2-2015.
 */
public class RoomActivity extends Activity implements View.OnClickListener {

    private PatientDAO patientDAO;
    private Patient patient;
    private PatientEPD patientEPD;
    private PatientEPDDAO patientEPDDAO;
    private int thisRoomNumber;
    private int loggedInNurseNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.epdsperroom_screen);

        thisRoomNumber = Integer.parseInt(getIntent().getStringExtra("roomNumber"));
        loggedInNurseNumber = Integer.parseInt(getIntent().getStringExtra("loggedInNurse"));

        List patientsInThisRoom = new ArrayList();
        patientsInThisRoom = patientEPDDAO.findAll();

        List patientEPDs = new ArrayList();

        for (int i = 0; i < patientsInThisRoom.size(); i++) {
            PatientEPDDAO EPDtoSearch = new PatientEPDDAO();

            PatientEPD rightPatientEPD = new PatientEPD();
            rightPatientEPD = EPDtoSearch.findPatientEPD(i);
            if (!rightPatientEPD.equals(null)&& rightPatientEPD.getNurseNumber() == loggedInNurseNumber && rightPatientEPD.getRoomNumber() == thisRoomNumber) {
                patientEPDs.add(rightPatientEPD);
            }
        }

        Collections.sort(patientEPDs, new Comparator<PatientEPD>() {
            public int compare(PatientEPD m1, PatientEPD m2) {
                return m1.getDate().compareTo(m2.getDate());
            }
        });

        List patientEPDsToWriteDown = new ArrayList();
        for (int z = 0; z < patientEPDs.size(); z++){
            PatientEPDDAO EPDtoSearch = new PatientEPDDAO();

            PatientEPD rightPatientEPD = new PatientEPD();
            rightPatientEPD = EPDtoSearch.findPatientEPD(z);

            if (!patientEPDsToWriteDown.contains(rightPatientEPD.getPatientNumber())){
                patientEPDsToWriteDown.add(patientEPDs.get(z));
            }
        }

        final TableLayout table = (TableLayout) findViewById(R.id.my_table);
        final TableRow tr = (TableRow) getLayoutInflater().inflate(R.layout.table_row_item, null);

        TextView tv;
        PatientDAO patientDAOforTable = new PatientDAO();
        Patient patientForTable = new Patient();
        EmployeeDAO employeeDAOForTable = new EmployeeDAO();
        Employee employeeForTable = new Employee();

        for (int x = 0; x < patientEPDsToWriteDown.size(); x++){

            final PatientEPD pEPD = (PatientEPD) patientEPDsToWriteDown.get(x);

            patientForTable = patientDAOforTable.findPatient(pEPD.getPatientNumber());
            employeeForTable = employeeDAOForTable.findEmployee(pEPD.getEmployeeNumber());

            tv = (TextView) tr.findViewById(R.id.DateTxtView);
            tv.setText(String.valueOf(pEPD.getDate()));

            tv = (TextView) tr.findViewById(R.id.PatientNameTxtView);
            tv.setText(patientForTable.getName());

            tv = (TextView) tr.findViewById(R.id.DoctorTxtView);
            tv.setText(String.valueOf(employeeForTable.getName()));

            tv = (TextView) tr.findViewById(R.id.DiagnosisTxtView);
            tv.setText(pEPD.getDiagnosis());

            tv = (TextView) tr.findViewById(R.id.EggsTxtView);
            tv.setText(pEPD.getEggsEaten());

            tv = (TextView) tr.findViewById(R.id.AddTxtView);
            tv.setText("X");
            tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View arg0) {
                    Intent myIntent = new Intent(arg0.getContext(), EPDsPerPersonActivity.class);
                    myIntent.putExtra("patientNumber", pEPD.getPatientNumber());
                    startActivityForResult(myIntent, 0);
                    new EPDsPerPersonActivity();
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
        new LoggedInActivity();

    }
}
