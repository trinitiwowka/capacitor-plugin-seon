package com.wearesho.pluginseon;

import android.Manifest;

import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;
import com.getcapacitor.annotation.Permission;

import io.seon.androidsdk.service.Seon;
import io.seon.androidsdk.service.SeonBuilder;

@CapacitorPlugin(name = "PluginSeon", permissions = {
        @Permission(
                strings = {
                        Manifest.permission.INTERNET,
                        Manifest.permission.READ_PHONE_STATE,
                        Manifest.permission.ACCESS_WIFI_STATE,
                        Manifest.permission.ACCESS_NETWORK_STATE,
                        Manifest.permission.ACCESS_FINE_LOCATION,
                        Manifest.permission.ACCESS_COARSE_LOCATION,
                }
        ),
})
public class PluginSeonPlugin extends Plugin {
    @PluginMethod
    public void getFingerprintBase64(PluginCall call) {
        String SESSION_ID = call.getString("sessionId", "");

        try {
            // Build with parameters
            Seon seonFingerprint = new SeonBuilder()
                    .withContext(this.getActivity().getApplicationContext())
                    .withSessionId(SESSION_ID)
                    .build();

            // Enable logging
            // seonFingerprint.setLoggingEnabled(true);

            seonFingerprint.getFingerprintBase64(fp -> {
                //set fp as the value for the session property of the fraud API request.
                JSObject result = new JSObject();
                result.put("fp", fp);
                call.resolve(result);
            });
        } catch (Throwable ex) {
            call.reject("An unexpected error occurred: " + ex.getMessage());
        }
    }
}
