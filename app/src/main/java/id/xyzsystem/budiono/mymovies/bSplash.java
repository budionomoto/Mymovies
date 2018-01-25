package id.xyzsystem.budiono.mymovies;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class bSplash extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run (){
                Intent i = new Intent(bSplash.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        },2500);
    }
}
