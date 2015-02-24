package com.example.heuvell.epdapplication;

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
import com.example.heuvell.domainclasses.Nurse;
import com.example.heuvell.domainclasses.Patient;


public class MainActivity extends Activity implements View.OnClickListener  {

   private ImageView image;
    private Nurse nurse = new Nurse();
    private NurseDAO nurseDAO = new NurseDAO();

    private String nurseNumber;
    private String nursePassword;
    private EditText textFieldNumber;

   private String filledInPassword;
   private EditText textFieldPassword;

  private  EditText errorView;







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        image = (ImageView) findViewById(R.id.imageView);
        image.setImageResource(R.drawable.logo55);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(this);



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    public void onClick(View v){
       textFieldNumber = (EditText) findViewById(R.id.editTextNumber);
        nurseNumber = String.valueOf(textFieldNumber.getText());
        nurse = nurseDAO.findNurse(Integer.parseInt(nurseNumber));
        nursePassword = nurse.getPassword();

        textFieldPassword = (EditText) findViewById(R.id.editTextPassword);
        filledInPassword = String.valueOf(textFieldPassword.getTextAlignment());

        errorView = (EditText) findViewById(R.id.textViewError);


        if (filledInPassword.equals(nursePassword)){


            //Doorsturen welke verpleegkundige is ingelogd
            Intent myIntent = new Intent(v.getContext(), LoggedInActivity.class);
            myIntent.putExtra("loggedInNurse", nurseNumber);
            startActivityForResult(myIntent, 0);
            Intent nextIntent = new Intent(v.getContext(), NewEPDActivity.class);
            myIntent.putExtra("nurse", nurseNumber);
            startActivityForResult(nextIntent, 0);


            new LoggedInActivity();
        }
       else {

            errorView.setText("ID en wachtwoord komen niet overeen.");
        }


    }
}
