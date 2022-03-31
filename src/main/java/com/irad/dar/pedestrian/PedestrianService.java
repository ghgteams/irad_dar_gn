package com.irad.dar.pedestrian;

import com.irad.dar.utils.LossesEntity;

public interface PedestrianService {

	String savePedestriandata(PedestrianEntity pedestrianEntity);

	PedestrianEntity getPedestriandata(String id);
	
	String savefamilylossesdata(LossesEntity lossesEntity);

	PedestrianIradEntity getPedestrianDetails(String accidentId, String vehicleId);

	String insertPedestrianDetails(PedestrianNewEntity pedestrianNewEntity);


}
