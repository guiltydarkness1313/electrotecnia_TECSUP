package com.shibuyaxpress.electrotecniatecsup;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class SistemaDesbalanceadoActivity extends AppCompatActivity {
  EditText txtVoltio,txtImpedancia1,txtImpedancia2,txtImpedancia3,txtIntencidad1,txtIntencidad2,txtIntencidad3;
    Button btnCalcular;
    double x1,y1,y2,y3,z1,z2,z3;
    //se pasaran dos arraylist con los puntos de los ejes
    ArrayList<Double> puntosX= new ArrayList<>();
    ArrayList<Double> puntosY1=new ArrayList<>();
    ArrayList<Double> puntosY2=new ArrayList<>();
    ArrayList<Double> puntosY3=new ArrayList<>();
    //el contador vera si hay la misma cantidad de puntos por eje para evitar problemas
    int contadorX=0,contadorY=0;
    int sample =11;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sistema_desbalanceado);
        btnCalcular = (Button)findViewById(R.id.btnCalcular);
        txtVoltio = (EditText)findViewById(R.id.txtVolt);
        txtImpedancia1 = (EditText)findViewById(R.id.txtImp);
        txtImpedancia2 = (EditText)findViewById(R.id.txtImp2);
        txtImpedancia3 = (EditText)findViewById(R.id.txtImp3);
        txtIntencidad1 = (EditText)findViewById(R.id.txtInt1);
        txtIntencidad2 = (EditText)findViewById(R.id.txtInt2);
        txtIntencidad3 = (EditText)findViewById(R.id.txtInt3);

    }
    public void Calcular(View view){
        try{
            x1 = Double.parseDouble(txtVoltio.getText().toString());
            y1 = Double.parseDouble(txtImpedancia1.getText().toString());
            y2 = Double.parseDouble(txtImpedancia2.getText().toString());
            y3 = Double.parseDouble(txtImpedancia3.getText().toString());
            z1 = (x1/ Math.sqrt(3))/y1;
            z2 = (x1/ Math.sqrt(3))/y2;
            z3 = (x1/ Math.sqrt(3))/y3;
            txtIntencidad1.setText(String.valueOf(z1));
            txtIntencidad1.setEnabled(false);
            txtIntencidad2.setText(String.valueOf(z2));
            txtIntencidad2.setEnabled(false);
            txtIntencidad3.setText(String.valueOf(z3));
            txtIntencidad3.setEnabled(false);


        }catch (Exception e1){

        }
    }
    public void Limpiar (View view){
        try {
            txtVoltio.setText("");
            txtImpedancia1.setText("");
            txtImpedancia2.setText("");
            txtImpedancia3.setText("");
            txtIntencidad1.setText("");
            txtIntencidad2.setText("");
            txtIntencidad3.setText("");
            puntosX.clear();
            puntosY1.clear();
            puntosY2.clear();
            puntosY3.clear();
            Toast.makeText(getApplicationContext(), "Se han eliminado los parámetros de la gráfica", Toast.LENGTH_SHORT).show();
        }catch(Exception e1){

        }
    }

    public void AgregaX(View view){

        try {
            puntosX.add(Double.parseDouble(txtVoltio.getText().toString()));
            contadorX++;
            Toast.makeText(getApplicationContext(), String.valueOf(puntosX.size())+"° punto añadido", Toast.LENGTH_SHORT).show();
        }catch (Exception e1){

        }
    }

    public void AgregaYS(View view){

        try {
            puntosY1.add(Double.parseDouble(txtImpedancia1.getText().toString()));
            puntosY2.add(Double.parseDouble(txtImpedancia2.getText().toString()));
            puntosY3.add(Double.parseDouble(txtImpedancia3.getText().toString()));
            contadorY++;
            Toast.makeText(getApplicationContext(), String.valueOf(puntosY1.size())+"° punto añadido", Toast.LENGTH_SHORT).show();
        }catch (Exception e1){

        }
    }

    public void pass(View view){

        if((puntosX.size()==puntosY1.size())==(puntosY2.size()==puntosY3.size())) {
            Intent act = new Intent();
            act.setClass(getApplicationContext(), GraficoActivity.class);
            act.putExtra("listaX",puntosX);
            act.putExtra("listaY1",puntosY1);
            act.putExtra("listaY2",puntosY2);
            act.putExtra("listaY3",puntosY3);
            act.putExtra("sample",sample);
            //Toast.makeText(getApplicationContext(),puntosX.size()+"   "+puntosY1.size(),Toast.LENGTH_SHORT).show();
            startActivity(act);

        }
        else{
            Toast.makeText(getApplicationContext(),"no se puede iniciar por tener una cantidad de puntos desiguales", Toast.LENGTH_SHORT).show();

        }
    }

}
