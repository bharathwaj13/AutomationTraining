package org.onboard.designpattern.strategy;

public class BasicCameraApp extends PhoneCameraApp {

    @Override
    public void editPhoto() {
        System.out.println("Editing photo using basic editor...");
    }
}
