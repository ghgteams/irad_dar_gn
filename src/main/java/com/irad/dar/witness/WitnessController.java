package com.irad.dar.witness;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.irad.dar.general.General;
import com.irad.dar.general.GeneralEntity;

@RestController
public class WitnessController {
	
	@Autowired
	WitnessService witnessService;
	
	@RequestMapping(value = "/dar/getwitness", method = RequestMethod.POST)
	public List<WitnessEntity> getData(@RequestBody Witness witness) throws Exception {
		//System.out.println("Accid RX"+general.getGeneral());
		System.out.println((String) witness.getAccId());
		String id=(String) witness.getAccId();

		List<WitnessEntity> witnessEntity=witnessService.getWitnessdata(id);
				
		//System.out.println(generalEntity.getOfficerName()+generalEntity.getOfficerAddress()+generalEntity.getOfficerNumber());
		return witnessEntity;
	
	}
	
	@RequestMapping(value = "/dar/witness", method = RequestMethod.POST)
	public String saveWitness(@RequestBody Witness witness) throws Exception {
		//System.out.println("Accid RX"+general.getGeneral());
		System.out.println((String) witness.getWitness().get("accid"));

		
		WitnessEntity we=new WitnessEntity();
		String accid=(String) witness.getWitness().get("accid");
		String name=(String) witness.getWitness().get("name");
		String guardianname=(String) witness.getWitness().get("guardianname");
		String guaridan_type=(String) witness.getWitness().get("guaridan_type");
		String gender=(String) witness.getWitness().get("gender");
		String mobile=(String) witness.getWitness().get("mobile");
		String residence=(String) witness.getWitness().get("residence");
		String occupation=(String) witness.getWitness().get("occupation");
		int age=(int) witness.getWitness().get("age");
		String audio=(String) witness.getWitness().get("audio");
		
		we.setName(name);
		we.setGuardianName(guardianname);
		we.setGuaridanType(guaridan_type);
		we.setGender(gender);
		we.setMobile(mobile);
		we.setResidence(residence);
		we.setOccupation(occupation);
		we.setAge(String.valueOf(age));
		we.setAudio(audio);
		we.setAccId(accid);
		
		String result = witnessService.saveWitness(we);

		//System.out.println(generalEntity.getOfficerName()+generalEntity.getOfficerAddress()+generalEntity.getOfficerNumber());
		return result;
	
	}
}
