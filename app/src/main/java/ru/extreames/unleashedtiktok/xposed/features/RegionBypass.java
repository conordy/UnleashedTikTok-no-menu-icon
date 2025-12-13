package ru.extreames.unleashedtiktok.xposed.features;

import android.telephony.TelephonyManager;

import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public class RegionBypass {
    private static final String REGION_COUNTRY_ISO = "BY";
    private static final String REGION_OPERATOR_NUM = "25704";
    private static final String REGION_OPERATOR_NAME = "life:)";

    public static void initialize(final XC_LoadPackage.LoadPackageParam lpParam) {
        retConst(TelephonyManager.class, "getSimOperatorName", REGION_OPERATOR_NAME);
        retConst(TelephonyManager.class, "getSimCountryIso", REGION_COUNTRY_ISO);
        retConst(TelephonyManager.class, "getSimOperator", REGION_OPERATOR_NUM);
        retConst(TelephonyManager.class, "getNetworkOperatorName", REGION_OPERATOR_NAME);
        retConst(TelephonyManager.class, "getNetworkCountryIso", REGION_COUNTRY_ISO);
        retConst(TelephonyManager.class, "getNetworkOperator", REGION_OPERATOR_NUM);
    }

    private static void retConst(Class<?> clazz, String method, String constant) {
        XposedHelpers.findAndHookMethod(
                clazz,
                method,
                new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) {
                        param.setResult(constant);
                    }
                });
    }
}
