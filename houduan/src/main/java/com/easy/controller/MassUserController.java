package com.easy.controller;


import com.easy.common.bean.Result;
import com.easy.common.until.ResultUtil;
import com.easy.domain.MassUser;
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
  private MassUserService massUserService;

  @PostMapping("/adduser")
  @ApiOperation(value = "报名集货")
  @ApiImplicitParam(dataType = "MassUser", name = "massUser", value = "集货用户信息", required = true)
  @ApiResponses({
      @ApiResponse(code = 200, message = "请求成功"),
  })
  public Result<Boolean> create(@RequestBody @Validated MassUser massUser,
      BindingResult bindingResult) {
    //模拟用户图片
    int num = (int) (Math.random() * 10);
    massUser.setHeadPortrait("/header/" + num + ".png ");
    //添加集货用户
    int insert = massUserService.insert(massUser);
    if (insert == 0) {
      return ResultUtil.error("参加失败", false);
    }
    return ResultUtil.success(true);
  }


}
