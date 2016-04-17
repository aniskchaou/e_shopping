package tn.iit.e_shopping.Activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import tn.iit.e_shopping.R;
import tn.iit.e_shopping.database.DataBaseHelper;

public class AjouterProduit extends AppCompatActivity {
    EditText marque,prix,adresse,categorie,carateristique;
    Button ajouter;
    DataBaseHelper dbh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajouter_produit);

        dbh=new DataBaseHelper(this);
        marque= (EditText) findViewById(R.id.txt_marque);
        prix=(EditText)findViewById(R.id.txt_prix);
        adresse=(EditText)findViewById(R.id.txt_adresse);
        categorie=(EditText)findViewById(R.id.categorie);
        carateristique=(EditText)findViewById(R.id.txt_caracterisque);
        ajouter =(Button)findViewById(R.id.bt_ajouter);



        ajouter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbh.insertDB(marque.getText().toString(),carateristique.getText().toString(),prix.getText().toString(),adresse.getText().toString(),categorie.getText().toString(),"dsf");
            //   dbh.insertDB("sdf","qsd","sd","qdf","qd","dsf");
          // Log.e("qd",marque.getText().toString()+""+carateristique.getText().toString()+""+Integer.parseInt(prix.getText().toString())+""+adresse.getText().toString()+""+categorie.getText().toString());
               StringBuffer sb=new StringBuffer();
                Cursor cr=dbh.getAllData();
                while (cr.moveToNext())
                {
                  sb.append("id "+cr.getString(0));
                    sb.append("marque "+cr.getString(1));
                    sb.append("crarestique "+cr.getString(2));
                    sb.append("prix "+cr.getString(3));

                }

                Toast.makeText(getApplicationContext(), "produit est ajoute avec succes", Toast.LENGTH_SHORT).show();
                Intent in=new Intent(getApplicationContext(),ListesProduit.class);
                startActivity(in);
            }
        });
    }



}
