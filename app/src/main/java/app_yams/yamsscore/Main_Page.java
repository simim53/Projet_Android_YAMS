package app_yams.yamsscore;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ZoomControls;

import java.util.Hashtable;



public class Main_Page extends AppCompatActivity {

    public int flag = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main__page);


        if (flag == 0) {
            final FrameLayout zoom = (FrameLayout) findViewById(R.id.grille);
            final Animation zoomAnimation = AnimationUtils.loadAnimation(this, R.anim.zoom);
            zoom.startAnimation(zoomAnimation);
            flag = 1;
        }

        flag = 1;

    }











}
