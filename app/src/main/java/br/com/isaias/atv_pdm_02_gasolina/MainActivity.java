package br.com.isaias.atv_pdm_02_gasolina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {
    private NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();

    private double precoGasolina;
    private double precoEtanol;
    private TextView textprecoGasolina;
    private TextView textprecoEtanol;
    private TextView textviewmelhorusar;
    private ImageView imgViewMelhorUsar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textviewmelhorusar = findViewById(R.id.textTrocaMelhorUsar);
        textprecoGasolina = findViewById(R.id.precoGasolina);
        textprecoEtanol = findViewById(R.id.precoEtanol);
        imgViewMelhorUsar = findViewById(R.id.imageViewMelhorUsar);
        SeekBar seekBarGasolina = findViewById(R.id.seekBarGasolina);
        SeekBar seekBarEtanol = findViewById(R.id.seekBarEtanol);
        seekBarGasolina.setOnSeekBarChangeListener(onSeekBarChangeListenerGasolina);
        seekBarEtanol.setOnSeekBarChangeListener(onSeekBarChangeListenerEtanol);
    }

    private SeekBar.OnSeekBarChangeListener onSeekBarChangeListenerGasolina = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
            precoGasolina = progress / 100D; //utilizando um D ou d alteramos o valor para double
            textprecoGasolina.setText(currencyFormat.format(precoGasolina));
        }
        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }
        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
            if(precoEtanol/precoGasolina > 0.7){
                textviewmelhorusar.setText(R.string.textMelhorUsarGasolina);
                imgViewMelhorUsar.setImageResource(R.drawable.imagengasolina);
            }
            else{
                textviewmelhorusar.setText(R.string.textMelhorUsarEtanol);
                imgViewMelhorUsar.setImageResource(R.drawable.imagen);
            }
        }
    };
    private SeekBar.OnSeekBarChangeListener onSeekBarChangeListenerEtanol = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
            precoEtanol = progress / 100D; //utilizando um D ou d alteramos o valor para double
            textprecoEtanol.setText(currencyFormat.format(precoEtanol));
        }
        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {
        }
        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
            if(precoEtanol/precoGasolina > 0.7){
                textviewmelhorusar.setText(R.string.textMelhorUsarGasolina);
                imgViewMelhorUsar.setImageResource(R.drawable.imagengasolina);
            }
            else{
                textviewmelhorusar.setText(R.string.textMelhorUsarEtanol);
                imgViewMelhorUsar.setImageResource(R.drawable.imagen);
            }
        }
    };
}
