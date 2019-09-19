package com.example.imc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    //String do TOASY
    String myString="Você clicou!";


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

                //TOAST
                Toast.makeText(getApplicationContext(),myString,Toast.LENGTH_LONG).show();



                // abaixo segue as  configuraçaoes dos textViews tanto dos que vao receber os valores do usuarios quanto os que vao exibir
              TextView editPeso = (TextView) findViewById(R.id.editPeso);
              TextView editAltura  = (TextView) findViewById(R.id.editAltura);
              TextView textResultado =(TextView)  findViewById(R.id.textResultado);
              TextView textDescricao = (TextView) findViewById(R.id.textDescricao);

                 int peso = Integer.parseInt(editPeso.getText().toString());// a string e aquilo que eu recebi do meu  usuário
                 float altura = Float.parseFloat(editAltura.getText().toString());

                 //Calculos para armazenaro os valores do imc na variavel IMC
                //pede para transformar em array o imc
                imc[0] = peso /(altura * altura);

                if(imc[0]<18.5) {
                    textResultado.setText(imc[0] + "");
                    textDescricao.setText("Baixo Peso");
                }
                        else{

                    if(imc[0]<25) {
                        textResultado.setText(imc[0] + "");
                        textDescricao.setText("Peso Adequado");
                    }
                    else{
                        if(imc[0]<30) {
                            textResultado.setText(imc[0] + "");
                            textDescricao.setText("Sobrepeso");
                        }
                        else{
                            textResultado.setText(imc[0] + "");
                            textDescricao.setText("Obesidade");


                        }
                    }
                }


                Intent intent = new Intent(MainActivity.this,Receber.class);

                intent.putExtra("result",textResultado.getText().toString());
                intent.putExtra("desc",textDescricao.getText().toString());
                startActivity(intent);


            }
        });





    }
}
