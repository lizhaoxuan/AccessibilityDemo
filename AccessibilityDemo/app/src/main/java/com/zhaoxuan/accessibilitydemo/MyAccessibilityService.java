package com.zhaoxuan.accessibilitydemo;

import android.accessibilityservice.AccessibilityService;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

import java.util.List;

/**
 * Created by lizhaoxuan on 2017/11/27.
 */

public class MyAccessibilityService extends AccessibilityService {

    private static final String TAG = MyAccessibilityService.class.getSimpleName();

    @Override
    public void onAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        int eventType = accessibilityEvent.getEventType();
        Log.d(TAG, "type:" + Tools.getTypeDesc(eventType) +
                "  ClassName:" + accessibilityEvent.getClassName() +
                "  Text:" + accessibilityEvent.getText() +
                "  BeforeText:" + accessibilityEvent.getBeforeText());
        if (eventType == AccessibilityEvent.TYPE_VIEW_CLICKED) {
            switch (switchAction(accessibilityEvent)) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    clickButton3And4();
                    break;
                case 4:
                    clickTextContent();
                    break;
                default:
                    break;
            }
        }
    }

    private int switchAction(AccessibilityEvent accessibilityEvent) {
        List<CharSequence> list = accessibilityEvent.getText();
        for (CharSequence str : list) {
            if (str.equals("改变文本内容")) {
                return 1;
            } else if (str.equals("单纯点击按钮")) {
                return 2;
            } else if (str.equals("使用辅助模式点击Button3、4")) {
                return 3;
            } else if (str.equals("获取文本内容")) {
                return 4;
            }
        }
        return 0;
    }

    private void clickButton3And4() {
        AccessibilityNodeInfo nodeInfo = getRootInActiveWindow();
        if (nodeInfo != null) {
            List<AccessibilityNodeInfo> button3 = nodeInfo.findAccessibilityNodeInfosByViewId("com.zhaoxuan.accessibilitydemo:id/button3");
            List<AccessibilityNodeInfo> button4 = nodeInfo.findAccessibilityNodeInfosByViewId("com.zhaoxuan.accessibilitydemo:id/button4");
            nodeInfo.recycle();
            for (AccessibilityNodeInfo item : button3) {
                item.performAction(AccessibilityNodeInfo.ACTION_CLICK);
            }
            for (AccessibilityNodeInfo item : button4) {
                item.performAction(AccessibilityNodeInfo.ACTION_CLICK);
            }
        }
    }

    private void clickTextContent() {
        AccessibilityNodeInfo nodeInfo = getRootInActiveWindow();
        if (nodeInfo != null) {
            List<AccessibilityNodeInfo> content = nodeInfo.findAccessibilityNodeInfosByText("嘿嘿嘿");
            List<AccessibilityNodeInfo> ids = nodeInfo.findAccessibilityNodeInfosByViewId("com.zhaoxuan.accessibilitydemo:id/customerImageView");
            nodeInfo.recycle();
            for (AccessibilityNodeInfo item : content) {
                Log.d(TAG, "item:" + item.getText());
            }
            for (AccessibilityNodeInfo item : ids) {
                Log.d(TAG, "findAccessibilityNodeInfosByViewId - item.getText:" + item.getText());
            }
        }
    }


    @Override
    public void onInterrupt() {
        Log.d(TAG, "onInterrupt");
    }

}
