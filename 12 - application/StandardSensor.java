/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

/**
 *
 * @author Nico
 */
public class StandardSensor implements Sensor{
    private int temperature;
    
    public StandardSensor(int temperature){
        this.temperature = temperature;
    }
    
    public boolean isOn(){
        return true;
    }
    
    public void setOn(){
    }
    
    public void setOff(){
    }
    
    public int read(){
        if (this.temperature == 0){
            throw new IllegalStateException("Sensor is off");
        }
        return this.temperature;
    }
}
