package com.example.aplics.prova4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    static final int PICK_CONTACT_REQUEST = 1;  // The request code
    TextView miC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        miC = (TextView) findViewById(R.id.textCabecera);

        Button botonCargaConsulta = (Button) findViewById(R.id.button_inicia);
        // Implemento el método que define los que hacemos al presionar el botón
        // El Listener espera eventos del Botón
        botonCargaConsulta.setOnClickListener(new View.OnClickListener() {
            // el método onClick nos dice la acción a realizar cuando hay un clic
            @Override
            public void onClick(View v) {
                // Para ello debo crear un Intent
                Intent llamadaConsulta = new Intent(getApplicationContext(), Consulta.class);
                // y arrancar el Intent
                llamadaConsulta.putExtra("tipo_llamada","SinResult" );

                startActivity(llamadaConsulta);
            }
        }
        );

        Button botonCargaConsultaResult = (Button) findViewById(R.id.button_inicia_result);
        // Implemento el método que define los que hacemos al presionar el botón
        // El Listener espera eventos del Botón
        botonCargaConsultaResult.setOnClickListener(new View.OnClickListener() {
            // el método onClick nos dice la acción a realizar cuando hay un clic
            @Override
            public void onClick(View v) {
                // Para ello debo crear un Intent
                Intent llamadaConsulta = new Intent(getApplicationContext(), Consulta.class);
                // y arrancar el Intent
                llamadaConsulta.putExtra("tipo_llamada","ConResult" );
                startActivityForResult(llamadaConsulta,PICK_CONTACT_REQUEST);
            }
        }
        );
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode,resultCode,data);
        // Check which request we're responding to
        if (requestCode == PICK_CONTACT_REQUEST) {
            if (resultCode == RESULT_OK) {
                String n = data.getStringExtra("nombre");
                String f = data.getStringExtra("fecha");

                miC.setText("Nombre: " + n + "\nfecha:" + f);
            }
        }
    }



}


