package com.zaman.sengkhunlim.photocollection;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(this);
        setContentView(R.layout.activity_main);

        final RecyclerView recyclerView = findViewById( R.id.photo_gallery );

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl( PhotoApi.BASE_URL )
                .addConverterFactory( GsonConverterFactory.create() )
                .build();

        PhotoApi service = retrofit.create( PhotoApi.class );

        Call<PhotoCollection> call = service.collectionList();
        call.enqueue( new Callback<PhotoCollection>() {

            @Override
            public void onResponse(Call<PhotoCollection> call, @NonNull Response<PhotoCollection> response) {

                Photos photos = response.body().getPhotos();

                PhotoAdapter adapter = new PhotoAdapter( photos.getPhoto() );
                recyclerView.setLayoutManager( new LinearLayoutManager( getApplicationContext(), LinearLayoutManager.VERTICAL, false ) );
                recyclerView.setAdapter( adapter );

            }

            @Override
            public void onFailure(Call<PhotoCollection> call, Throwable t) {
                Log.d("hello", "onFailure: " + t);
            }

        });


    }


}
