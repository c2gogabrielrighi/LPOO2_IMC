package com.example.imc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // variavel que ira armazenar o valor do meu IMC

        final float[] imc = new float[1];
        //Configurações do meu botão
        //button calcular vai receber (button)conversao para button
        Button btCalcular =  (Button) findViewById(R.id.btCalcular);
        // abaixo segue o evento do OnClick do botao
        btCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Configurações dos textViews que recebem os valores
                TextView editPeso = (TextView) findViewById(R.id.editPeso);
                TextView editAltura  = (TextView) findViewById(R.id.editAltura);
                // Configuração dos textViews que exibem os valores
                TextView textResultado =(TextView)  findViewById(R.id.textResultado);
                TextView textDescricao = (TextView) findViewById(R.id.textDescricao);

                if(TextUtils.isEmpty(editPeso.getText()) || TextUtils.isEmpty(editAltura.getText())){
                    Toast.makeText(getApplicationContext(),getString(R.string.err_valorinvalido),Toast.LENGTH_LONG).show();
                }else {
                    // Peso recebido do usuario
                    int peso = Integer.parseInt(editPeso.getText().toString());

                    // Altura recebida do usuario
                    float altura = Float.parseFloat(editAltura.getText().toString()) / 100;

                    //Calculos para armazenar os valores do imc na variavel IMC
                    //pede para transformar em array o imc


                    imc[0] = peso / (altura * altura);

                    if (imc[0] < 18.5) {
                        textResultado.setText(imc[0] + "");
                        textDescricao.setText(getString(R.string.rec_pesobaixo));
                    } else {

                        if (imc[0] < 25) {
                            textResultado.setText(imc[0] + "");
                            textDescricao.setText(getString(R.string.rec_pesoadequado));
                        } else {
                            if (imc[0] < 30) {
                                textResultado.setText(imc[0] + "");
                                textDescricao.setText(getString(R.string.rec_pesoacima));
                            } else {
                                textResultado.setText(imc[0] + "");
                                textDescricao.setText(getString(R.string.rec_pesoobeso));


                            }
                        }
                    }


                    Intent intent = new Intent(MainActivity.this, Receber.class);

                    intent.putExtra("result", textResultado.getText().toString());
                    intent.putExtra("desc", textDescricao.getText().toString());
                    startActivity(intent);
                }

            }
        });





    }
}
