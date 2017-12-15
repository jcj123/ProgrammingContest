package com.sf.race.activity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bigkoo.pickerview.OptionsPickerView;
import com.google.gson.Gson;
import com.sf.race.R;
import com.sf.race.bean.AreaBean;
import com.sf.race.bean.CityBean;
import com.sf.race.bean.MassUser;
import com.sf.race.bean.ProvinceBean;
import com.sf.race.db.DBManager;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by lxb on 2017-12-15.
 */

public class EditInfoActivity extends AppCompatActivity implements View.OnClickListener{
    private OptionsPickerView pvOptions;//地址选择器
    private ArrayList<ProvinceBean> options1Items = new ArrayList<>();//省
    private ArrayList<ArrayList<CityBean>> options2Items = new ArrayList<>();//市
    private ArrayList<ArrayList<ArrayList<AreaBean>>> options3Items = new ArrayList<>();//区
    private ArrayList<String> Provincestr = new ArrayList<>();//省
    private ArrayList<ArrayList<String>> Citystr = new ArrayList<>();//市
    private ArrayList<ArrayList<ArrayList<String>>> Areastr = new ArrayList<>();//区
    private String massId;
    private String province;
    private String address;
    private String userName;
    private String phone;
    private String sendNumber;
    private String sendWeight;

    private LinearLayout ll_setlectAddress;
    private TextView tvShowAddress;
    private EditText etInputAddress;
    private EditText etInputName;
    private EditText etInputPhone;
    private EditText etInputAmount;
    private EditText etInputWeight;

    private Gson gson=new Gson();
    private static final String URL="http://10.2.4.85:8082/mass/adduser";
    private static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");
    public static final String PARAM_MASS_ID="mass_id";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.edit_info_aty);
        initView();
        getIntentData();
    }

    private void initView() {
        ll_setlectAddress= (LinearLayout) findViewById(R.id.ll_select_address);
        tvShowAddress= (TextView) findViewById(R.id.tv_show_address);
        etInputAddress= (EditText) findViewById(R.id.et_input_address);
        etInputName= (EditText) findViewById(R.id.et_input_name);
        etInputPhone= (EditText) findViewById(R.id.et_input_phone);
        etInputAmount= (EditText) findViewById(R.id.et_input_predict_amount);
        etInputWeight= (EditText) findViewById(R.id.et_input_average_weight);
        Button collect = (Button) findViewById(R.id.tv_collect);
        ll_setlectAddress.setOnClickListener(this);
        collect.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ll_select_address:
                showSitePickUp();
                break;
            case R.id.tv_collect:
                if (checkParams()){
                    uploadInfo();
                }
                break;
            default:
                break;
        }
    }

    private void getIntentData(){
        Intent intent=getIntent();
        massId=intent.getStringExtra(PARAM_MASS_ID);
    }

    private void uploadInfo() {
        MassUser user=new MassUser();
        user.setMassId(massId);
        user.setProvince(province);
        user.setAddress(address);
        user.setUserName(userName);
        user.setPhone(phone);
        user.setSendNumber(sendNumber);
        user.setSendWeight(sendWeight);
        String uploadStr=gson.toJson(user,MassUser.class);
        try {
            doPost(URL,uploadStr);
        } catch (IOException e) {
            Log.e("EditInfoActivity","uploadInfo:",e);
        }
    }

    private void doPost(String url,String json)throws IOException{
        OkHttpClient client = new OkHttpClient();
        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Toast.makeText(EditInfoActivity.this,"报名失败",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                setResult(RESULT_OK);
                finish();
            }
        });
    }

    private boolean checkParams(){
        address=etInputAddress.getText().toString();
        userName=etInputName.getText().toString();
        phone=etInputPhone.getText().toString();
        sendNumber=etInputAmount.getText().toString();
        sendWeight=etInputWeight.getText().toString();
        return !("".equals(massId)
                ||"".equals(province)
                ||"".equals(address)
                ||"".equals(userName)
                ||"".equals(phone)
                ||"".equals(sendNumber)
                ||Integer.parseInt(sendNumber)<20
                ||"".equals(sendWeight));
    }

    private void showSitePickUp() {
        SQLiteDatabase db = DBManager.getdb(getApplication());
        //省
        Cursor cursor = db.query("province", null, null, null, null, null,
                null);
        while (cursor.moveToNext()) {
            int pro_id = cursor.getInt(0);
            String pro_code = cursor.getString(1);
            String pro_name = cursor.getString(2);
            String pro_name2 = cursor.getString(3);
            ProvinceBean provinceBean = new ProvinceBean(pro_id, pro_code, pro_name, pro_name2);
            options1Items.add(provinceBean);//添加一级目录
            Provincestr.add(cursor.getString(2));
            //查询二级目录，市区
            Cursor cursor1 = db.query("city", null, "province_id=?", new String[]{String.valueOf(pro_id)}, null, null,
                    null);
            ArrayList<CityBean> cityBeanList = new ArrayList<>();
            ArrayList<String> cityStr = new ArrayList<>();
            //地区集合的集合（注意这里要的是当前省份下面，当前所有城市的地区集合我去）
            ArrayList<ArrayList<AreaBean>> options3Items_03 = new ArrayList<>();
            ArrayList<ArrayList<String>> options3Items_str = new ArrayList<>();
            while (cursor1.moveToNext()) {
                int cityid = cursor1.getInt(0);
                int province_id = cursor1.getInt(1);
                String code = cursor1.getString(2);
                String name = cursor1.getString(3);
                String provincecode = cursor1.getString(4);
                CityBean cityBean = new CityBean(cityid, province_id, code, name, provincecode);
                //添加二级目录
                cityBeanList.add(cityBean);
                cityStr.add(cursor1.getString(3));
                //查询三级目录
                Cursor cursor2 = db.query("area", null, "city_id=?", new String[]{String.valueOf(cityid)}, null, null,
                        null);
                ArrayList<AreaBean> areaBeanList = new ArrayList<>();
                ArrayList<String> areaBeanstr = new ArrayList<>();
                while (cursor2.moveToNext()) {
                    int areaid = cursor2.getInt(0);
                    int city_id = cursor2.getInt(1);
//                    String code0=cursor2.getString(2);
                    String areaname = cursor2.getString(3);
                    String citycode = cursor2.getString(4);
                    AreaBean areaBean = new AreaBean(areaid, city_id, areaname, citycode);
                    areaBeanList.add(areaBean);
                    areaBeanstr.add(cursor2.getString(3));
                }
                options3Items_str.add(areaBeanstr);//本次查询的存储内容
                options3Items_03.add(areaBeanList);
            }
            options2Items.add(cityBeanList);//增加二级目录数据
            Citystr.add(cityStr);
            options3Items.add(options3Items_03);//添加三级目录
            Areastr.add(options3Items_str);
        }
        //设置三级联动效果
        pvOptions=new  OptionsPickerView.Builder(this, new OptionsPickerView.OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int option2, int options3 ,View v) {
                //返回的分别是三个级别的选中位置
                String tx = Provincestr.get(options1)
                        + Citystr.get(options1).get(option2)
                        + Areastr.get(options1).get(option2).get(options3);
                province=tx;
                tvShowAddress.setText(tx);
            }
        }).build();
        pvOptions.setPicker(Provincestr, Citystr, Areastr);
        pvOptions.show();
    }
}
