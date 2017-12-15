package com.easy.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.easy.common.bean.Result;
import com.easy.domain.Mass;
import com.easy.domain.ShowMass;
import com.easy.service.MassService;
import com.easy.service.ProMarketService;

import io.swagger.annotations.ApiImplicitParam;
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
	private ProMarketService proMarketService;

	@PostMapping("/create")
	@ApiOperation(value = "生成集貨信息")
	@ApiImplicitParam(dataType = "Mass", name = "mass", value = "集貨信息", required = true)
	@ApiResponses({
	          @ApiResponse(code = 201, message = "生成成功"),
	          @ApiResponse(code = 500, message = "接口異常"),
	})
	public Result<ShowMass> create() {
		
		Mass mass = new Mass();
		ShowMass showMass = new ShowMass();
		
		//查詢集貨基礎表信息
		proMarketService.selectByPrimaryKey("666");
		
		Integer count = massService.saveMassInfo(mass);
		Result<ShowMass> result = new Result<>();
		result.setSuccess(true);
		result.setObj(mass);
		return result;
	}


}
