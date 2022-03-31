package com.irad.dar.court;

import java.util.ArrayList;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.irad.dar.master.MasterEntity;
import com.irad.dar.master.UserDao;
import com.itextpdf.styledxmlparser.jsoup.select.Evaluator.IsEmpty;

@Service
public class CourtServiceImpl implements CourtService{
	@Autowired
	CourtRepo courtRepo;
	
	@Autowired
	TalukRepo talukRepo;
	
	@Autowired
	CourtListRepo courtListRepo;
	
	@Autowired
	ClaimsRepo claimsRepo;
	@Autowired
	CourtListDataRepo courtListDataRepo;
	
	@Autowired
	DistrictCourtUsersRepo districtCourtUsersRepo;
	
	@Override
	public ArrayList<CourtEntity> getdistrict(String id) {
		ArrayList<CourtEntity> courtEntity = courtRepo.findByStcode11(id);
		courtEntity.get(1);
		return courtEntity;
	}
	
	
	
	@Override
	public String saveCourtdata(ClaimsEntity claimsEntity) {
		if(!Objects.isNull(claimsEntity)) {
			try {
				claimsRepo.save(claimsEntity);
				return "1";
			} catch (DataIntegrityViolationException e) {
			    System.out.println("Already exist");
			    return "0";
			}
			
		}
		return "0";
	}

	@Override
	public ArrayList<UserDao> getDistrictCourtUsers(String officeId, String roleId) {
		ArrayList<UserDao> courtListEntity = districtCourtUsersRepo.findByOfficeId(officeId,roleId);
		return courtListEntity;
	}
	
	@Override
	public ArrayList<TalukEntity> getTaluk(String district) {
		ArrayList<TalukEntity> talukEntity = talukRepo.findByDtcode11(district);
		return talukEntity;
	}
	
	
	
	
	
	@Override
	public ArrayList<CourtListEntity> getCourtList(String district, String state, String courtType) {
		ArrayList<CourtListEntity> courtListEntity = courtListRepo.findByDistrictCode(district, state, courtType);
		return courtListEntity;
	}
	@Override
	public ArrayList<CourtListEntity> getDistrictCourtTaluk(String district, String state, String typeofcourt) {
		ArrayList<CourtListEntity> courtListEntity = courtListRepo.findByDistrictCode(district, state, typeofcourt);
		return courtListEntity;
	}
	@Override
	public ArrayList<CourtListEntity> getSubordinateCourtTaluk(String district, String state, String typeofcourt) {
		ArrayList<CourtListEntity> courtListEntity = courtListRepo.findByDistrictTalukCode(district, state, typeofcourt);
		return courtListEntity;
	}



	@Override
	public ArrayList<CourtListEntity> getCourtDetails(String psId, int officeId) {
		ArrayList<CourtListEntity> courtListEntity = courtListRepo.findByStateOfficeId(psId, officeId);
		return courtListEntity;
	}



	@Override
	public String updateCourtdetails(CourtListData courtListEntity) {
		if(!Objects.isNull(courtListEntity)) {
			try {
				courtListDataRepo.save(courtListEntity);
				return "1";
			} catch (DataIntegrityViolationException e) {
			    System.out.println("Already exist");
			    return "0";
			}
			
		}
		return "0";
	}



	


	
	

}
