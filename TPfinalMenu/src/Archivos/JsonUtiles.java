package Archivos;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class JsonUtiles {
    public final static String JSON_ARCHI = "JSON.json";

    /**
     * Graba en un archivo, el string de un JSONObject
     * @param obj
     */
    public static void grabar(JSONObject obj) {
        try {
            FileWriter file = new FileWriter(JSON_ARCHI);
            file.write(obj.toString());
            file.flush();
            file.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Lee desde un archivo, el String de un JSONObject.
     * @return String
     */
    public static String leer()
    {
        String contenido = "";
        try
        {
            contenido = new String(Files.readAllBytes(Paths.get(JSON_ARCHI)));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return contenido;
    }
}