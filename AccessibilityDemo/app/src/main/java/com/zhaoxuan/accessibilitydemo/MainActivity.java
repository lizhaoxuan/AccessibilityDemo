package com.zhaoxuan.accessibilitydemo;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.zhaoxuan.accessibilitydemo.widget.CustomerImageView;
import com.zhaoxuan.accessibilitydemo.widget.CustomerTextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static android.accessibilityservice.AccessibilityServiceInfo.FEEDBACK_GENERIC;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @SuppressLint("SimpleDateFormat")
    private static final DateFormat TIME_FORMAT = new SimpleDateFormat("HH:mm:ss");
    private static final String TAG = MainActivity.class.getSimpleName();
    private TextView textView;
    private Button button1;
    private CustomerImageView customerImageView;
    private CustomerTextView customerTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        customerImageView = findViewById(R.id.customerImageView);
        customerTextView = findViewById(R.id.customerTextView);

        findViewById(R.id.checkServiceRunning).setOnClickListener(this);
        button1 = findViewById(R.id.button1);
        button1.setOnClickListener(this);
        findViewById(R.id.button2).setOnClickListener(this);
        findViewById(R.id.button3).setOnClickListener(this);
        findViewById(R.id.button4).setOnClickListener(this);
        findViewById(R.id.button5).setOnClickListener(this);
        findViewById(R.id.button7).setOnClickListener(this);

        findViewById(R.id.button4).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    Log.d("MainActivity", "button4 onTouch : " + event.getAction());
                }
                return true;
            }
        });
        customerImageView.setText("暴打小女孩：你看不到我");
        customerImageView.setContentDescription("嘿嘿嘿1");
        customerTextView.setText("嘿嘿嘿3");
        customerTextView.setContentDescription("嘿嘿嘿2");
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.checkServiceRunning:
                if (serviceIsRunning()) {
                    showToast("服务已经在运行！");
                } else {
                    startAccessibilityService();
                }
                break;
            case R.id.button1:
                textView.sendAccessibilityEvent(AccessibilityEvent.TYPE_NOTIFICATION_STATE_CHANGED);
                textView.sendAccessibilityEvent(1024);
                textView.setText(TIME_FORMAT.format(new Date()));
                button1.setText("改变文本内容" + TIME_FORMAT.format(new Date()));
                break;
            case R.id.button2:
                Log.d(TAG, "button2 被点击了");
                break;
            case R.id.button3:
                Log.d(TAG, "button3 被点击了");
                break;
            case R.id.button4:
                Log.d(TAG, "button4 被点击了");
                break;
            case R.id.button5:
                Log.d(TAG, "button5 被点击了");
                break;
            case R.id.button7:
                List<AccessibilityServiceInfo> result = getInstalledAccessibilityServiceList();
                if (result != null) {
                    Log.d(TAG, "size:" + result.size());
                    for (AccessibilityServiceInfo info : result) {
                        Log.d("ServiceInfo", AccessibilityServiceInfotoString(info));
                    }
                    Log.d("ServiceInfo", "-------------------------");
                    for (AccessibilityServiceInfo info : getEnabledAccessibilityServiceList()) {
                        Log.d("ServiceInfo", AccessibilityServiceInfotoString(info));
                    }
                } else {
                    Log.d(TAG, "result = null");
                }
                break;
        }
    }

    public String AccessibilityServiceInfotoString(AccessibilityServiceInfo info) {
        StringBuilder stringBuilder = new StringBuilder();
        appendPackageNames(stringBuilder, info.packageNames);
        stringBuilder.append(", \n");
        stringBuilder.append("id: ").append(info.getId());
        stringBuilder.append(", \n");
        stringBuilder.append("description: ").append(info.getDescription());
        return stringBuilder.toString();
    }

    private static void appendPackageNames(StringBuilder stringBuilder, String[] packageNames) {
        stringBuilder.append("packageNames:");
        stringBuilder.append("[");
        if (packageNames != null) {
            final int packageNameCount = packageNames.length;
            for (int i = 0; i < packageNameCount; i++) {
                stringBuilder.append(packageNames[i]);
                if (i < packageNameCount - 1) {
                    stringBuilder.append(", ");
                }
            }
        }
        stringBuilder.append("]");
    }


    /**
     * 判断自己的应用的AccessibilityService是否在运行
     *
     * @return
     */
    private boolean serviceIsRunning() {
        ActivityManager am = (ActivityManager) getApplicationContext().getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningServiceInfo> services = am.getRunningServices(Short.MAX_VALUE);
        for (ActivityManager.RunningServiceInfo info : services) {
            if (info.service.getClassName().equals(getPackageName() + ".MyAccessibilityService")) {
                return true;
            }
        }
        return false;
    }

    /**
     * 判断自己的应用的AccessibilityService是否在运行
     *
     * @return
     */
    private List<AccessibilityServiceInfo> getInstalledAccessibilityServiceList() {
        AccessibilityManager accessibilityManager = (AccessibilityManager) getApplicationContext().getSystemService(Context.ACCESSIBILITY_SERVICE);
        return accessibilityManager.getInstalledAccessibilityServiceList();
    }

    /**
     * 判断自己的应用的AccessibilityService是否在运行
     *
     * @return
     */
    private List<AccessibilityServiceInfo> getEnabledAccessibilityServiceList() {
        AccessibilityManager accessibilityManager = (AccessibilityManager) getApplicationContext().getSystemService(Context.ACCESSIBILITY_SERVICE);
        return accessibilityManager.getEnabledAccessibilityServiceList(FEEDBACK_GENERIC);
    }

    /**
     * 取得正在监控目标包名的AccessibilityService
     */
    private List<AccessibilityServiceInfo> getInstalledAccessibilityServiceList(String targetPackage) {
        List<AccessibilityServiceInfo> result = new ArrayList<>();
        AccessibilityManager accessibilityManager = (AccessibilityManager) getApplicationContext().getSystemService(Context.ACCESSIBILITY_SERVICE);
        if (accessibilityManager == null) {
            return result;
        }
        List<AccessibilityServiceInfo> infoList = accessibilityManager.getInstalledAccessibilityServiceList();
        if (infoList == null || infoList.size() == 0) {
            return result;
        }
        for (AccessibilityServiceInfo info : infoList) {
            if (info.packageNames == null) {
                result.add(info);
            } else {
                for (String packageName : info.packageNames) {
                    if (targetPackage.equals(packageName)) {
                        result.add(info);
                    }
                }
            }
        }
        return result;
    }

    /**
     * 判断自己的应用的AccessibilityService是否在运行
     *
     * @return
     */
    private List<AccessibilityServiceInfo> getEnabledAccessibilityServiceList(String myPackage) {
        AccessibilityManager accessibilityManager = (AccessibilityManager) getApplicationContext().getSystemService(Context.ACCESSIBILITY_SERVICE);
        List<AccessibilityServiceInfo> result = accessibilityManager.getEnabledAccessibilityServiceList(FEEDBACK_GENERIC);
    }

    /**
     * 前往设置界面开启服务
     */
    private void startAccessibilityService() {
        new AlertDialog.Builder(this)
                .setTitle("开启辅助功能")
                .setIcon(R.mipmap.ic_launcher)
                .setMessage("使用此项功能需要您开启辅助功能")
                .setPositiveButton("立即开启", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // 隐式调用系统设置界面
                        Intent intent = new Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS);
                        startActivity(intent);
                    }
                }).create().show();
    }

    private void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
