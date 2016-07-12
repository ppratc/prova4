package com.example.aplics.prova4;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.content.Intent;

/**
 * Created by usuario on 20/05/2016.
 */
public class Web extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        String n = getIntent().getStringExtra("nombre");
        String f = getIntent().getStringExtra("fecha");
        TextView miNombre = (TextView) findViewById(R.id.textViewDatos);
        miNombre.setText("Nombre: " + n + "\nFecha: " + f);
        //pickContact();
        Button botonFinaliza = (Button) findViewById(R.id.button_web);
        botonFinaliza.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                finish();
            }
        });

    }



}
