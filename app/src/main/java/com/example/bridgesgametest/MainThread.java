package com.example.bridgesgametest;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

public class MainThread extends Thread {

    private SurfaceHolder surfaceHolder;
    private BridgesView bridgesView;
    public static Canvas canvas;
    private boolean running;

    public MainThread(SurfaceHolder surfaceHolder, BridgesView bridgesView){
        super();
        this.surfaceHolder = surfaceHolder;
        this.bridgesView = bridgesView;
    }

    @Override
    public void run() {
        while (running) {
            canvas = null;

            try {
                canvas = this.surfaceHolder.lockCanvas();
                synchronized(surfaceHolder) {
                    this.bridgesView.update();
                    this.bridgesView.draw(canvas);
                }
            } catch (Exception e) {} finally {
                if (canvas != null) {
                    try {
                        surfaceHolder.unlockCanvasAndPost(canvas);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public void setRunning(boolean isRunning) {
        running = isRunning;
    }

}
