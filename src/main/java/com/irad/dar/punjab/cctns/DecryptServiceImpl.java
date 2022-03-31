package com.irad.dar.punjab.cctns;

import java.security.PrivateKey;
import java.util.Base64;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Service;

@Service
public class DecryptServiceImpl implements DecryptService {
	
	@Override
	public String getEncodeData(DecryptDTO decryptdata) throws Exception {
		    
		//JSONParser parser = new JSONParser();
		//Object obj  = parser.parse(decryptdata);
		//String data =  obj.toString();
		//JSONArray array = new JSONArray();
		///array.put(data);
		//JSONObject jsonobj = new JSONObject(data);
		//String dt =  jsonobj.getString("Data");
		//System.out.println("obtained data"+dt);
		
		 String data = decryptdata.getData();
		byte[] cipherText = Base64.getDecoder().decode(data);
		PrivateKey pk = DataSecurityUtil.pemLoadKeyTest();
		byte[] plainText = DataSecurityUtil.decryptData(cipherText, pk);
        String pld2 = new String(plainText);
        
       // System.out.println("Decrypted data" + pld2);
        
		return pld2;
	}

	
}
