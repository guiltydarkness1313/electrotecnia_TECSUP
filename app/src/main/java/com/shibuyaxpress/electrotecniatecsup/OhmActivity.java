package com.shibuyaxpress.electrotecniatecsup;

import android.app.Dialog;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class OhmActivity extends AppCompatActivity {
    public ImageView ohnio;
    public ImageView amper;
    public ImageView voltio;
    public Button experiental;
    double x,y,z;
    private Toolbar toolbar;
    private Button cal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_ohm_law);


        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        ohnio = (ImageView)findViewById(R.id.ohnio);
        amper = (ImageView)findViewById(R.id.amper);
        voltio = (ImageView)findViewById(R.id.voltio);
        experiental = (Button) findViewById(R.id.btnexperimental);
        toolbar = (Toolbar)findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);

        /*ohnio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OhmActivity.this,OhmiosActivity.class);
                startActivity(intent);
            }
        });

        amper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(OhmActivity.this,AmperiosActivity.class);
                startActivity(intent2);
            }
        });

        voltio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3 = new Intent(OhmActivity.this,VoltiosActivity.class);
                startActivity(intent3);
            }
        });*/

    }


    public void Experimental(View view)
    {
        Intent act=new Intent();
        act.setClass(getApplicationContext(),DatosExperimentalesActivity.class);
        startActivity(act);
    }

    public void Show(View view){
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.activity_custom_voltage);

        dialog.setTitle("Tension");

        final EditText amperio = (EditText) dialog.findViewById(R.id.amperiosVol);
        final EditText tension = (EditText) dialog.findViewById(R.id.voltiosVol);
        final EditText res = (EditText) dialog.findViewById(R.id.resVol);
        final ImageView imgcloseamper = (ImageView) dialog.findViewById(R.id.btnclosetension);
        Button cal = (Button) dialog.findViewById(R.id.calVolt);
        Button bor = (Button) dialog.findViewById(R.id.borrarTension);
        imgcloseamper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        bor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                amperio.setText(" ");
                tension.setText(" ");
                res.setText(" ");
            }
        });
        cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    x = Double.parseDouble(tension.getText().toString());
                    y = Double.parseDouble(amperio.getText().toString());
                    z = x * y;
                    res.setText(String.valueOf(z)+ " V");
                    res.setEnabled(false);
                }catch (Exception e1){

                }
            }
        });
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();
    }


    //Hallamos los amperios
    public void ShowAmper(View view){
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.activity_custom_amper);



        dialog.setTitle("Amperios");

        final EditText tensionAmper = (EditText) dialog.findViewById(R.id.tenAmper);
        final EditText resisAmper = (EditText) dialog.findViewById(R.id.resisAmper);
        final EditText resAmper = (EditText) dialog.findViewById(R.id.resAmper);
        final ImageView imgcloseamper = (ImageView) dialog.findViewById(R.id.btncloseamper);
        Button calAmper = (Button) dialog.findViewById(R.id.calAmper);
        Button borAmper = (Button) dialog.findViewById(R.id.borrarAmper);

        imgcloseamper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        borAmper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tensionAmper.setText("");
                resisAmper.setText("");
                resAmper.setText("");
            }
        });

        calAmper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    x = Double.parseDouble(tensionAmper.getText().toString());
                    y = Double.parseDouble(resisAmper.getText().toString());
                    z = x / y;
                    resAmper.setText(String.valueOf(z) + " A");
                    resAmper.setEnabled(false);
                }catch (Exception e1){

                }
            }
        });

        dialog.setCanceledOnTouchOutside(false);
        dialog.show();
    }
    public void ShowResistencia(View view){
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.activity_custom_resistencia);

        dialog.setTitle("Resistencia");

       final EditText tensionResis = (EditText) dialog.findViewById(R.id.tenResistencia);
       final EditText amperiosResis = (EditText) dialog.findViewById(R.id.amperiosResistencia);
       final EditText resResistenci = (EditText) dialog.findViewById(R.id.resResistencia);
       final ImageView imgclose = (ImageView) dialog.findViewById(R.id.btnclose);
        Button calResistencia = (Button) dialog.findViewById(R.id.calResis);
        Button borraResis = (Button) dialog.findViewById(R.id.borrarResis);
        imgclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        borraResis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tensionResis.setText(" ");
                amperiosResis.setText(" ");
                resResistenci.setText(" ");
            }
        });


        calResistencia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    x = Double.parseDouble(tensionResis.getText().toString());
                    y = Double.parseDouble(amperiosResis.getText().toString());
                    z = x / y;
                    resResistenci.setText(String.valueOf(z)+ " Ω");
                    resResistenci.setEnabled(false);
                }catch (Exception e1){

                }
            }
        });
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_activity_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                action(R.string.about);

        }
        return true;
    }

    private void action(int resid) {
        Intent intent = new Intent(OhmActivity.this,ScrollingActivity.class);
        startActivity(intent);
    }


}
