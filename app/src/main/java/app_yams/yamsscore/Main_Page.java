package app_yams.yamsscore;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;



public class Main_Page extends AppCompatActivity {

    private float scale ;
    public ScaleGestureDetector SGD;
    public ImageView ImageGrille;
    public FrameLayout Layout_Principal;
    public RelativeLayout RelativeLayout_;
    public Create_colonne colonne1;
    private float dX;
    private float dY;


    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main__page);




        // condition valide si 1er lancement
      //  if (savedInstanceState == null) {

            // effet de zoom au lancement uniquement
            final FrameLayout zoom = (FrameLayout) findViewById(R.id.Layout_Principal);
            final Animation zoomAnimation = AnimationUtils.loadAnimation(this, R.anim.zoom);
            zoom.startAnimation(zoomAnimation);



      //  }


        ImageGrille = (ImageView) findViewById(R.id.imageView);
        Layout_Principal = (FrameLayout) findViewById(R.id.Layout_Principal);
        RelativeLayout_ = (RelativeLayout)findViewById(R.id.RelativeLayout);

        //creation listener geste et scale
        SGD = new ScaleGestureDetector(this, new ScaleListener());




        colonne1 = new Create_colonne();
        colonne1.creation(10,10,Layout_Principal);









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


    // event touche écran
    public boolean onTouchEvent(MotionEvent ev) {

        SGD.onTouchEvent(ev);

        final int action = ev.getAction();
        switch (action & MotionEvent.ACTION_MASK) {

            case MotionEvent.ACTION_DOWN:

                dX = Layout_Principal.getX() - ev.getRawX();
                dY = Layout_Principal.getY() - ev.getRawY();

                break;

            case MotionEvent.ACTION_MOVE:

                Layout_Principal.animate()
                        .x(ev.getRawX() + dX)
                        .y(ev.getRawY() + dY)
                        .setDuration(0)
                        .start();
                break;
            default:
                return false;
        }


        return true;
    }




    // gestion zoom 2 doigts
    private class ScaleListener extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        @Override
        public boolean onScale(ScaleGestureDetector detector) {
            scale *= detector.getScaleFactor();
            scale = Math.max(0.1f, Math.min(scale, 5.0f));

            Layout_Principal.setScaleX(scale);
            Layout_Principal.setScaleY(scale);
            return true;
        }
    }






}
