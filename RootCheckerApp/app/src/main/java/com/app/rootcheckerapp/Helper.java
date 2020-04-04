package com.app.rootcheckerapp;

import android.util.Log;

public class Helper {

public static boolean isRooted()
{
    Process process = null;
    try {
        process = Runtime.getRuntime().exec("su");
        return true;
    }
    catch (Exception e)
    {
        Log.d("Exception", e.toString());
         return false;
    }
    finally {
        // Destroy process
        if (process != null)
        {
            process.destroy();
        }
    }
}
}
