/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FlightControl.ui;

import java.util.Scanner;
import FlightControl.logic.FlightControl;
import FlightControl.domain.Airplane;
import FlightControl.domain.Flight;

/**
 *
 * @author Nico
 */
public class TextUI {
    private Scanner scanner;
    private FlightControl flightControl;
    
    public TextUI (Scanner scanner){
        this.scanner = scanner;
        this.flightControl = new FlightControl();
    }
    
    public void start(){
        startAirportAssetControl();
        startFlightControl();
    }
    
    private void startAirportAssetControl(){
        System.out.println("Airport Asset Control");
        
        
        while (true){
            System.out.println("Choose an action:");
            System.out.println("[1] Add an airplane");
            System.out.println("[2] Add a flight");
            System.out.println("[x] Exit Airport Asset Control");
            
            System.out.print("> ");
            String choice = this.scanner.nextLine();
            
            if (choice.equals("1")){
                addPlane();
            } else if (choice.equals("2")){
                addFlight();
            } else if (choice.equals("x")){
                break;
            }
        }
    }
    
    private void addPlane(){
        System.out.print("Give the airplane id: ");
        String id = this.scanner.nextLine();
        System.out.print("Give the airplane capacity: ");
        int capacity = Integer.valueOf(this.scanner.nextLine());
        
        this.flightControl.addAirplane(id, capacity);
    }
    
    private void addFlight(){
        System.out.print("Give the airplane id: ");
        String id = this.scanner.nextLine();
        Airplane airplane = askForAirplane(id);
        System.out.print("Give the departure airport id: ");
        String departure = this.scanner.nextLine();
        System.out.print("Give the target airport id: ");
        String destination = this.scanner.nextLine();
        
        this.flightControl.addFlight(airplane, departure, destination);
    }
    
    private Airplane askForAirplane(String id){
        Airplane airplane = this.flightControl.getAirplane(id);
        
        if (airplane == null){
            System.out.println("No airplane with the id " + id + ".");
        }
        
        return airplane;
    }
    
    private void startFlightControl(){
        System.out.println("Flight Control");
        
        
        while (true){
            System.out.println("Choose an action:");
            System.out.println("[1] Print airplanes");
            System.out.println("[2] Print flights");
            System.out.println("[3] Print airplane details");
            System.out.println("[x] Quit");
            
            System.out.print("> ");
            String answer = this.scanner.nextLine();
            if (answer.equals("1")){
                printAirplanes();
            } else if (answer.equals("2")){
                printFlights();
            } else if (answer.equals("3")){
                printAirplaneDetails();
            } else if (answer.equals("x")){
                break;
            }
        }
    }
    
    private void printAirplanes(){
        for (Airplane plane : this.flightControl.getAirplanes()){
            System.out.println(plane);
        }
    }
    
    private void printFlights(){
        for (Flight flight : this.flightControl.getFlights()){
            System.out.println(flight);
        }
        System.out.println();
    }
    
    private void printAirplaneDetails(){
        System.out.print("Give the airplane id: ");
        String id = this.scanner.nextLine();
        Airplane airplane = askForAirplane(id);
        System.out.println(airplane);
        System.out.println();
    }
    
}
