package com.irad.dar.utils;

import java.util.List;

public interface MinorChildrenDetailsService {

	String saveMinorchilddata(MinorChildrenDetailsEntity minorChildrenDetailsEntity);

	List<MinorChildrenDetailsEntity> getMinorChildrendata(String victimid);

}
