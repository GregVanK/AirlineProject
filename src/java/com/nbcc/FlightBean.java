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
    /**
     * Creates a new instance of FlightBean
     */
    public FlightBean() {
	flight = new Flight();
    }
    public void createFlight(){
	try {
	    this.resultMessage="";
            combineDateTimes();
	    flight.createFlight(this);
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
//<editor-fold defaultstate="collapsed" desc="Getters and setters">

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
