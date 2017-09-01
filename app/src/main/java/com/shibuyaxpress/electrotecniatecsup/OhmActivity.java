package com.shibuyaxpress.electrotecniatecsup;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class OhmActivity extends AppCompatActivity {
    public ImageView ohnio;
    public ImageView amper;
    public ImageView voltio;
    public Button experiental;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_ohm_law);


        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        ohnio = (ImageView)findViewById(R.id.ohnio);
        amper = (ImageView)findViewById(R.id.amper);
        voltio = (ImageView)findViewById(R.id.voltio);
        experiental = (Button) findViewById(R.id.btnexperimental);

        ohnio.setOnClickListener(new View.OnClickListener() {
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
        });

    }

    public void Experimental(View view)
    {
        Intent act=new Intent();
        act.setClass(getApplicationContext(),DatosExperimentalesActivity.class);
        startActivity(act);
    }
}
