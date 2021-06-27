package com.example.flightgear.models;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.Observable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class JoystickModel extends Observable implements IJoystickModel {
    private PrintWriter out;
    private boolean connected;
    private Socket socket;
    private final ExecutorService executor;

    public JoystickModel() {
        executor = Executors.newSingleThreadExecutor();
    }

    public boolean getConnectionStatus() {
        return connected;
    }

    @Override
    public void connect(String IP, int port) {
        try {
            if (!connected) {
                socket = new Socket(IP, port);
                if (socket.isConnected()) {
                    connected = true;
                    out = new PrintWriter(socket.getOutputStream(), true);
                }
                setChanged();
                notifyObservers();
            }
        }
        catch (Exception e){
            connected = false;
        }
    }

    public void disconnect() {
        try{
            if (socket.isConnected()){
                out.flush();
                socket.close();
            }
            connected = false;
        }
        catch (Exception e) { }
    }

    @Override
    public void setThrottle(final double val) {
        if (connected) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    out.print("set /controls/engines/current-engine/throttle " + Double.toString(val) + "\r\n");
                    out.flush();
                }
            });
        }
    }

    @Override
    public void setRudder(final double val) {
        if (connected) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    out.print("set /controls/flight/rudder " + Double.toString(val) + "\r\n");
                    out.flush();
                }
            });
        }
    }

    @Override
    public void setElevator(final double val) {
        if (connected) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    out.print("set /controls/flight/elevator " + Double.toString(val) + "\r\n");
                    out.flush();
                }
            });
        }
    }

    @Override
    public void setAileron(final double val) {
        if (connected) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    out.print("set /controls/flight/aileron " + Double.toString(val) + "\r\n");
                    out.flush();
                }
            });
        }
    }
}
