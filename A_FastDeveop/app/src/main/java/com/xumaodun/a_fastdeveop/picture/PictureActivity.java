package com.xumaodun.a_fastdeveop.picture;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.xumaodun.a_fastdeveop.R;
import com.xumaodun.a_fastdeveop.picture.imageloader.ImageLoaderActivity;

public class PictureActivity extends AppCompatActivity {

    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture);
        initToolbar("图片层");
    }

    protected void initToolbar(String title) {
        Toolbar toolbar = (Toolbar) findViewById(R.id.activity_toolbar);
        setTitle(title);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.btn_back_press);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void ImageLoaderActivity(View view){
        intent = new Intent(this, ImageLoaderActivity.class);
        startActivity(intent);
    }

    public void circleImageViewActivity(View view){
        intent = new Intent(this, CircleImageViewActivity.class);
        startActivity(intent);
    }
}
