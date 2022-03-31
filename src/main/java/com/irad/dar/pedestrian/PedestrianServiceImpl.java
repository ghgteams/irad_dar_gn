package com.irad.dar.pedestrian;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import com.irad.dar.utils.LossesEntity;
import com.irad.dar.utils.LossesRepo;

@Service
public class PedestrianServiceImpl implements PedestrianService{
	@Autowired
	PedestrianRepo pedestrianDao;
	
	@Autowired
	PedestrianRepository pedestrianRepository;
	
	@Autowired
	PedestrianDetailsRepo PedestrianDetailsRepo;
	
	@Autowired
	LossesRepo lossRepo;
	
	@Override
	public String savePedestriandata(PedestrianEntity pedestrianEntity) {
	  System.out.println("generalEntity.getAcc_id"+pedestrianEntity.getAccId());
	  if(pedestrianEntity.getAccId()!=null) {
	    pedestrianDao.save(pedestrianEntity);
		return "Success";
	  }	
	  return "Failed";
	}
 
	@Override
	public PedestrianEntity getPedestriandata(String refid) {
	  System.out.println("Accid"+refid);
	  PedestrianEntity pedestrianEntity=pedestrianDao.findByAccId(refid);
	  PedestrianEntity pedestrianEntity2=pedestrianDao.findByPedestrianId(refid);
	  return pedestrianEntity2;
	}

	@Override
	public String savefamilylossesdata(LossesEntity lossesEntity) {
		// TODO Auto-generated method stub
		System.out.println("generalEntity.getAcc_id"+lossesEntity.getAccId());
		  if(lossesEntity.getAccId()!=null) {
			  lossRepo.save(lossesEntity);
			return "Success";
		  }	
		  return "Failed";
	}

	@Override
	public PedestrianIradEntity getPedestrianDetails(String accidentId, String vehicleId) {
		PedestrianIradEntity pedestrianIradEntity=PedestrianDetailsRepo.findByAccidentIdAndVehicleId(accidentId,vehicleId);
		return pedestrianIradEntity;
	}

	@Override
	public String insertPedestrianDetails(PedestrianNewEntity pedestrianNewEntity) {
		if(!Objects.isNull(pedestrianNewEntity)) {
			try {
				pedestrianRepository.save(pedestrianNewEntity);
				return "1";
			} catch (DataIntegrityViolationException e) {
			    System.out.println("Already exist");
			    return "0";
			}
			
		}
		return "0";
	}

	
}
