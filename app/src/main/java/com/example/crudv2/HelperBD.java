package com.example.crudv2;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class HelperBD extends SQLiteOpenHelper {

    private static final String NOMBRE_BASE_DE_DATOS = "botiquin",
                                NOMBRE_TABLA = "remedios";


    public HelperBD(Context context) {
        super(context, NOMBRE_BASE_DE_DATOS, null, 1);
    }


    public static String getNombreBaseDeDatos() {
        return NOMBRE_BASE_DE_DATOS;
    }

    public static String getNombreTabla() {
        return NOMBRE_TABLA;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        StringBuilder queryTable = new StringBuilder();
        queryTable.append("CREATE TABLE " + NOMBRE_TABLA + " (");
        queryTable.append("id integer primary key autoincrement, ");
        queryTable.append("nombre text,");
        queryTable.append("cantidad integer, ");
        queryTable.append("fec_vencimiento text, ");
        queryTable.append("mg integer, ");
        queryTable.append("presentacion text,");
        queryTable.append("descripcion text");
        queryTable.append("), " + NOMBRE_TABLA);
        db.execSQL(String.valueOf(queryTable));
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
