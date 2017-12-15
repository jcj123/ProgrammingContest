package com.easy.controller;


import com.easy.common.bean.Result;
import com.easy.common.until.ResultUtil;
import com.easy.domain.ProMarket;
import com.easy.service.ProMarketService;
import org.springframework.beans.factory.annotation.Autowired;
import com.easy.domain.Mass;
import com.easy.service.MassService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/***
 * Created on 2017/11/3 <br>
 * Description: [BookController]<br>
 * @author easy
 * @version 1.0
 */
@RestController
@RequestMapping("/proMarket")
public class ProMarketController {

  @Autowired
  ProMarketService proMarketService;
	@Autowired
	private MassService massService;

  @PostMapping("/creat")
  public Result<Boolean> create(@RequestBody ProMarket proMarket) {
    proMarketService.insert(proMarket);
    return ResultUtil.success(true);
  @PostMapping
  @ApiOperation(value = "新增团信息")
  @ApiImplicitParam(dataType = "Mass", name = "mass", value = "团信息", required = true)
  @ApiResponses({
          @ApiResponse(code = 201, message = "新增成功"),
          @ApiResponse(code = 500, message = "接口异常"),
  })
  public Result<Integer> save(@RequestBody Mass mass) {
	  Integer count = massService.saveMassInfo(mass);
	  Result<Integer> result = new Result<>();
	  result.setSuccess(true);
	  result.setObj(count);
	  return result;
  }


}
