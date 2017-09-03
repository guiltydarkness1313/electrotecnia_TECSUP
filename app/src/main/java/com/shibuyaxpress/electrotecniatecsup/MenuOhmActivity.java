package com.shibuyaxpress.electrotecniatecsup;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
//MenuOhmActivity es el menu de seleccion en la wea

public class MenuOhmActivity extends AppCompatActivity {
    public ImageView alterna;
    public ImageView continua;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_ohm);
        alterna = (ImageView)findViewById(R.id.alterna);
        continua = (ImageView)findViewById(R.id.continua);

        toolbar = (Toolbar) findViewById(R.id.tool_bar); // Conectamos el Layout al objeto Toolbar
        setSupportActionBar(toolbar);

        // Configuración de la barra de herramientas (toolbar ) como la Barra de acciones (ActionBar)
        // con la llamada de setSupportActionBar ()

        alterna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuOhmActivity.this,OhmActivity.class);
                startActivity(intent);
            }
        });

        continua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(MenuOhmActivity.this,MenuTipoElectricidadActivity.class);
                startActivity(intent2);
            }
        });



    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_activity_menu, menu);
        return super.onCreateOptionsMenu(menu);
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
        Intent intent = new Intent(MenuOhmActivity.this,ScrollingActivity.class);
        startActivity(intent);
    }

}