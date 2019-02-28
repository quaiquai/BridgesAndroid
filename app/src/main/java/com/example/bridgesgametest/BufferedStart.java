package com.example.bridgesgametest;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class BufferedStart extends AppCompatActivity {

    // Game objects
    BugStomp bs;
    Snake sn;
    Pong po;
    MinimalGameStub_Android min_game_stub;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.game_view);

        /**IN DEVELOPMENT:
         * Custom error handling for students. When the application crashes it will display a
         * popup view in the app stating the main cause of the crash. For example "An object has gone
         * outside the boundaries of the array. The error log is indicating line 'x'."
        Thread t = Thread.currentThread();
        t.setDefaultUncaughtExceptionHandler(new exceptionHandler());
        **/

         /** WORKING CODE:
          *  //This code runs a BugStomp game on users phone:
         bs = new BugStomp(); // Initialize game object.
         bs.handleFragment(this); // This must be called before any game method.
         bs.main(); // Start the students game. **/

        /** WORKING CODE:
         *  //This code runs a snake game on users phone:
         sn = new Snake();
         sn.handleFragment(this);
         sn.main();
         **/


        /** WORKING CODE:
         * // This code runs a pong game on users phone:
        po = new Pong();
        po.handleFragment(this);
        po.main();
        **/

        /** //This code runs the minimal Game Stub code on users phone:
         min_game_stub = new MinimalGameStub_Android();
         min_game_stub.handleFragment(this);
         min_game_stub.main();
         **/
    }
}
