package com.easy.service;

import com.easy.domain.Mass;

/***
 * Created on 2017/12/15 <br>
 * Description: <br>
 * @author easy
 */
public interface MassService {
	
	Integer saveMassInfo(Mass mass);

	Mass selectByPrimaryKey(String id);
	
	Mass getMassInfo();

}
