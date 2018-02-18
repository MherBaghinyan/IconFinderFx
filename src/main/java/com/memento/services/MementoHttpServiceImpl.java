package com.memento.services;

import com.memento.rest.IconFinderUtils;
import okhttp3.*;

import java.io.IOException;

/**
 * Created by Gebruiker on 2/15/2018.
 */
public class MementoHttpServiceImpl implements MementoHttpServer {

        public static final MediaType JSON
                = MediaType.parse("application/json; charset=utf-8");

        private OkHttpClient client = new OkHttpClient();

        @Override
        public String call(String url) throws IOException {

                Request request = new Request.Builder()
                    .url(url)
                    .build();

                Response response = client.newCall(request).execute();
                return response.body().string();
        }

        @Override
        public String authenticate() throws IOException {

                String json = bowlingJson();
                String response = post(IconFinderUtils.AUTH_TOKEN_URL, json);
                System.out.println(response);

//                RequestBody requestBody = new MultipartBody.Builder()
//                    .setType(MultipartBody.FORM)
//                    .addFormDataPart("grant_type", "jwt_bearer")
//                    .addFormDataPart("client_id", IconFinderUtils.CLIENT_ID)
//                    .addFormDataPart("client_secret", IconFinderUtils.CLIENT_SECRET)
//                    .build();
//
//                Request request = new Request.Builder()
//                    .url(IconFinderUtils.AUTH_TOKEN_URL)
//                    .post(requestBody)
//                    .build();
//
//                OkHttpClient client = new OkHttpClient();
//
//                Response response = client.newCall(request).execute();
//
//                System.out.println(response.isSuccessful());
//                System.out.println(response.body());
//                System.out.println(response.message());
//                System.out.println(response.headers());

                return response.toString();
        }

        private String post(String url, String json) throws IOException {

                RequestBody body = RequestBody.create(JSON, json);
                Request request = new Request.Builder()
                        .url(url)
                        .post(body)
                        .build();

                Response response = client.newCall(request).execute();
                return response.body().string();
        }

        private String bowlingJson() {
                return "{'grant_type':'jwt_bearer',"
                        + "'client_id':'" + IconFinderUtils.CLIENT_ID + "',"
                        + "'client_secret':'" + IconFinderUtils.CLIENT_SECRET + "'"
                        + "}";
        }

}
