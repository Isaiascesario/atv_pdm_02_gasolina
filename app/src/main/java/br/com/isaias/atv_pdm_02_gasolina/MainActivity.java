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
    private TextView textviewmelhorusar;
    private ImageView imgViewMelhorUsar;

    private double valeAPena = 0.0;
    private int imagen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    private SeekBar.OnSeekBarChangeListener onSeekBarChangeListenerGasolina = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
            precoGasolina = progress / 100D; //utilizando um D ou d alteramos o valor para double
        }
        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }
        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    };
    private SeekBar.OnSeekBarChangeListener onSeekBarChangeListenerEtanol = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
            precoEtanol = progress / 100D; //utilizando um D ou d alteramos o valor para double
        }
        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {
        }
        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
        }
    };
}
