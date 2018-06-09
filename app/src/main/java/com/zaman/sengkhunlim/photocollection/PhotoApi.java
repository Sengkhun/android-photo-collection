package com.zaman.sengkhunlim.photocollection;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PhotoApi {

    String BASE_URL = "https://api.flickr.com/";

    @GET("services/rest/?method=flickr.photos.getRecent&api_key=a6d819499131071f158fd740860a5a88&extras=url_h,date_taken&format=json&nojsoncallback=1")
    Call<PhotoCollection> collectionList();

}
