package lk.ac.kln.countdowntimer;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int counter = 99;
    private boolean running = false;
    private boolean wasrunning = false;
    private static final String CURRENT_COUNTER = "counter";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState != null) {
            counter = savedInstanceState.getInt(CURRENT_COUNTER);
        }
             countDown();
    }

    @Override
    public void onSaveInstanceState(Bundle SavedInstanceState){
        super.onSaveInstanceState(SavedInstanceState);
        SavedInstanceState.putInt(CURRENT_COUNTER,counter);


    }


    private void countDown(){

        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                final TextView textview=findViewById(R.id.textView3);
                textview.setText(Integer.toString(counter));
                //Reset the counter
                if (counter == 0) {
                    counter = 99;
                }
                if(running) {
                    counter--;
                }
                handler.postDelayed(this,1000);


            }
        });

    }


    protected void startCounter(View view) {
        running = true;
    }


    protected void stopCounter(View view){
        running = false;
    }

    @Override
    public void onPause(){
        super.onPause();
    }




    @Override
    public void onRestart(){
        super.onRestart();
        running = true;
    }

    @Override
    public void onStop() {

        super.onStop();
        running =false;
    }
}
