package com.example.muabansach;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import  android.view.View;

public class Register_Book extends Activity {
    TextView editText_HaveAcount ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_book);
        editText_HaveAcount =(TextView) findViewById(R.id.editText_HaveAcount);
        editText_HaveAcount.setOnClickListener(v -> {
            startActivity(new Intent(this, Login_Book.class));
            finish();
        });

    }
    private Boolean validateName(){
        String val = ((EditText)findViewById(R.id.editText_userEmailLogin)).getText().toString();
        if(val.isEmpty()){
        ((EditText)findViewById(R.id.editText_userEmailLogin)).setError("Field cannot be empty");
        return false;
    }else{
        ((EditText)findViewById(R.id.editText_userEmailLogin)).setError(null);
        return true;
    }

}

    private Boolean validateEmail(){
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        String val = ((EditText)findViewById(R.id.editText_Login_password)).getText().toString();
        if(val.isEmpty()){
            ((EditText)findViewById(R.id.editText_Login_password)).setError("Field cannot be empty");
            return false;
        }
        else if(!val.matches(emailPattern)){
            ((EditText)findViewById(R.id.editText_Login_password)).setError("Invalid email address");
            return false;
        }
        else{
            ((EditText)findViewById(R.id.editText_Login_password)).setError(null);
            return true;
        }
      

    }

    private Boolean validatePassword(){
        String val = ((EditText)findViewById(R.id.editText_regiser_pw)).getText().toString();
        if(val.isEmpty()){
            ((EditText)findViewById(R.id.editText_regiser_pw)).setError("Field cannot be empty");
            return false;
        }else{
            ((EditText)findViewById(R.id.editText_regiser_pw)).setError(null);
            return true;
        }

    }

    private Boolean validateRepassword(){
        String val = ((EditText)findViewById(R.id.editText_registerRepassword)).getText().toString();
        if(!val.equals(((EditText)findViewById(R.id.editText_regiser_pw)).getText().toString())){
            ((EditText)findViewById(R.id.editText_registerRepassword)).setError("Field don't match");
            return false;
        }else if(val.isEmpty()){
            ((EditText)findViewById(R.id.editText_registerRepassword)).setError("Field cannot be empty");

            return false;
        }
        else {
            ((EditText)findViewById(R.id.editText_registerRepassword)).setError(null);
            return true;
        }

    }
    public void onClickRegister(View view){
        if(!validateName() | !validateEmail() | !validatePassword() | !validateRepassword()){
            return;
        }
        String name = ((EditText)findViewById(R.id.editText_userEmailLogin)).getText().toString();
        String email = ((EditText)findViewById(R.id.editText_Login_password)).getText().toString();
        String password = ((EditText)findViewById(R.id.editText_regiser_pw)).getText().toString();
        String rePassword = ((EditText)findViewById(R.id.editText_registerRepassword)).getText().toString();
//        UserHelperClass userHelper = new UserHelper(name,email,password,rePassword);

    }
}