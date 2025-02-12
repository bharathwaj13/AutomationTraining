package org.onboard.designpattern.strategy;

public abstract class PhoneCameraApp {
    private ShareStrategy shareStrategy;

    public void setShareStrategy(ShareStrategy shareStrategy) {
        this.shareStrategy = shareStrategy;
    }

    public void takePhoto() {
        System.out.println("Taking a photo...");
    }

    public abstract void editPhoto();

    public void savePhoto() {
        System.out.println("Saving photo...");
    }

    public void sharePhoto(String photo) {
        if (shareStrategy != null) {
            shareStrategy.sharePhoto(photo);
        } else {
            System.out.println("No sharing strategy set.");
        }
    }
}
