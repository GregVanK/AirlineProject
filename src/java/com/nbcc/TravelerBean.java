/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nbcc;

import com.nbcc.airline.business.Traveler;
import com.nbcc.airline.business.models.TravelerBase;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.annotation.ManagedBean;

/**
 *
 * @author Greg.VanKampen
 */
@Named(value = "travelerBean")
@SessionScoped
@ManagedBean
public class TravelerBean extends TravelerBase implements Serializable {
    private Traveler traveler;
    private String resultMessage;
    private int travelerID;
    
    /**
     * Creates a new instance of TravelerBean
     */
    public TravelerBean() {
        traveler = new Traveler();
    }
    public void createTraveler(){
        try {
            this.resultMessage="";
            traveler.createTraveler(this);
            this.resultMessage="Successfully Inserted";
        } catch (Exception e) {
            this.resultMessage = e.getMessage();
        }
        
    }

    public String getResultMessage() {
        return resultMessage;
    }

    public void setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
    }
    
    
}
