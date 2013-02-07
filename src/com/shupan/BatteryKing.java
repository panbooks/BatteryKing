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
        
        KeyguardManager  km= (KeyguardManager) getSystemService(Context.KEYGUARD_SERVICE); //得到键盘锁管理器对象 
        KeyguardLock kl = km.newKeyguardLock("unLock"); //参数是LogCat里用的Tag 　　
        kl.disableKeyguard(); //解锁 
        PowerManager pm=(PowerManager)getSystemService(Context.POWER_SERVICE); //获取电源管理器对象 
        //获取PowerManager.WakeLock对象，后面的参数|表示同时传入两个值，最后的是LogCat里用的Tag 
        PowerManager.WakeLock wl = pm.newWakeLock(PowerManager.ACQUIRE_CAUSES_WAKEUP | PowerManager.SCREEN_DIM_WAKE_LOCK, "bright"); 
        wl.acquire();//点亮屏幕 　　
      wl.release();//释放
        
    }
}