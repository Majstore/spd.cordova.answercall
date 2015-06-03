package spd.codova.answercall;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.telephony.TelephonyManager;

public class SPDAnswerPhone extends CordovaPlugin
{
    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {

        TelephonyManager tm = (TelephonyManager) mContext
                .getSystemService(Context.TELEPHONY_SERVICE);

        try {
            if (tm == null) {
                // this will be easier for debugging later on
                throw new NullPointerException("tm == null");
            }

            // do reflection magic
            tm.getClass().getMethod("answerRingingCall").invoke(tm);

        } catch (Exception e) {
            callbackContext.error("Unable to use the Telephony Manager directly");
        }
        return true;
    }
}
