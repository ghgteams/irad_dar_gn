package com.irad.dar.passenger;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class PassengerServiceImpl implements PassengerService{

	@Autowired
	PassengerRepo passengerDao;
	
	@Autowired
	PassengerRepository passengerRepository;

	@Override
	public String savePassengerdata(PassengerEntity passengerEntity) {
		  if(passengerEntity.getAccId()!=null) {
		    passengerDao.save(passengerEntity);
			return "Success";
		  }	
		  return "Failed";
	}

	@Override
	public PassengerEntity getPassengerdata(String accid) {
		System.out.println(accid);
		PassengerEntity passengerEntity=passengerDao.findByAccId(accid);
		PassengerEntity passengerEntity2=passengerDao.findByPassengerId(accid);

		
		  return passengerEntity2;
	}

	@Override
	public String insertPassengerDetails(PassengerNewEntity passengerNewEntity) {
		if(!Objects.isNull(passengerNewEntity)) {
			try {
				passengerRepository.save(passengerNewEntity);
				return "1";
			} catch (DataIntegrityViolationException e) {
			    System.out.println("Already exist");
			    return "0";
			}
			
		}
		return "0";
	}

//	@Override
//	public String insertPassengerDetails(PassengerNewEntity passengerNewEntity) {
//		// TODO Auto-generated method stub
//		return null;
//	}
}
