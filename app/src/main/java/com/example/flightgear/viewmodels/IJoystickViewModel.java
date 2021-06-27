package com.example.flightgear.viewmodels;

import android.graphics.Point;

public interface IJoystickViewModel {
    boolean isConnected();
    void onConnect(String IP, int port);
    void onThrottleChanged(double val);
    void onRudderChanged(double val);
    void onJoystickMoved(Point location);
}
