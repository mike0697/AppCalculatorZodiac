package com.michele.appcalculatorzodiac;

import static android.view.View.GONE;

import static com.michele.appcalculatorzodiac.ZodiacSignChecker.getZodiacSign;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class MainActivity extends AppCompatActivity {

    EditText inizialiNomeLui;
    EditText inizialiCognomeLui;
    AutoCompleteTextView autoCompleteTextViewLui;


    EditText inizialiNomeLei;
    EditText inizialiCognomeLei;
    AutoCompleteTextView autoCompleteTextViewLei;
    TextView textResult;
    ZodiacSignChecker zodiacSignChecker;

    TextView textDescrizione;

    private AdView mAdView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Init();
        //segnoZodiacali
        String[] opzioni = {traduciSegno(R.string.ariete), traduciSegno(R.string.toro), traduciSegno(R.string.gemelli), traduciSegno(R.string.cancro), traduciSegno(R.string.leone), traduciSegno(R.string.vergine), traduciSegno(R.string.bilancia), traduciSegno(R.string.scorpione),
                traduciSegno(R.string.sagittario), traduciSegno(R.string.capricorno), traduciSegno(R.string.acquario), traduciSegno(R.string.pesci)}; // Elenco dei segni zodiacali
        ArrayAdapter<String> adapterLui = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, opzioni) {
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                TextView textView = (TextView) super.getView(position, convertView, parent);
                int customColor = ContextCompat.getColor(getContext(), R.color.white); // Cambia il colore del testo
                textView.setTextColor(customColor);
                return textView;
            }
        };
        ArrayAdapter<String> adapterLei = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, opzioni) {
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                TextView textView = (TextView) super.getView(position, convertView, parent);
                int customColor = ContextCompat.getColor(getContext(), R.color.white); // Cambia il colore del testo
                textView.setTextColor(customColor);
                return textView;
            }
        };
        autoCompleteTextViewLui.setAdapter(adapterLui);
        autoCompleteTextViewLei.setAdapter(adapterLei);


        textResult = findViewById(R.id.matchResult);
        textResult.setVisibility(GONE);
        Button match = findViewById(R.id.buttonMatch);
        match.setOnClickListener((v) -> {
            //chiude la tastiera
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(v.getWindowToken(), 0);
            controlloDati();
        });

        //Ads
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

    }

    private void Init() {
        inizialiNomeLui = findViewById(R.id.inizialiNomeLui);
        inizialiCognomeLui = findViewById(R.id.inizialiCognomeLui);
        autoCompleteTextViewLui = findViewById(R.id.segnoZodiacaleLui);


        inizialiNomeLei = findViewById(R.id.inizialiNomeLei);
        inizialiCognomeLei = findViewById(R.id.inizialiCognomeLei);
        autoCompleteTextViewLei = findViewById(R.id.segnoZodiacaleLei);

        zodiacSignChecker = new ZodiacSignChecker();
        zodiacSignChecker.creaMappa();

        textDescrizione = findViewById(R.id.textDescrizione);
        textDescrizione.setVisibility(GONE);
    }


    private void controlloDati() {
        //controlla che i campi non siano vuoti delle inziali
        if (isEditTextEmpty(inizialiNomeLui)  || isEditTextEmpty(inizialiCognomeLui) || isEditTextEmpty(inizialiNomeLei) || isEditTextEmpty(inizialiCognomeLei)) {
            // L'EditText è vuoto
            Log.d("HEY","campo non valido");
            mostraToast(R.string.messaggio_errore_iniziali);

        } else {
            Log.d("HEY","inziali valide");
            // L'EditText contiene testo
            //puoi procedere
            //controlla se è un segno zodiacale
            String segnoLui = autoCompleteTextViewLui.getText().toString().trim();
            String segnoLei = autoCompleteTextViewLei.getText().toString().trim();

            //conrolla se i segni sono validi
            ZodiacSignChecker.ZodiacSign signLui = getZodiacSign(segnoLui);
            ZodiacSignChecker.ZodiacSign signLei = getZodiacSign(segnoLei);
            if((signLui != null) && (signLei != null)) {
                Log.d("HEY", "SEGNO = "+ signLui + " : " + signLei);
                Double p = zodiacSignChecker.creaMatchNew(signLui,signLei,0); // va lasciato 0 di deafault
                textResult.setText(p + "%");
                textResult.setVisibility(View.VISIBLE);
            }
            else {
                Log.d("HEY", "segno non valido");
                mostraToast(R.string.messaggio_errore_segno_zodiacale);
            }
        }

    }
    public boolean isEditTextEmpty(EditText editText) {
        return editText.getText().toString().trim().isEmpty();
    }

    private void mostraToast(int idMessaggio) {
        String messaggio = getResources().getString(idMessaggio);
        Toast.makeText(getApplicationContext(), messaggio, Toast.LENGTH_SHORT).show();
    }

    private String traduciSegno(int id){
        return getResources().getString(id);
    }
}