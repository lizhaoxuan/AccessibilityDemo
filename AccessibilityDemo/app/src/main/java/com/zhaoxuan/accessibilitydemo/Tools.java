package com.zhaoxuan.accessibilitydemo;

/**
 * Created by lizhaoxuan on 2017/11/27.
 */

public class Tools {

    public static final int TYPES_ALL_MASK = -1;
    public static final int TYPE_ANNOUNCEMENT = 16384;
    public static final int TYPE_ASSIST_READING_CONTEXT = 16777216;
    public static final int TYPE_GESTURE_DETECTION_END = 524288;
    public static final int TYPE_GESTURE_DETECTION_START = 262144;
    public static final int TYPE_NOTIFICATION_STATE_CHANGED = 64;
    public static final int TYPE_TOUCH_EXPLORATION_GESTURE_END = 1024;
    public static final int TYPE_TOUCH_EXPLORATION_GESTURE_START = 512;
    public static final int TYPE_TOUCH_INTERACTION_END = 2097152;
    public static final int TYPE_TOUCH_INTERACTION_START = 1048576;
    public static final int TYPE_VIEW_ACCESSIBILITY_FOCUSED = 32768;
    public static final int TYPE_VIEW_ACCESSIBILITY_FOCUS_CLEARED = 65536;
    public static final int TYPE_VIEW_CLICKED = 1;
    public static final int TYPE_VIEW_CONTEXT_CLICKED = 8388608;
    public static final int TYPE_VIEW_FOCUSED = 8;
    public static final int TYPE_VIEW_HOVER_ENTER = 128;
    public static final int TYPE_VIEW_HOVER_EXIT = 256;
    public static final int TYPE_VIEW_LONG_CLICKED = 2;
    public static final int TYPE_VIEW_SCROLLED = 4096;
    public static final int TYPE_VIEW_SELECTED = 4;
    public static final int TYPE_VIEW_TEXT_CHANGED = 16;
    public static final int TYPE_VIEW_TEXT_SELECTION_CHANGED = 8192;
    public static final int TYPE_VIEW_TEXT_TRAVERSED_AT_MOVEMENT_GRANULARITY = 131072;
    public static final int TYPE_WINDOWS_CHANGED = 4194304;
    public static final int TYPE_WINDOW_CONTENT_CHANGED = 2048;
    public static final int TYPE_WINDOW_STATE_CHANGED = 32;


    public static String getTypeDesc(int type) {
        switch (type) {
            case TYPES_ALL_MASK:
                return "TYPES_ALL_MASK - 所有类型";
            case TYPE_ANNOUNCEMENT:
                return "TYPE_ANNOUNCEMENT -";
            case TYPE_ASSIST_READING_CONTEXT:
                return "TYPE_ASSIST_READING_CONTEXT - ";
            case TYPE_GESTURE_DETECTION_END:
                return "TYPE_GESTURE_DETECTION_END -  ";
            case TYPE_GESTURE_DETECTION_START:
                return "TYPE_GESTURE_DETECTION_START -  ";
            case TYPE_NOTIFICATION_STATE_CHANGED:
                return "TYPE_NOTIFICATION_STATE_CHANGED - 通知状态改变";
            case TYPE_TOUCH_EXPLORATION_GESTURE_END:
                return "TYPE_TOUCH_EXPLORATION_GESTURE_END -  ";
            case TYPE_TOUCH_EXPLORATION_GESTURE_START:
                return "TYPE_TOUCH_EXPLORATION_GESTURE_START -  ";
            case TYPE_TOUCH_INTERACTION_END:
                return "TYPE_TOUCH_INTERACTION_END -  ";
            case TYPE_TOUCH_INTERACTION_START:
                return "TYPE_TOUCH_INTERACTION_START -  ";
            case TYPE_VIEW_ACCESSIBILITY_FOCUSED:
                return "TYPE_VIEW_ACCESSIBILITY_FOCUSED - 获取焦点";
            case TYPE_VIEW_ACCESSIBILITY_FOCUS_CLEARED:
                return "TYPE_VIEW_ACCESSIBILITY_FOCUS_CLEARED -  ";
            case TYPE_VIEW_CLICKED:
                return "TYPE_VIEW_CLICKED - 单击";
            case TYPE_VIEW_CONTEXT_CLICKED:
                return "TYPE_VIEW_CONTEXT_CLICKED -  ";
            case TYPE_VIEW_FOCUSED:
                return "TYPE_VIEW_FOCUSED -  ";
            case TYPE_VIEW_HOVER_ENTER:
                return "TYPE_VIEW_HOVER_ENTER -  ";
            case TYPE_VIEW_HOVER_EXIT:
                return "TYPE_VIEW_HOVER_EXIT -  ";
            case TYPE_VIEW_LONG_CLICKED:
                return "TYPE_VIEW_LONG_CLICKED - 长按";
            case TYPE_VIEW_SCROLLED:
                return "TYPE_VIEW_SCROLLED -  ";
            case TYPE_VIEW_TEXT_CHANGED:
                return "TYPE_VIEW_TEXT_CHANGED - 文字改变";
            case TYPE_VIEW_TEXT_SELECTION_CHANGED:
                return "TYPE_VIEW_TEXT_SELECTION_CHANGED -  ";
            case TYPE_VIEW_TEXT_TRAVERSED_AT_MOVEMENT_GRANULARITY:
                return "TYPE_VIEW_TEXT_TRAVERSED_AT_MOVEMENT_GRANULARITY -  ";
            case TYPE_WINDOWS_CHANGED:
                return "TYPE_WINDOWS_CHANGED -  ";
            case TYPE_WINDOW_CONTENT_CHANGED:
                return "TYPE_WINDOW_CONTENT_CHANGED -  窗体内容变化";
            case TYPE_WINDOW_STATE_CHANGED:
                return "TYPE_WINDOW_STATE_CHANGED - 窗口状态改变";
            case TYPE_VIEW_SELECTED:
                return "TYPE_VIEW_SELECTED - 选中";
            default:
                return "NOT FOUND";
        }
    }

}
