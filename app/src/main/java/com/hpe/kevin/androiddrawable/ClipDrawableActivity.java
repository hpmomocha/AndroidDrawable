package com.hpe.kevin.androiddrawable;

import android.app.Activity;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class ClipDrawableActivity extends Activity {
    private SeekBar mSeekBar;
    private ImageView mImageView;
    private TextView mTvShow;

    private Timer timer;
    private TimerTask timerTask;
    private ClipDrawable clipDrawable;
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            clipDrawable.setLevel(msg.what);
        }
    };

    /**
     * Called when the activity is starting.  This is where most initialization
     * should go: calling {@link #setContentView(int)} to inflate the
     * activity's UI, using {@link #findViewById} to programmatically interact
     * with widgets in the UI, calling
     * {@link #managedQuery(Uri, String[], String, String[], String)} to retrieve
     * cursors for data being displayed, etc.
     * <p>
     * <p>You can call {@link #finish} from within this function, in
     * which case onDestroy() will be immediately called without any of the rest
     * of the activity lifecycle ({@link #onStart}, {@link #onResume},
     * {@link #onPause}, etc) executing.
     * <p>
     * <p><em>Derived classes must call through to the super class's
     * implementation of this method.  If they do not, an exception will be
     * thrown.</em></p>
     *
     * @param savedInstanceState If the activity is being re-initialized after
     *                           previously being shut down then this Bundle contains the data it most
     *                           recently supplied in {@link #onSaveInstanceState}.  <b><i>Note: Otherwise it is null.</i></b>
     * @see #onStart
     * @see #onSaveInstanceState
     * @see #onRestoreInstanceState
     * @see #onPostCreate
     */
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_clip_drawable);
        mImageView = (ImageView) findViewById(R.id.iv_show);
        mTvShow = (TextView) findViewById(R.id.tv_info);

        timer = new Timer();

//        mSeekBar = findViewById(R.id.seekbar);
//        mSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
//            @Override
//            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
//                int max = seekBar.getMax();
//                double scale = (double) progress / (double) max;
//                ClipDrawable clipDrawable = (ClipDrawable) mImageView.getBackground();
//                clipDrawable.setLevel((int)(10000*scale));
//                mTvShow.setText("当前进度：" + progress);
//            }
//
//            @Override
//            public void onStartTrackingTouch(SeekBar seekBar) {
//
//            }
//
//            @Override
//            public void onStopTrackingTouch(SeekBar seekBar) {
//
//            }
//        });
    }

    public void startPlay(View view) {
        switch (view.getId()) {
            case R.id.btnL2R:
                mImageView.setBackgroundResource(R.drawable.test_clip_drawable_default);
                break;
            case R.id.btnT2B:
                mImageView.setBackgroundResource(R.drawable.test_clip_drawable_top);
                break;
            case R.id.btnCenter:
                mImageView.setBackgroundResource(R.drawable.test_clip_drawable_center_horizontal);
                break;
            case R.id.btnB2T:
                mImageView.setBackgroundResource(R.drawable.test_clip_drawable_bottom);
                break;
            case R.id.btnR2L:
                mImageView.setBackgroundResource(R.drawable.test_clip_drawable_right);
                break;
        }
        clipDrawable = (ClipDrawable) mImageView.getBackground();
        timerTask = new TimerTask() {
            @Override
            public void run() {
                if (clipDrawable.getLevel() <= 10000) {
                    handler.sendEmptyMessage(clipDrawable.getLevel() + 50);
                }
            }
        };
        timer.schedule(timerTask, 1000, 50);
    }
}
