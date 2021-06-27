package com.example.flightgear.viewmodels;

import android.graphics.Point;
import com.example.flightgear.models.IJoystickModel;

import java.util.Observable;
import java.util.Observer;

public class JoystickViewModel extends Observable implements IJoystickViewModel, Observer {
    private final IJoystickModel model;
    private boolean connected;

    public JoystickViewModel(IJoystickModel m) {
        model = m;
        connected = false;
    }

    @Override
    public boolean isConnected() {
        return true;
    }

    @Override
    public void onConnect(String IP, int port) {
        model.connect(IP, port);
    }

    @Override
    public void onThrottleChanged(double val) {
        model.setThrottle(val);
    }

    @Override
    public void onRudderChanged(double val) {
        model.setRudder(val);
    }

    @Override
    public void onJoystickMoved(Point location) {

    }

    @Override
    public void update(Observable o, Object arg) {
        if (o==model) {
            connected = model.getConnectionStatus();
        }
    }
}
