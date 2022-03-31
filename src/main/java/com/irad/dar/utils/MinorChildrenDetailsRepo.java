package com.irad.dar.utils;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



public interface MinorChildrenDetailsRepo extends JpaRepository<MinorChildrenDetailsEntity, Long> {
	
	List<MinorChildrenDetailsEntity> findByVictimId(String victimid);
}
