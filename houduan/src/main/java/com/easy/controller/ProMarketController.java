package com.easy.controller;


import com.easy.common.bean.Result;
import com.easy.common.until.ResultUtil;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
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



  @PostMapping
  public Result<Object> create(BindingResult bindingResult) {
    return ResultUtil.success(null);
  }


}
