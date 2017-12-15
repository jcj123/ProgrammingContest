package com.easy.controller;


import com.easy.common.bean.Result;
import com.easy.common.until.ResultUtil;
import com.easy.domain.ProMarket;
import com.easy.service.ProMarketService;
import org.springframework.beans.factory.annotation.Autowired;
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

  @PostMapping("/creat")
  public Result<Boolean> create(@RequestBody ProMarket proMarket) {
    proMarketService.insert(proMarket);
    return ResultUtil.success(true);
  }


}
