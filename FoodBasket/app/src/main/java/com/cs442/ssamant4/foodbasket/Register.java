package com.cs442.ssamant4.foodbasket;

import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

public class Register extends AppCompatActivity {
    EditText ET_PASSWORD,ET_USER_NAME,ET_USER_EMAIL,ET_USER_ADDRESS;
    String user_name,user_role,user_pass,user_address;
    AlertDialog alertDialog;
    boolean status;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        alertDialog=new AlertDialog.Builder(this).create();
        setContentView(R.layout.activity_register);
        ET_USER_NAME=(EditText)findViewById(R.id.new_user_name);
        ET_PASSWORD=(EditText)findViewById(R.id.new_user_pass);
        ET_USER_EMAIL=(EditText)findViewById(R.id.new_user_email);
        ET_USER_ADDRESS=(EditText)findViewById(R.id.new_user_address);
    }
    public void userReg(View view)
    {
        user_name=ET_USER_NAME.getText().toString();
        user_pass=ET_PASSWORD.getText().toString();
        user_role=ET_USER_EMAIL.getText().toString();
        user_address=ET_USER_ADDRESS.getText().toString();
        String method="register";
        status = isValidEmail(ET_USER_EMAIL.getText());
        if(status == true) {
            BackgroundTask backgroundTask = new BackgroundTask(this);
            backgroundTask.execute(method, user_name, user_pass, user_role, user_address);
        }
        else
        {
            alertDialog.setTitle("Registration Information....");
            alertDialog.setMessage("Enter Valid email");
              alertDialog.show();
        }
//        alertDialog.setTitle("Registration Information....");
        //      alertDialog.setMessage("Registration successul");
        //    alertDialog.show();
        //finish();
    }
    public final static boolean isValidEmail(CharSequence target) {
        if (TextUtils.isEmpty(target)) {
            return false;
        } else {
            return android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
        }
    }
}
