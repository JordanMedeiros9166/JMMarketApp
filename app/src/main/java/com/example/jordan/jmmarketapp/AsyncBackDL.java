package com.example.jordan.jmmarketapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Jordan on 12/30/2017.
 */

 public class AsyncBackDL extends AsyncTask<String, Integer, Bitmap>{
    Context context;
    ImageView imageView;
    Bitmap bitmap;
    InputStream inp = null;
    int responseCode = -1;
    public AsyncBackDL(Context context, ImageView imageView) {
        this.context = context;
        this.imageView = imageView;
    }
    @Override
    protected void onPreExecute() {
        //nothing yet
    }
    @Override
    protected Bitmap doInBackground(String... params) {

        URL url = null;
        try {

            url = new URL(params[0]);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setDoOutput(true);
            httpURLConnection.connect();

            responseCode = httpURLConnection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                inp = httpURLConnection.getInputStream();
                bitmap = BitmapFactory.decodeStream(inp);
                inp.close();


            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bitmap;
    }

    @Override
    protected void onPostExecute(Bitmap data) {
        imageView.setImageBitmap(data);
    }

}



