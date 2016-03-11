package appewtc.masterung.broadcastertest;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.PowerManager;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class TestActivity extends Activity  {

    //Explicit
    private TextView showDetailTextView;
    private String detailString;
    private int timeAnInt = 1, scoreAnInt = 0;



    /* constants */
    private static final int POLL_INTERVAL = 300;

    /** running state **/
    private boolean mRunning = false;

    /** config state **/
    private int mThreshold;

    private PowerManager.WakeLock mWakeLock;

    private Handler mHandler = new Handler();

    /* References to view elements */
    private TextView mStatusView;
    private SoundLevelView mDisplay;

    /* sound data source */
    private SoundMeter mSensor;

    /****************** Define runnable thread again and again detect noise *********/

    private Runnable mSleepTask = new Runnable() {
        public void run() {
            //Log.i("Noise", "runnable mSleepTask");

            start();
        }
    };

    // Create runnable thread to Monitor Voice
    private Runnable mPollTask = new Runnable() {
        public void run() {

            double amp = mSensor.getAmplitude();
            //Log.i("Noise", "runnable mPollTask");
            updateDisplay(getResources().getString(R.string.start_test), amp);


            if (amp > 6) {
                if (amp > 8) {
                    scoreAnInt += 1;
                    timeAnInt += 1;
                    callForHelp();
                } else {
                    timeAnInt += 1;
                }   // if2
            }   // if1

            Log.d("11March", "Score = " + scoreAnInt);
            Log.d("11March", "Times = " + timeAnInt);



            mHandler.postDelayed(mPollTask, POLL_INTERVAL);

        }
    };



    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Defined SoundLevelView in main.xml file
        setContentView(R.layout.activity_test);
        mStatusView = (TextView) findViewById(R.id.status);
        showDetailTextView = (TextView) findViewById(R.id.textView5);

        //Show Detail View
        showDetailView();

        // Used to record voice
        mSensor = new SoundMeter();
        mDisplay = (SoundLevelView) findViewById(R.id.volume);

        PowerManager pm = (PowerManager) getSystemService(Context.POWER_SERVICE);
        mWakeLock = pm.newWakeLock(PowerManager.SCREEN_DIM_WAKE_LOCK, "NoiseAlert");

    }   // Main Method

    public void clickShowScore(View view) {
        Intent intent = new Intent(TestActivity.this, ShowScoreActivity.class);

        intent.putExtra("Score", scoreAnInt);
        intent.putExtra("Times", timeAnInt);

        startActivity(intent);
        finish();
    }

    public void clickBackTest(View view) {
        finish();
    }


    private void showDetailView() {
        detailString = getIntent().getStringExtra("Detail");
        showDetailTextView.setText(detailString);
    }


    @Override
    public void onResume() {
        super.onResume();
        //Log.i("Noise", "==== onResume ===");

        initializeApplicationConstants();
        mDisplay.setLevel(0, mThreshold);

        if (!mRunning) {
            mRunning = true;
            start();
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        // Log.i("Noise", "==== onStop ===");

        //Stop noise monitoring
        stop();

    }

    private void start() {
        //Log.i("Noise", "==== start ===");

        mSensor.start();
        if (!mWakeLock.isHeld()) {
            mWakeLock.acquire();
        }

        //Noise monitoring start
        // Runnable(mPollTask) will execute after POLL_INTERVAL
        mHandler.postDelayed(mPollTask, POLL_INTERVAL);
    }

    private void stop() {
        Log.i("Noise", "==== Stop Noise Monitoring===");
        if (mWakeLock.isHeld()) {
            mWakeLock.release();
        }
        mHandler.removeCallbacks(mSleepTask);
        mHandler.removeCallbacks(mPollTask);
        mSensor.stop();
        mDisplay.setLevel(0,0);
        updateDisplay("stopped...", 0.0);
        mRunning = false;

    }


    private void initializeApplicationConstants() {
        // Set Noise Threshold
        mThreshold = 8;

    }

    private void updateDisplay(String status, double signalEMA) {
        mStatusView.setText(status);
        //
        mDisplay.setLevel((int)signalEMA, mThreshold);
    }


    private void callForHelp() {

        //scoreAnInt += 1;

        Toast.makeText(getApplicationContext(), getResources().getString(R.string.bingo),
                Toast.LENGTH_SHORT).show();
    }

};
