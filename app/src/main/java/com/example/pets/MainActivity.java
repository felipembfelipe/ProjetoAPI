package com.example.pets;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    Integer posicao;
    ImageView tAvatar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            posicao = extras.getInt("posicao");
        }

        tAvatar = findViewById(R.id.imageAvatar);
        final TextView tNome = findViewById(R.id.txtNome);
        final TextView tCidade = findViewById(R.id.txtCidade);
        final TextView tIdade = findViewById(R.id.txtIdade);
        final TextView tPeso = findViewById(R.id.txtPeso);
        final TextView tPorte = findViewById(R.id.txtPorte);
        final TextView tRaca = findViewById(R.id.txtRaca);
        final TextView tCor = findViewById(R.id.txtCor);
        final TextView tSexo = findViewById(R.id.txtSexo);
        final TextView tDescricao = findViewById(R.id.txtDescricao);




        //Conexao Retrofit2
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://5dd40af58b5e080014dc4e30.mockapi.io/api/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        //JSON
        JsonPlaceHolderAPI jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderAPI.class);
        Call<List<Pets>> call = jsonPlaceHolderApi.getPets();


        call.enqueue(new Callback<List<Pets>>() {
            @Override
            public void onResponse(Call<List<Pets>> call, Response<List<Pets>> response) {
                List<Pets> pets = response.body();

                Integer id;

                for (Pets post : pets) {
                    String avatar, nome, cidade, idade, peso, porte, raca, cor, sexo, descricao;
                    id = post.getId();



                    if (id==posicao) {
                        avatar = post.getAvatar();
                        nome = post.getNome();
                        cidade = post.getCidade();
                        idade = post.getIdade();
                        peso = post.getPeso();
                        porte = post.getPorte();
                        raca = post.getRaca();
                        cor = post.getCor();
                        sexo = post.getSexo();
                        descricao = post.getDescricao();

                        loadImageFromURL(avatar);

                        tNome.setText(nome);
                        tCidade.setText(cidade);
                        tIdade.setText(idade);
                        tPeso.setText(peso);
                        tPorte.setText(porte);
                        tRaca.setText(raca);
                        tCor.setText(cor);
                        tSexo.setText(sexo);
                        tDescricao.setText(descricao);
                    }
                }
            }


            @Override
            public void onFailure(Call<List<Pets>> call, Throwable t) {

            }
        });


    }

    private void loadImageFromURL(String url){

        Picasso.with(this).load(url).placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .into(tAvatar, new com.squareup.picasso.Callback(){

                    @Override
                    public void onSuccess() {

                    }

                    @Override
                    public void onError() {

                    }
                });


    }

}
