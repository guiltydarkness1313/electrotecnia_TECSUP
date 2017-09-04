package com.shibuyaxpress.electrotecniatecsup;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class SistemaBalanceadoActivity extends AppCompatActivity {
 EditText txtVoltios, txtImpedancia, txtIntencidad1,txtIntencidad2,txtIntencidad3;
    Button btnCalcular;
    double x,y,z;
    //se pasaran dos arraylist con los puntos de los ejes
    ArrayList<Double> puntosX= new ArrayList<>();
    ArrayList<Double> puntosY=new ArrayList<>();
    //el contador vera si hay la misma cantidad de puntos por eje para evitar problemas
    int contadorX=0,contadorY=0;
    int sample=4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sistema_balanceado);

        btnCalcular = (Button)findViewById(R.id.btnCalcular2);
        txtVoltios = (EditText)findViewById(R.id.txtVolt);
        txtImpedancia = (EditText)findViewById(R.id.txtImp);
        txtIntencidad1 = (EditText)findViewById(R.id.txtInt1);
        txtIntencidad2 = (EditText)findViewById(R.id.txtInt2);
        txtIntencidad3 = (EditText)findViewById(R.id.txtInt3);
    }
    public void Calcular(View view){
        try{
            x = Double.parseDouble(txtVoltios.getText().toString());
            y = Double.parseDouble(txtImpedancia.getText().toString());
            z = (x/ Math.sqrt(3))/y;
            txtIntencidad1.setText(String.valueOf(z));
            txtIntencidad1.setEnabled(false);
            txtIntencidad2.setText(String.valueOf(z));
            txtIntencidad2.setEnabled(false);
            txtIntencidad3.setText(String.valueOf(z));
            txtIntencidad3.setEnabled(false);

        }catch (Exception e1){

        }
    }
    //funcion del boton limpiar
    public void Limpiar(View view ){
        try {
            txtVoltios.setText("");
            txtImpedancia.setText("");
            txtIntencidad1.setText("");
            txtIntencidad2.setText("");
            txtIntencidad3.setText("");
            puntosY.clear();
            puntosX.clear();
            Toast.makeText(getApplicationContext(), "Se han eliminado los parámetros de la gráfica", Toast.LENGTH_SHORT).show();
            }catch(Exception e1){
            }
        }


    public void agregaX(View view){
        try {
            puntosX.add(Double.parseDouble(txtVoltios.getText().toString()));
            contadorX++;
            Toast.makeText(getApplicationContext(), String.valueOf(puntosX.size())+"° punto añadido", Toast.LENGTH_SHORT).show();
        }catch (Exception e1){

        }
    }

    public void agregaY(View view){
        try {
            puntosY.add(Double.parseDouble(txtImpedancia.getText().toString()));
            contadorY++;
            Toast.makeText(getApplicationContext(), String.valueOf(puntosY.size())+"° punto añadido", Toast.LENGTH_SHORT).show();
        }catch (Exception e1){

        }
    }

    public void pass(View view){
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
