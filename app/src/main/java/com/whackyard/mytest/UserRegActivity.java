package com.whackyard.mytest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserRegActivity extends AppCompatActivity {

    private EditText mName;
    private EditText mEmail;
    private EditText mMobNum;
    private EditText mPassword;
    private EditText mPasswordRep;
    private EditText mDate;

    private Button mSubmit;

    private RadioGroup mGenderGroup;
    private RadioButton mGenderBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_reg);

        mName = (EditText) findViewById(R.id.etFullName);
        mEmail = (EditText) findViewById(R.id.etEmailID);
        mMobNum = (EditText) findViewById(R.id.etMobileNum);
        mPassword = (EditText) findViewById(R.id.etPassword);
        mPasswordRep = (EditText) findViewById(R.id.etPasswordRep);
        mDate = (EditText) findViewById(R.id.etDate);
        mSubmit = (Button) findViewById(R.id.btnRegSubmit);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String email = mEmail.getText().toString();
                if(!isValidEmail(email)){
                    mEmail.setError("Invalid Email");
                    
                }

                final String pass = mPassword.getText().toString();
                final String passRep = mPasswordRep.getText().toString();
                if(!isValidPassword(pass,passRep)){
                    mPassword.setError("Invalid Password");
                }

                final String name = mName.getText().toString();
                if(!isValidName(name)){
                    mName.setError("Invalid Name");
                }

                final String mob = mMobNum.getText().toString();
                if(!isValidMobNumber(mob)){
                    mMobNum.setError("Invalid Phone Number");
                }

                final String dob = mDate.getText().toString();
                if(!isValidDate(dob)){
                    mDate.setError("Invalid Date Format");
                }

                if(isValidEmail(email) && isValidDate(dob) && isValidMobNumber(mob) && isValidName(name) && isValidPassword(pass,passRep)){
                    try {
                        GMailSender sender = new GMailSender("zayid4u@gmail.com", "9995561576");
                        sender.sendMail("Registration Successful",
                                "Test body by Z",
                                "zayid4u@gmail.com",
                                email);
                    } catch (Exception e) {
                        Toast.makeText(UserRegActivity.this, "Registration Successful",Toast.LENGTH_LONG).show();
                    }
                    Intent intent = new Intent(getBaseContext(), MainActivity.class);
                    startActivity(intent);
                }
            }
        });
    }

    private boolean isValidDate(String dob) {
        DateFormat df = new SimpleDateFormat("dd-mm-yyyy");
        int age=0;
        try {
            Date dateOb = df.parse(dob);
            Date dateToday=new Date();
            age=dateToday.getYear()-dateOb.getYear();
        } catch (ParseException e) {
            //mDate.setError("Invalid Date Format");
        }
        if(age>16){
            return true;
        }
        else{
            mDate.setError("Age Must be over 16");
            return false;
        }
    }

    private boolean isValidMobNumber(String mob) {
        String NUM_PATTERN = "\\d{10}";
        Pattern pattern = Pattern.compile(NUM_PATTERN);
        Matcher matcher = pattern.matcher(mob);
        return  matcher.matches();
    }

    private boolean isValidName(String name) {
        String NAME_PATTERN = "^[\\p{L} .'-]+$";

        Pattern pattern = Pattern.compile(NAME_PATTERN);
        Matcher matcher = pattern.matcher(name);
        return matcher.matches();
    }

    private boolean isValidPassword(String pass, String passRep) {
        if (pass != null && pass.length() >= 6 && pass.equals(passRep)) {
            return true;
        }
        return false;
    }

    private boolean isValidEmail(String email) {
        String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
