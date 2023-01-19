package com.increff.employee.controller;

import com.increff.employee.dto.OrderDto;
import com.increff.employee.model.OrderData;
import com.increff.employee.model.OrderItemForm;
import com.increff.employee.pojo.OrderItemPojo;
import com.increff.employee.pojo.OrderPojo;
import com.increff.employee.service.ApiException;
import com.increff.employee.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Api
@RestController
public class OrderController {
 @Autowired
 private OrderService service;

 @ApiOperation(value = "creates an order")
 @RequestMapping(path = "/api/order",method = RequestMethod.POST)
 public OrderData createOrder() throws ApiException{
     OrderPojo orderPojo = new OrderPojo();
     return service.createOrder(orderPojo);
 }

 @ApiOperation(value = "gets all the orders placed")
 @RequestMapping(path = "/api/order",method = RequestMethod.GET)
 public List<OrderData> getAll() throws ApiException{
     return service.getAll();
 }

@ApiOperation(value = "gets an order with given id")
@RequestMapping(path = "/api/order/{id}",method = RequestMethod.GET)
public OrderData getOrderWithGivenId(@PathVariable int id) throws ApiException{
     return service.getOrder(id);
}

@ApiOperation(value = "gets an order with given random key")
@RequestMapping(path = "/api/order/useRandomKey/{randomKey}",method = RequestMethod.GET)
public OrderData getOrderWithGivenRandomKey(@PathVariable String randomKey) throws ApiException{
     return service.getOrder(randomKey);
}

}
