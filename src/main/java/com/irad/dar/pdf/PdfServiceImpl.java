package com.irad.dar.pdf;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PdfServiceImpl implements PdfService{
	@Autowired
	PdfRepo pdfRepo;
	
	@Autowired
	MinorChildrenDetailsRepo1 minorRepo;
	
	@Autowired
	VehicleDetailsRepo vehicleDetailsRepo;
	
	@Override
	public Pdf1Entity getreport1(String accidentId) {
		return pdfRepo.getreport1(accidentId);
	}
	@Override
	public Pdf2Entity getreport2(String accidentId,String name) {
		return pdfRepo.getreport2(accidentId,name);
	}
	@Override
	public Pdf3Entity getreport3(String accidentId, String vehicleId) {
		return pdfRepo.getreport3(accidentId, vehicleId);
	}
	@Override
	public Pdf4Entity getreport4(String accidentId, String vehicleId) {
		return pdfRepo.getreport4(accidentId, vehicleId);
	}
	@Override
	public Pdf5Entity getreport5(String accidentId, String vehicleId) {
		return pdfRepo.getreport5(accidentId, vehicleId);
	}
	@Override
	public Pdf6Entity getreport6(String accidentId, String vehicleId,String mode,String vehicle_id) {
		return pdfRepo.getreport6(accidentId, vehicleId,mode,vehicle_id);
	}
	@Override
	public Pdf7Entity getreport7(String accidentId, String vehicleId,String refId,String mode) {
		return pdfRepo.getreport7(accidentId, vehicleId, refId,mode);
	}
	@Override
	public Pdf8Entity getreport8(String accidentId, String vehicleId) {
		return pdfRepo.getreport8(accidentId, vehicleId);
	}
	@Override
	public Pdf9Entity getreport9(String accidentId, String vehicleId) {
		return pdfRepo.getreport9(accidentId, vehicleId);
	}
//	@Override
//	public AccidentDetails getreport10(String accidentId, String vehicleId) {
//		return pdfRepo.getreport10(accidentId, vehicleId);
//	}
	@Override
	public Pdf6aEntity getreport6a(String accid,String whoseChild,String user_type) {
		return pdfRepo.getreport6a(accid,whoseChild,user_type);
	}
	@Override
	public List<MinorChildrenDetailsEntity1> getMinorChildrendata(String whoseChild,String user_type,String accid) {
		List<MinorChildrenDetailsEntity1> minorChildrenDetailsEntity=new ArrayList<MinorChildrenDetailsEntity1>();
		if(whoseChild!=""&&user_type!="" &&accid!="") {
			minorChildrenDetailsEntity=(List<MinorChildrenDetailsEntity1>) minorRepo.findByWhoseChildAndUserTypeAndAccId(whoseChild,user_type,accid);
			
			return minorChildrenDetailsEntity;
		}
		return minorChildrenDetailsEntity;
	}	
	@Override
	public Pdf10Entity getvehicledata(String accidentId,String vehicleRegNo) {
		List<vehicleDetailsEntity> vehicleEntity=new ArrayList<vehicleDetailsEntity>();
		List<vehicleDetailsEntity> vehicleEntity2=new ArrayList<vehicleDetailsEntity>();
		boolean flag;
		int id=Integer.valueOf(vehicleRegNo);
		if(vehicleRegNo!="") {
			vehicleEntity=(List<vehicleDetailsEntity>) vehicleDetailsRepo.findById(id);
			vehicleEntity2=(List<vehicleDetailsEntity>) vehicleDetailsRepo.findByAccidentId(accidentId);
//			vehicleEntity2.get(1);
			if(!vehicleEntity.isEmpty() && !vehicleEntity2.isEmpty()) {
				flag = true;
				return pdfRepo.getreport10(accidentId,vehicleRegNo,flag);
			} else {
				flag = false;
				return pdfRepo.getreport10(accidentId,vehicleRegNo,flag);
			}
 			
		}
		return null;
		
	}
	
	@Override
	public Pdf11Entity getPdf11Report(String accidentId,String vehicleId,String mode,String personId) {
		
		return pdfRepo.getPdf11Report(accidentId, vehicleId,mode,personId);
	}
	@Override
	public Pdf12Entity getPdf12Report(String accidentId, String vehicleId,String mode,String personId) {
		
		return pdfRepo.getPdf12Report(accidentId, vehicleId, mode, personId);
	}
	@Override
	public Pdf13Entity  getPdf13Report(String accidentId, String vehicleId,String personId,String personType) {
		
		return pdfRepo.getPdf13Report(accidentId,vehicleId,personId,personType);
	}
	@Override
	public Pdf14Entity getPdf14Report(String accidentId, String vehicleId,String personId,String personType) {
		
		return pdfRepo.getPdf14Report(accidentId,vehicleId,personId,personType);
	}
	@Override
	public Pdf15Entity getPdf15Report(String accidentId, String vehicleId,String personId,String personType) {
		
		return pdfRepo.getPdf15Report(  accidentId,  vehicleId, personId, personType);
	}
	@Override
	public Pdf16Entity getPdf16Report(String accidentId, String vehicleId, String personId, String personType) {
		
		return pdfRepo.getPdf16Report( accidentId,  vehicleId,  personId,  personType);
	}
	@Override
	public Pdf17Entity getPdf17Report(String accidentId) {
		
		return pdfRepo.getPdf17Report(accidentId);
	}
	@Override
	public Pdf18Entity getPdf18Report(String accidentId) {
		
		return pdfRepo.getPdf18Report(accidentId);
	}
	@Override
	public Pdf20Entity getPdf20Report(String accidentId) {
		return pdfRepo.getPdf20Report(accidentId);
		
	}
	
	
}


//l05283-lc lg
//6034accura 