package com.irad.dar.master;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;



public interface UserRepo {

	/**
	 * 
	 * @param token
	 * @return
	 */
	String getUser(String token);
	
	/**
	 * 
	 * @param title
	 * @param content
	 * @param thumbURL
	 * @param pictureURL
	 * @param userId
	 * @param userNmae
	 * @return
	 */
	//Long createPostDetail(String title, String content, String thumbURL, String pictureURL, String userId, String userNmae);
	
	//PostDetailList getPostDetail(Long postId);
	

	//String insertPassengerDetails(PassengerDetailsRequest passengerDetailsRequest);

	void getMasterDetails(String language);

	ArrayList<JSONObject> getPostDetail(String tableArrayName, String lang);

	//String insertAccidentDetails(AccidentDetailsRequest accidentDetailsRequest);
	
	ArrayList<JSONObject> getPostDetail(String state, String district, String station, String mode, String type,
			int dept, int offset, int limit);

	List<JSONObject> getAccViewDetail(String state, String district, String station, String id, String ln, String mode);

	//List<Object[]> getPostDetail(String[] tableArrayName, String lang);
	
	//PostURL getPostUrls(Long postId);

	//AccDetailList getAccList();
	
}
