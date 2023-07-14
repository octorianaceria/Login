package com.octoriana201103650.login;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class HotelMainActivity extends AppCompatActivity {

    private ImageView _imageView1;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel_main);

        _imageView1 = (ImageView) findViewById(R.id.imageView1);

        String imageUrl = "https://petualangmudacomc4f8f.zapwp.com/q:intelligent/r:0/wp:1/w:1/u:https://petualangmuda.com/wp-content/uploads/2021/02/Penginapan-Seru-Berteman-Debur-Ombak-Di-Jogja.jpg";
        Picasso.with(this).load(imageUrl).into(_imageView1);
    }
}