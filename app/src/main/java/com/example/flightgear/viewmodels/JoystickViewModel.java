package com.example.flightgear.viewmodels;

import com.example.flightgear.models.JoystickModelInterface;

public class JoystickViewModel implements JoystickViewModelInterface {
    private final JoystickModelInterface model;

    public JoystickViewModel(JoystickModelInterface m) {
        model = m;
    }

    @Override
    public void onConnect(String IP, int port) {
        model.connect(IP, port);
    }

    @Override
    public void onThrottleChanged() {

    }

    @Override
    public void onRudderChanged() {

    }

    @Override
    public void onJoystickMoved() {

    }
}
