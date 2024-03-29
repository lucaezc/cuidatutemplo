package com.holysoft.cuidatutemplo;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.text.Normalizer;

public class DbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "CuidaTuTemplo.db";
    private static final int DATABASE_VERSION = 1;

    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        scriptsVersion1(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion == 1) {
            scriptsDropVersion1(db);
            scriptsVersion1(db);
        }
    }

    private void scriptsVersion1(SQLiteDatabase db) {
        db.execSQL(DataSource.CREATE_TIPO_ALIMENTO_SCRIPT);
        db.execSQL(DataSource.CREATE_ALIMENTO_SCRIPT);
        db.execSQL(DataSource.CREATE_CONSUMO_ALIMENTO_SCRIPT);
        db.execSQL(DataSource.CREATE_BENEFICIO_SCRIPT);
        db.execSQL(DataSource.CREATE_BENEFICIO_ALIMENTO_SCRIPT);
        db.execSQL(DataSource.CREATE_ENFERMEDAD_SCRIPT);
        db.execSQL(DataSource.CREATE_ENFERMEDAD_ALIMENTO_SCRIPT);
        db.execSQL(DataSource.CREATE_PROPIEDAD_SCRIPT);
        db.execSQL(DataSource.CREATE_PROPIEDAD_ALIMENTO_SCRIPT);
        db.execSQL(DataSource.INSERT_TIPO_ALIMENTO_SCRIPT);
        db.execSQL(DataSource.INSERT_ALIMENTO_SCRIPT);
        db.execSQL(DataSource.INSERT_PROPIEDAD_SCRIPT);
        db.execSQL(DataSource.INSERT_BENEFICIO_SCRIPT);
        db.execSQL(DataSource.INSERT_PROPIEDAD_ALIMENTO_SCRIPT);
        db.execSQL(DataSource.INSERT_BENEFICIO_ALIMENTO_SCRIPT);
        db.execSQL(DataSource.INSERT_ENFERMEDAD_SCRIPT);
        db.execSQL(DataSource.INSERT_ENFERMEDAD_ALIMENTO_SCRIPT);
    }

    private void scriptsDropVersion1(SQLiteDatabase db) {
        db.execSQL(DataSource.DROP_BENEFICIO_ALIMENTO_SCRIPT);
        db.execSQL(DataSource.DROP_CONSUMO_ALIMENTO_SCRIPT);
        db.execSQL(DataSource.DROP_ENFERMEDAD_ALIMENTO_SCRIPT);
        db.execSQL(DataSource.DROP_PROPIEDAD_ALIMENTO_SCRIPT);
        db.execSQL(DataSource.DROP_BENEFICIO_SCRIPT);
        db.execSQL(DataSource.DROP_PROPIEDAD_SCRIPT);
        db.execSQL(DataSource.DROP_ENFERMEDAD_SCRIPT);
        db.execSQL(DataSource.DROP_ALIMENTO_SCRIPT);
        db.execSQL(DataSource.DROP_TIPO_ALIMENTO_SCRIPT);
    }

    public Cursor queryListAlimentos() {
        SQLiteDatabase bd = this.getReadableDatabase();
        return bd.rawQuery("SELECT " + DataSource.Alimento_Campos.ALIMENTO_ID + ", " + DataSource.Alimento_Campos.ALIMENTO_NOMBRE + ", " +
                                DataSource.Alimento_Campos.ALIMENTO_INFO + ", " + DataSource.Alimento_Campos.ALIMENTO_IMAGEN + ", " +
                                DataSource.Alimento_Campos.ALIMENTO_TIPO + " FROM " + DataSource.ALIMENTO_TABLE_NAME + " ORDER BY " + DataSource.Alimento_Campos.ALIMENTO_NOMBRE + " ASC" , null);
    }

    public Cursor queryListPropiedades() {
        SQLiteDatabase bd = this.getReadableDatabase();
        return bd.rawQuery("SELECT " + DataSource.Propiedad_Campos.PROPIEDAD_ID + ", " + DataSource.Propiedad_Campos.PROPIEDAD_NOMBRE + ", " + DataSource.Propiedad_Campos.PROPIEDAD_DESC + " FROM " + DataSource.PROPIEDAD_TABLE_NAME + " ORDER BY " + DataSource.Propiedad_Campos.PROPIEDAD_NOMBRE + " ASC" , null);
    }

    public Cursor queryListBeneficios() {
        SQLiteDatabase bd = this.getReadableDatabase();
        return bd.rawQuery("SELECT " + DataSource.Beneficio_Campos.BENEFICIO_ID + ", " + DataSource.Beneficio_Campos.BENEFICIO_NOMBRE + " FROM " + DataSource.BENEFICIO_TABLE_NAME + " ORDER BY " + DataSource.Beneficio_Campos.BENEFICIO_NOMBRE + " ASC", null);
    }

    public Cursor queryListTiposAlimento() {
        SQLiteDatabase bd = this.getReadableDatabase();
        return bd.rawQuery("SELECT " + DataSource.Tipo_Campos.TIPO_ID + ", " + DataSource.Tipo_Campos.TIPO_NOMBRE + " FROM " + DataSource.TIPO_ALIMENTO_TABLE_NAME + " ORDER BY " + DataSource.Tipo_Campos.TIPO_NOMBRE + " ASC", null);
    }

    public Cursor queryListPropiedadesAlimento(Integer alimentoId) {
        SQLiteDatabase bd = this.getReadableDatabase();
        return bd.rawQuery("SELECT P." + DataSource.Propiedad_Campos.PROPIEDAD_ID + ", P." + DataSource.Propiedad_Campos.PROPIEDAD_NOMBRE + ", P." + DataSource.Propiedad_Campos.PROPIEDAD_DESC +
                                " FROM " + DataSource.PROPIEDAD_ALIMENTO_TABLE_NAME + " PA JOIN " + DataSource.PROPIEDAD_TABLE_NAME + " P ON PA." + DataSource.PropiedadAlimento_Campos.PROPIEDAD_ID + " = P." + DataSource.Propiedad_Campos.PROPIEDAD_ID +
                                " WHERE PA." + DataSource.PropiedadAlimento_Campos.ALIMENTO_ID + " = " + alimentoId.toString() +
                                " ORDER BY P." + DataSource.Propiedad_Campos.PROPIEDAD_NOMBRE + " ASC", null);
    }

    public Cursor queryListBeneficiosAlimento(Integer alimentoId) {
        SQLiteDatabase bd = this.getReadableDatabase();
        return bd.rawQuery("SELECT B." + DataSource.Beneficio_Campos.BENEFICIO_ID + ", B." + DataSource.Beneficio_Campos.BENEFICIO_NOMBRE +
                                " FROM " + DataSource.BENEFICIO_ALIMENTO_TABLE_NAME + " BA JOIN " + DataSource.BENEFICIO_TABLE_NAME + " B ON BA." + DataSource.BeneficioAlimento_Campos.BENEFICIO_ID + " = B." + DataSource.Beneficio_Campos.BENEFICIO_ID +
                                " WHERE BA." + DataSource.BeneficioAlimento_Campos.ALIMENTO_ID + " = " + alimentoId.toString() +
                                " ORDER BY B." + DataSource.Beneficio_Campos.BENEFICIO_NOMBRE + " ASC", null);
    }

    public Cursor queryListEnfermedadesAlimento(Integer alimentoId) {
        SQLiteDatabase bd = this.getReadableDatabase();
        return bd.rawQuery("SELECT E." + DataSource.Enfermedad_Campos.ENFERMEDAD_ID + ", E." + DataSource.Enfermedad_Campos.ENFERMEDAD_NOMBRE +
                                " FROM " + DataSource.ENFERMEDAD_ALIMENTO_TABLE_NAME + " EA JOIN " + DataSource.ENFERMEDAD_TABLE_NAME + " E ON EA." + DataSource.EnfermedadAlimento_Campos.ENFERMEDAD_ID + " = E." + DataSource.Enfermedad_Campos.ENFERMEDAD_ID +
                                " WHERE EA." + DataSource.EnfermedadAlimento_Campos.ALIMENTO_ID + " = " + alimentoId.toString() +
                                " ORDER BY E." + DataSource.Enfermedad_Campos.ENFERMEDAD_NOMBRE + " ASC", null);
    }

    public Cursor queryListAlimentosEnfermedad(Integer enfermedadId) {
        SQLiteDatabase bd = this.getReadableDatabase();
        return bd.rawQuery("SELECT A." + DataSource.Alimento_Campos.ALIMENTO_ID + ", A." + DataSource.Alimento_Campos.ALIMENTO_NOMBRE +
                                " FROM " + DataSource.ENFERMEDAD_ALIMENTO_TABLE_NAME + " EA JOIN " + DataSource.ALIMENTO_TABLE_NAME + " A ON EA." + DataSource.EnfermedadAlimento_Campos.ALIMENTO_ID + " = A." + DataSource.Alimento_Campos.ALIMENTO_ID +
                                " WHERE EA." + DataSource.EnfermedadAlimento_Campos.ENFERMEDAD_ID + " = " + enfermedadId.toString() +
                                " ORDER BY A." + DataSource.Alimento_Campos.ALIMENTO_NOMBRE + " ASC", null);
    }

    public Cursor queryListAlimentosPropiedad(Integer propiedadId) {
        SQLiteDatabase bd = this.getReadableDatabase();
        return bd.rawQuery("SELECT A." + DataSource.Alimento_Campos.ALIMENTO_ID + ", A." + DataSource.Alimento_Campos.ALIMENTO_NOMBRE +
                                " FROM " + DataSource.PROPIEDAD_ALIMENTO_TABLE_NAME + " PA JOIN " + DataSource.ALIMENTO_TABLE_NAME + " A ON PA." + DataSource.PropiedadAlimento_Campos.ALIMENTO_ID + " = A." + DataSource.Alimento_Campos.ALIMENTO_ID +
                                " WHERE PA." + DataSource.PropiedadAlimento_Campos.PROPIEDAD_ID + " = " + propiedadId.toString() +
                                " ORDER BY A." + DataSource.Alimento_Campos.ALIMENTO_NOMBRE + " ASC", null);
    }

    public Cursor BusquedaAlimentos(String searchString) {
        SQLiteDatabase bd = this.getReadableDatabase();
        return bd.rawQuery("SELECT " + DataSource.Alimento_Campos.ALIMENTO_ID + ", " + DataSource.Alimento_Campos.ALIMENTO_NOMBRE + ", " + DataSource.Alimento_Campos.ALIMENTO_INFO + ", " + DataSource.Alimento_Campos.ALIMENTO_IMAGEN + ", " + DataSource.Alimento_Campos.ALIMENTO_TIPO +
                                " FROM " + DataSource.ALIMENTO_TABLE_NAME +
                                " WHERE REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(LOWER(" + DataSource.Alimento_Campos.ALIMENTO_NOMBRE + "), 'á','a'), 'ã','a'), 'â','a'), 'é','e'), 'ê','e'), 'í','i'),'ó','o') ,'õ','o') ,'ô','o'),'ú','u'), 'ç','c')"  + " LIKE '" + quitarAcentos(searchString.trim()) + "%'" +
                                " ORDER BY " + DataSource.Alimento_Campos.ALIMENTO_NOMBRE + " ASC", null);
    }

    public Cursor BusquedaPropiedades(String searchString) {
        SQLiteDatabase bd = this.getReadableDatabase();
        return bd.rawQuery("SELECT " + DataSource.Propiedad_Campos.PROPIEDAD_ID + ", " + DataSource.Propiedad_Campos.PROPIEDAD_NOMBRE + ", " + DataSource.Propiedad_Campos.PROPIEDAD_DESC +
                                " FROM " + DataSource.PROPIEDAD_TABLE_NAME +
                                " WHERE REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(LOWER(" + DataSource.Propiedad_Campos.PROPIEDAD_NOMBRE + "), 'á','a'), 'ã','a'), 'â','a'), 'é','e'), 'ê','e'), 'í','i'),'ó','o') ,'õ','o') ,'ô','o'),'ú','u'), 'ç','c')" + " LIKE '" + quitarAcentos(searchString.trim()) + "%'" +
                                " ORDER BY " + DataSource.Propiedad_Campos.PROPIEDAD_NOMBRE + " ASC", null);
    }

    public Cursor BusquedaEnfermedades(String searchString) {
        SQLiteDatabase bd = this.getReadableDatabase();
        return bd.rawQuery("SELECT " + DataSource.Enfermedad_Campos.ENFERMEDAD_ID + ", " + DataSource.Enfermedad_Campos.ENFERMEDAD_NOMBRE +
                                " FROM " + DataSource.ENFERMEDAD_TABLE_NAME +
                                " WHERE REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(LOWER(" + DataSource.Enfermedad_Campos.ENFERMEDAD_NOMBRE + "), 'á','a'), 'ã','a'), 'â','a'), 'é','e'), 'ê','e'), 'í','i'),'ó','o') ,'õ','o') ,'ô','o'),'ú','u'), 'ç','c')" + " LIKE '" + quitarAcentos(searchString.trim()) + "%'" +
                                " ORDER BY " + DataSource.Enfermedad_Campos.ENFERMEDAD_NOMBRE + " ASC", null);
    }

    public String quitarAcentos(String s)
    {
        s = Normalizer.normalize(s, Normalizer.Form.NFD);
        s = s.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
        return s;
    }
}
