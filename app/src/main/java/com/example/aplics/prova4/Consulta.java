package com.example.aplics.prova4;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by usuario on 20/05/2016.
 */
public class Consulta extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro_datos);
        final String tl = getIntent().getStringExtra("tipo_llamada");
        TextView miTl = (TextView) findViewById(R.id.textView);
        miTl.setText("TIPO: " + tl);
        TextView mib = (TextView) findViewById(R.id.button_siguiente);
        mib.setText("TIPO:"+tl);
        final EditText miNombre = (EditText) findViewById(R.id.editTextNombre);
        final EditText miFecha = (EditText) findViewById(R.id.editTextFecha);
        Button botonCargaWeb = (Button) findViewById(R.id.button_siguiente);
        botonCargaWeb.setOnClickListener(new View.OnClickListener() {
            // el método onClick nos dice la acción a realizar cuando hay un clic
            @Override
            public void onClick(View v) {
                Intent llamadaWeb;
                if (tl.compareTo("ConResult") == 0) {
                    // Para ello debo crear un Intent
                    llamadaWeb = new Intent();
                } else {
                    llamadaWeb = new Intent(getApplicationContext(), Web.class);
                }
                //llamadaWeb.putExtra("nombre",miNombre.getText().toString() );
                //llamadaWeb.putExtra("fecha",miFecha.getText().toString() );
                String min = miNombre.getText().toString();
                String fec = miFecha.getText().toString();
                llamadaWeb.putExtra("nombre",min );
                llamadaWeb.putExtra("fecha",fec );
                if (tl.compareToIgnoreCase("ConResult") == 0) {
                    setResult(Activity.RESULT_OK,llamadaWeb);
                    finish();
                } else {
                    startActivity(llamadaWeb);
                }
            }
        }
        );
    }
}