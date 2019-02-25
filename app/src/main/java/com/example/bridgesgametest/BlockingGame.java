package com.example.bridgesgametest;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;

import org.json.JSONObject;

import java.util.Queue;

public class BlockingGame {
/**UNDER CONSTRUCTION: NOT READY FOR END USER
    AppCompatActivity a;
    Context c;
    GameGrid gg;
    ControllerDpad dp;
    ControllerXY xy;

    boolean firsttime;
    //Bridges bridges;
    //SocketConnection sock;

    Queue<String> keyqueue;

    public void handleFragment(Context con){
        c = con;
        a = (AppCompatActivity) c;
        gg = (GameGrid) a.getSupportFragmentManager().findFragmentById(R.id.GridFragment);
        dp = (ControllerDpad) a.getSupportFragmentManager().findFragmentById(R.id.Dpad);
        xy =(ControllerXY) a.getSupportFragmentManager().findFragmentById(R.id.XY);
    }

    public void keypress(JSONObject keypress) {
        String type = "";
        String key = "";

        // get keypress details
        try {
            type = (String) keypress.get("type");
            key = (String) keypress.get("key");

            System.out.println(type + ": " + key);

        } catch (Exception JSONe) {
            //e.printStackTrace();
        }

        if (type.equals("keydown")) {
            synchronized (keyqueue) {
                System.err.println(type+" "+key);
                keyqueue.add(key);
                keyqueue.notify();
            }
        }

    }

    public String getKeyPress() {

        String ret = "";

        synchronized (keyqueue) {

            try {
                keyqueue.wait();
            } catch (Exception ie) {

            }

            ret = keyqueue.poll();
        }

        return ret;
    }

    public GameGrid getGameGrid() {
        return gg;
    }

    public BlockingGame() {
        firsttime = true;

        // bridges-sockets account (you need to make a new account:
        // https://bridges-sockets.herokuapp.com/signup)
        //bridges = new Bridges(assignmentID, username, apikey);

        // make sure the bridges connects to the games version of the web app
        //bridges.setServer("games");

        // create a new color grid with random color
        //gg = new GameGrid(gridsizeX, gridsizeY);

        keyqueue = new ArrayDeque<String>();

        // set up socket connection to receive and send data
        //sock = new SocketConnection();
        //sock.setupConnection(bridges.getUserName(), bridges.getAssignment());
        //sock.addListener(this);

    }

    public void setTitle(String title) {
        //bridges.setTitle(title);
    }

    public void setDescription(String desc) {
        //bridges.setDescription(desc);
    }

    public void render() {
        if (firsttime) {
            firsttime = false;
            // associate the grid with the Bridges object
            //bridges.setDataStructure(gg);

            // visualize the grid
            try {
                //bridges.visualize();
            } catch (Exception err) {
                System.out.println(err);
            }
        }

        String gridState = gg.getDataStructureRepresentation();
        //String gridJSON = '{' + gridState;
        // System.out.println(gridJSON);

        // send valid JSON for grid into the socket
        //sock.sendData(gridJSON);
    }

    public void quit() {
        //sock.close();
    }
 **/
}
