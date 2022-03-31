package com.irad.dar.jwt;

import java.nio.ByteBuffer;
import java.security.Security;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

import java.util.Base64;

import javax.crypto.Cipher;

import javax.crypto.spec.IvParameterSpec;

import javax.crypto.spec.SecretKeySpec;

import org.bouncycastle.cms.CMSAlgorithm;
import org.bouncycastle.cms.CMSEnvelopedData;
import org.bouncycastle.cms.CMSEnvelopedDataGenerator;
import org.bouncycastle.cms.CMSException;
import org.bouncycastle.cms.CMSProcessableByteArray;
import org.bouncycastle.cms.CMSTypedData;
import org.bouncycastle.cms.jcajce.JceCMSContentEncryptorBuilder;
import org.bouncycastle.cms.jcajce.JceKeyTransRecipientInfoGenerator;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.operator.OutputEncryptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.itextpdf.io.IOException;


@ComponentScan
@RestController
public class CaptchaController {

	@Autowired
	private UserRepository userDao;

	@GetMapping({ "/tokendecode" })
	public String firstPage(String token) {
		// String jwtToken =
		// "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0ZXN0Iiwicm9sZXMiOiJST0xFX0FETUlOIiwiaXNzIjoibXlzZWxmIiwiZXhwIjoxNDcxMDg2MzgxfQ.1EI2haSz9aMsHjFUXNVz2Z4mtC0nMdZo6bo3-x-aRpw";
		System.out.println(token);
		System.out.println("------------ Decode JWT ------------");
		String[] split_string = token.split("\\.");
		String base64EncodedHeader = split_string[0];
		String base64EncodedBody = split_string[1];
		// String base64EncodedSignature = split_string[2];

		System.out.println("~~~~~~~~~ JWT Header ~~~~~~~");
		// Base64 base64Url = new Base64(true);
		String header = new String(Base64.getDecoder().decode(base64EncodedHeader));
		System.out.println("JWT Header : " + header);

		System.out.println("~~~~~~~~~ JWT Body ~~~~~~~");
		String body = new String(Base64.getDecoder().decode(base64EncodedBody));
		System.out.println("JWT Body : " + body);

		return body;
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	private static final String key = "veudhegorasusadh";
	private static final String initVector = "0000000000000000";

	@RequestMapping(value = "/encrypt", method = RequestMethod.POST, consumes = MediaType.ALL_VALUE)
	public String encrypt(String value) {
		String encryptedValue = null;
		try {
			IvParameterSpec iv = new IvParameterSpec(initVector.getBytes("UTF-8"));
			SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");

			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
			cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);

			byte[] encrypted = cipher.doFinal(value.getBytes());
			encryptedValue = Base64.getEncoder().encodeToString(encrypted);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return encryptedValue;
	}

	@RequestMapping(value = "/decrypt", method = RequestMethod.POST, consumes = MediaType.ALL_VALUE)
	 //public String decrypt(String encrypted) {
	public String decrypt() {
		String decryptedValue = "";
		//
		//String encrypted = "R1envE+lnAZek5t06CiLoqFC3ywNFC92OBVpQTxq7HtRWy6JTC1eRj7o7GI8WLI2QwhMOf4p/yohVptjcJ4Tn3A7XTW89l+1NnelIjgVdqc9vmSWd0SBl30FXs5cKIqudjWvdsfeaKQXwnsKV5unX7x8i9Ez7y7yodLW0efGwwNFLxwuWqO2tSLphwuSzTaGz2WDk0OPSmLia0NnwsAojTt6113/mKkpWb/gRDo0i8uimLC3EaDMyomELOKHyu2LOQS2X93P0WcnOWclHAT/8/ibZlyBMgj9qH9LsSCsW6f4kW7WuUSKrx0CWrh8vmmeG/3+s9w+DDl5Aad4bByfkGDElpqEnX7Tl94M1lY1LKNrJRKS9ZV1g3Jesp6O5zRKCIW/kTFlBA1VhBeL+L0C0j4R1pdYvmd9KeGGqurHXzheRNtu8J69/I/5UZu40d+WlEsWuBzqsTUdrZJH3KDpbeyJN0tGcWibUUKu2NDoclDtiwhUhb3KCCcSTEavZd5JR56z2r1iRxw3RlmzGA0tHxRHv3XvwkoXmQR+Ty0KOsKQASn3rOVVN4Z0AKxHIOjx";
		//health
		//String encrypted ="R1envE+lnAZek5t06CiLoqFC3ywNFC92OBVpQTxq7HtRWy6JTC1eRj7o7GI8WLI2QwhMOf4p/yohVptjcJ4Tn3A7XTW89l+1NnelIjgVdqc9vmSWd0SBl30FXs5cKIquYI5G2KOIcbH2ltNpwJKnS3hhvkhYsYDrNKrNVyssFa9aXpZOvOfyqTPoYAz0E/sM55zuFtSIBdgPJwo3HV5H7QY0uL1A3HDdqa0e1XBoBgFoCnn7CiDrG+J8C5+5kXAe4HwVTCuLa8QJvJhHMjD20o/TDPTyV3Q+4oNowGrGs4eHyMjnS0ZdOG3lCFZxNMlSKe2Cl5aOSxDM4BQFvbkbfvxTv+xh1PCVC39OOe9yiuwZMj4cCnlRFXibLxrCQWQcy90aFqgERIQjO/E4JgriZtVKCHIPAgfQMzPr9Y72lHCaJOAK45bqYPJiNGVTLWPzplYtCqS49eXKtEkbVkC4B1iwDx2KepYn1nCahLNuG/AVwHLrA79X8ceWYY6xRnFeAR/SVkvPyfAHQgXE1Lrfjs4HERNndJais/qa11H2iJk=";
		
		String encrypted="KGI3Zl870qiYuwy5Fzz9RLYxYvJxYsNo60Fgy6UILVA2dMvI75OCF9HBuu8ccX13DXejDnod4MmOxs3WwOW1dkAfoX7ni0BQNrE+AAEwz5DIziStvAYVpJ5OEo27VCvd4k/WTtmuuISv1azUz7kRnP1iQn8Rp6SjTEPmEVu4LFhusV7Qhk2cHf9E10AgPR3Fa35m5SyHPM6G/Cy2g09pTvvGXCz5IzWKYgDk7IN6hTm5PqL/x+hNIdQWFUqxMi0with1MqWRcDjd7ob2sTgzDfqSzxb/aeUqnT4WUUnNUyWWYa8gmknnJyCNl39C8+GUwOW9vHBxxGHszWEzgwpYLtUqEVdgVRmllgzQ9PWElXgocVjLaUvKVfizs0wxRO7vCWRu7YNf3QjvE7z8o6QOEp09EqaCbXnRetukhRsUl+awTZWQxTmO7155P7V7qULDZR/4nPzHuQLPgsVwZhUHYkOurNu62SRD4QMdljOvbmR7xto8riRr/CYNiLa4R7YMlvOUSUyYaE20hpvUJtWa8MEOXZIk92dyUBRLPG9PFUx83ZP6eEPfUbS3+S/7ECyN2Ek0etyamXHX3AOrgtqS9FeclCUNL8oJJnSekTJF97yNopPDeIrIimNOMTzvXkC9h1g4DxSC/+qtbdmNiFvtKHRTbVRb/Q1+GQvflWIStT7oh7ams8mOTrIFcLY7umWnJB/67bLR5Vb2naGt+M58Wkx/8bk7reBrZUlo/pLX5KYEqFZonLN3gC6NfHp2oH+B0vWpG5GgaPO4hD8j6ung7Pnr9NaFBDuVOy6YVNsoHAme48zYZTNw1BJuv0jgIOFyUhNVwIZ/jdFUtYw+776jRK0JikdJGkLgCTm2VV/nb0dt9t09/g9fViAq8xw/MyOE7a83dnHYG58dMjBvMkOp4DuKpuhwE62cjL6cfn1lvWm8HxotTKyG3LMKUAWNcpk1bhaoserChf6wOt3GnzaazVY0Mri5UeG+3qQNuZg1F53i/wf0fIgMimhfEwMxykxr5fG2t4Er4S98V+j0DIJWBW47qa6sdcYJC/IFvPyeTjgmS+3DZgR+sv6paB3sNMQlz/00L2cjOl+NveEg27rNUI7YQfojt9ksFIWu5FoMixNNdWdpCP6Um88ZUQ84ZlyS+fRZpdvDSBJUzORCdcvGnpAqEPdOib0Nsfca5aKm+PXHSycli3FNfulHIvzHZTew59MhguX4+GufpKJ0p/bRfs9iXHM+xhbXMAErvGeBJRUQQaBlad4U6x86aqeIyn1pTvM7Gjfck5CFTbxdHRxMAxzh+aq3tZcBX/ZhZ+IbBe1tykIBBE68CnAnfUTYBI6MIjfI0EAgyHSz4UdhIY6aTMN7nQjeKZIQ1lQl8ZeV1qpGHdA2UzsxD33C14aq+p26TXnMtLXJbzqN33Zf0RcnVcH3Uuy67DNDHKVv4NO1y0us5UB9zZclzF3JhsIqYinXIG9z3jh6QoHS+x9tWx54UHCiiPgmGFoelqgL/B6fAmBLWCNBIUi009h+pzpJk4B5RjEsQJditJvtsNkkyRQ0rHsSFhqIMp46pi2t0GKgPsQWktPn69y9IHbLurod3Zkeu+PmjngQmbySchz5Txeye0oQ0sjehSxIfG+mHFH9NTVgwPOLF4F8IBkfxlv2HmP0";
		
		try {
			IvParameterSpec iv = new IvParameterSpec(initVector.getBytes("UTF-8"));
			SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");
			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
			cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);
//	        String decodedValue = Base64().getDecoder().decode(encrypted.getBytes());
			// byte[] original = cipher.doFinal(Base64.getDecoder().decode(encrypted));

			decryptedValue = new String(cipher.doFinal(Base64.getDecoder().decode(encrypted)));

			// byte[] decodedBytes = Base64.getDecoder().decode(decryptedValue);
			// String decodedString = new String(original);

			System.out.println(decryptedValue);
			// firstPage(decryptedValue);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return firstPage(decryptedValue);
	}
	
	
	public static byte[] encryptData(byte[] data)
			throws CertificateEncodingException, CMSException, IOException, Exception {
		Security.addProvider(new BouncyCastleProvider());
		CertificateFactory fact = CertificateFactory.getInstance("X.509");
		ClassLoader classloader = Thread.currentThread().getContextClassLoader();
		X509Certificate encryptionCertificate = (X509Certificate) fact.generateCertificate(classloader.getResourceAsStream("/irad_cert.pem"));
		byte[] encryptedData = null;
		if (null != data && null != encryptionCertificate) {
			CMSEnvelopedDataGenerator cmsEnvelopedDataGenerator = new CMSEnvelopedDataGenerator();
			JceKeyTransRecipientInfoGenerator jceKey = new JceKeyTransRecipientInfoGenerator(encryptionCertificate);
			cmsEnvelopedDataGenerator.addRecipientInfoGenerator(jceKey);
			CMSTypedData msg = new CMSProcessableByteArray(data);
			OutputEncryptor encryptor = new JceCMSContentEncryptorBuilder(CMSAlgorithm.AES256_CBC).setProvider("BC")
					.build();
			CMSEnvelopedData cmsEnvelopedData = cmsEnvelopedDataGenerator.generate(msg, encryptor);
			encryptedData = cmsEnvelopedData.getEncoded();
		}
		return encryptedData;
	}
	
	
	
	
//	@SuppressWarnings("static-access")
//	//@RequestMapping(value = "/decrypt", method = RequestMethod.POST, consumes = MediaType.ALL_VALUE)
//	  public String decrypt1(String encryptedText) throws Exception {
//		ObjectMapper mapper = new ObjectMapper();
//		Map<String, Map<String, Object>> list = new LinkedHashMap<String, Map<String, Object>>();
//        //String accidentId="202116443500011";
//        Long firNum = getFirNumberFromAccidentId(accidentId);
//        Map firDtTm = returnFirDateTime(firNum);
//        Map actSec = returnFirActsSections(firNum);
//        Map stCd = returnStateCd(firNum);
//        Map dstCd = returnDistrictCd(firNum);
//        Map psCd = returnPsCd(firNum);
//        Map ioDetails = returnIoDetails(firNum);
//        Map insertDt = returnFirInsertDt(firNum);
//        Map modeInfo = returnModeOfInfo(firNum);
//        Map complInfo = returnComplainantInfo(firNum);
//        Map victimInfo = returnVictimInfo(firNum);
//        Map accusedInfo = returnAccusedInfo(firNum);
//        Map vehicleInfo = returnVehicleInfo(firNum);
//        Map caseInfo = returnCaseInfo(firNum);
//        Map courtInfo = returnCourtAllInfo(firNum);
////returnCourtAllInfo(firNum);
//        Map lastUpd = returnFirLastUpdated(firNum);
//
//        String finalFir = firNum.toString();
//        Map<String, Object> arr = new HashMap<String, Object>();
//        ArrayList arr2 = new ArrayList<String>();
//        arr.put("fir_number", finalFir);
//        arr.put("accident_id", accidentId);
//        //  arr.add("act sec 2");
//        System.out.println("directory" + System.getProperty("user.dir"));
//
//        Map<String, Object> accid = new HashMap<String, Object>();
//        Map<String, Object> firno = new HashMap<String, Object>();
//        accid.put("accident_id", accidentId);
//        firno.put("fir_number", finalFir);
//        list.put("Accident-ID", accid);
//        list.put("FIR-Number", firno);
//        // list.put("General Details", arr);
//        list.put("FIR-Registration-Date-Time", firDtTm);
//
//        list.put("Acts-and-Sections", actSec);
//
//        list.put("State-Code", stCd);
//        list.put("District-Code", dstCd);
//        list.put("Station-Code", psCd);
//        list.put("Investigating-Officer", ioDetails);
//        list.put("Inserted-Date", insertDt);
//        list.put("Mode-of-Information", modeInfo);
//        list.put("Complainant-Information", complInfo);
//        list.put("Victim-Information", victimInfo);
//        list.put("Accused-Information", accusedInfo);
//        list.put("Vehicle-Information", vehicleInfo);
//        list.put("Case-Information", caseInfo);
//        list.put("Court-Information", courtInfo); //lastUpd
//       list.put("Last-Updated-Date", lastUpd);
//       
//        byte[] payload = mapper.writeValueAsBytes(list);
//		String ciphertextBase64 = null;
//		byte[] payload = mapper.writeValueAsBytes(list);
//		ciphertextBase64 = Base64.encodeBase64String(encryptData(payload));
//		byte[] . = Base64.decodeBase64(ciphertextBase64);
//        PrivateKey pk = DataSecurityUtil.pemLoadKeyTest();
//        byte[] plainText = DataSecurityUtil.decryptData(cipherText, pk);
//        String pld2 = new String(plainText);
//       // System.out.println("Decrypted data" + pld2);
//        // return new ResponseEntity(ciphertextBase64,HttpStatus.OK);
//        //  String fnl = new String(finals); //new one
//        //   System.out.println("Key " + DataSecurityUtil.);
//        //      System.out.println("Decrypted"+fnl);
//     
//	   
//	    return new String(decryptedTextBytes);
//	  }
	
}



//	
//	@GetMapping({ "/sample" })
//	public String secPage() {
//		return "Welcome";
//	}
//	
////	@GetMapping({ "/captcha" })
////	public String captcha(Model model,HttpSession httpSession) {
////		model.addAttribute("captchaValue",new CaptchaModel());
////		Captcha captcha=captchaGenerator.createCaptcha(200, 50);
////		httpSession.setAttribute("captcha", captcha.getAnswer());
////		model.addAttribute("captchaEncode",CaptchaUtils.encodeBase64(captcha));
////		System.out.println("Value="+CaptchaUtils.encodeBase64(captcha));
////		System.out.println(model.getAttribute("captchaEncode"));
////		
////		String val=(String) model.getAttribute("captchaEncode").toString();
////		return val;
////	}
////	
////	@PostMapping({"/savecaptcha"})
////	public String saveCaptcha(@ModelAttribute("captchaValue") CaptchaModel captchaModel, HttpServletRequest httpServletRequest){
////		if(captchaModel.getCaptchaValue().equals(httpServletRequest.getSession().getAttribute("captcha"))) {
////			return "Success";
////		}else {
////			return "redirect:/captcha";
////		}
////		
////	}
//	
//	
//}
