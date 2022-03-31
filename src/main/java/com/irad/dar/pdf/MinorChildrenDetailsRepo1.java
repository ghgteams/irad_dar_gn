package com.irad.dar.pdf;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MinorChildrenDetailsRepo1 extends JpaRepository<MinorChildrenDetailsEntity1, Long> {
	
	//List<MinorChildrenDetailsEntity1> findByVictimId(String victimid);

//	List<MinorChildrenDetailsEntity1> findByWhoseChild(String victimid);

	List<MinorChildrenDetailsEntity1> findByWhoseChildAndUserTypeAndAccId(String whoseChild, String user_type,String accid);
}
