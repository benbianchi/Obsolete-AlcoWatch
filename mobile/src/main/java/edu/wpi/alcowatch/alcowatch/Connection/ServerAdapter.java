package edu.wpi.alcowatch.alcowatch.Connection;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.net.URL;

/**
 * Created by ben on 1/30/17.
 */

public class ServerAdapter {

    Object payload;

    public void send(final String url, final Context context)
    {
        try {
            URL destination = new URL(url);
            Runnable connectionThread = new Runnable() {
                @Override
                public void run() {

                    RequestQueue queue = Volley.newRequestQueue(context);


                    // Request a string response from the provided URL.
                    StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                            new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {
                                    // Classify

                                    //updateClassification();

                                }
                            }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Log.e("ERROR", "onErrorResponse: "+error.getMessage() );
                        }
                    });
                    // Add the request to the RequestQueue.
                    queue.add(stringRequest);

                    return;
                }
            };
        }
        catch (Exception e)
        {
            Log.e("ERROR", "URL used is malformed: "+e.getMessage());
        }
    }
}
