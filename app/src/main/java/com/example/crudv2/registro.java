package com.example.crudv2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.crudv2.entities.Remedio;
import com.example.crudv2.services.RemedioService;

public class Registrar extends AppCompatActivity implements View.OnClickListener{
    EditText no, ca, fe, mg, pr, de;
    Button reg, can;
    daoBotiquin dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registrar);
        no=(EditText)findViewById(R.id.RegNombre);
        ca=(EditText)findViewById(R.id.RegCantidad);
        fe=(EditText)findViewById(R.id.RegFechaVencimiento);
        mg=(EditText)findViewById(R.id.RegMG);
        pr=(EditText)findViewById(R.id.RegPresentacion);
        de=(EditText)findViewById(R.id.RegDescripcion);

        reg=(Button)findViewById(R.id.btnRegistrar);
        can=(Button)findViewById(R.id.btnCancelar);
        reg.setOnClickListener(this);
        can.setOnClickListener(this);
        dao=new daoBotiquin(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnRegistrar:
                Remedio remedio = new Remedio();

                RemedioService remedioService = new RemedioService(HelperBD helperBD = new HelperBD(context));
                remedio.setNombre(no.getText().toString());
                remedio.setCantidad(Integer.parseInt(ca.getText().toString()));
                remedio.setDescripcion(de.getText().toString());
                remedio.setPresentacion(pr.getText().toString());
                remedio.setMg(Integer.parseInt(mg.getText().toString()));
                remedio.setFec_vencimiento(fe.getText().toString());

                if(false){
                    Toast.makeText(this, "ERROR: Campos Vacios", Toast.LENGTH_LONG).show();
                }else if(){

                    Toast.makeText(this, "Registro Exitoso", Toast.LENGTH_LONG).show();
                    Intent i2=new Intent(Registrar.this, MainActivity.class);
                    startActivity(i2);
                    finish();
                    break;
                }else{
                    Toast.makeText(this, "ERROR: Usuario Ocupado", Toast.LENGTH_LONG).show();
                }

                break;

            case R.id.btnCancelar:
                Intent i=new Intent(Registrar.this, Inicio.class);
                startActivity(i);
                finish();
                break;
        }
    }
}