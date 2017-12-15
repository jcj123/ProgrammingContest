package com.easy.controller;


import com.easy.common.bean.Result;
import com.easy.common.until.ResultUtil;
import com.easy.domain.Mass;
import com.easy.domain.MassUser;
import com.easy.service.MassService;
import com.easy.service.MassUserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
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
@RequestMapping("/mass")
public class MassUserController {

  @Autowired
  MassUserService massUserService;

  @Autowired
  MassService massService;

  @PostMapping("/adduser")
  @ApiOperation(value = "参加集货")
  @ApiImplicitParam(dataType = "MassUser", name = "massUser", value = "集货用户信息", required = true)
  @ApiResponses({
      @ApiResponse(code = 200, message = "请求成功"),
  })
  public Result<Boolean> create(@RequestBody @Validated MassUser massUser,
      BindingResult bindingResult) {
    String massId = massUser.getMassId();

    Mass mass = massService.selectByPrimaryKey(massId);


    //模拟用户头像
    int num = (int) (Math.random() * 10);
    massUser.setHeadPortrait("/herder/" + num + ".png ");
    //添加集货用户
    massUserService.insert(massUser);
    return ResultUtil.success(true);
  }


}
