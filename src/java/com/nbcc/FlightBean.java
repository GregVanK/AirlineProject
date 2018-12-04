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
import java.text.SimpleDateFormat;
import java.util.List;
import javax.annotation.ManagedBean;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author Greg.VanKampen
 */
@Named(value = "flightBean")
@SessionScoped
@ManagedBean
public class FlightBean extends FlightBase implements  Serializable {

    private Flight flight;
    private String resultMessage;
    private String  departBeanDate;
    private String  arrivalBeanDate;
    private String  departBeanTime;
    private String  arrivalBeanTime;
    private int     currentFlightNo;
    private boolean isModify;
    private boolean formActive;
    /**
     * Creates a new instance of FlightBean
     */
    public FlightBean() {
	flight = new Flight();
        formActive = false;
        currentFlightNo = 0;
    }
    public void createFlight(){
	try {
	    this.resultMessage="";
            combineDateTimes();
            this.setFlightNo(currentFlightNo);
	    flight.createFlight(this);
            this.resultMessage="Succesfully Inserted";
	} catch (Exception e) {
	    this.resultMessage = e.getMessage();
	}
    }
    public void updateFlight(){
        try {
        this.resultMessage="";
            combineDateTimes();
            this.setFlightNo(currentFlightNo);
	    flight.updateFlight(this);
            this.resultMessage="Succesfully Inserted";
	} catch (Exception e) {
	    this.resultMessage = e.getMessage();
	}
    }
    public List<IAirportBase> getAirportList(){
	return flight.getAirports();
    }
    public void combineDateTimes(){
        //TODO::Validate Time
        this.setDepartureDate(departBeanDate + " " +departBeanTime);
        this.setArrivalDate(arrivalBeanDate + " " + arrivalBeanTime);
    }
    public void setFlight(){
        IFlightBase curFlight =  flight.getFlight(currentFlightNo);
        
        String[] departDatetime= curFlight.getArrivalDate().split(" ");
        String[] arriveDatetime = curFlight.getArrivalDate().split(" ");
        
        this.setAirlineName(curFlight.getAirlineName());
        this.setArrivalAirport(curFlight.getArrivalAirport());
        
        this.setArrivalBeanDate(arriveDatetime[0]);
        this.setArrivalBeanTime(arriveDatetime[1]);
        this.setDepartBeanDate(departDatetime[0]);
        this.setDepartBeanTime(departDatetime[1]);
        
        this.setAvailableSeats(curFlight.getAvailableSeats());
        this.setDepartureAirport(curFlight.getDepartureAirport());
        this.setDepartureDate(curFlight.getDepartureDate());
        this.setFlightNo(curFlight.getFlightNo());
        this.setFlightTime(curFlight.getFlightTime());
        this.setPrice(curFlight.getPrice());
        this.setSeats(curFlight.getSeats());
        this.setStatus(curFlight.getStatus());
        
        this.setFormActive(true);
        this.setIsModify(true);
    }
    public void clearFlight(){
        this.setAirlineName("");
        this.setArrivalAirport("");
        
        this.setArrivalBeanDate("");
        this.setArrivalBeanTime("");
        this.setDepartBeanDate("");
        this.setDepartBeanTime("");
        this.setArrivalDate("");
        this.setDepartureDate("");
        
        this.setAvailableSeats(0);
        this.setDepartureAirport("");
        this.setDepartureDate("");
        this.setFlightNo(0);
        this.setFlightTime("");
        this.setPrice(0.f);
        this.setSeats(0);
        this.setStatus("");
        
        this.setFormActive(true);
        this.setIsModify(false);
    }
    public void resetForm(){
        this.clearFlight();
        this.setFormActive(false);
    }
//<editor-fold defaultstate="collapsed" desc="Getters and setters">

    public boolean isIsModify() {
        return isModify;
    }

    public void setIsModify(boolean isModify) {
        this.isModify = isModify;
    }

    public int getCurrentFlightNo() {
        return currentFlightNo;
    }

    public void setCurrentFlightNo(int currentFlightNo) {
        this.currentFlightNo = currentFlightNo;
    }

    public boolean isFormActive() {
        return formActive;
    }

    public void setFormActive(boolean formActive) {
        this.formActive = formActive;
    }


    public String getResultMessage() {
        return resultMessage;
    }

    public void setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
    }
    
    public String getDepartBeanDate() {
        return departBeanDate;
    }
    
    public void setDepartBeanDate(String departBeanDate) {
        this.departBeanDate = departBeanDate;
    }
    
    public String getArrivalBeanDate() {
        return arrivalBeanDate;
    }
    
    public void setArrivalBeanDate(String arrivalBeanDate) {
        this.arrivalBeanDate = arrivalBeanDate;
    }
    
    public String getDepartBeanTime() {
        return departBeanTime;
    }
    
    public void setDepartBeanTime(String departBeanTime) {
        this.departBeanTime = departBeanTime;
    }
    
    public String getArrivalBeanTime() {
        return arrivalBeanTime;
    }
    
    public void setArrivalBeanTime(String arrivalBeanTime) {
        this.arrivalBeanTime = arrivalBeanTime;
    }
//</editor-fold>
    
}
