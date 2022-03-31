package com.irad.dar.familydetails;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


public class FamilydetailsController {

	@Autowired 
	FamilydetailsService familydetailsService;
	
	
	@RequestMapping(value = "/dar/familydetails2", method = RequestMethod.POST)
	public String saveData(@RequestBody Familydetails familydetails) throws Exception {
		System.out.println("Check" + familydetails);
		
		FamilydetailsEntity familydetailsEntity=new FamilydetailsEntity();
		
		String accid=(String) familydetails.getFamilydetails().get("accid");
		System.out.println("Accid"+accid);
		String user_type=(String)familydetails.getType();
		String ref_id=(String)familydetails.getRef_id();
		
		Random rnd = new Random();
	    int number = rnd.nextInt(999999);

	    // this will convert any number sequence into 6 character.
	    String reference_id= String.format("%06d", number);
		
		String famName=(String)familydetails.getFamilydetails().get("famName");
		String famAge=(String)familydetails.getFamilydetails().get("famAge");
		String famGender=(String)familydetails.getFamilydetails().get("famGender");
		String famRelation=(String)familydetails.getFamilydetails().get("famRelation");
		String famAddress=(String)familydetails.getFamilydetails().get("famAddress");
		String famContact=(String)familydetails.getFamilydetails().get("famContact");
				
		familydetailsEntity.setAccId(accid);
		familydetailsEntity.setPedestrianId(reference_id);
		familydetailsEntity.setUserType(user_type);
		familydetailsEntity.setFamName(famName);
		familydetailsEntity.setFamAge(famAge);
		familydetailsEntity.setFamGender(famGender);
		familydetailsEntity.setFamRelation(famRelation);
		familydetailsEntity.setFamAddress(famAddress);
		familydetailsEntity.setFamContact(famContact);	
		
		
	    String result = familydetailsService.savefamilydetailsdata(familydetailsEntity);
		return result;
	}

}
