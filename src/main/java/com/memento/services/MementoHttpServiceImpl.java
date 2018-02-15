package com.memento.services;


import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

/**
 * Created by Gebruiker on 2/15/2018.
 */
public class MementoHttpServiceImpl implements MementoHttpServer {

        public String run(String url) throws IOException {

                OkHttpClient client = new OkHttpClient();

                Request request = new Request.Builder()
                    .url(url)
                    .build();

                Response response = client.newCall(request).execute();
                return response.body().string();

        }

}
