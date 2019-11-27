package br.com.dbccompany.coworking.Funcoes;

import java.text.NumberFormat;
import java.util.Locale;

public class Conversao {

    public static Double converteRealParaValor( String valor ) {
        NumberFormat formato = NumberFormat.getNumberInstance(new Locale("pt", "BR"));
        try {
            //return Double.parseDouble( valor.replaceAll("[^\\d.,]", "") );
            return formato.parse( valor.replaceAll( "[^\\d.,]", "" ) ).doubleValue();
        } catch ( Exception e ) {
            return null;
        }
    }

    public static String converteValorParaReal( Double valor ) {
        try {
            return NumberFormat.getCurrencyInstance( new Locale( "pt", "BR" ) ).format( valor );
        } catch ( Exception e ) {
            return null;
        }
    }
}
