package com.irad.dar.punjab.cctns;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class GeneralDecryptorController {
	
	
@Autowired
DecryptService decryptService;
	
//@GetMapping(value="/hello")
//public String gethello() throws Exception{
//	
//	return "hello";
//	
//}

@RequestMapping(value ="/decrypt", method = RequestMethod.POST)
public String getData(@RequestBody DecryptDTO decryptdata) throws Exception {
	
  String decrypteddata=decryptService.getEncodeData(decryptdata);
	return decrypteddata;
		
		
	}

}
