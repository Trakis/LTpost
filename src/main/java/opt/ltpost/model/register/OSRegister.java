/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opt.ltpost.model.register;

import java.util.prefs.Preferences;

/**
 * operating system local storage Registers Saving form parameters
 *
 * @author gbruzgys
 */
public class OSRegister {

    /*Register Location for LT POST app settings */
    private static final Preferences PREFS_LT_POST = Preferences.userRoot().node("ltpost/settings");

    /**
     * Create register key with value
     *
     * @param keyName register variable name
     * @param keyValue value
     */
    public static void setKey(keyNames keyName, String keyValue) {
        PREFS_LT_POST.put(keyName.toString(), keyValue);
    }

    /**
     * Create register key with value
     *
     * @param keyName register variable name
     * @param keyValue value long
     */
    public static void setKey(keyNames keyName, long keyValue) {
        PREFS_LT_POST.putLong(keyName.toString(), keyValue);
    }

    /**
     * Extract register value
     *
     * @param keyName register variable name
     * @return value
     */
    public static String getKey(keyNames keyName) {
        return PREFS_LT_POST.get(keyName.toString(), null);
    }

    /**
     * Register key names for saving values
     */
    public static enum keyNames {

        POST_LABEL_LOCATION,
        SIGNED_POST_LABEL_FOLDER,
        SIGNATURE_IMAGE_LOCATION,
        DATE_SIGNED,
        STAMP_POINT_X,
        STAMP_POINT_Y,
        STAMP_WIDTH,
        DATE_SIZE,
        ;

    }

}
