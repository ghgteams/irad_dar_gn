package com.irad.dar.court;

import java.util.ArrayList;

import com.irad.dar.master.MasterEntity;
import com.irad.dar.master.UserDao;

public interface CourtService {

	public ArrayList<CourtEntity> getdistrict(String id);

	public ArrayList<TalukEntity> getTaluk(String district);

	public String saveCourtdata(ClaimsEntity claimsEntity);

	public ArrayList<UserDao> getDistrictCourtUsers(String officeId, String roleId);
	
	
	
	public ArrayList<CourtListEntity> getCourtList(String district, String state, String courtType);

	public ArrayList<CourtListEntity> getDistrictCourtTaluk(String district, String state, String typeofcourt);

	public ArrayList<CourtListEntity> getSubordinateCourtTaluk(String district, String state, String typeofcourt);

	public ArrayList<CourtListEntity> getCourtDetails(String psId, int officeId);

	//public String saveCourtdetails(CourtListEntity courtListEntity);

	public String updateCourtdetails(CourtListData courtListEntity);


	
}
