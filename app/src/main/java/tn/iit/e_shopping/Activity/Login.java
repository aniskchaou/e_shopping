package tn.iit.e_shopping.Activity;

import android.content.Context;
import android.content.Intent;
<<<<<<< ec700dd9cfc4895636f662f8c6c2f90c50b3d536
=======
import android.content.SharedPreferences;
>>>>>>> 4eme commit
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
<<<<<<< ec700dd9cfc4895636f662f8c6c2f90c50b3d536
=======
import android.widget.CheckBox;
>>>>>>> 4eme commit
import android.widget.EditText;
import android.widget.Toast;

import tn.iit.e_shopping.R;
import tn.iit.e_shopping.database.DataBaseHelper;
import tn.iit.e_shopping.database.DataBaseUserHelper;

public class Login extends AppCompatActivity implements View.OnClickListener {
    DataBaseHelper dh;

<<<<<<< ec700dd9cfc4895636f662f8c6c2f90c50b3d536
    EditText login,pwd;
    Button login_bt;
    DataBaseUserHelper duh;
=======
    EditText inputlogin,inputMot_passe;
    Button login_bt;
    CheckBox checkBox;
    DataBaseUserHelper duh;
    /* Enregistrement des préférences */
    public static final String PREFS_NAME = ".Preferences";
    private static final String PREF_Login = "login";
    private static final String PREF_PASSWORD = "password";
    private static final String PREF_CHECKED = "checked";
>>>>>>> 4eme commit
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        duh=new DataBaseUserHelper(this);
<<<<<<< ec700dd9cfc4895636f662f8c6c2f90c50b3d536
        login= (EditText) findViewById(R.id.txt_log_login);
        pwd= (EditText) findViewById(R.id.txt_log_pwd);
        login_bt= (Button) findViewById(R.id.bt_log_log);
        login_bt.setOnClickListener(this);


=======
        inputlogin= (EditText) findViewById(R.id.txt_log_login);
        inputMot_passe= (EditText) findViewById(R.id.txt_log_pwd);
        checkBox = (CheckBox)findViewById(R.id.cb_garder);
        login_bt= (Button) findViewById(R.id.bt_Login);
        login_bt.setOnClickListener(this);

 /* Restauration des préférences sauvegardées si la checkbox est cochée */
        SharedPreferences pref = getSharedPreferences(PREFS_NAME,MODE_PRIVATE);
        String login=pref.getString(PREF_Login,"");
        String password = pref.getString(PREF_PASSWORD, "");
        String checked = pref.getString(PREF_CHECKED, "");

        inputlogin.setText(login);
        inputMot_passe.setText(password);
        checkBox.setChecked(Boolean.parseBoolean(checked));
>>>>>>> 4eme commit
    }

    @Override
    public void onClick(View v) {
<<<<<<< ec700dd9cfc4895636f662f8c6c2f90c50b3d536
     boolean  existe =duh.login(login.getText().toString(),pwd.getText().toString());
=======
        /* Enregistrement des préférences si la checkbox est cochée */
        if (checkBox.isChecked())
        {
            getSharedPreferences(PREFS_NAME,MODE_PRIVATE)
                    .edit()
                    .putString(PREF_Login, inputlogin.getText().toString())
                    .putString(PREF_PASSWORD, inputMot_passe.getText().toString())
                    .putString(PREF_CHECKED,"TRUE")
                    .commit();
        }
				 /* Sinon on les efface */
        else if(!checkBox.isChecked())
        {
            getSharedPreferences(PREFS_NAME,MODE_PRIVATE).edit().clear().commit();
        }
     boolean  existe =duh.login(inputlogin.getText().toString(),inputMot_passe.getText().toString());
>>>>>>> 4eme commit
        if(existe)
        {
            Intent intent=new Intent(this,Acceuil.class);
            startActivity(intent);
        }else
        {
            Toast.makeText(this,"erreur login ou mot de passe",Toast.LENGTH_LONG).show();
        }
    }
}
