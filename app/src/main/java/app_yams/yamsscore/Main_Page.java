package app_yams.yamsscore;

import android.graphics.Point;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;


public class Main_Page extends AppCompatActivity {

    private float scale = 1.0f ;
    public ScaleGestureDetector SGD;
    public ImageView ImageGrille;
    public FrameLayout Layout_Principal;
    public RelativeLayout RelativeLayout_;
    public Create_colonne colonne1;
    private float dX;
    private float dY;

    boolean isthefirstpointer = false;



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
        colonne1.creation(10,10,Layout_Principal,getApplicationContext());








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

    public boolean onTouchEvent(MotionEvent event) {
        onTouch(Layout_Principal,event);
        return true;
    }
    // event touche écran
    public boolean onTouch(View v, MotionEvent event) {


        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;
        int height = size.y;
        float x,y;

        ImageGrille = (ImageView) findViewById(R.id.imageView);

          SGD.onTouchEvent(event);


            if(event.getPointerCount() >= 2)
            {
                isthefirstpointer = false;
            }





        switch (v.getId()) {
                case R.id.Layout_Principal:
                    if (event.getAction() == MotionEvent.ACTION_DOWN) {

                            dX = Layout_Principal.getX() - event.getX(0);
                            dY = Layout_Principal.getY() - event.getY(0);


                        return true;
                    } else if (event.getAction() == MotionEvent.ACTION_MOVE) {

                        if(isthefirstpointer == true) {

                            x = Layout_Principal.getX();
                            y = Layout_Principal.getY();

                        if(event.getX(0) + dX >  -(scale * 250)){

                           if(event.getX(0) + dX < (width/10 + (scale*250))) {


                               Log.i("system.out", "test =" + scale );

                                x = event.getX(0) + dX;
                            }


                        }

                            if(event.getY(0) + dY >  -(scale*250)){

                               if(event.getY(0) + dY < (height/10 + (scale*250))) {

                                    y = event.getY(0) + dY;
                                }

                            }

                            Layout_Principal.animate()
                                    .x(x)
                                    .y(y)
                                    .setDuration(0)
                                    .start();


                            }



                        return true;
                    } else if (event.getAction() == android.view.MotionEvent.ACTION_UP) {

                      isthefirstpointer = true;
                        return true;
                    }
                    return true;
            }
            return true;





    }






    // gestion zoom 2 doigts
    private class ScaleListener extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        @Override
        public boolean onScale(ScaleGestureDetector detector) {
            scale *= detector.getScaleFactor() ;
            scale = Math.max(1.0f, Math.min(scale, 3.0f));

            Layout_Principal.setScaleX(scale);
            Layout_Principal.setScaleY(scale);

            return true;
        }
    }






}
