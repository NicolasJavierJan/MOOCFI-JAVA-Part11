/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FlightControl.domain;

/**
 *
 * @author Nico
 */
public class Flight {
    private Airplane airplane;
    private Place departureAirport;
    private Place targetAirport;
    
    public Flight(Airplane airplane, Place departure, Place target){
        this.airplane = airplane;
        this.departureAirport = departure;
        this.targetAirport = target;
    }
    
    public Airplane getAirplane(){
        return this.airplane;
    }
    
    public Place getDepartureAirport(){
        return this.departureAirport;
    }
    
    public Place getTargetAirport(){
        return this.targetAirport;
    }
    
    public String toString(){
        return this.airplane.toString() + " (" + this.departureAirport + "-" + this.targetAirport + ")";
    }
}
