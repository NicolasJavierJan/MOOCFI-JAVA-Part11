/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FlightControl.logic;

/**
 *
 * @author Nico
 */

import FlightControl.domain.Airplane;
import FlightControl.domain.Flight;
import FlightControl.domain.Place;
import java.util.HashMap;
import java.util.Collection;

public class FlightControl {
    private HashMap<String, Airplane> airplanes;
    private HashMap<String, Flight> flights;
    private HashMap<String, Place> places;
    
    public FlightControl(){
        this.airplanes = new HashMap<>();
        this.flights = new HashMap<>();
        this.places = new HashMap<>();
    }
    
    public void addAirplane(String ID, int capacity){
        Airplane plane = new Airplane(ID, capacity);
        this.airplanes.put(ID, plane);
    }
    
    public void addFlight(Airplane plane, String departureID, String targetID){
        this.places.putIfAbsent(departureID, new Place(departureID));
        this.places.putIfAbsent(targetID, new Place(targetID));
        
        Flight flight = new Flight(plane, this.places.get(departureID), this.places.get(targetID));
        this.flights.put(flight.toString(), flight);
    }
    
    public Airplane getAirplane(String ID){
        return this.airplanes.get(ID);
    }
    
    public Collection<Airplane> getAirplanes(){
        return this.airplanes.values();
    }
    
    public Collection<Flight> getFlights(){
        return this.flights.values();
    }
}
