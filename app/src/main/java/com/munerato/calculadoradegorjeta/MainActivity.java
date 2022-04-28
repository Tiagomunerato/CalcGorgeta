package com.munerato.calculadoradegorjeta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editValor;
    private TextView txtPorcentagem;
    private TextView txtGorgeta;
    private TextView txtTotal;
    private SeekBar seekBarGerjeta;

    private double porcentagem = 0;
    private int progress;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editValor = findViewById(R.id.editevalor);
        txtPorcentagem = findViewById(R.id.textporcentagem);
        txtGorgeta = findViewById(R.id.textGorjeta);
        txtTotal = findViewById(R.id.texttotal);
        seekBarGerjeta = findViewById(R.id.seekBargorgeta);

        seekBarGerjeta.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                porcentagem = progress;
                txtPorcentagem.setText(Math.round(porcentagem) + "%");
                calcular();

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void calcular(){

        String valorRecuperado = editValor.getText().toString();
        if(valorRecuperado == null || valorRecuperado.equals("")){
            Toast.makeText(getApplicationContext(),"Digite um valor",Toast.LENGTH_LONG).show();

        }else{

            double valorDigitado = Double.parseDouble(valorRecuperado);

            double gorjeta = valorDigitado * (porcentagem/100);

            double total = gorjeta + valorDigitado;

            txtGorgeta.setText("R$ " +(gorjeta));
            txtTotal.setText("R$ " + total);




        }



    }



}