package com.example.formativa_2;

public class DefBD {

    public static final String nameDb = "Registro_user";
    public static final String tabla_user = "Usuario";
    public static final String col_name = "nombre";
    public static final String col_id = "identificacion";
    public static final String col_apto = "apto";
    public static final String col_tipo = "tipo";
    public static final String col_fecha = "fecha";
    public static final String col_hora = "hora";

    public static final String create_tabla_user = "CREATE TABLE IF NOT EXISTS usuario(" +
            "  identificacion text primary key," +
            "  nombre text," +
            "  apto text," +
            "  tipo text," +
            "  fecha text," +
            "  hora text" +
            ");";
}
