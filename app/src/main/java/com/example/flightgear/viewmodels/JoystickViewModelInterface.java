package com.example.flightgear.viewmodels;

public interface JoystickViewModelInterface {
    void onConnect(String IP, int port);
    void onThrottleChanged();
    void onRudderChanged();
    void onJoystickMoved();
}
