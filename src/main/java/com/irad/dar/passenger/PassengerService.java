package com.irad.dar.passenger;

public interface PassengerService {

	String savePassengerdata(PassengerEntity passengerEntity);

	PassengerEntity getPassengerdata(String id);

	String insertPassengerDetails(PassengerNewEntity passengerNewEntity);

}
