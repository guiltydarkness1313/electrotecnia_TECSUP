package com.shibuyaxpress.electrotecniatecsup;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class SistemaMonofasicoActivity extends AppCompatActivity {
    Button btnCalcular;
    EditText txtVol,txtImp,txtRespu;
    double x,y,z;
    //se pasaran dos arraylist con los puntos de los ejes
    ArrayList<Double> puntosX= new ArrayList<>();
    ArrayList<Double> puntosY=new ArrayList<>();
    //el contador vera si hay la misma cantidad de puntos por eje para evitar problemas
    int contadorX=0,contadorY=0;
    int sample=5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sistema_monofasico);


        btnCalcular=(Button)findViewById(R.id.btnCalcular);
        txtVol=(EditText)findViewById(R.id.txtA2);
        txtImp=(EditText)findViewById(R.id.txtZ2);
        txtRespu=(EditText)findViewById(R.id.txtC2);

    }

    public void Calcular(View view){
        try{
            x = Double.parseDouble(txtVol.getText().toString());
            y = Double.parseDouble(txtImp.getText().toString());
            z = (x/ Math.sqrt(3))/y;
            txtRespu.setText(String.valueOf(z));
            txtRespu.setEnabled(false);

        }catch (Exception e1){

        }
    }
    public void Limpiar(View view){
        try{
            txtVol.setText("");
            txtImp.setText("");
            txtRespu.setText("");
            puntosY.clear();
            puntosX.clear();
        }catch (Exception e1){

        }
    }

    public void AgregaX(View view){

        try {
            puntosX.add(Double.parseDouble(txtVol.getText().toString()));
            contadorX++;
            Toast.makeText(getApplicationContext(), String.valueOf(puntosX.size())+"° punto añadido", Toast.LENGTH_SHORT).show();
        }catch (Exception e1){

        }
    }

    public void AgregaY(View view){

        try {
            puntosY.add(Double.parseDouble(txtImp.getText().toString()));
            contadorY++;
            Toast.makeText(getApplicationContext(), String.valueOf(puntosY.size())+"° punto añadido", Toast.LENGTH_SHORT).show();
        }catch (Exception e1){

        }
    }

    public void Pass(View view){

        if(puntosX.size()==puntosY.size()) {
            Intent act = new Intent();
            act.setClass(getApplicationContext(), GraficoActivity.class);
            act.putExtra("listaX",puntosX);
            act.putExtra("listaY",puntosY);
            act.putExtra("sample",sample);
            //Toast.makeText(getApplicationContext(),puntosX.size()+"   "+puntosY.size(),Toast.LENGTH_SHORT).show();
            startActivity(act);

        }
        else{
            Toast.makeText(getApplicationContext(),"no se puede iniciar por tener una cantidad de puntos desiguales", Toast.LENGTH_SHORT).show();

        }
    }
}
