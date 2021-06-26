package com.example.flightgear.models;

public interface JoystickModelInterface {
    void connect(String IP, int port);
    void disconnect();
    void setThrottle(double val);
    void setRudder(double val);
    void setElevator(double val);
    void setAileron(double val);
}
