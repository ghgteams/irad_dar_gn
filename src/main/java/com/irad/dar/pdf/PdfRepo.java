package com.irad.dar.pdf;


public interface PdfRepo {

	Pdf1Entity getreport1(String accidentId);

	Pdf2Entity getreport2(String accidentId,String name);

	Pdf3Entity getreport3(String accidentId, String vehicleId);

	Pdf4Entity getreport4(String accidentId, String vehicleId);

	Pdf5Entity getreport5(String accidentId, String vehicleId);

	Pdf6Entity getreport6(String accidentId, String vehicleId,String mode,String vehicle_id);
	
	Pdf7Entity getreport7(String accidentId, String vehicleId,String refId,String mode);
	
	Pdf8Entity getreport8(String accidentId, String vehicleId);

	Pdf9Entity getreport9(String accidentId, String vehicleId);

	Pdf10Entity getreport10(String accidentId, String vehicleId, boolean flag);

	Pdf6aEntity getreport6a(String accidentId, String whoseChild, String user_type);

	Pdf11Entity getPdf11Report(String accidentId, String vehicleId, String mode,String personId);

	Pdf12Entity getPdf12Report(String accidentId, String vehicleId,String mode,String personId);

	Pdf13Entity getPdf13Report(String accidentId, String vehicleId,String personId,String personType);

	Pdf14Entity getPdf14Report(String accidentId, String vehicleId,String personId,String personType);

	Pdf15Entity getPdf15Report(String accidentId, String vehicleId,String personId,String personType);

	Pdf16Entity getPdf16Report(String accidentId, String vehicleId, String personId, String personType);

	Pdf17Entity getPdf17Report(String accidentId);

	Pdf18Entity getPdf18Report(String accidentId);

	Pdf20Entity getPdf20Report(String accidentId);

	//List<MinorChildrenDetailsEntity> getreport6a();
}
