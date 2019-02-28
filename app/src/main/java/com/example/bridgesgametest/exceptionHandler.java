package com.example.bridgesgametest;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import static android.content.ContentValues.TAG;

public class exceptionHandler extends AppCompatActivity implements Thread.UncaughtExceptionHandler {
    @Override
    public void uncaughtException(Thread thread, Throwable ex) {
        Log.e(TAG, "Received exception '" + ex.getMessage() + "' from thread " + thread.getName(), ex);
        Intent i = new Intent(exceptionHandler.this, BufferedStart.class);
        //finishAffinity();

        i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        i.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);

        startActivity(i);
        finish();
    }
}

