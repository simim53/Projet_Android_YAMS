package app_yams.yamsscore;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;

import static app_yams.yamsscore.R.id.grille;


public class Main_Page extends AppCompatActivity {



    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main__page);



        if(savedInstanceState == null){
            // effet de zoom au lancement uniquement
            final FrameLayout zoom = (FrameLayout) findViewById(grille);
            final Animation zoomAnimation = AnimationUtils.loadAnimation(this, R.anim.zoom);
            zoom.startAnimation(zoomAnimation);
        }



        // resize proportion et placement de la grille ( a chaque demmarage et orientation )
         final FrameLayout grilleFrame = (FrameLayout) findViewById(grille);
        grilleFrame.setX(25.0f);
        grilleFrame.setY(25.0f);
        grilleFrame.setScaleX(1.0f);
        grilleFrame.setScaleY(1.0f);


    }




    protected void onStart() {
        super.onStart();

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
    /*Save your data to be restored here
    Example : outState.putLong("time_state", time); , time is a long variable*/
        super.onSaveInstanceState(outState);
    }




}
