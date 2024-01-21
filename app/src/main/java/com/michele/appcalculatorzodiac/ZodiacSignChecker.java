package com.michele.appcalculatorzodiac;

import android.util.Log;

import java.util.HashMap;
import java.util.Map;

public class ZodiacSignChecker {
    enum ZodiacSign {
        ARIES, TAURUS, GEMINI, CANCER, LEO, VIRGO, LIBRA,
        SCORPIO, SAGITTARIUS, CAPRICORN, AQUARIUS, PISCES
    }

    public static ZodiacSign getZodiacSign(String input) {
        String zodiacSign = input.toLowerCase();

        switch (zodiacSign) {
            case "ariete":
            case "aries":
                return ZodiacSign.ARIES;
            case "toro":
            case "taurus":
                return ZodiacSign.TAURUS;
            case "gemelli":
            case "gemini":
                return ZodiacSign.GEMINI;
            case "cancro":
            case "cancer":
                return ZodiacSign.CANCER;
            case "leone":
            case "leo":
                return ZodiacSign.LEO;
            case "vergine":
            case "virgo":
                return ZodiacSign.VIRGO;
            case "bilancia":
            case "libra":
                return ZodiacSign.LIBRA;
            case "scorpione":
            case "scorpio":
                return ZodiacSign.SCORPIO;
            case "sagittario":
            case "sagittarius":
                return ZodiacSign.SAGITTARIUS;
            case "capricorno":
            case "capricorn":
                return ZodiacSign.CAPRICORN;
            case "acquario":
            case "aquario":
            case "aquarius":
                return ZodiacSign.AQUARIUS;
            case "pesci":
            case "fish":
            case "fishes":
            case "pisces":
                return ZodiacSign.PISCES;
            default:
                return null;
        }
    }
    public Map<String, Double> percentuali = new HashMap<>();
    public void creaMappa(){
        // Creazione della mappa per associare le percentuali alle coppie di segni zodiacali
        percentuali.put(ZodiacSign.ARIES + "-" + ZodiacSign.ARIES, 75.0);
        percentuali.put(ZodiacSign.ARIES + "-" + ZodiacSign.TAURUS, 75.0);
        percentuali.put(ZodiacSign.ARIES + "-" + ZodiacSign.GEMINI, 99.0);
        percentuali.put(ZodiacSign.ARIES + "-" + ZodiacSign.CANCER, 85.0);
        percentuali.put(ZodiacSign.ARIES + "-" + ZodiacSign.LEO, 99.0);
        percentuali.put(ZodiacSign.ARIES + "-" + ZodiacSign.VIRGO, 75.0);
        percentuali.put(ZodiacSign.ARIES + "-" + ZodiacSign.LIBRA, 99.0);
        percentuali.put(ZodiacSign.ARIES + "-" + ZodiacSign.SCORPIO, 75.0);
        percentuali.put(ZodiacSign.ARIES + "-" + ZodiacSign.SAGITTARIUS, 99.0);
        percentuali.put(ZodiacSign.ARIES + "-" + ZodiacSign.CAPRICORN, 85.0);
        percentuali.put(ZodiacSign.ARIES + "-" + ZodiacSign.AQUARIUS, 99.0);
        percentuali.put(ZodiacSign.ARIES + "-" + ZodiacSign.PISCES, 99.0);
        //FINE ARIETI valori
        percentuali.put(ZodiacSign.TAURUS + "-" + ZodiacSign.TAURUS, 99.0);
        percentuali.put(ZodiacSign.TAURUS + "-" + ZodiacSign.GEMINI, 85.0);
        percentuali.put(ZodiacSign.TAURUS + "-" + ZodiacSign.CANCER, 99.0);
        percentuali.put(ZodiacSign.TAURUS + "-" + ZodiacSign.LEO, 75.0);
        percentuali.put(ZodiacSign.TAURUS + "-" + ZodiacSign.VIRGO, 99.0);
        percentuali.put(ZodiacSign.TAURUS + "-" + ZodiacSign.LIBRA, 85.0);
        percentuali.put(ZodiacSign.TAURUS + "-" + ZodiacSign.SCORPIO, 99.0);
        percentuali.put(ZodiacSign.TAURUS + "-" + ZodiacSign.SAGITTARIUS, 75.0);
        percentuali.put(ZodiacSign.TAURUS + "-" + ZodiacSign.CAPRICORN, 99.0);
        percentuali.put(ZodiacSign.TAURUS + "-" + ZodiacSign.AQUARIUS, 75.0);
        percentuali.put(ZodiacSign.TAURUS + "-" + ZodiacSign.PISCES, 99.0);
        //GEMINI
        percentuali.put(ZodiacSign.GEMINI + "-" + ZodiacSign.GEMINI, 99.0);
        percentuali.put(ZodiacSign.GEMINI + "-" + ZodiacSign.CANCER, 85.0);
        percentuali.put(ZodiacSign.GEMINI + "-" + ZodiacSign.LEO, 85.0);
        percentuali.put(ZodiacSign.GEMINI + "-" + ZodiacSign.VIRGO, 85.0);
        percentuali.put(ZodiacSign.GEMINI + "-" + ZodiacSign.LIBRA, 99.0);
        percentuali.put(ZodiacSign.GEMINI + "-" + ZodiacSign.SCORPIO, 75.0);
        percentuali.put(ZodiacSign.GEMINI + "-" + ZodiacSign.SAGITTARIUS, 99.0);
        percentuali.put(ZodiacSign.GEMINI + "-" + ZodiacSign.CAPRICORN, 75.0);
        percentuali.put(ZodiacSign.GEMINI + "-" + ZodiacSign.AQUARIUS, 99.0);
        percentuali.put(ZodiacSign.GEMINI + "-" + ZodiacSign.PISCES, 85.0);
        //fatto
        //CANCER
        percentuali.put(ZodiacSign.CANCER + "-" + ZodiacSign.CANCER, 99.0);
        percentuali.put(ZodiacSign.CANCER + "-" + ZodiacSign.LEO, 85.0);
        percentuali.put(ZodiacSign.CANCER + "-" + ZodiacSign.VIRGO, 85.0);
        percentuali.put(ZodiacSign.CANCER + "-" + ZodiacSign.LIBRA, 85.0);
        percentuali.put(ZodiacSign.CANCER + "-" + ZodiacSign.SCORPIO, 99.0);
        percentuali.put(ZodiacSign.CANCER + "-" + ZodiacSign.SAGITTARIUS, 75.0);
        percentuali.put(ZodiacSign.CANCER + "-" + ZodiacSign.CAPRICORN, 99.0);
        percentuali.put(ZodiacSign.CANCER + "-" + ZodiacSign.AQUARIUS, 75.0);
        percentuali.put(ZodiacSign.CANCER + "-" + ZodiacSign.PISCES, 99.0);
        //fatto

        //LEO
        percentuali.put(ZodiacSign.LEO + "-" + ZodiacSign.LEO, 75.0);
        percentuali.put(ZodiacSign.LEO + "-" + ZodiacSign.VIRGO, 85.0);
        percentuali.put(ZodiacSign.LEO + "-" + ZodiacSign.LIBRA, 99.0);
        percentuali.put(ZodiacSign.LEO + "-" + ZodiacSign.SCORPIO, 85.0);
        percentuali.put(ZodiacSign.LEO + "-" + ZodiacSign.SAGITTARIUS, 99.0);
        percentuali.put(ZodiacSign.LEO + "-" + ZodiacSign.CAPRICORN, 75.0);
        percentuali.put(ZodiacSign.LEO + "-" + ZodiacSign.AQUARIUS, 99.0);
        percentuali.put(ZodiacSign.LEO + "-" + ZodiacSign.PISCES, 75.0);
        //fatto
        //VIRGO
        percentuali.put(ZodiacSign.VIRGO + "-" + ZodiacSign.VIRGO, 85.0);
        percentuali.put(ZodiacSign.VIRGO + "-" + ZodiacSign.LIBRA, 85.0);
        percentuali.put(ZodiacSign.VIRGO + "-" + ZodiacSign.SCORPIO, 75.0);
        percentuali.put(ZodiacSign.VIRGO + "-" + ZodiacSign.SAGITTARIUS, 85.0);
        percentuali.put(ZodiacSign.VIRGO + "-" + ZodiacSign.CAPRICORN, 99.0);
        percentuali.put(ZodiacSign.VIRGO + "-" + ZodiacSign.AQUARIUS, 75.0);
        percentuali.put(ZodiacSign.VIRGO + "-" + ZodiacSign.PISCES, 99.0);
        //fatto

        percentuali.put(ZodiacSign.LIBRA + "-" + ZodiacSign.LIBRA, 99.0);
        percentuali.put(ZodiacSign.LIBRA + "-" + ZodiacSign.SCORPIO, 85.0);
        percentuali.put(ZodiacSign.LIBRA + "-" + ZodiacSign.SAGITTARIUS, 85.0);
        percentuali.put(ZodiacSign.LIBRA + "-" + ZodiacSign.CAPRICORN, 85.0);
        percentuali.put(ZodiacSign.LIBRA + "-" + ZodiacSign.AQUARIUS, 99.0);
        percentuali.put(ZodiacSign.LIBRA + "-" + ZodiacSign.PISCES, 75.0);
        //fatto
        percentuali.put(ZodiacSign.SCORPIO + "-" + ZodiacSign.SCORPIO, 99.0);
        percentuali.put(ZodiacSign.SCORPIO + "-" + ZodiacSign.SAGITTARIUS, 85.0);
        percentuali.put(ZodiacSign.SCORPIO + "-" + ZodiacSign.CAPRICORN, 85.0);
        percentuali.put(ZodiacSign.SCORPIO + "-" + ZodiacSign.AQUARIUS, 75.0);
        percentuali.put(ZodiacSign.SCORPIO + "-" + ZodiacSign.PISCES, 99.0);
        //fatto
        percentuali.put(ZodiacSign.SAGITTARIUS + "-" + ZodiacSign.SAGITTARIUS, 75.0);
        percentuali.put(ZodiacSign.SAGITTARIUS + "-" + ZodiacSign.CAPRICORN, 75.0);
        percentuali.put(ZodiacSign.SAGITTARIUS + "-" + ZodiacSign.AQUARIUS, 85.0);
        percentuali.put(ZodiacSign.SAGITTARIUS + "-" + ZodiacSign.PISCES, 85.0);
        //fatto
        percentuali.put(ZodiacSign.CAPRICORN + "-" + ZodiacSign.CAPRICORN, 85.0);
        percentuali.put(ZodiacSign.CAPRICORN + "-" + ZodiacSign.AQUARIUS, 75.0);
        percentuali.put(ZodiacSign.CAPRICORN + "-" + ZodiacSign.PISCES, 85.0);
        //fatto
        percentuali.put(ZodiacSign.AQUARIUS + "-" + ZodiacSign.AQUARIUS, 75.0);
        percentuali.put(ZodiacSign.AQUARIUS + "-" + ZodiacSign.PISCES, 85.0);
        //fatto
        percentuali.put(ZodiacSign.PISCES + "-" + ZodiacSign.PISCES, 99.0);
        //FATTO
    }

    public double creaMatchNew(ZodiacSign segnoLui, ZodiacSign segnoLei, int inverti){
        // Esempio di coppie di segni zodiacali
        ZodiacSign segno1 = segnoLui;
        ZodiacSign segno2 = segnoLei;

        // Costruzione della chiave per la mappa
        String key = segno1.toString() + "-" + segno2.toString();

        // Verifica se la combinazione è presente nella mappa e ottieni la percentuale associata
        if (percentuali.containsKey(key)) {
            double percentuale = percentuali.get(key);
            Log.d("HEY","La percentuale associata alla combinazione è: " + percentuale + "%");
            return percentuale;
        } else {
            if(inverti == 0){
                //se non è stata richiamata una seconda volta
                return creaMatchNew(segnoLei,segnoLui,1);
            }else {
                Log.d("HEY", "Combinazione non gestita");
                return 0.0;
            }
        }
    }
}
