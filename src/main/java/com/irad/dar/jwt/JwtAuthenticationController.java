package com.irad.dar.jwt;


import java.security.MessageDigest;
import java.security.spec.KeySpec;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.DatatypeConverter;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.irad.dar.master.UserDao;

@RestController
public class JwtAuthenticationController {
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private UserRepository userDao;
	@Autowired
	private JWTUserDetailsService userDetailsService;
	@Autowired
	private CaptchaController controller;

	private String tokenValue;

	/* Token Generation */
	@RequestMapping(value = "/authenticate", method = RequestMethod.POST, consumes = MediaType.ALL_VALUE)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthModel authModel) throws Exception {
		String user = authModel.getUserid();
		// String pass = authModel.getPassword();
		String pass = "nicsi21";
		System.out.println("createAuthenticationToken" + user + pass);
		authenticate(user, pass);
		final UserDetails userDetails = userDetailsService.loadUserByUsername(user);

		System.out.println("Userdetails" + userDetails);
		final String token = jwtTokenUtil.generateToken(userDetails, userDao.findByUsername(user));
		tokenValue = token;

		UserDao user1 = userDao.findByUsername(user);

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("dept", user1.getDept());
		jsonObject.put("district_code", user1.getDistrict_code());
		jsonObject.put("expiresIn", 864000);
		jsonObject.put("idToken", token);
		jsonObject.put("localId", authModel.getCaptcha());
		jsonObject.put("message", "Successful login.");
		jsonObject.put("name", user1.getName());
		// jsonObject.put("office_id", null);
		jsonObject.put("role", user1.getRole_code());
		jsonObject.put("state_code", user1.getState_code());
		jsonObject.put("station_code", user1.getStation_code());
		jsonObject.put("userid", user1.getUsername());
		// return ResponseEntity.ok(new JwtResponse(token));
		return ResponseEntity.ok(jsonObject);
	}

	/* User Authentication */
	private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}

	
	
	
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//  /* Register User */
//  @RequestMapping(value = "/register", method = RequestMethod.POST)
//  public ResponseEntity<?> saveUser(@RequestBody String username,@RequestBody String password) throws Exception {
//	System.out.println("SavingUser"+username+password);
//	return ResponseEntity.ok(userDetailsService.save(username,password));
//  }

	/* Get User Details by Username */
//  @RequestMapping(value = "/profile", method = RequestMethod.GET)
//  public UserData userProfile(String token)throws Exception {	
//	System.out.println(tokenValue);
//	String username = controller.firstPage(tokenValue);
//	JSONObject jsonObj = new JSONObject(username);
//	System.out.println(jsonObj);
//	try {				
//	  UserData user = userRepository.findByName(jsonObj.get("sub").toString());				
//	  return user;
//	} catch (Exception e) {
//		e.printStackTrace();
//		throw e;
//	}			
//  }
	
	@RequestMapping(value = "/login_enc", method = RequestMethod.POST, consumes = MediaType.ALL_VALUE)
	public ResponseEntity<?> password(@RequestBody AuthModel authModel) throws Exception {
//		String ipAddress = request.getHeader("X-Forwarded-For");
//		System.out.println(ipAddress);
		String user = authModel.getUserid();
		UserDao user1 = userDao.findByUsername(user);
		System.out.println(user1.getPassword());
		String password = user1.getPassword().toString();
		String dbPassword = user1.getPassword();
		String capcha = authModel.getCaptcha();
	    String salt="QPALZM";
	    
	    //String rand=
	    
	    //capcha
	    MessageDigest md = MessageDigest.getInstance("MD5");
	    md.update(capcha.getBytes());
	    byte[] digest = md.digest();
	    String mycapchaHash = DatatypeConverter.printHexBinary(digest).substring(3,13).toLowerCase().toString();
	    System.out.println(mycapchaHash);
	    
	    //password
	    MessageDigest md1 = MessageDigest.getInstance("MD5");
	    md1.update(password.getBytes());
	    byte[] digest1 = md1.digest();
	    String myPasswordHash = DatatypeConverter.printHexBinary(digest1).toLowerCase().toString();
	    System.out.println(myPasswordHash);
	    
	    //adding salt
	    String saltConcat = mycapchaHash+salt+myPasswordHash.toLowerCase().toString();
	    System.out.println(saltConcat);
	    
	    //md5
	    MessageDigest md2 = MessageDigest.getInstance("MD5");
	    md2.update(saltConcat.getBytes());
	    byte[] digest2 = md2.digest();
	    String md5Password = DatatypeConverter.printHexBinary(digest2).toLowerCase().toString();
	    System.out.println(md5Password);
	     if(authModel.getRandval().equals(md5Password)) {
	    	 System.out.println("password is correct");
	     } else {
	    	 System.out.println("wrong password");
	     }
	    
	   // String randSalt= 
	    //assertThat(myHash.equals(hash)).isTrue();
		return null;
		
	}
	public String getClientIp(HttpServletRequest request) {
		String ipAddress = request.getHeader("X-Forwarded-For");
		System.out.println(ipAddress);
//		if(StringUtils.isEmpty(ipAddress) || "unknown".equalsIgnoreCase(ipAddress)) {
//			ipAddress = request.getHeader("Proxy-Client-IP");
//		}
		
		return ipAddress;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	//private static final String key = "veudhegorasusadh";
//	//private static final byte[] key1 = key.getBytes();
//	private static final String SECRET_KEY = "veudhegorasusadh";
//	  private static final String SALT = "QPALZM";
//	  @RequestMapping(value = "/decrypt1", method = RequestMethod.POST, consumes = MediaType.ALL_VALUE)
//	  public static byte[] decrypt1(String encrypted) {
//	    try {
//	      byte[] iv = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
//	      IvParameterSpec ivspec = new IvParameterSpec(iv);
//	      
//	      //SecretKeySpec skeySpec = new SecretKeySpec(key1, "AES");
//	      
//	      SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256"); 
//	      KeySpec spec = new PBEKeySpec(SECRET_KEY.toCharArray(), SALT.getBytes(), 65536, 256);
//	      SecretKey tmp = factory.generateSecret(spec);
//	      SecretKeySpec secretKey = new SecretKeySpec(tmp.getEncoded(), "AES");
//	 
//	      Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
//	      cipher.init(Cipher.DECRYPT_MODE, secretKey, ivspec);
//	      System.out.println("test");
//	      String originalString = new String(Base64.decodeBase64(encrypted));
//	      System.out.println("test2");
//	      byte[] base64decodedTokenArr = Base64.decodeBase64(encrypted.getBytes("UTF-8"));
//	      System.out.println("test3");
//	      System.out.println(base64decodedTokenArr.toString());
//	      String decStr = new String(cipher.doFinal(base64decodedTokenArr),"UTF-8");
//	      System.out.println(decStr);
//	      byte[] decryptedPassword = cipher.doFinal(base64decodedTokenArr);
//	      System.out.println("test4");
//	      
//	      System.out.println("test"+decStr);
//	      return decryptedPassword;
//	    } catch (Exception e) {
//	      System.out.println("Error while decrypting: " + e.toString());
//	    }
//	    return null;
//	  }
	

//	public static String decrypt(String algorithm, String cipherText, SecretKey key, IvParameterSpec iv) throws NoSuchPaddingException, NoSuchAlgorithmException,
//		    InvalidAlgorithmParameterException, InvalidKeyException,BadPaddingException, IllegalBlockSizeException {
//
//		    Cipher cipher = Cipher.getInstance(algorithm);
//		    cipher.init(Cipher.DECRYPT_MODE, key, iv);
//		    byte[] plainText = cipher.doFinal(Base64.getDecoder()
//		        .decode(cipherText));
//		    return new String(plainText);
//		}
	  
	  
	  
	private static final String key = "veudhegorasusadh";
	private static final byte[] key1 = key.getBytes();
	private static final String initVector = "0000000000000000";
	@RequestMapping(value = "/decrypt1", method = RequestMethod.POST, consumes = MediaType.ALL_VALUE)
	public static String decrypt(String encrypted) {
		try {
			//initVector = getAlphaNumericString(16);
			IvParameterSpec iv = new IvParameterSpec(initVector.getBytes("UTF-8"));
			SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");

			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
			cipher.init(Cipher.DECRYPT_MODE, skeySpec,new IvParameterSpec(new byte[16]));
			byte[] original = cipher.doFinal(DatatypeConverter.parseBase64Binary(encrypted));
			//byte[] original = Base64.getDecoder().decode(encrypted);
			//String originalString = new String(Base64.getDecoder().decode(encrypted));
			return new String(original);
		} catch (Exception ex) {
			ex.printStackTrace();
		} 

		return null;
	}
	
	
	
	
//	private static String decryptUsingAESKey(String encryptedData,byte[] key)throws NoSuchPaddingException, NoSuchAlgorithmException,InvalidAlgorithmParameterException, InvalidKeyException,BadPaddingException, IllegalBlockSizeException {
//		SecretKeySpec skeySpec = new SecretKeySpec(key, "AES");
//		Cipher cipher = Cipher.getInstance("AES");
//		cipher.init(Cipher.DECRYPT_MODE, skeySpec);
//		cipher.doFinal(Base64.)
//		return encryptedData;
//	}	
	
	@RequestMapping(value = "/decrypt3", method = RequestMethod.POST, consumes = MediaType.ALL_VALUE)
	public static String decrypt3(String encrypted)
    {
        try {
  
            // Default byte array
            byte[] iv = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
            // Create IvParameterSpec object and assign with
            // constructor
            IvParameterSpec ivspec = new IvParameterSpec(iv);
  
            // Create SecretKeyFactory Object
            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
  
            // Create KeySpec object and assign with
            // constructor
            KeySpec spec = new PBEKeySpec(key.toCharArray(), initVector.getBytes(),65536, 256);
            SecretKey tmp = factory.generateSecret(spec);
            SecretKeySpec secretKey = new SecretKeySpec(tmp.getEncoded(), "AES");
  
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, secretKey, ivspec);
            // Return decrypted string
            byte[] original =cipher.doFinal(DatatypeConverter.parseBase64Binary(encrypted));
            return new String(original);
        }
        catch (Exception e) {
            System.out.println("Error while decrypting: " + e.toString());
        }
        return null;
    }

}
