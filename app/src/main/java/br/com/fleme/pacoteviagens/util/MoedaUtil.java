package br.com.fleme.pacoteviagens.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

//Ctrl+Alt+O >> ajusta imports

public class MoedaUtil {

    public static final String PORTUGUES = "pt";
    public static final String BRASIL = "br";
    public static final String FORMATO_PADRAO = "R$";
    public static final String FORMATO_ESPACO = "R$ ";

    public static String formataMoedaParaPtBr(BigDecimal valor) {
        NumberFormat formatoBrasileiro = DecimalFormat.getCurrencyInstance(new Locale(PORTUGUES, BRASIL));
        return formatoBrasileiro.format(valor).replace(FORMATO_PADRAO, FORMATO_ESPACO);
    }

}
