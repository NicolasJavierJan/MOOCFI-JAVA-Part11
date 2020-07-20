/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.util.Random;

/**
 *
 * @author Nico
 */
public class TemperatureSensor implements Sensor{
    private boolean isOn;
    private int temperature;
    
    public TemperatureSensor(){
        this.isOn = false;
    }
    
    public boolean isOn(){
        if (this.isOn == true){
            return true;
        }
        return false;
    }
    
    public void setOn(){
        if (this.isOn == false){
            this.isOn = true;
        }
    }
    
    public void setOff(){
        if (this.isOn == true){
            this.isOn = false;
        }
    }
    
    public int read(){
        if (this.isOn == false){
            throw new IllegalStateException("TemperatureSensor is Off");
        }
        int rand1 = new Random().nextInt(61);
        
        return rand1 - 30;
    }
}
