package com.irad.dar.court;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.irad.dar.general.GeneralEntity;

public interface CourtListDataRepo extends JpaRepository<CourtListData, Integer>{
	public CourtListData findById(int id);
}
