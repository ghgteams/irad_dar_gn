package com.irad.dar.slsa;

import org.springframework.data.jpa.repository.JpaRepository;


public interface SlsaDeathRepo extends JpaRepository<SlsaDeathEntity, Long>{
	public SlsaDeathEntity findById(long id);

}
