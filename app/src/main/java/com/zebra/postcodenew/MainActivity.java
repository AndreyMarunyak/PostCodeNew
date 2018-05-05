package com.zebra.postcodenew;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.zebra.postcodenew.model.PostcodeResponse;

public class MainActivity extends AppCompatActivity implements Callback {

    private static final String[] PERMISSIONS = {Manifest.permission.INTERNET, Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION};
    private static final int REQUEST_CODE = 1337;
    String sample;
    HttpRequest request = new HttpRequest();
    private TextView textView;
    private Parser parser = new Parser();
    private LocationChecker locationChecker;
    private String postcode;
    private double latitude;
    private double longitude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.hello_world_text);
    }

    public void onClickButton(View view) {
        if (!hasPermissions(this, PERMISSIONS)) {
            ActivityCompat.requestPermissions(this, PERMISSIONS, REQUEST_CODE);
        } else {
            request.sendRequest(this);
            locationChecker = new LocationChecker(MainActivity.this);
            latitude = locationChecker.getLatitude();
            longitude = locationChecker.getLongitude();
        }
    }

    private boolean hasPermissions(Context context, String[] permissions) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && context != null &&
                permissions != null) {
            for (String perm : permissions) {
                if (ActivityCompat.checkSelfPermission(context, perm) !=
                        PackageManager.PERMISSION_GRANTED) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public void onResponse(Call call, Response response) throws IOException {
        sample = response.body().string();
        final PostcodeResponse postcodeResponse = parser.getParsedResponse(sample);
        if (postcodeResponse.result != null && !postcodeResponse.result.isEmpty()){
            postcode = postcodeResponse.result.get(0).postcode;
        }
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                textView.setText(postcode + " long: " + longitude + " lat:" + latitude);
            }
        });
    }

    @Override
    public void onFailure(Call call, IOException e) {
        textView.setText("FAILURE");
    }

     GsonBuilder builder = new GsonBuilder();
     Gson gson = builder.create();
     Parser parsedResponse = gson.fromJson(sample, Parser.class);


}


