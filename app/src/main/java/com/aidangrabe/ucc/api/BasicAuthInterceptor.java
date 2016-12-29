package com.aidangrabe.ucc.api;

import java.io.IOException;

import okhttp3.Credentials;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by aidangrabe on 27/11/2016.
 *
 * This is an Interceptor that will add a Basic Auth header to each request, without it the requests
 * to Teamwork.com will return 401 - unauthorized
 *
 */
public class BasicAuthInterceptor implements Interceptor {

    private final String auth;

    public BasicAuthInterceptor(String username, String password) {
        // Base64 encode the credentials
        auth = Credentials.basic(username, password);
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        // this will be performed before each request is sent
        // here we add the Authorization header with the Base64 encoded credentials
        Request authRequest = chain.request()
                .newBuilder()
                .addHeader("Authorization", auth)
                .build();
        return chain.proceed(authRequest);
    }

}
