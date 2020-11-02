package com.example.crudv2.services;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.crudv2.HelperBD;
import com.example.crudv2.entities.Remedio;

import java.util.ArrayList;

public class RemedioService {

    private HelperBD helperBD;

    public RemedioService(Context context){
        helperBD = new HelperBD(context);
    }

    public Integer eliminarRemedio(Remedio remedio){
        SQLiteDatabase query = helperBD.getWritableDatabase();
        String[] argumentos = {String.valueOf(remedio.getId())};
        return query.delete(helperBD.getNombreTabla(), "id = ?", argumentos);
    }

    public Long crearRemedio(Remedio remedio){
        SQLiteDatabase query = helperBD.getWritableDatabase();
        ContentValues aInsertar = new ContentValues();
        aInsertar.put("nombre", remedio.getNombre());
        aInsertar.put("cantidad", remedio.getCantidad());
        aInsertar.put("mg", remedio.getMg());
        aInsertar.put("presentacion", remedio.getPresentacion());
        aInsertar.put("descripcion", remedio.getDescripcion());
        return query.insert(helperBD.getNombreTabla(), null, aInsertar);
    }

    public int actualizarRemedio(Remedio remedio){
        SQLiteDatabase query = helperBD.getWritableDatabase();
        ContentValues aInsertar = new ContentValues();
        aInsertar.put("nombre", remedio.getNombre());
        aInsertar.put("cantidad", remedio.getCantidad());
        aInsertar.put("mg", remedio.getMg());
        aInsertar.put("presentacion", remedio.getPresentacion());
        aInsertar.put("descripcion", remedio.getDescripcion());
        String campoParaActulizar = "id = ?";
        String[] argumentosActualizar = {String.valueOf(remedio.getId())};
        return query.update(helperBD.getNombreTabla(), aInsertar, campoParaActulizar, argumentosActualizar);
    }

    public ArrayList<Remedio> obtenerRemedios(){
        ArrayList<Remedio> remedios = new ArrayList<>();
        SQLiteDatabase query = helperBD.getReadableDatabase();
        String[] columnasAConsultar = {"id","nombre", "cantidad", "mg", "presentacion", "descripcion"};
        Cursor cursor = query.query(
                helperBD.getNombreTabla(),
                columnasAConsultar,
                null,
                null,
                null,
                null,
                null
        );
        if(cursor == null || !cursor.moveToFirst()){
            return remedios;
        }

        do{
            Remedio remedio = new Remedio();
            remedio.setId(cursor.getInt(0));
            remedio.setNombre(cursor.getString(1));
            remedio.setCantidad(cursor.getInt(2));
            remedio.setMg(cursor.getInt(3));
            remedio.setPresentacion(cursor.getString(4));
            remedio.setDescripcion(cursor.getString(5));
        }while (cursor.moveToNext());
        cursor.close();
        return remedios;
    }


}
