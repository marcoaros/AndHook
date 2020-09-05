package com.tuan800.zhe800.framework.util;

import android.app.Activity;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.telephony.TelephonyManager;
import android.util.Log;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.List;

import andhook.lib.HookHelper;

public class AndHookConfig {
    /** Hook Activity's onStart() method */
    @HookHelper.Hook(clazz = Activity.class)
    private static void onStart(Activity activity) {
        Log.d("GSD_HOOK", "onStart: HookedActivity::onStart start, this is " + activity.getClass());
        HookHelper.invokeVoidOrigin(activity);// invoke the origin method
        Log.d("GSD_HOOK", "onStart: HookedActivity::onStart end, this is " + activity.getClass());
    }

    @HookHelper.Hook(clazz = TelephonyManager.class)
    private static String getDeviceId(TelephonyManager telephonyManager) {
        try {
            Log.d("GSD_HOOK", "this is getDeviceId call" + telephonyManager.getClass());
            throw new NullPointerException();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return HookHelper.invokeObjectOrigin(telephonyManager);
    }

    @HookHelper.Hook(clazz = NetworkInterface.class)
    private static byte[] getHardwareAddress(NetworkInterface networkInterface) throws SocketException {
        try {
            Log.d("GSD_HOOK", "this is getHardwareAddress call" + networkInterface.getClass());
            throw new NullPointerException();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return HookHelper.invokeObjectOrigin(networkInterface);
    }

    @HookHelper.Hook(clazz = PackageManager.class)
    private static List<PackageInfo> getInstalledPackages(PackageManager packageManager, int flags) {
        //android.app.ApplicationPackageManager is hide method
        try {
            Log.d("GSD_HOOK", "this is getInstalledPackages call" + packageManager.getClass());
            throw new NullPointerException();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return HookHelper.invokeObjectOrigin(packageManager);
    }



}
