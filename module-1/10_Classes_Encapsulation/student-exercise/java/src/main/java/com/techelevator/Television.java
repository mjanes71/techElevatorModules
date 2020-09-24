package com.techelevator;

public class Television {
    private boolean on = false;
    private int currentChannel = 3;
    private int currentVolume = 2;

    public Television(){

    }

    public boolean isOn(){
        return on;
    }

    public int getCurrentChannel(){
        return currentChannel;
    }

    public int getCurrentVolume() {
        return currentVolume;
    }

    public void turnOff(){
        this.on = false;
    }

    public void turnOn(){
        this.on = true;
        this.currentChannel = 3;
        this.currentVolume = 2;
    }

    public void changeChannel(int newChannel){
        if(this.on == true) {
            if (newChannel >= 3 && newChannel <= 18) {
                this.currentChannel = newChannel;
            }
        }
    }

    public void channelUp(){
        if(this.on == true){
            if(getCurrentChannel() == 18){
                this.currentChannel = 3;
            }else{
                this.currentChannel = getCurrentChannel() + 1;
            }
        }
    }

    public void channelDown(){
        if(this.on == true){
            if(getCurrentChannel() == 3){
                this.currentChannel = 18;
            }else{
                this.currentChannel = getCurrentChannel() - 1;
            }
        }
    }

    public void raiseVolume(){
        if(this.on == true){
            if(getCurrentVolume() < 10){
                this.currentVolume = getCurrentVolume() + 1;
            }
        }
    }

    public void lowerVolume(){
        if(this.on == true){
            if(getCurrentVolume() > 0){
                this.currentVolume = getCurrentVolume() - 1;
            }
        }
    }

}
