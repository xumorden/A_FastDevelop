package com.xumaodun.a_fastdeveop.picture.imageloader;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;
import com.xumaodun.a_fastdeveop.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ImageLoaderActivity extends AppCompatActivity {

    @Bind(R.id.imageView)
    ImageView imageView;

    private String imageUrl = "http://image.bonday.cn/images/1452856687000adbc0a34-ef0f-4313-a38a-2b6ccc05bd36.jpg";
    // 设置图片显示相关参数
    private DisplayImageOptions options;
    public ImageLoader imageLoader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_loader);
        ButterKnife.bind(this);

        imageLoader = ImageLoader.getInstance();

        //初始化图片配置
        options = new DisplayImageOptions.Builder()
                .showImageOnLoading(R.drawable.b) // 设置图片下载期间显示的图片
                .showImageForEmptyUri(R.drawable.c) // 设置图片Uri为空或是错误的时候显示的图片
                .showImageOnFail(R.drawable.d) // 设置图片加载或解码过程中发生错误显示的图片
                .cacheInMemory(true) // 设置下载的图片是否缓存在内存中
                .cacheOnDisk(true) // 设置下载的图片是否缓存在SD卡中
                .displayer(new RoundedBitmapDisplayer(20)) // 设置成圆角图片
                .build();

        useImageLoder();
    }

    private void useImageLoder() {

        this.imageLoader.displayImage(imageUrl,imageView,options);
    }
}