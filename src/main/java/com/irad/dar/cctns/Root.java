package com.irad.dar.cctns;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Root {
	@JsonProperty("AtTheTime_of_FIRRegistration") 
    public AtTheTimeOfFIRRegistration atTheTime_of_FIRRegistration;
    @JsonProperty("AtTheTime_of_Investigation") 
    public AtTheTimeOfInvestigation atTheTime_of_Investigation;
    
    
	public AtTheTimeOfFIRRegistration getAtTheTime_of_FIRRegistration() {
		return atTheTime_of_FIRRegistration;
	}
	public void setAtTheTime_of_FIRRegistration(AtTheTimeOfFIRRegistration atTheTime_of_FIRRegistration) {
		this.atTheTime_of_FIRRegistration = atTheTime_of_FIRRegistration;
	}
	public AtTheTimeOfInvestigation getAtTheTime_of_Investigation() {
		return atTheTime_of_Investigation;
	}
	public void setAtTheTime_of_Investigation(AtTheTimeOfInvestigation atTheTime_of_Investigation) {
		this.atTheTime_of_Investigation = atTheTime_of_Investigation;
	}
    
    
}
