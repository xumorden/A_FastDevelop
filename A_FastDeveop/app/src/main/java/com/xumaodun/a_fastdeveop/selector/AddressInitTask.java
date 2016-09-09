package com.xumaodun.a_fastdeveop.selector;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;

import cn.qqtheme.framework.picker.AddressPicker;

/**
 * Created by xumaodun on 16/6/16.
 */
public class AddressInitTask extends AsyncTask<String, Void, ArrayList<AddressPicker.Province>> {
    private Activity activity;
    private ProgressDialog dialog;
    private String selectedProvince = "", selectedCity = "", selectedCounty = "";
    private boolean hideCounty=false;

    /**
     * 初始化为不显示区县的模式
     * @param activity
     * @param hideCounty   is hide County
     */
    public AddressInitTask(Activity activity, boolean hideCounty) {
        this.activity = activity;
        this.hideCounty=hideCounty;
        dialog = ProgressDialog.show(activity, null, "正在初始化数据...", true, true);
    }

    public AddressInitTask(Activity activity) {
        this.activity = activity;
        dialog = ProgressDialog.show(activity, null, "正在初始化数据...", true, true);
    }
    @Override
    protected ArrayList<AddressPicker.Province> doInBackground(String... params) {
        if (params != null) {
            switch (params.length) {
                case 1:
                    selectedProvince = params[0];
                    break;
                case 2:
                    selectedProvince = params[0];
                    selectedCity = params[1];
                    break;
                case 3:
                    selectedProvince = params[0];
                    selectedCity = params[1];
                    selectedCounty = params[2];
                    break;
                default:
                    break;
            }
        }
        ArrayList<AddressPicker.Province> data = new ArrayList<AddressPicker.Province>();
        try {
            String json = AssetsUtils.readText(activity, "city.json");
            data.addAll(JSON.parseArray(json, AddressPicker.Province.class));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

    @Override
    protected void onPostExecute(ArrayList<AddressPicker.Province> result) {
        dialog.dismiss();
        if (result.size() > 0) {
            AddressPicker picker = new AddressPicker(activity, result);
            picker.setHideCounty(hideCounty);
            picker.setSelectedItem(selectedProvince, selectedCity, selectedCounty);
            picker.setOnAddressPickListener(new AddressPicker.OnAddressPickListener() {
                @Override
                public void onAddressPicked(AddressPicker.Province province, AddressPicker.City city, AddressPicker.County county) {
                    if (county == null) {
                        Toast.makeText(activity, "province : " + province + ", city: " + city, Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(activity, "province : " + province + ", city: " + city + ", county: " + county, Toast.LENGTH_LONG).show();
                    }
                }


            });
            picker.show();
        } else {
            Toast.makeText(activity, "数据初始化失败", Toast.LENGTH_SHORT).show();
        }
    }

}
