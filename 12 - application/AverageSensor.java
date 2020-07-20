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

import java.util.ArrayList;
import java.util.List;

public class AverageSensor implements Sensor{
    private ArrayList<Sensor> sensors;
    private ArrayList<Integer> readings;
    
    public AverageSensor(){
        this.sensors = new ArrayList<>();
        this.readings = new ArrayList<>();
    }
    
    public void addSensor(Sensor sensor){
        this.sensors.add(sensor);
    }
    
    public int read(){
        int sum = 0;
        int number = 0;
        for (Sensor sensor : this.sensors){
            sum = sum +  sensor.read();
            number++;
        }
        this.readings.add(sum / number);
        return (sum / number);
    }
    
    public void setOff(){
        for (Sensor sensor : this.sensors){
            sensor.setOff();
        }
    }
    
    public void setOn(){
        for (Sensor sensor : this.sensors){
            sensor.setOn();
        }
    }
    
    public boolean isOn(){
        for (Sensor sensor : this.sensors){
            if (sensor.isOn() == true){
                return true;
            }
        }
        return false;
    }
    
    public List<Integer> readings(){
        return this.readings;
    }
    
}
