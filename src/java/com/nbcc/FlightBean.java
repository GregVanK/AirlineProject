/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nbcc;

import com.nbcc.airline.business.Flight;
import com.nbcc.airline.business.models.FlightBase;
import com.nbcc.airline.business.models.IAirportBase;
import com.nbcc.airline.business.models.IFlightBase;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Greg.VanKampen
 */
@Named(value = "flightBean")
@SessionScoped
public class FlightBean extends FlightBase implements  Serializable {

    private Flight flight;
    private String resultMessage;
    /**
     * Creates a new instance of FlightBean
     */
    public FlightBean() {
	flight = new Flight();
    }
    public void createFlight(){
	try {
	    this.resultMessage="";
	    flight.createFlight(this);
	} catch (Exception e) {
	    this.resultMessage = e.getMessage();
	}
    }
    public List<IAirportBase> getAirportList(){
	return flight.getAirports();
    }
}
