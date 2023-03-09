package com.example.muabansach;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Login_Book extends Activity {
    TextView textFileSignUpnow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login_book);
        System.out.println(textFileSignUpnow);
        textFileSignUpnow=(TextView) findViewById(R.id.txt_Donthavepassowork);
        textFileSignUpnow.setOnClickListener(v -> {
            startActivity(new Intent(this, Register_Book.class));
            finish();
        });
    }
    private Boolean validateEmail(){
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        String val = ((EditText)findViewById(R.id.editText_userEmailLogin)).getText().toString().trim();
        if(val.isEmpty()){
            ((EditText)findViewById(R.id.editText_userEmailLogin)).setError("Field cannot be empty");
            return false;
        }
        else if(!val.matches(emailPattern)){
            ((EditText)findViewById(R.id.editText_userEmailLogin)).setError("Invalid email address");
            return false;
        }
        else{
            ((EditText)findViewById(R.id.editText_userEmailLogin)).setError(null);
            return true;
        }


    }
    private  Boolean validatePassword(){
        String val = ((EditText)findViewById(R.id.editText_Login_password)).getText().toString().trim();
        if(val.isEmpty()){
            ((EditText)findViewById(R.id.editText_Login_password)).setError("Field cannot be empty");
            return false;
        }else{
            ((EditText)findViewById(R.id.editText_Login_password)).setError(null);
            return true;
        }

    }



    public void onclickLogin(View view){
        if(!validateEmail() | !validatePassword()){
            return;
        }

        finish();
    }
}