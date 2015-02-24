package com.example.heuvell.epdapplication;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.ArrayAdapter;
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
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

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


    private Nurse nurse = new Nurse();
    private NurseDAO nurseDAO = new NurseDAO();
    private PatientDAO patientDAO = new PatientDAO(), toSearch = new PatientDAO();
    private Patient patient = new Patient(), rightPatient = new Patient();
    private int roomNumber;
    private int loggedInNurseNumber;
    private String selectedRoom;
    private List nursesPatients = new ArrayList(), patients = new ArrayList(), roomNumbersForThisNurse = new ArrayList();
    private List uniqueRoomNumbers = new ArrayList();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.roomstochoose_screen);
        addTable();
    }

    private void addTable() {

        loggedInNurseNumber = Integer.parseInt(getIntent().getStringExtra("loggedInNurse"));
        nurse = nurseDAO.findNurse(loggedInNurseNumber);


        patients = patientDAO.findAll();

        for (int i = 0; i < patients.size(); i++) {

            rightPatient = toSearch.findPatient(i);
            if (!rightPatient.equals(null)&& rightPatient.getDepartment() == nurse.getDepartmentNumber()) {
                nursesPatients.add(rightPatient);
            }
        }

        for (int x = 0; x < nursesPatients.size(); x++) {

            patient = (Patient) nursesPatients.get(x);
            if (!patient.equals(null)) {
                roomNumber = patient.getRoomNumber();
                roomNumbersForThisNurse.add(roomNumber);
            }

        }



        for (int z = 0; z < roomNumbersForThisNurse.size(); z++){


            if (!uniqueRoomNumbers.contains(roomNumbersForThisNurse.get(z))){
                uniqueRoomNumbers.add(roomNumbersForThisNurse.get(z));
            }
        }

        Collections.sort(uniqueRoomNumbers);
        final TableLayout table = (TableLayout) findViewById(R.id.my_table);
        final TableRow tr = (TableRow) getLayoutInflater().inflate(R.layout.table_row_item_rooms, null);

        TextView tv;
        // Fill out our cells

        for (int s = 0; s<uniqueRoomNumbers.size(); s++) {
            tv = (TextView) tr.findViewById(R.id.RoomNumberTxtView);
             selectedRoom = String.valueOf (uniqueRoomNumbers.get(s));
            tv.setText(selectedRoom);
            tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent myIntent = new Intent(v.getContext(), RoomActivity.class);
                    myIntent.putExtra("roomNumber", selectedRoom);
                    myIntent.putExtra("loggedInNurse", loggedInNurseNumber);
                    startActivityForResult(myIntent, 0);
                }
            });


            // Draw separator
            tv = new TextView(this);

            tv.setHeight(2);
            table.addView(tv);
        }

        // If you use context menu it should be registered for each table row

    }

    @Override
    public void onClick(View v) {
        new MainActivity();


    }

}
