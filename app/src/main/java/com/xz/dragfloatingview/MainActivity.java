package com.xz.dragfloatingview;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    //悬浮球
    private DragFloatActionButton floatBall;
    //弹窗
    private PopupWindow popup;
    //弹窗菜单View
    private View menuView;
    //菜单上面的组件
    private TextView menuTime;
    private TextView menuPhone;
    private TextView menuAirCondition;
    private TextView menuLight;
    private TextView menuAir;
    private TextView menuITPower;
    private TextView menuMusic;
    private TextView menuLog;
    private TextView menuSetting;
    private TextView menuMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    //初始化view
    private void initView() {
        floatBall = findViewById(R.id.floatBall);
        menuView = LayoutInflater.from(this).inflate(R.layout.float_menu, null);
        menuTime = menuView.findViewById(R.id.menu_time);
        menuPhone = menuView.findViewById(R.id.menu_phone);
        menuAirCondition = menuView.findViewById(R.id.menu_airCondition);
        menuLight = menuView.findViewById(R.id.menu_lighting);
        menuAir = menuView.findViewById(R.id.menu_air);
        menuITPower = menuView.findViewById(R.id.menu_power);
        menuMusic = menuView.findViewById(R.id.menu_music);
        menuLog = menuView.findViewById(R.id.menu_log);
        menuSetting = menuView.findViewById(R.id.menu_setting);
        menuMain = menuView.findViewById(R.id.menu_main);

        menuTime.setOnClickListener(this);
        menuPhone.setOnClickListener(this);
        menuAirCondition.setOnClickListener(this);
        menuLight.setOnClickListener(this);
        menuAir.setOnClickListener(this);
        menuITPower.setOnClickListener(this);
        menuMusic.setOnClickListener(this);
        menuLog.setOnClickListener(this);
        menuSetting.setOnClickListener(this);
        menuMain.setOnClickListener(this);
        floatBall.setOnClickListener(this);
    }

    //显示View
    private void showView() {
        DisplayMetrics dm = getResources().getDisplayMetrics();
        popup = new PopupWindow(menuView, (int) (dm.widthPixels * 0.7), (int) (dm.heightPixels * 0.5));
        Drawable transpent = new ColorDrawable(Color.TRANSPARENT);
        popup.setBackgroundDrawable(transpent);
        popup.setFocusable(true);
        popup.setOutsideTouchable(true);
        popup.showAtLocation(floatBall, Gravity.CENTER, 0, 0);
        popup.update();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.floatBall:
                showView();
                break;

            default: break;
        }
    }

}
