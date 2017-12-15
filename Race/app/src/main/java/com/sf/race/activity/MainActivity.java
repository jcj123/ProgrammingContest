package com.sf.race.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.util.Log;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.sf.race.R;
import com.sf.race.Utils.HttpHelper;
import com.sf.race.Utils.SearchResultUtil;
import com.sf.race.bean.MainBean;

import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    TextView tvTitle;
    TextView tvWeight;
    TextView tvOne;
    TextView tvTwo;
    TextView tvFive;
    TextView tvSix;
    TextView tvSeven;
    LinearLayout llCircleImg;
    TextView tvNine;
    Button button;
    RelativeLayout llShare;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        tvTitle=(TextView) findViewById(R.id.tv_title);
        tvWeight=(TextView) findViewById(R.id.tv_weight);
        tvOne=(TextView) findViewById(R.id.tv_one);
        tvFive=(TextView) findViewById(R.id.tv_five);
        tvSix=(TextView) findViewById(R.id.tv_six);
        tvSeven=(TextView) findViewById(R.id.tv_seven);
        tvNine=(TextView) findViewById(R.id.tv_nine);
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
                            MainBean.ObjBean objBean=finalMainBean.getObj();
                            tvTitle.setText(objBean.getMktNameShow());
                            SpannableString s1= SearchResultUtil.matcherSearchTitle(Color.parseColor("#ff6532"),String.valueOf(objBean.getDailyMinPackages()),String.valueOf(objBean.getDailyMinPackages()));
                            tvWeight.setText(String.valueOf(objBean.getWeightMin())+"_"+String.valueOf(objBean.getWeightMax()+"  "+"每日最低需寄"+s1+"件"));
                            tvOne.setText(objBean.getLowestPrice());
                            SpannableString s2= SearchResultUtil.matcherSearchTitle(Color.parseColor("#ff6532"),String.valueOf(objBean.getGroupLimit()-objBean.getCurrentUsers()),String.valueOf(objBean.getGroupLimit()-objBean.getCurrentUsers()));
                            tvFive.setText("还差"+s2+"人即可成团");
                            tvSix.setText("截止日期："+objBean.getEndtm());
                            String[] front=objBean.getUseRequire().split("）");
                            SpannableString s3= SearchResultUtil.matcherSearchTitle(Color.parseColor("#ff6532"),String.valueOf(objBean.getDailyMinPackages()),String.valueOf(front[0]));
                            SpannableString s4= SearchResultUtil.matcherSearchTitle(Color.parseColor("#ff6532"),String.valueOf(objBean.getLowestFreight()),String.valueOf(front[1]));
                            tvSeven.setText(s3.toString()+s4);
                            SpannableString s5= SearchResultUtil.matcherSearchTitle(Color.parseColor("#ff6532"),String.valueOf(objBean.getCurrentUsers()),String.valueOf(objBean.getCurrentUsers()));

                            tvNine.setText("已有"+s5+"人参团");



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
