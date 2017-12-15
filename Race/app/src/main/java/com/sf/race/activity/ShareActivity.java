package com.sf.race.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.sf.race.R;
import com.sf.race.Utils.ImageUtil;

public class ShareActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_share);
        final ImageView QCode = (ImageView) findViewById(R.id.bt_qcode);
        Button share = (Button) findViewById(R.id.bt_share);
        Intent intent = getIntent();
        String qcodeString = intent.getStringExtra(MainActivity.QCODEString);
        final Bitmap bitmap = ImageUtil.encodeAsBitmap(qcodeString);
        byte[] bytes = ImageUtil.transferBitmapToByte(bitmap);
        Glide.with(ShareActivity.this).load(bytes).into(QCode);
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageUtil.saveBitmap(bitmap,"babywang");
            }
        });
    }
}
