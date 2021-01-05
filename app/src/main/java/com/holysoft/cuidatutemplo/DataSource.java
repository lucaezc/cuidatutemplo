package com.holysoft.cuidatutemplo;

import android.content.res.TypedArray;

public class DataSource {
    private static String getScriptInsertTipoAlimento(){
        TypedArray tiposAlimentos = App.getContext().getResources().obtainTypedArray(R.array.tipos_alimentos);
        String script = "insert into " + TIPO_ALIMENTO_TABLE_NAME + " values ";
        int j = 1;
        for (int i = 0; i < tiposAlimentos.length(); i++) {
            script = script + "( " + j + ", \"" + tiposAlimentos.getString(i) + "\"),";
            j++;
        }
        script = script.substring(0, script.length() - 1);
        tiposAlimentos.recycle();
        return script;
    }

    private static String getScriptInsertAlimento(){
        TypedArray alimentos = App.getContext().getResources().obtainTypedArray(R.array.alimentos);
        TypedArray alimento;
        String script = "insert into " + ALIMENTO_TABLE_NAME + " values ";
        for (int i = 0; i < alimentos.length(); i++) {
            int resId = alimentos.getResourceId(i, -1);
            if (resId < 0){ continue; }
            alimento = App.getContext().getResources().obtainTypedArray(resId);
            for (int j = 0; j < alimento.length(); j++) {
                switch (j){
                    case 0:
                        script = script + "( " + alimento.getInt(j,-1) + ",";
                        break;
                    case 3:
                        int imgId = alimento.getResourceId(j,-1);
                        if (imgId < 0){ continue; }
                        script = script + " " + imgId + ",";
                        break;
                    case 4:
                        script = script + " " + alimento.getInt(j,-1) + "),";
                        break;
                    default:
                        script = script + " \"" + alimento.getString(j) + "\",";
                        break;
                }
            }
            alimento.recycle();
        }
        script = script.substring(0, script.length() - 1);
        alimentos.recycle();
        return script;
    }

    private static String getScriptInsertPropiedad(){
        TypedArray propiedades = App.getContext().getResources().obtainTypedArray(R.array.propiedades);
        TypedArray propiedad;
        String script = "insert into " + PROPIEDAD_TABLE_NAME + " values ";
        for (int i = 0; i < propiedades.length(); i++) {
            int resId = propiedades.getResourceId(i, -1);
            if (resId < 0){ continue; }
            propiedad = App.getContext().getResources().obtainTypedArray(resId);
            for (int j = 0; j < propiedad.length(); j++) {
                switch (j){
                    case 0:
                        script = script + "( " + propiedad.getInt(j,-1) + ",";
                        break;
                    case 2:
                        script = script + " \"" + propiedad.getString(j) + "\"),";
                        break;
                    default:
                        script = script + " \"" + propiedad.getString(j) + "\",";
                        break;
                }
            }
            propiedad.recycle();
        }
        script = script.substring(0, script.length() - 1);
        propiedades.recycle();
        return script;
    }

    private static String getScriptInsertBeneficio(){
        TypedArray beneficios = App.getContext().getResources().obtainTypedArray(R.array.beneficios);
        String script = "insert into " + BENEFICIO_TABLE_NAME + " values ";
        int j = 1;
        for (int i = 0; i < beneficios.length(); i++) {
            script = script + "( " + j + ", \"" + beneficios.getString(i) + "\"),";
            j++;
        }
        script = script.substring(0, script.length() - 1);
        beneficios.recycle();
        return script;
    }

    private static String getScriptInsertEnfermedad(){
        TypedArray enfermedades = App.getContext().getResources().obtainTypedArray(R.array.enfermedades);
        String script = "insert into " + ENFERMEDAD_TABLE_NAME + " values ";
        int j = 1;
        for (int i = 0; i < enfermedades.length(); i++) {
            script = script + "( " + j + ", \"" + enfermedades.getString(i) + "\"),";
            j++;
        }
        script = script.substring(0, script.length() - 1);
        enfermedades.recycle();
        return script;
    }

    private static String getScriptInsertPropiedadAlimento(){
        TypedArray propiedades_alimento = App.getContext().getResources().obtainTypedArray(R.array.propiedades_alimento);
        TypedArray propiedad_alimento;
        String script = "insert into " + PROPIEDAD_ALIMENTO_TABLE_NAME + " values ";
        for (int i = 0; i < propiedades_alimento.length(); i++) {
            int resId = propiedades_alimento.getResourceId(i, -1);
            if (resId < 0){ continue; }
            propiedad_alimento = App.getContext().getResources().obtainTypedArray(resId);
            for (int j = 0; j < propiedad_alimento.length(); j++) {
                if (j != 0) {
                    script = script + "( " + propiedad_alimento.getInt(0, -1) + "," + propiedad_alimento.getInt(j, -1) + "),";
                }
            }
            propiedad_alimento.recycle();
        }
        script = script.substring(0, script.length() - 1);
        propiedades_alimento.recycle();
        return script;
    }

    private static String getScriptInsertBeneficioAlimento(){
        TypedArray beneficios_alimento = App.getContext().getResources().obtainTypedArray(R.array.beneficios_alimento);
        TypedArray beneficio_alimento;
        String script = "insert into " + BENEFICIO_ALIMENTO_TABLE_NAME + " values ";
        for (int i = 0; i < beneficios_alimento.length(); i++) {
            int resId = beneficios_alimento.getResourceId(i, -1);
            if (resId < 0){ continue; }
            beneficio_alimento = App.getContext().getResources().obtainTypedArray(resId);
            for (int j = 0; j < beneficio_alimento.length(); j++) {
                if (j != 0) {
                    script = script + "( " + beneficio_alimento.getInt(0, -1) + "," + beneficio_alimento.getInt(j, -1) + "),";
                }
            }
            beneficio_alimento.recycle();
        }
        script = script.substring(0, script.length() - 1);
        beneficios_alimento.recycle();
        return script;
    }

    private static String getScriptInsertEnfermedadAlimento(){
        TypedArray enfermedades_alimento = App.getContext().getResources().obtainTypedArray(R.array.enfermedades_alimento);
        TypedArray enfermedad_alimento;
        String script = "insert into " + ENFERMEDAD_ALIMENTO_TABLE_NAME + " values ";
        for (int i = 0; i < enfermedades_alimento.length(); i++) {
            int resId = enfermedades_alimento.getResourceId(i, -1);
            if (resId < 0){ continue; }
            enfermedad_alimento = App.getContext().getResources().obtainTypedArray(resId);
            for (int j = 0; j < enfermedad_alimento.length(); j++) {
                if (j != 0) {
                    script = script + "( " + enfermedad_alimento.getInt(0, -1) + "," + enfermedad_alimento.getInt(j, -1) + "),";
                }
            }
            enfermedad_alimento.recycle();
        }
        script = script.substring(0, script.length() - 1);
        enfermedades_alimento.recycle();
        return script;
    }

    //Metainformación de la base de datos
    public static final String STRING_TYPE = "text";
    public static final String INT_TYPE = "integer";
    public static final String ALIMENTO_TABLE_NAME = "ALIMENTO";
    public static final String TIPO_ALIMENTO_TABLE_NAME = "TIPO_ALIMENTO";
    public static final String PROPIEDAD_TABLE_NAME = "PROPIEDAD";
    public static final String BENEFICIO_TABLE_NAME = "BENEFICIO";
    public static final String ENFERMEDAD_TABLE_NAME = "ENFERMEDAD";
    public static final String CONSUMO_ALIMENTO_TABLE_NAME = "CONSUMO_ALIMENTO";
    public static final String PROPIEDAD_ALIMENTO_TABLE_NAME = "PROPIEDAD_ALIMENTO";
    public static final String BENEFICIO_ALIMENTO_TABLE_NAME = "BENEFICIO_ALIMENTO";
    public static final String ENFERMEDAD_ALIMENTO_TABLE_NAME = "ENFERMEDAD_ALIMENTO";

    //Campos de la tabla ALIMENTO
    public static class Alimento_Campos{
        public static final String ALIMENTO_ID = "_id";
        public static final String ALIMENTO_NOMBRE = "alimento_nombre";
        public static final String ALIMENTO_INFO = "alimento_informacion";
        public static final String ALIMENTO_IMAGEN = "alimento_imagen";
        public static final String ALIMENTO_TIPO = "alimento_tipo";
    }

    //Campos de la tabla TIPO_ALIMENTO
    public static class Tipo_Campos{
        public static final String TIPO_ID = "_id";
        public static final String TIPO_NOMBRE = "tipo_nombre";
    }

    //Campos de la tabla PROPIEDAD
    public static class Propiedad_Campos{
        public static final String PROPIEDAD_ID = "_id";
        public static final String PROPIEDAD_NOMBRE = "propiedad_nombre";
        public static final String PROPIEDAD_DESC = "propiedad_descripcion";
    }

    //Campos de la tabla BENEFICIO
    public static class Beneficio_Campos{
        public static final String BENEFICIO_ID = "_id";
        public static final String BENEFICIO_NOMBRE = "beneficio_nombre";
    }

    //Campos de la tabla ENFERMEDAD
    public static class Enfermedad_Campos{
        public static final String ENFERMEDAD_ID = "_id";
        public static final String ENFERMEDAD_NOMBRE = "enfermedad_nombre";
    }

    //Campos de la tabla CONSUMO_ALIMENTO
    public static class ConsumoAlimento_Campos{
        public static final String CONSUMO_ID = "consumo_id";
        public static final String ALIMENTO_ID = "alimento_id";
        public static final String CONSUMO_TITULO = "consumo_titulo";
        public static final String CONSUMO_DESC = "consumo_descripcion";
    }

    //Campos de la tabla PROPIEDAD_ALIMENTO
    public static class PropiedadAlimento_Campos{
        public static final String ALIMENTO_ID = "alimento_id";
        public static final String PROPIEDAD_ID = "propiedad_id";
    }

    //Campos de la tabla BENEFICIO_ALIMENTO
    public static class BeneficioAlimento_Campos{
        public static final String ALIMENTO_ID = "alimento_id";
        public static final String BENEFICIO_ID = "beneficio_id";
    }

    //Campos de la tabla ENFERMEDAD_ALIMENTO
    public static class EnfermedadAlimento_Campos{
        public static final String ALIMENTO_ID = "alimento_id";
        public static final String ENFERMEDAD_ID = "enfermedad_id";
    }

    //Script de Creación de la tabla TIPO_ALIMENTO
    public static final String CREATE_TIPO_ALIMENTO_SCRIPT =
        "create table " + TIPO_ALIMENTO_TABLE_NAME + "(" +
            Tipo_Campos.TIPO_ID + " " + INT_TYPE + " primary key," +
            Tipo_Campos.TIPO_NOMBRE + " " + STRING_TYPE + " not null)";

    //Script de Creación de la tabla ALIMENTO
    public static final String CREATE_ALIMENTO_SCRIPT =
        "create table " + ALIMENTO_TABLE_NAME + "(" +
            Alimento_Campos.ALIMENTO_ID + " " + INT_TYPE + " primary key," +
            Alimento_Campos.ALIMENTO_NOMBRE + " " + STRING_TYPE + " not null," +
            Alimento_Campos.ALIMENTO_INFO + " " + STRING_TYPE + " not null," +
            Alimento_Campos.ALIMENTO_IMAGEN + " " + INT_TYPE + " null," +
            Alimento_Campos.ALIMENTO_TIPO + " " + INT_TYPE + " not null," +
            "foreign key(" + Alimento_Campos.ALIMENTO_TIPO + ") references " + TIPO_ALIMENTO_TABLE_NAME + "(" + Tipo_Campos.TIPO_ID + "))";

    //Script de Creación de la tabla PROPIEDAD
    public static final String CREATE_PROPIEDAD_SCRIPT =
        "create table " + PROPIEDAD_TABLE_NAME + "(" +
            Propiedad_Campos.PROPIEDAD_ID + " " + INT_TYPE + " primary key," +
            Propiedad_Campos.PROPIEDAD_NOMBRE + " " + STRING_TYPE + " not null," +
            Propiedad_Campos.PROPIEDAD_DESC + " " + STRING_TYPE + " null)";

    //Script de Creación de la tabla BENEFICIO
    public static final String CREATE_BENEFICIO_SCRIPT =
        "create table " + BENEFICIO_TABLE_NAME + "(" +
            Beneficio_Campos.BENEFICIO_ID + " " + INT_TYPE + " primary key," +
            Beneficio_Campos.BENEFICIO_NOMBRE + " " + STRING_TYPE + " not null)";

    //Script de Creación de la tabla ENFERMEDAD
    public static final String CREATE_ENFERMEDAD_SCRIPT =
        "create table " + ENFERMEDAD_TABLE_NAME + "(" +
            Enfermedad_Campos.ENFERMEDAD_ID + " " + INT_TYPE + " primary key," +
            Enfermedad_Campos.ENFERMEDAD_NOMBRE + " " + STRING_TYPE + " not null)";

    //Script de Creación de la tabla CONSUMO_ALIMENTO
    public static final String CREATE_CONSUMO_ALIMENTO_SCRIPT =
        "create table " + CONSUMO_ALIMENTO_TABLE_NAME + "(" +
            ConsumoAlimento_Campos.ALIMENTO_ID + " " + INT_TYPE + " not null," +
            ConsumoAlimento_Campos.CONSUMO_ID + " " + INT_TYPE + " not null," +
            ConsumoAlimento_Campos.CONSUMO_TITULO + " " + STRING_TYPE + " not null," +
            ConsumoAlimento_Campos.CONSUMO_DESC + " " + STRING_TYPE + " null," +
            "primary key(" + ConsumoAlimento_Campos.ALIMENTO_ID + ", " + ConsumoAlimento_Campos.CONSUMO_ID + ")," +
            "foreign key(" + ConsumoAlimento_Campos.ALIMENTO_ID + ") references " + ALIMENTO_TABLE_NAME + "(" + Alimento_Campos.ALIMENTO_ID + "))";

    //Script de Creación de la tabla PROPIEDAD_ALIMENTO
    public static final String CREATE_PROPIEDAD_ALIMENTO_SCRIPT =
        "create table " + PROPIEDAD_ALIMENTO_TABLE_NAME + "(" +
            PropiedadAlimento_Campos.ALIMENTO_ID + " " + INT_TYPE + " not null," +
            PropiedadAlimento_Campos.PROPIEDAD_ID + " " + INT_TYPE + " not null," +
            "primary key(" + PropiedadAlimento_Campos.ALIMENTO_ID + ", " + PropiedadAlimento_Campos.PROPIEDAD_ID + ")," +
            "foreign key(" + PropiedadAlimento_Campos.ALIMENTO_ID + ") references " + ALIMENTO_TABLE_NAME + "(" + Alimento_Campos.ALIMENTO_ID + ")," +
            "foreign key(" + PropiedadAlimento_Campos.PROPIEDAD_ID + ") references " + PROPIEDAD_TABLE_NAME + "(" + Propiedad_Campos.PROPIEDAD_ID + "))";

    //Script de Creación de la tabla BENEFICIO_ALIMENTO
    public static final String CREATE_BENEFICIO_ALIMENTO_SCRIPT =
        "create table " + BENEFICIO_ALIMENTO_TABLE_NAME + "(" +
            BeneficioAlimento_Campos.ALIMENTO_ID + " " + INT_TYPE + " not null," +
            BeneficioAlimento_Campos.BENEFICIO_ID + " " + INT_TYPE + " not null," +
            "primary key(" + BeneficioAlimento_Campos.ALIMENTO_ID + ", " + BeneficioAlimento_Campos.BENEFICIO_ID + ")," +
            "foreign key(" + BeneficioAlimento_Campos.ALIMENTO_ID + ") references " + ALIMENTO_TABLE_NAME + "(" + Alimento_Campos.ALIMENTO_ID + ")," +
            "foreign key(" + BeneficioAlimento_Campos.BENEFICIO_ID + ") references " + BENEFICIO_TABLE_NAME + "(" + Beneficio_Campos.BENEFICIO_ID + "))";

    //Script de Creación de la tabla ENFERMEDAD_ALIMENTO
    public static final String CREATE_ENFERMEDAD_ALIMENTO_SCRIPT =
        "create table " + ENFERMEDAD_ALIMENTO_TABLE_NAME + "(" +
            EnfermedadAlimento_Campos.ALIMENTO_ID + " " + INT_TYPE + " not null," +
            EnfermedadAlimento_Campos.ENFERMEDAD_ID + " " + INT_TYPE + " not null," +
            "primary key(" + EnfermedadAlimento_Campos.ALIMENTO_ID + ", " + EnfermedadAlimento_Campos.ENFERMEDAD_ID + ")," +
            "foreign key(" + EnfermedadAlimento_Campos.ALIMENTO_ID + ") references " + ALIMENTO_TABLE_NAME + "(" + Alimento_Campos.ALIMENTO_ID + ")," +
            "foreign key(" + EnfermedadAlimento_Campos.ENFERMEDAD_ID + ") references " + ENFERMEDAD_TABLE_NAME + "(" + Enfermedad_Campos.ENFERMEDAD_ID + "))";

    //Scripts de INSERTS
    public static String INSERT_TIPO_ALIMENTO_SCRIPT = getScriptInsertTipoAlimento();
    public static String INSERT_ALIMENTO_SCRIPT = getScriptInsertAlimento();
    public static String INSERT_PROPIEDAD_SCRIPT = getScriptInsertPropiedad();
    public static String INSERT_BENEFICIO_SCRIPT = getScriptInsertBeneficio();
    public static String INSERT_PROPIEDAD_ALIMENTO_SCRIPT = getScriptInsertPropiedadAlimento();
    public static String INSERT_BENEFICIO_ALIMENTO_SCRIPT = getScriptInsertBeneficioAlimento();
    public static String INSERT_ENFERMEDAD_SCRIPT = getScriptInsertEnfermedad();
    public static String INSERT_ENFERMEDAD_ALIMENTO_SCRIPT = getScriptInsertEnfermedadAlimento();

    //Scripts de Drops de las tablas
    public static final String DROP_TIPO_ALIMENTO_SCRIPT = "drop table if exists " + TIPO_ALIMENTO_TABLE_NAME;
    public static final String DROP_ALIMENTO_SCRIPT = "drop table if exists " + ALIMENTO_TABLE_NAME;
    public static final String DROP_PROPIEDAD_SCRIPT = "drop table if exists " + PROPIEDAD_TABLE_NAME;
    public static final String DROP_BENEFICIO_SCRIPT = "drop table if exists " + BENEFICIO_TABLE_NAME;
    public static final String DROP_ENFERMEDAD_SCRIPT = "drop table if exists " + ENFERMEDAD_TABLE_NAME;
    public static final String DROP_CONSUMO_ALIMENTO_SCRIPT = "drop table if exists " + CONSUMO_ALIMENTO_TABLE_NAME;
    public static final String DROP_PROPIEDAD_ALIMENTO_SCRIPT = "drop table if exists " + PROPIEDAD_ALIMENTO_TABLE_NAME;
    public static final String DROP_BENEFICIO_ALIMENTO_SCRIPT = "drop table if exists " + BENEFICIO_ALIMENTO_TABLE_NAME;
    public static final String DROP_ENFERMEDAD_ALIMENTO_SCRIPT = "drop table if exists " + ENFERMEDAD_ALIMENTO_TABLE_NAME;

}
