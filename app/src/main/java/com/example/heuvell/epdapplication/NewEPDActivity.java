package com.example.heuvell.epdapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.heuvell.daoclasses.EmployeeDAO;
import com.example.heuvell.daoclasses.PatientDAO;
import com.example.heuvell.daoclasses.PatientEPDDAO;
import com.example.heuvell.domainclasses.Employee;
import com.example.heuvell.domainclasses.Patient;
import com.example.heuvell.domainclasses.PatientEPD;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by HeuvelL on 16-2-2015.
 */
public class NewEPDActivity extends Activity implements View.OnClickListener {
    private Patient patient = new Patient();
    private PatientEPD patientEPD = new PatientEPD();
    private PatientDAO patientDAO = new PatientDAO();
    private PatientEPDDAO patientEPDDAO = new PatientEPDDAO();
    private TextView tv;
    private int thisPatient;
    private Spinner spinner;
    private Employee employee = new Employee();
    private EmployeeDAO employeedao = new EmployeeDAO();
    private EditText et, bp, bt, ps, ee, dia;
    private int loggedInNurseNumber;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newepd_screen);
        loggedInNurseNumber = Integer.parseInt(getIntent().getStringExtra("loggedInNurse"));

        String name = String.valueOf(findViewById(R.id.patientNameTextView));
        thisPatient = Integer.parseInt(getIntent().getStringExtra("patientNumber"));
        patient = patientDAO.findPatient(thisPatient);
        tv = (TextView) findViewById(R.id.patientNameTextView);
        tv.setText(patient.getName());

        spinner = (Spinner) findViewById(R.id.spinner);
        List employees = new ArrayList();
        employees.add(employeedao.findAll());
        List doctors = new ArrayList();
        for (int i = 0; i < employees.size(); i++){
            employee = (Employee) employees.get(i);

            if (employee.getFunction().equals("Arts")){
                String value1 = employee.getName();
                int value2 = employee.getEmployeeNumber();
                String toAdd = value1 + "-" + value2;
                doctors.add(toAdd);
            }
            ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_spinner_item, doctors);
            dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(dataAdapter);

        }



    }

    public void makeNewEPD(){
        java.util.Date date = new java.util.Date();
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        patientEPD.setDate(sqlDate);
        String  doctorNumber = String.valueOf(spinner.getSelectedItem());
        String[] parts = doctorNumber.split("-");
        String part1 = parts[0];
        String part2 = parts[1];
         patientEPD.setEmployeeNumber(Integer.parseInt(part2));
        et = (EditText) findViewById(R.id.temperatureET);
        patientEPD.setTemperature(Integer.parseInt(String.valueOf(et.getText())));
        bp = (EditText) findViewById(R.id.editText3);
        patientEPD.setBloodPressure(String.valueOf(bp.getText()));
        bt = (EditText) findViewById(R.id.editText4);
        patientEPD.setBreathing(Integer.parseInt(String.valueOf(bt.getText())));
        ps = (EditText) findViewById(R.id.editText5);
        patientEPD.setPain(Integer.parseInt(String.valueOf(ps.getText())));
        patientEPD.setEggsContent(0);
        patientEPD.setEggsEaten(0);
        ee = (EditText) findViewById(R.id.editText6);
        patientEPD.setEggsToEat(Integer.parseInt(String.valueOf(ee.getText())));
        patientEPD.setEggsEaten(0);
        patientEPD.setEggsContent(0);
        patientEPD.setNurseNumber(loggedInNurseNumber);
        patientEPD.setPatientNumber(thisPatient);





        patientEPDDAO.add(patientEPD);

    }

    @Override
    public void onClick(View v) {
    makeNewEPD();







    }
}
