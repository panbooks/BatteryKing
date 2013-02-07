package com.shupan;

import android.app.Activity;
import android.app.KeyguardManager;
import android.app.KeyguardManager.KeyguardLock;
import android.content.Context;
import android.os.Bundle;
import android.os.PowerManager;

public class BatteryKing extends Activity {
	/** Called when the activity is first created. */
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        KeyguardManager  km= (KeyguardManager) getSystemService(Context.KEYGUARD_SERVICE); //�õ����������������� 
        KeyguardLock kl = km.newKeyguardLock("unLock"); //������LogCat���õ�Tag ����
        kl.disableKeyguard(); //���� 
        PowerManager pm=(PowerManager)getSystemService(Context.POWER_SERVICE); //��ȡ��Դ���������� 
        //��ȡPowerManager.WakeLock���󣬺���Ĳ���|��ʾͬʱ��������ֵ��������LogCat���õ�Tag 
        PowerManager.WakeLock wl = pm.newWakeLock(PowerManager.ACQUIRE_CAUSES_WAKEUP | PowerManager.SCREEN_DIM_WAKE_LOCK, "bright"); 
        wl.acquire();//������Ļ ����
      wl.release();//�ͷ�
        
    }
}