package com.example.myapplication;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.widget.ImageView;
https://github.com/jenly1314/AppUpdater
import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import com.bumptech.glide.request.RequestOptions;

import java.security.MessageDigest;

 public class ImageUtils {

        // 方法用于改变图片亮度
        public static void changeBrightness(Context context, String imageUrl, ImageView imageView, float brightness) {
            // 使用Glide加载图片
            Glide.with(context)
                    .asBitmap()
                    .load(imageUrl)
                    .apply(RequestOptions.bitmapTransform(new BrightnessTransformation(brightness)))
                    .into(imageView);
        }

        // 自定义Transformation类，用于处理图片亮度
        static class BrightnessTransformation extends BitmapTransformation implements Transformation<Bitmap> {
            private float brightness; // 亮度值

            public BrightnessTransformation(float brightness) {
                this.brightness = brightness;
            }

            @Override
            protected Bitmap transform(@NonNull BitmapPool pool, @NonNull Bitmap toTransform, int outWidth, int outHeight) {
                Bitmap bitmap = pool.get(outWidth, outHeight, Bitmap.Config.ARGB_8888);
                if (bitmap == null) {
                    bitmap = Bitmap.createBitmap(outWidth, outHeight, Bitmap.Config.ARGB_8888);
                }

                Canvas canvas = new Canvas(bitmap);
                Paint paint = new Paint();
                paint.setColorFilter(createBrightnessColorMatrixFilter(brightness));
                canvas.drawBitmap(toTransform, 0, 0, paint);

                return bitmap;
            }

            @Override
            public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
                messageDigest.update(("brightness" + brightness).getBytes(CHARSET));
            }

            private ColorMatrixColorFilter createBrightnessColorMatrixFilter(float brightness) {
                ColorMatrix colorMatrix = new ColorMatrix();
                colorMatrix.set(new float[]{
                        1, 0, 0, 0, brightness,
                        0, 1, 0, 0, brightness,
                        0, 0, 1, 0, brightness,
                        0, 0, 0, 1, 0
                });

                return new ColorMatrixColorFilter(colorMatrix);
            }
        }
    }

// 获取 RecyclerView 的 LayoutManager
LayoutManager layoutManager = recyclerView.getLayoutManager();

// 获取要检查的子 View 的位置
int position = 0; // 你想要检查的子 View 的位置

// 获取子 View
View childView = layoutManager.findViewByPosition(position);

// 检查子 View 是否可见
if (childView != null && childView.getLocalVisibleRect(new Rect())) {
    // 子 View 可见
    // 这里可以进行相应的操作
} else {
    // 子 View 不可见
}
