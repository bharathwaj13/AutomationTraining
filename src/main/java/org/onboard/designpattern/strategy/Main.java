package org.onboard.designpattern.strategy;

public class Main {

    public static void main(String[] args) {
        PhoneCameraApp cameraApp=new CameraPlusApp();
        cameraApp.setShareStrategy(new ShareByEmail());

        cameraApp.editPhoto();
        cameraApp.savePhoto();
        cameraApp.sharePhoto("photo");
    }

}
