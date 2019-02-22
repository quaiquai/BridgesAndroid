package com.example.bridgesgametest;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ControllerXY extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.control_xy, parent, false);

        connectToControls(v);

        return v;
    }

    private void connectToControls(View vi){

    }
}
