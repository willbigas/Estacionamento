package br.com.estacionamento.util;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Utilitario para Formatacao de Variaveis - Data, DecimalFormat
 *
 * @since 03/09/2018 - Ultima Modificação
 * @author William Bigas Mauro
 */
public class UtilFormat {

    /**
     * Convertendo String para Data no Formato DD/MM/AAAA
     *
     * @param dataStr
     * @return Date
     * @throws Exception
     */
    public static Date data(String dataStr) {
        try {
            DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            return df.parse(dataStr);
        } catch (ParseException parseException) {
            parseException.printStackTrace();
        }
        return null;
    }

    /**
     * Convertendo Data para String no Formato DD/MM/AAAA
     *
     * @param data
     * @return String
     */
    public static String data(Date data) {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        return df.format(data);
    }

    /**
     * Convertendo String para Data no Formato HH:mm:ss
     *
     * @param dataStr
     * @return Date
     * @throws Exception
     */
    public static Date dataHour(String dataStr) {
        try {
            DateFormat df = new SimpleDateFormat("HH:mm:ss");
            return df.parse(dataStr);
        } catch (ParseException parseException) {
        }
        return null;
    }

    /**
     * Convertendo Data para String no Formato HH:mm:ss
     *
     * @param data
     * @return String
     */
    public static String dataHour(Date data) {
        DateFormat df = new SimpleDateFormat("HH:mm:ss");
        return df.format(data);
    }

    /**
     * Formatando um Double em Moeda - "R$ 1,110.00"
     *
     * @param numero
     * @return String
     */
    public static String decimalFormatR$(Double numero) {
        DecimalFormat df = new DecimalFormat();
        df.applyPattern("R$ ###,###,##0.00");
        return df.format(numero);
    }

    /**
     * Formatando um Integer em Moeda - "R$ 1,110.00"
     *
     * @param numero
     * @return String
     */
    public static String decimalFormatR$(Integer numero) {
        DecimalFormat df = new DecimalFormat();
        df.applyPattern("R$ ###,###,##0.00");
        return df.format(numero);
    }

    /**
     * Formatando um Decimal em Valor decimal Normal - "1,110.00"
     *
     * @param numero
     * @return
     */
    public static String decimalFormat(Double numero) {
        DecimalFormat df = new DecimalFormat();
        df.applyPattern("###,###,##0.00");
        return df.format(numero);
    }

    /**
     * Formatando um Inteiro em Valor decimal Normal - "1,110.00"
     *
     * @param numero
     * @return
     */
    public static String decimalFormat(Integer numero) {
        DecimalFormat df = new DecimalFormat();
        df.applyPattern("###,###,##0.00");
        return df.format(numero);
    }

    /**
     * Formatando Integer em Minutos:Segundos
     *
     * @param numero
     * @return
     */
    public static String mmss(Integer numero) {
        SimpleDateFormat sdf = new SimpleDateFormat();
        sdf.applyPattern("mm:ss");
        return sdf.format(numero);
    }

    /**
     * Formatando Double em Minutos:Segundos
     *
     * @param numero
     * @return
     */
    public static String mmss(Double numero) {
        SimpleDateFormat sdf = new SimpleDateFormat();
        sdf.applyPattern("mm:ss");
        return sdf.format(numero);
    }

    /**
     * Formatando Integer em Horas:Minutos:Segundos
     *
     * @param numero
     * @return
     */
    public static String hhmmss(Integer numero) {
        SimpleDateFormat sdf = new SimpleDateFormat();
        sdf.applyPattern("HH:mm:ss");
        return sdf.format(numero);
    }

    /**
     * Formatando Double em Horas:Minutos:Segundos
     *
     * @param numero
     * @return
     */
    public static String hhmmss(Double numero) {
        SimpleDateFormat sdf = new SimpleDateFormat();
        sdf.applyPattern("HH:mm:ss");
        return sdf.format(numero);
    }

    /**
     * Metodo que verifica se uma String é uma Data com Verificavação de Datas
     * validas usando @SetLenient
     *
     * @param data
     * @return Retorna True se a Data for Valida
     */
    public static boolean isDate(String data) {
        try {
            
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            
            /**
             * O setLenient() é usado para setar sua escolha sobre datas
             * estranhas, quando eu seto para "false" estou dizendo que não
             * aceito datas falsas como 31/02/2016
             */
            sdf.setLenient(false);
            sdf.parse(data);
            return true;
        } catch (ParseException ex) {
            return false;
        }
    }
    

}
