package app_yams.yamsscore;

import android.content.Context;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

/**
 * Created by sim-d on 16/10/2016.
 */

public class Create_colonne {


    public void creation(float PosX, float PosY, FrameLayout Layout, Context context) {


        CheckBox checkBox1 = new CheckBox(context);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams (LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);
        checkBox1.setLayoutParams(params);

        Layout.addView(checkBox1);

    }

}
