package com.example.sergio.applealtad.storage;

import android.content.Context;
import android.content.SharedPreferences;

public class DemoPreference {
    private SharedPreferences pref;
    private SharedPreferences.Editor editor;
    private Context mContext;

    private final int PRIVATE_MODE = 0;
    private static final String PREF_NAME = "DemoPreferences";
    private static DemoPreference _instance;


    public static synchronized DemoPreference getInstance(Context context) {
        if (_instance == null) {
            _instance = new DemoPreference(context);
        }
        return _instance;
    }
    private DemoPreference(Context context) {
        this.mContext = context;
        pref = mContext.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    private static final String Digito1 = "UNO";
    private static final String Digito2 = "DOS";
    private static final String Digito3 = "TRES";
    private static final String Digito4 = "CUATRO";
    private static final String Digito5 = "CINCO";
    private static final String Digito6 = "SEIS";
    public void setKilometraje(int dUno,int dDos,int dTres,int dCuatro,int dCinco,int dSeis){
        editor.putInt(Digito1, dUno);
        editor.putInt(Digito2, dDos);
        editor.putInt(Digito3, dTres);
        editor.putInt(Digito4, dCuatro);
        editor.putInt(Digito5, dCinco);
        editor.putInt(Digito6, dSeis);
        editor.commit();
    }

    public  int[] getKilometraje(){
        int[] kilometraje = new int[6];
        kilometraje[0]= pref.getInt(Digito1,0);
        kilometraje[1]= pref.getInt(Digito2,0);
        kilometraje[2]= pref.getInt(Digito3,0);
        kilometraje[3]= pref.getInt(Digito4,0);
        kilometraje[4]= pref.getInt(Digito5,0);
        kilometraje[5]= pref.getInt(Digito6,0);

        return kilometraje;
    }
}
