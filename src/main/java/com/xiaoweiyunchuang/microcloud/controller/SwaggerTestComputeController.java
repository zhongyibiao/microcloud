package com.xiaoweiyunchuang.microcloud.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(value = "计算服务",description="简单的计算服务，提供加减乘除运算API")
@RestController
@RequestMapping("/compute")
public class SwaggerTestComputeController {
      @ApiOperation("加法运算")
      @RequestMapping(value = "/add", method = RequestMethod.POST)
      public Double add(@RequestParam Double a,  @RequestParam Double b) {
         return a + b;
      }

      @ApiOperation("减法运算")
      @RequestMapping(value = "/sub", method = RequestMethod.POST)
      public Double sub(@RequestParam Double a,  @RequestParam Double b) {
          return a - b;
      }

      @ApiOperation("乘法运算")
      @RequestMapping(value = "/mul", method = RequestMethod.POST)
      public Double mul(@RequestParam Double a,  @RequestParam Double b) {
          return a * b;
      }

      @ApiOperation("除法运算")
      @RequestMapping(value = "/div", method = RequestMethod.POST)
      public Double div(@ApiParam("被除数")@RequestParam Double a, @ApiParam("除数")@RequestParam   Double b) {
          return a / b;
      }
}