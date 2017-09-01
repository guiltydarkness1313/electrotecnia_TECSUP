package com.shibuyaxpress.electrotecniatecsup;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class MenuTipoElectricidadActivity extends AppCompatActivity {
    public ImageView monofasico;
    public ImageView trifasico;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tipo_electricidad);
        monofasico  = (ImageView)findViewById(R.id.monofasico);
        trifasico = (ImageView)findViewById(R.id.trifasico);

        monofasico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
Intent intent1 = new Intent(MenuTipoElectricidadActivity.this,SistemaMonofasicoActivity.class);
                startActivity(intent1);
            }
        });


        trifasico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            alertDialogBasico();

            }
        });


    }

    public void alertDialogBasico(){


        // 1. Instancia de AlertDialog.Builder con este constructor
        android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(this);

        // 2. Encadenar varios métodos setter para ajustar las características del diálogo
        builder.setMessage("Escoja el sistema para calcular")
                .setTitle("TIPO DE SISTEMA");


        builder.setPositiveButton("Balanceado", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                Intent intent3 = new Intent(MenuTipoElectricidadActivity.this,SistemaBalanceadoActivity.class);
                startActivity(intent3);

            }
        });
        builder.setNegativeButton("Desbalanceado", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {

                Intent intent4 = new Intent(MenuTipoElectricidadActivity.this,SistemaDesbalanceadoActivity.class);
                startActivity(intent4);
            }
        });

        builder.show();

    }

}
