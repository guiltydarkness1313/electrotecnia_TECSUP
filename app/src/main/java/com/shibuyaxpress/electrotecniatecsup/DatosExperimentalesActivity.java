package com.shibuyaxpress.electrotecniatecsup;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TabHost;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class DatosExperimentalesActivity extends AppCompatActivity {
    TabHost tabs;
    EditText editV3,editV2,editV1,editI1,editI2,editI3;
    Button btnAgregaX1,btnAgregaX2,btnAgregaX3, btnAgregaY1,btnAgregaY2,btnAgregaY3, btnLimpia1,btnLimpia2,btnLimpia3;
    Button btnGrafico1,btnGrafico2,btnGrafico3;
    TableLayout tabla1,tabla2;
    TextView puntos1,puntos2;
    TextView ptosX2,ptosY2;
    TableRow tableRow;

    double x,y,z;


    //se pasaran dos arraylist con los puntos de los ejes
    ArrayList<Double> puntosX1= new ArrayList<>();
    ArrayList<Double> puntosX2=new ArrayList<>();
    //ArrayList<Double> puntosX3=new ArrayList<>();
    ArrayList<Double> puntosY1=new ArrayList<>();
    ArrayList<Double> puntosY2=new ArrayList<>();
    //ArrayList<Double> puntosY3=new ArrayList<>();
    //el contador vera si hay la misma cantidad de puntos por eje para evitar problemas
    int contadorX=0,contadorY=0;
    int contadorX2=0,contadorY2=0;
    int sample=2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_exp);

        tabla1=(TableLayout)findViewById(R.id.tabla_1);

        tabla1.setColumnStretchable(0,true);
        tabla1.setColumnStretchable(1,true);

        tabla2=(TableLayout)findViewById(R.id.tabla_2);

        tabla2.setColumnStretchable(0,true);
        tabla2.setColumnStretchable(1,true);

        /////////////////////////////////
        editV1=(EditText)findViewById(R.id.editV1);
        editV2=(EditText)findViewById(R.id.editV2);
        //editV3=(EditText)findViewById(R.id.editV3);

        editI1=(EditText)findViewById(R.id.editI1);
        editI2=(EditText)findViewById(R.id.editI2);
        //editI3=(EditText)findViewById(R.id.editI3);

        btnAgregaX1=(Button)findViewById(R.id.btnX1);
        btnAgregaX2=(Button)findViewById(R.id.btnX2);
        //btnAgregaX3=(Button)findViewById(R.id.btnX3);

        btnAgregaY1=(Button)findViewById(R.id.btnY1);
        btnAgregaY2=(Button)findViewById(R.id.btnY2);
        //btnAgregaY3=(Button)findViewById(R.id.btnY3);

        btnLimpia1=(Button)findViewById(R.id.btnLimpiar1);
        btnLimpia2=(Button)findViewById(R.id.btnlimpiar2);
        //btnLimpia3=(Button)findViewById(R.id.btnlimpiar3);

        btnGrafico1=(Button)findViewById(R.id.btngrafico1);
        btnGrafico2=(Button)findViewById(R.id.btngrafico2);
        //btnGrafico3=(Button)findViewById(R.id.btngrafico3);


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

            tableRow=new TableRow(this);
            puntos1=new TextView(this);
            puntos2=new TextView(this);

            puntos1.setText(String.valueOf(puntosX1.get(contadorX)));
            puntos1.setTextSize(15);
            puntos1.setGravity(Gravity.CENTER);

            puntos2.setText(String.valueOf(puntosY1.get(contadorY)));
            puntos2.setTextSize(15);
            puntos2.setGravity(Gravity.CENTER);

            tableRow.addView(puntos1);
            tableRow.addView(puntos2);

            tabla1.addView(tableRow);

            contadorX+=1;
            contadorY+=1;
            editV1.setText("");
            editI1.setText("");
        }catch (Exception e1){
            e1.printStackTrace();
            Log.e("APP", e1.toString());
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
            tableRow=new TableRow(this);
            ptosX2=new TextView(this);
            ptosY2=new TextView(this);

            ptosX2.setText(String.valueOf(puntosX2.get(contadorX2)));
            ptosX2.setTextSize(15);
            ptosX2.setGravity(Gravity.CENTER);

            ptosY2.setText(String.valueOf(puntosY2.get(contadorY2)));
            ptosY2.setTextSize(15);
            ptosY2.setGravity(Gravity.CENTER);

            tableRow.addView(ptosX2);
            tableRow.addView(ptosY2);

            tabla2.addView(tableRow);

            contadorX2+=1;
            contadorY2+=1;
            editV2.setText("");
            editI2.setText("");
            //contadorY++;
            Toast.makeText(getApplicationContext(), String.valueOf(puntosY2.size())+"° punto añadido", Toast.LENGTH_SHORT).show();

        }catch (Exception e1){
            e1.printStackTrace();
            Log.e("APP", e1.toString());
        }
    }


    public void LimpiarXY(View view){
        try {
            puntosY1.clear();
            puntosX1.clear();

            puntosY2.clear();
            puntosX2.clear();

            contadorX=0;
            contadorY=0;
            contadorX2=0;
            contadorY2=0;
            //puntosY3.clear();
            // puntosX3.clear();
            editV1.setText("");
            editI1.setText("");
            editV2.setText("");
            editI2.setText("");

            int childCount = tabla1.getChildCount();
            tabla2.removeAllViews();

            tabla1.removeViews(0,childCount);
            Toast.makeText(getApplicationContext(), "Se han eliminado los parametros de la gráfica", Toast.LENGTH_SHORT).show();
        }catch(Exception e1){
            Log.e("APP", e1.toString());
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

}
