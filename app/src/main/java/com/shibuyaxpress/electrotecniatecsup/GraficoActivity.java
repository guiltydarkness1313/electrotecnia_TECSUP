package com.shibuyaxpress.electrotecniatecsup;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.ArrayList;

public class GraficoActivity extends AppCompatActivity {



    LineGraphSeries<DataPoint> series,series1,series2,series3;
    GraphView grafico;
    int sample;
    TextView x,y;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grafico);
        grafico=(GraphView)findViewById(R.id.grafico);
        x=(TextView)findViewById(R.id.txtX);
        y=(TextView)findViewById(R.id.txtY);
        series = new LineGraphSeries<DataPoint>();
        series1 = new LineGraphSeries<DataPoint>();
        series2 = new LineGraphSeries<DataPoint>();
        series3 = new LineGraphSeries<DataPoint>();
        ArrayList<Double> PuntosX;
        ArrayList<Double> PuntosY;
        ArrayList<Double> PuntosY1,PuntosY2,PuntosY3;

        try {
            PuntosX = (ArrayList<Double>) getIntent().getSerializableExtra("listaX");
            PuntosY = (ArrayList<Double>) getIntent().getSerializableExtra("listaY");
            PuntosY1 = (ArrayList<Double>) getIntent().getSerializableExtra("listaY1");
            PuntosY2 = (ArrayList<Double>) getIntent().getSerializableExtra("listaY2");
            PuntosY3 = (ArrayList<Double>) getIntent().getSerializableExtra("listaY3");
            Bundle datos = this.getIntent().getExtras();
            sample = datos.getInt("sample");
            if (sample != 11) {
                switch (sample) {
                    case 1:
                        //voltios
                        x.setText("Intensidad");
                        y.setText("Resistencia");
                        break;
                    case 2:
                        //amperios
                        y.setText("Voltios");
                        x.setText("Resitencia");
                        break;
                    case 3:
                        //ohmios
                        x.setText("Voltios");
                        y.setText("Intensidad");
                        break;
                    case 4:
                        x.setText("Voltios");
                        y.setText("impedancias");
                        break;
                    case 5:
                        x.setText("Voltios");
                        y.setText("impedancias");
                        break;

                }
                for (int i = 0; i < PuntosX.size(); i++) {

                    series.appendData(new DataPoint(PuntosX.get(i), PuntosY.get(i)), true, PuntosX.size());
                }

                /*new DataPoint(0, 1),
                new DataPoint(1, 5),
                new DataPoint(2, 3),
                new DataPoint(3, 2),
                new DataPoint(4, 6)*/
                //este metodo permitira el scroll en la pantalla de graficos
                grafico.getViewport().setScalable(true);
                grafico.getViewport().setScalableY(true);
                grafico.setTitle("Grafico");

                grafico.addSeries(series);
                series.setDrawDataPoints(true);
                series.setDataPointsRadius(10);
            }
            else{
                x.setText("Voltios");
                y.setText("Impedancias");
                for (int i = 0; i < PuntosX.size(); i++) {

                    series1.appendData(new DataPoint(PuntosX.get(i), PuntosY1.get(i)), true, PuntosX.size());
                    series2.appendData(new DataPoint(PuntosX.get(i), PuntosY2.get(i)), true, PuntosX.size());
                    series3.appendData(new DataPoint(PuntosX.get(i), PuntosY3.get(i)), true, PuntosX.size());
                }

                grafico.getViewport().setScalable(true);
                grafico.getViewport().setScalableY(true);

                series1.setColor(Color.RED);
                series2.setColor(Color.BLUE);
                series3.setColor(Color.GREEN);

                grafico.addSeries(series1);
                grafico.addSeries(series2);
                grafico.addSeries(series3);

                series1.setDrawDataPoints(true);
                series1.setDataPointsRadius(10);

                series2.setDrawDataPoints(true);
                series2.setDataPointsRadius(10);

                series3.setDrawDataPoints(true);
                series3.setDataPointsRadius(10);


            }
        }
        catch (Exception e1){

        }

    }
}
