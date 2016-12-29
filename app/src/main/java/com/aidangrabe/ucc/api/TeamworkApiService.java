package com.aidangrabe.ucc.api;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by aidangrabe on 27/11/2016.
 *
 */
public class TeamworkApiService {

    public static final String DOMAIN = "uccandroidlabs";
    public static final String API_KEY = "api_key";

    public static TeamworkApi create() {
        return create(DOMAIN, API_KEY);
    }

    public static TeamworkApi create(String domain, String apiKey) {
        OkHttpClient httpClient = new OkHttpClient.Builder()
                // for Teamwork.com, if we login with apikey, password can be anything ("." in this case)
                .addInterceptor(new BasicAuthInterceptor(apiKey, "."))
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://" + domain + ".teamwork.com")
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient)
                .build();
        return retrofit.create(TeamworkApi.class);
    }

}
