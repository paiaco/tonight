package com.tonight.tonight.infra;

import android.content.Context;
import android.widget.Toast;

public class GuiUtil {
    private static GuiUtil guiUtil = new GuiUtil();

    private GuiUtil(){
    }

    public static GuiUtil getGuiUtil() {
        return guiUtil;
    }

    public void toastLong(Context context, String string) {
        Toast.makeText(context, string, Toast.LENGTH_LONG).show();
    }

    public void toastShort(Context context, String string) {
        Toast.makeText(context, string, Toast.LENGTH_SHORT).show();
    }
}
