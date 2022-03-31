package com.irad.dar.witness;

import java.util.List;

public interface WitnessService {
	public List<WitnessEntity> getWitnessdata(String accid);
	
	public String saveWitness(WitnessEntity witnessEntity);
}
