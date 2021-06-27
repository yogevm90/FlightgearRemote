package com.example.flightgear.models;

public interface IJoystickModel {
    void connect(String IP, int port);
    boolean getConnectionStatus();
    void disconnect();
    void setThrottle(double val);
    void setRudder(double val);
    void setElevator(double val);
    void setAileron(double val);
}
