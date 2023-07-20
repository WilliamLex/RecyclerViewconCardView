package com.example.myapprecyclerview;

import android.os.Bundle;
import android.widget.GridView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapprecyclerview.R;

import java.util.List;

import Adaptadores.ImageAdapter;

public class ImageListActivity extends AppCompatActivity {

    private GridView gridView;
    private List<String> imageList;
    private ImageAdapter imageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.imglist);

        gridView = findViewById(R.id.gridView);
        imageList = getIntent().getStringArrayListExtra("images");
        imageAdapter = new ImageAdapter(this, imageList);
        gridView.setAdapter(imageAdapter);
    }
}
