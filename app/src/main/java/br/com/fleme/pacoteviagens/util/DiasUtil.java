package br.com.fleme.pacoteviagens.util;

import android.support.annotation.NonNull;

public class DiasUtil {

    public static final String PLURAL = " dias";
    public static final String SINGULAR = " dia";

    @NonNull
    public static String formataEmTexto(int dias) {
        if(dias > 1) {
            return dias + PLURAL;
        }
        return dias + SINGULAR;
    }

}
