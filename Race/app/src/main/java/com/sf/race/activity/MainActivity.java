package com.sf.race.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.sf.race.R;
import com.sf.race.Utils.HttpHelper;
import com.sf.race.bean.MainBean;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_weight)
    TextView tvWeight;
    @BindView(R.id.tv_one)
    TextView tvOne;
    @BindView(R.id.tv_two)
    TextView tvTwo;
    @BindView(R.id.tv_five)
    TextView tvFive;
    @BindView(R.id.tv_six)
    TextView tvSix;
    @BindView(R.id.tv_seven)
    TextView tvSeven;
    @BindView(R.id.tv_eight)
    TextView tvEight;
    @BindView(R.id.ll_circle_img)
    LinearLayout llCircleImg;
    @BindView(R.id.tv_nine)
    TextView tvNine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initData();

    }

    private void initData() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                final String s = HttpHelper.get("http://10.2.4.85:8082/Mass/getShowMass");
                Log.e("succ",s);
                MainBean mainBean;
                mainBean= new Gson().fromJson(s,MainBean.class);
                final MainBean finalMainBean = mainBean;
                Log.e("succ",finalMainBean.toString());
                MainActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (finalMainBean != null) {
//                            tvTitle.setText(finalMainBean.getEndtm());
                        }
                    }
                });
            }
        }).start();

//        OkHttp3Util.get("http://10.2.4.85:8082/Mass/getShowMass", new Callback() {
//            @Override
//            public void onFailure(Call call, IOException e) {
//                Log.e("failure",String.valueOf(e));
//
//            }
//
//            @Override
//            public void onResponse(Call call, Response response) throws IOException {
//                String s=response.body().toString();
//                Log.e("succ",s);
//                MainBean mainBean;
//                mainBean= new Gson().fromJson(s,MainBean.class);
//                final MainBean finalMainBean = mainBean;
//                MainActivity.this.runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        if (finalMainBean !=null){
//                            tvTitle.setText(finalMainBean.getEndtm());
//                        }
//                    }
//                });
//
//            }
//        });

    }
}
