package com.irad.dar.documents;

import java.util.ArrayList;
import java.util.List;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.irad.dar.general.VehicleDetails;
import com.irad.dar.general.VehicleInsuranceRequest;
import com.irad.dar.jwt.CaptchaController;

@RestController
public class DocumentController {
	@Autowired
	DocumentService documentService; 
	
	@Autowired
	CaptchaController captchaController;
	
	@RequestMapping(value = "/dar/insertdocuments", method = RequestMethod.POST)
	public String saveAllDocuments(@RequestBody DarDocuments documents) throws Exception {
		System.out.println("Entered document upload"+documents);
		DocumentEntity documentEntity=new DocumentEntity();	
	  //if(documents.getModeOfTheDocument() == "passenger") {
		
	    documentEntity.setAccidentId(documents.getAccidentId());
	    documentEntity.setUsetype(documents.getModeOfTheDocument());
	    documentEntity.setLinkId(documents.getLinkId());
	    documentEntity.setTitle(documents.getNameOfTheDocument());
	    documentEntity.setFile(documents.getDocuments());
	    documentEntity.setRemarks(documents.getRemarks());
	    documentEntity.setActive(true);
	    documentEntity.setInsertedBy(documents.getInsertedBy());
	    
	 // }
	  String result = documentService.savePassengerdocuments(documentEntity);
	  return result;		
    }
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/insertdocuments", method = RequestMethod.POST)
	public JSONObject insertdocuments(@RequestBody EdarDocuments edarDocuments) throws Exception {
		System.out.println("Entered document upload"+edarDocuments);
		JSONObject response = new JSONObject();
		EdarDocumentsEntity edarDocumentsEntity=new EdarDocumentsEntity();	
        System.out.println(edarDocuments.getAccidentid());
        
        String value = captchaController.decrypt();
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(value);
		JSONObject request = (JSONObject) obj;
		JSONObject request1 = (JSONObject) request.get("data");	
		String stateCode = String.valueOf(request1.get("state_code"));
		String districtCode = String.valueOf(request1.get("district_code"));
		String stationCode = String.valueOf(request1.get("station_code"));
		String psId = stateCode.concat(districtCode).concat(stationCode);
		String reqOfficer = String.valueOf(request1.get("username"));
        
        
        
	    edarDocumentsEntity.setAccidentId(edarDocuments.getAccidentid());
	    edarDocumentsEntity.setDocName(edarDocuments.getDocname());
	    edarDocumentsEntity.setDocType(edarDocuments.getDoctype());
	    edarDocumentsEntity.setFile(edarDocuments.getFile());
	    edarDocumentsEntity.setFlag(edarDocuments.getFlag());
	    edarDocumentsEntity.setFormNo(edarDocuments.getFormno());
	    edarDocumentsEntity.setPersontype(edarDocuments.getPersontype());
	    edarDocumentsEntity.setRefId(edarDocuments.getRefid());
	    edarDocumentsEntity.setFlag(edarDocuments.getFlag());
	    edarDocumentsEntity.setInsertedBy(reqOfficer);
	    edarDocumentsEntity.setSrctypec(edarDocuments.getSrctypec());
	    
	  String result = documentService.saveEdarDocuments(edarDocumentsEntity);
	  if(result.equals("Success")&& !result.isEmpty()) {
		  response.put("ErrorCode", result);
		  response.put("Message", "Inserted Successfully");
		  
		}else if(result.equals("Failed")&&!result.isEmpty()) {
			response.put("ErrorCode", result);
			response.put("Message", "Not Inserted");
		}
		return response;		
    }
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/getEdarDocForms", method = RequestMethod.POST)
	public JSONObject getEdarDocForms(@RequestBody EdarFormsDoc edarFormsDoc) throws Exception {
		System.out.println("1");
		@SuppressWarnings("unused")
		String accidentId = edarFormsDoc.getAccidentId();
		String formno =edarFormsDoc.getFormno();
		String mode =edarFormsDoc.getMode();
		String token =edarFormsDoc.getToken();
		String version =edarFormsDoc.getVersion();
		
	
		List<EdarFormsDocEntity> resObject = new ArrayList<EdarFormsDocEntity>();
		JSONObject response = new JSONObject();
		System.out.println(edarFormsDoc.getAccidentId());
		resObject=documentService.getEdarDocForms(edarFormsDoc.getAccidentId());
		response.put("data", resObject);
		response.put("count", resObject.size());
		System.out.println(resObject.size());
		return response;
	
	}
	
	
}
