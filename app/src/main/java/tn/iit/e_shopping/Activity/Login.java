package tn.iit.e_shopping.Activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import tn.iit.e_shopping.R;
import tn.iit.e_shopping.database.DataBaseHelper;
import tn.iit.e_shopping.database.DataBaseUserHelper;

public class Login extends AppCompatActivity implements View.OnClickListener {
    DataBaseHelper dh;

    EditText login,pwd;
    Button login_bt;
    DataBaseUserHelper duh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        duh=new DataBaseUserHelper(this);
        login= (EditText) findViewById(R.id.txt_log_login);
        pwd= (EditText) findViewById(R.id.txt_log_pwd);
        login_bt= (Button) findViewById(R.id.bt_log_log);
        login_bt.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
     boolean  existe =duh.login(login.getText().toString(),pwd.getText().toString());
        if(existe)
        {
            Intent intent=new Intent(this,ListesProduit.class);
            startActivity(intent);
        }else
        {
            Toast.makeText(this,"erreur login ou mot de passe",Toast.LENGTH_LONG).show();
        }
    }
}
