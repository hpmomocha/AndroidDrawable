package com.hpe.kevin.androiddrawable;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void clickClipDrawable(View view) {
        Intent intent = new Intent(this, ClipDrawableActivity.class);
        startActivity(intent);
    }

    public void clickScaleDrawable(View view) {
        Intent intent = new Intent(this, ScaleDrawableActivity.class);
        startActivity(intent);
    }

    public void clickInsetDrawable(View view) {
        Intent intent = new Intent(this, InsetDrawableActivity.class);
        startActivity(intent);
    }

    public void clickTransitionDrawable(View view) {
        Intent intent = new Intent(this, TransitionDrawableActivity.class);
        startActivity(intent);
    }

    public void clickLevelListDrawable(View view) {
        Intent intent = new Intent(this, LevelListDrawableActivity.class);
        startActivity(intent);
    }

    public void clickStateListDrawable(View view) {
        Intent intent = new Intent(this, StateListDrawableActivity.class);
        startActivity(intent);
    }
}
