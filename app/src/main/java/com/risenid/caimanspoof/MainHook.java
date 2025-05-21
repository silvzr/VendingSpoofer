/*
 * WearableSpoof
 * Copyright (C) 2023 Simon1511
 * CaimanSpoof
 * Copyright (C) 2024 RisenID
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.risenid.caimanspoof;

import android.os.Build;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public class MainHook implements IXposedHookLoadPackage {

    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam lpparam) throws Throwable {        
        XposedBridge.log("caimanSpoof: Hooking into: " + lpparam.packageName);

        if (!lpparam.packageName.equals("com.google.android.gms") || lpparam.processName.equals("com.google.android.gms.unstable")) {
            // ro.product.manufacturer
            XposedHelpers.setStaticObjectField(Build.class, "MANUFACTURER", "Google");

            // ro.product.brand
            XposedHelpers.setStaticObjectField(Build.class, "BRAND", "google");

            // ro.product.device
            XposedHelpers.setStaticObjectField(Build.class, "DEVICE", "tegu");

            // ro.build.tags
            XposedHelpers.setStaticObjectField(Build.class, "TAGS", "release-keys");

            // ro.build.type
            XposedHelpers.setStaticObjectField(Build.class, "TYPE", "user");

            // ro.product.product
            XposedHelpers.setStaticObjectField(Build.class, "PRODUCT", "tegu");

            // ro.model.model
            XposedHelpers.setStaticObjectField(Build.class, "MODEL", "Pixel 9a");

            // ro.build.id
            XposedHelpers.setStaticObjectField(Build.class, "ID", "BP31.250502.008");

            // ro.build.fingerprint
            XposedHelpers.setStaticObjectField(Build.class, "FINGERPRINT",
                "google/tegu_beta/tegu:16/BP31.250502.008/13497110:user/release-keys");

            // ro.security.patch
            XposedHelpers.setStaticObjectField(Build.VERSION.class, "SECURITY_PATCH", "2025-05-05");
        }

        if (lpparam.packageName.equals("com.android.vending")) {
            // SDK_INT
            XposedHelpers.setStaticIntField(Build.VERSION.class, "SDK_INT", 32);
        }
    }
}