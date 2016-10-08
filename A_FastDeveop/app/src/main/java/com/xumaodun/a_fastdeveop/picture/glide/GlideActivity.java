package com.xumaodun.a_fastdeveop.picture.glide;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import com.xumaodun.a_fastdeveop.R;

public class GlideActivity extends AppCompatActivity {

    private Activity mActivity;
    // 将从此URL加载网络图片。
    private String img_url = "http://image.bonday.cn/images/1452856687000adbc0a34-ef0f-4313-a38a-2b6ccc05bd36.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = this;
        setContentView(R.layout.activity_glide);
        ImageView iv = (ImageView) findViewById(R.id.imageView);
        Glide.with(mActivity).load(img_url).bitmapTransform(new GlideRoundTransform(this,50))
            /*
             * 缺省的占位图片，一般可以设置成一个加载中的进度GIF图
             * crossFade 渐入渐出的动画效果
             * Glide加载图片大小是自动调整的，他根据ImageView的尺寸自动调整加载的图片大小，
             * 并且缓存的时候也是按图片大小缓存，每种尺寸都会保留一份缓存，
             * 如果图片不会自动适配到 ImageView，调用 override(horizontalSize, verticalSize) 。
             * 这将在图片显示到 ImageView之前重新改变图片大小
             * .dontAnimate().override(400,600).fitCenter().into(imageView)
             *
             * centerCrop 这个方法是裁剪图片，当图片比ImageView大的时候，
                他把把超过ImageView的部分裁剪掉，尽可能的让ImageView 完全填充
                ，但图像可能不会全部显示

                加载Gif文件
                Glide.with(context).load("http://img1.3lian.com/2015/w4/17/d/64.gif").into(imageView);
             */
                //.placeholder(R.drawable.b).crossFade(2000).fitCenter()
                .into(iv);
    }

    /**
     * 将图像转换为四个角有弧度的图像
     */
    public class GlideRoundTransform extends BitmapTransformation {
        private float radius = 0f;

        public GlideRoundTransform(Context context) {
            this(context, 100);
        }

        public GlideRoundTransform(Context context, int dp) {
            super(context);
            this.radius = Resources.getSystem().getDisplayMetrics().density * dp;
        }

        @Override
        protected Bitmap transform(BitmapPool pool, Bitmap toTransform, int outWidth, int outHeight) {
            return roundCrop(pool, toTransform);
        }

        private Bitmap roundCrop(BitmapPool pool, Bitmap source) {
            if (source == null) return null;

            Bitmap result = pool.get(source.getWidth(), source.getHeight(), Bitmap.Config.ARGB_8888);
            if (result == null) {
                result = Bitmap.createBitmap(source.getWidth(), source.getHeight(), Bitmap.Config.ARGB_8888);
            }
            Canvas canvas = new Canvas(result);
            Paint paint = new Paint();
            paint.setShader(new BitmapShader(source, BitmapShader.TileMode.CLAMP, BitmapShader.TileMode.CLAMP));
            paint.setAntiAlias(true);
            RectF rectF = new RectF(0f, 0f, source.getWidth(), source.getHeight());
            canvas.drawRoundRect(rectF, radius, radius, paint);
            Log.e("11aa", radius + "");
            return result;
        }

        @Override
        public String getId() {
            return getClass().getName() + Math.round(radius);
        }
    }

}
