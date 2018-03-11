package com.techespo.androiduibasic;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegistrationActivity extends Activity {

    Button btnRegister;
    EditText etUsername,etPassword;
    TextView label;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        etPassword = (EditText) findViewById(R.id.et_password);
        etUsername = (EditText) findViewById(R.id.et_username);
        label = (TextView) findViewById(R.id.label);

        btnRegister = (Button) findViewById(R.id.btn_register);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               String password= etPassword.getText().toString();
               String username =  etUsername.getText().toString();
               if(validation()) {
                   label.setText("Username:" + username + " , Password:" + password);
               }
               // Toast.makeText(RegistrationActivity.this,"Button Clicked",Toast.LENGTH_LONG).show();
            }
        });
    }


    private boolean validation(){
        if(etUsername.getText().toString() == null || etUsername.getText().toString().length()<=0){
            etUsername.setError("invalid username");
           return false;
        }
        if(etPassword.getText().toString() == null || etPassword.getText().toString().length()<=0){
            etPassword.setError("invalid password");
            return false;
        }
        return true;
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
