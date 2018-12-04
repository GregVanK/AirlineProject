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
    /**
     * Creates a new instance of FlightBean
     */
    public FlightBean() {
	flight = new Flight();
    }
        public void onDateSelect(SelectEvent event) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Date Selected", format.format(event.getObject())));
    }
     
    /**public void click() {
        PrimeFaces.current().ajax().update("form:display");
        PrimeFaces.current().executeScript("PF('dlg').show()");
    }*/
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
