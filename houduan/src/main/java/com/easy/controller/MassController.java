package com.easy.controller;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.easy.common.bean.Result;
import com.easy.domain.Mass;
import com.easy.domain.ProMarket;
import com.easy.domain.ShowMass;
import com.easy.service.MassService;
import com.easy.service.MassUserService;
import com.easy.service.ProMarketService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/***
 * Created on 2017/12/15 <br>
 * Description: [MassController]<br>
 * @author easy
 * @version 1.0
 */
@RestController
@RequestMapping("/Mass")
public class MassController {

	@Autowired
	private MassService massService;
	
	@Autowired
	private MassUserService massUserService;
	
	@Autowired
	private ProMarketService proMarketService;

	public ShowMass createShowMass() {
		
		Mass mass = new Mass();
		ShowMass showMass = new ShowMass();
		ProMarket proMarket = new ProMarket();
		
		//查詢集貨基礎表信息
		proMarket = proMarketService.selectByPrimaryKey("e174424f-e153-11e7-83f0-00ff8ba56b27");
		Integer round = proMarket.getGroupDuration();
		
		Date now = new Date();
		Date endDate = new Date(now.getTime() + round*60*1000);
		
		mass.setCurrentUsers(0);
		mass.setEndtm(endDate);
		mass.setLowestFreight("120");
		mass.setLowestPrice("6元/1.5KG");
		mass.setMassType("全國團");
		mass.setMktId(proMarket.getMktId());
		mass.setPicUrl("/cc");
		
		massService.saveMassInfo(mass);
		mass = massService.getMassInfo();
		
		List<String> picList = new ArrayList<>();
		
		showMass.setId(mass.getId());
		showMass.setCurrentUsers(mass.getCurrentUsers());
		showMass.setDailyMinPackages(proMarket.getDailyMinPackages());;
		showMass.setEndtm(mass.getEndtm());
		showMass.setGroupLimit(proMarket.getGroupLimit());
		showMass.setLowestFreight(mass.getLowestFreight());
		showMass.setLowestPrice(mass.getLowestPrice());
		showMass.setMassType(mass.getMassType());
		showMass.setMktId(mass.getMktId());
		showMass.setMktNameShow(proMarket.getMktNameShow());
		showMass.setPicUrl(mass.getPicUrl());
		showMass.setUseRequire(proMarket.getUseRequire());
		showMass.setUsersPic(picList);
		showMass.setWeightMax(proMarket.getWeightMax());
		showMass.setWeightMin(proMarket.getWeightMin());
		
		return showMass;
	}
	
	@GetMapping("/getShowMass")
	@ApiOperation(value = "獲取集貨信息")
	@ApiResponses({
	          @ApiResponse(code = 201, message = "獲取成功"),
	          @ApiResponse(code = 500, message = "接口異常"),
	})
	public Result<ShowMass> getShowMass() {
		
		Result<ShowMass> result = new Result<>();
		ShowMass showMass = new ShowMass();
		ProMarket proMarket = new ProMarket();
		
		//查詢集貨基礎表信息
		Mass mass = massService.getMassInfo();
		proMarket = proMarketService.selectByPrimaryKey(mass.getMktId());
		
		if(mass == null || proMarket.getGroupLimit() <= mass.getCurrentUsers() || new Date().after(mass.getEndtm())) {
			showMass = createShowMass();
			if(showMass != null) {
				result.setSuccess(true);
				result.setObj(showMass);
			}else {
				result.setSuccess(false);
				result.setMessage("获取集货信息失败");
			}
			return result;
		}
		
		List<String> picList = massUserService.getHeadUrlListByMassId(mass.getId());
		String userRequire = proMarket.getUseRequire();
		
		showMass.setId(mass.getId());
		showMass.setCurrentUsers(mass.getCurrentUsers());
		showMass.setDailyMinPackages(proMarket.getDailyMinPackages());;
		showMass.setEndtm(mass.getEndtm());
		showMass.setGroupLimit(proMarket.getGroupLimit());
		showMass.setLowestFreight(mass.getLowestFreight());
		showMass.setLowestPrice(mass.getLowestPrice());
		showMass.setMassType(mass.getMassType());
		showMass.setMktId(mass.getMktId());
		showMass.setMktNameShow(proMarket.getMktNameShow());
		showMass.setPicUrl(mass.getPicUrl());
		
		userRequire = String.format(userRequire, proMarket.getDailyMinPackages(), mass.getLowestFreight());
		showMass.setUseRequire(proMarket.getUseRequire());
		showMass.setUsersPic(picList);
		showMass.setWeightMax(proMarket.getWeightMax());
		showMass.setWeightMin(proMarket.getWeightMin());
		
		result.setSuccess(true);
		result.setObj(showMass);
		return result;
	}


}
