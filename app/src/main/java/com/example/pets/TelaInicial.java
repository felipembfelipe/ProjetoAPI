package com.example.pets;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TelaInicial extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_inicial);

    }

    public void onClick(View v){
        Integer numero =1;
        Intent i = new Intent(TelaInicial.this, MainActivity.class);
        switch (v.getId()){
            case R.id.btn1:
                numero=1;
                i.putExtra("posicao", numero);
                startActivity(i);
                break;
            case R.id.btn2:
                numero=2;
                i.putExtra("posicao", numero);
                startActivity(i);
                break;
            case R.id.btn3:
                numero=3;
                i.putExtra("posicao", numero);
                startActivity(i);
                break;
            case R.id.btn4:
                numero=4;
                i.putExtra("posicao", numero);
                startActivity(i);
                break;
            case R.id.btn5:
                numero=5;
                i.putExtra("posicao", numero);
                startActivity(i);
                break;
            case R.id.btn6:
                numero=6;
                i.putExtra("posicao", numero);
                startActivity(i);
                break;
            case R.id.btn7:
                numero=7;
                i.putExtra("posicao", numero);
                startActivity(i);
                break;
            case R.id.btn8:
                numero=8;
                i.putExtra("posicao", numero);
                startActivity(i);
                break;
            case R.id.btn9:
                numero=9;
                i.putExtra("posicao", numero);
                startActivity(i);
                break;
            case R.id.btn10:
                numero=10;
                i.putExtra("posicao", numero);
                startActivity(i);
                break;
        }
    }

}
