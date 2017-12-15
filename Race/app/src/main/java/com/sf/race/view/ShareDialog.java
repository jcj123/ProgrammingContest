package com.sf.race.view;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import com.sf.race.R;

/**
 * Created by jcj on 2017/12/15.
 */

public class ShareDialog extends Dialog{

    public ShareDialog(@NonNull Context context) {
        super(context);
    }

    public ShareDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    protected ShareDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.share_dialog);
        Button shareWechat = (Button) findViewById(R.id.share_wechat);
        Button shareWechatGroup = (Button) findViewById(R.id.share_wechat_group);
        shareWechat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener !=null) {
                    listener.clickShareWechat();
                }
            }
        });
        shareWechatGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.clickShareWechatGroup();
                }
            }
        });
    }
    private ShareWechatListener listener;

    public ShareWechatListener getListener() {
        return listener;
    }

    public void setListener(ShareWechatListener listener) {
        this.listener = listener;
    }

    public interface ShareWechatListener{
        void clickShareWechat();
        void clickShareWechatGroup();
    }
}
