/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nbcc;

import com.nbcc.airline.business.Reservation;
import com.nbcc.airline.business.models.FlightBase;
import com.nbcc.airline.business.models.IFlightBase;
import com.nbcc.airline.business.models.ReservationBase;
import com.nbcc.airline.repository.ReservationRepository;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.annotation.ManagedBean;

/**
 *
 * @author Greg.VanKampen
 */
@Named(value = "reservationBean")
@SessionScoped
@ManagedBean
public class ReservationBean extends ReservationBase implements Serializable {
    private Reservation reservation;
    private IFlightBase selectedFlight;
    private ReservationRepository repo;
    private String resultMessage;
    private FlightBase currentFlight;
    /**
     * Creates a new instance of ReservationBean
     */
    public ReservationBean() {
	reservation = new Reservation();
        repo = new ReservationRepository();
	this.setStatus("Active");
    }
    public void addReservation(){
	this.setPassengerNo(selectedFlight.getAvailableSeats());
	this.setStartDate(selectedFlight.getDepartureDate());
	this.setEndDate(selectedFlight.getArrivalDate());
	this.setTicketType("Adult");
        repo.insertReservation(this);
    }
    public float calculateTax(){
	this.setOtherFees(selectedFlight.getPrice() * 0.10f);
	return this.getOtherFees();
    }

    public FlightBase getCurrentFlight() {
        return currentFlight;
    }

    public void setCurrentFlight(FlightBase currentFlight) {
        this.selectedFlight = currentFlight;
    }


    
    
}
