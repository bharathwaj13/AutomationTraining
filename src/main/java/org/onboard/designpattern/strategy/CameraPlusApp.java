package org.onboard.designpattern.strategy;

public class CameraPlusApp extends PhoneCameraApp{
    @Override
    public void editPhoto() {
        System.out.println("Editing photo using the Advanced Editor");
    }
}
