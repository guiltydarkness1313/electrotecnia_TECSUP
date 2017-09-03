package com.shibuyaxpress.electrotecniatecsup;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class DatosExperimentalesActivity extends AppCompatActivity {
    TabHost tabs;
    EditText editV3,editV2,editV1,editI1,editI2,editI3;
     Button btnAgregaX1,btnAgregaX2,btnAgregaX3, btnAgregaY1,btnAgregaY2,btnAgregaY3, btnLimpia1,btnLimpia2,btnLimpia3;
    Button btnGrafico1,btnGrafico2,btnGrafico3;
    double x,y,z;


    //se pasaran dos arraylist con los puntos de los ejes
    ArrayList<Double> puntosX1= new ArrayList<>();
    ArrayList<Double> puntosX2=new ArrayList<>();
    ArrayList<Double> puntosX3=new ArrayList<>();
    ArrayList<Double> puntosY1=new ArrayList<>();
    ArrayList<Double> puntosY2=new ArrayList<>();
    ArrayList<Double> puntosY3=new ArrayList<>();
    //el contador vera si hay la misma cantidad de puntos por eje para evitar problemas
    int contadorX=0,contadorY=0;
    int sample=2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_exp);

        editV1=(EditText)findViewById(R.id.editV1);
        editV2=(EditText)findViewById(R.id.editV2);
        editV3=(EditText)findViewById(R.id.editV3);

        editI1=(EditText)findViewById(R.id.editI1);
        editI2=(EditText)findViewById(R.id.editI2);
        editI3=(EditText)findViewById(R.id.editI3);

        btnAgregaX1=(Button)findViewById(R.id.btnX1);
        btnAgregaX2=(Button)findViewById(R.id.btnX2);
        btnAgregaX3=(Button)findViewById(R.id.btnX3);

        btnAgregaY1=(Button)findViewById(R.id.btnY1);
        btnAgregaY2=(Button)findViewById(R.id.btnY2);
        btnAgregaY3=(Button)findViewById(R.id.btnY3);

        btnLimpia1=(Button)findViewById(R.id.btnLimpiar1);
        btnLimpia2=(Button)findViewById(R.id.btnlimpiar2);
        btnLimpia3=(Button)findViewById(R.id.btnlimpiar3);

        btnGrafico1=(Button)findViewById(R.id.btngrafico1);
        btnGrafico2=(Button)findViewById(R.id.btngrafico2);
        btnGrafico3=(Button)findViewById(R.id.btngrafico3);


        tabs=(TabHost) findViewById(R.id.tabhost);
        tabs.setup();

        TabHost.TabSpec spec=tabs.newTabSpec("Voltios");
        spec.setContent(R.id.tab1);
        spec.setIndicator("I vs V");
        tabs.addTab(spec);

        spec=tabs.newTabSpec("Nagisa tab");
        spec.setContent(R.id.tab2);
        spec.setIndicator("I vs R");
        tabs.addTab(spec);

        spec=tabs.newTabSpec("Riko tab");
        spec.setContent(R.id.tab3);
        spec.setIndicator("V vs R");
        tabs.addTab(spec);

        tabs.setCurrentTab(0);

        int titleColor = Color.WHITE; //<-- change this to the color you want the title text to be
        for(int i = 0;i < tabs.getTabWidget().getChildCount(); i++)
        {
            TextView textView = (TextView)tabs.getTabWidget().getChildAt(i).findViewById(android.R.id.title);
            textView.setTextColor(titleColor);
        }




    }

    public void AgregaX1(View view){
        try {
            puntosX1.add(Double.parseDouble(editV1.getText().toString()));
            //contadorX++;
            Toast.makeText(getApplicationContext(), String.valueOf(puntosX1.size())+"° punto añadido", Toast.LENGTH_SHORT).show();
        }catch (Exception e1){

        }

    }

    public void AgregaY1(View view){
        try {
            puntosY1.add(Double.parseDouble(editI1.getText().toString()));
            //contadorY++;
            Toast.makeText(getApplicationContext(), String.valueOf(puntosY1.size())+"° punto añadido", Toast.LENGTH_SHORT).show();

        }catch (Exception e1){

        }
    }

    public void AgregaX2(View view){
        try {
            puntosX2.add(Double.parseDouble(editV2.getText().toString()));
            //contadorX++;
            Toast.makeText(getApplicationContext(), String.valueOf(puntosX2.size())+"° punto añadido", Toast.LENGTH_SHORT).show();
        }catch (Exception e1){

        }

    }

    public void AgregaY2(View view){
        try {
            puntosY2.add(Double.parseDouble(editI2.getText().toString()));
            //contadorY++;
            Toast.makeText(getApplicationContext(), String.valueOf(puntosY2.size())+"° punto añadido", Toast.LENGTH_SHORT).show();

        }catch (Exception e1){

        }
    }

    public void AgregaX3(View view){
        try {
            puntosX3.add(Double.parseDouble(editV3.getText().toString()));
            //contadorX++;
            Toast.makeText(getApplicationContext(), String.valueOf(puntosX3.size())+"° punto añadido", Toast.LENGTH_SHORT).show();
        }catch (Exception e1){

        }

    }

    public void AgregaY3(View view){
        try {
            puntosY3.add(Double.parseDouble(editI3.getText().toString()));
            //contadorY++;
            Toast.makeText(getApplicationContext(), String.valueOf(puntosY3.size())+"° punto añadido", Toast.LENGTH_SHORT).show();

        }catch (Exception e1){

        }
    }

    public void LimpiarXY(View view){
        try {
            puntosY1.clear();
            puntosX1.clear();

            puntosY2.clear();
            puntosX2.clear();

            puntosY3.clear();
            puntosX3.clear();
            editV1.setText(" ");
            editI1.setText(" ");
            Toast.makeText(getApplicationContext(), "Se han eliminado los parametros de la gráfica", Toast.LENGTH_SHORT).show();
        }catch(Exception e1){

        }
    }

    public void pass1(View view){
        if(puntosX1.size()==puntosY1.size()) {
            sample=3;
            Intent act = new Intent();
            act.setClass(getApplicationContext(), GraficoActivity.class);
            act.putExtra("listaX",puntosX1);
            act.putExtra("listaY",puntosY1);
            act.putExtra("sample",sample);
            //Toast.makeText(getApplicationContext(),puntosX.size()+"   "+puntosY.size(),Toast.LENGTH_SHORT).show();
            startActivity(act);

        }
        else{
            Toast.makeText(getApplicationContext(),"no se puede iniciar por tener una cantidad de puntos desiguales", Toast.LENGTH_SHORT).show();

        }
    }

    public void pass2(View view){
        if(puntosX2.size()==puntosY2.size()) {
            Intent act = new Intent();
            sample=1;
            act.setClass(getApplicationContext(), GraficoActivity.class);
            act.putExtra("listaX",puntosX2);
            act.putExtra("listaY",puntosY2);
            act.putExtra("sample",sample);
            //Toast.makeText(getApplicationContext(),puntosX.size()+"   "+puntosY.size(),Toast.LENGTH_SHORT).show();
            startActivity(act);

        }
        else{
            Toast.makeText(getApplicationContext(),"no se puede iniciar por tener una cantidad de puntos desiguales", Toast.LENGTH_SHORT).show();

        }
    }

    public void pass3(View view){
        if(puntosX3.size()==puntosY3.size()) {
            Intent act = new Intent();
            sample=2;
            act.setClass(getApplicationContext(), GraficoActivity.class);
            act.putExtra("listaX",puntosX3);
            act.putExtra("listaY",puntosY3);
            act.putExtra("sample",sample);
            //Toast.makeText(getApplicationContext(),puntosX.size()+"   "+puntosY.size(),Toast.LENGTH_SHORT).show();
            startActivity(act);

        }
        else{
            Toast.makeText(getApplicationContext(),"no se puede iniciar por tener una cantidad de puntos desiguales", Toast.LENGTH_SHORT).show();

        }
    }


}
