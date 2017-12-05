package com.michael.carsensor.helper;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.PowerManager;


public class ScreenListener {
    private Context mContext;
    private ScreenBroadcastReceiver mScreenReceiver;
    private ScreenStateListener mScreenStateListener;

    public ScreenListener(Context context) {
        mContext = context;
        mScreenReceiver = new ScreenBroadcastReceiver();
    }

    /**
     * ��ʼ������Ļ״̬
     *
     * @param listener
     */
    public void start(ScreenStateListener listener) {
        mScreenStateListener = listener;
        IntentFilter filter = new IntentFilter();
        filter.addAction(Intent.ACTION_SCREEN_ON);
        filter.addAction(Intent.ACTION_SCREEN_OFF);
        filter.addAction(Intent.ACTION_USER_PRESENT);
        mContext.registerReceiver(mScreenReceiver, filter);
        initScreenState();
    }

    /**
     * ��ʼ����Ļ״̬
     */
    private void initScreenState() {
        if (mScreenStateListener == null) {
            throw new IllegalArgumentException("listener is null");
        }
        PowerManager manager = (PowerManager) mContext
                .getSystemService(Context.POWER_SERVICE);
        if (manager.isScreenOn()) {
            mScreenStateListener.onScreenOn();
        } else {
            mScreenStateListener.onScreenOff();
        }
    }

    /**
     * ֹͣscreen״̬����
     */
    public void stop() {
        mContext.unregisterReceiver(mScreenReceiver);
    }

    /**
     * ��Ļ״̬�㲥������
     */
    private class ScreenBroadcastReceiver extends BroadcastReceiver {
        private String action = null;

        @Override
        public void onReceive(Context context, Intent intent) {
            action = intent.getAction();
            if (Intent.ACTION_SCREEN_ON.equals(action)) { // ����
                mScreenStateListener.onScreenOn();
            } else if (Intent.ACTION_SCREEN_OFF.equals(action)) { // ����
                mScreenStateListener.onScreenOff();
            } else if (Intent.ACTION_USER_PRESENT.equals(action)) { // ����
                mScreenStateListener.onUserPresent();
            }
        }

    }

    /**
     * �ص��ӿ�
     */
    public interface ScreenStateListener {

        /**
         * ��Ļ�ѵ���
         */
        void onScreenOn();

        /**
         * ��Ļ��Ϩ��
         */
        void onScreenOff();

        /**
         * ��Ļ�ѽ���
         */
        void onUserPresent();

    }

}

