package com.tanzi.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.tanzi.ssm.domain.Orders;
import com.tanzi.ssm.service.IOderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private IOderService iOderService;
    @RequestMapping("findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page",required = true,defaultValue = "1") int page,@RequestParam(name="size",required = true,defaultValue = "4")int size) throws Exception{
        ModelAndView mv= new ModelAndView();
        List<Orders> ordersList = iOderService.findAll(page,size);
        PageInfo pageInfo =new PageInfo(ordersList);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("orders-page-list");
        return mv;
        }
//    @Autowired
//    private IOderService iOderService;
//    @RequestMapping("findAll.do")
//    public ModelAndView findAll() throws Exception{
//        ModelAndView mv= new ModelAndView();
//        List<Orders> ordersList = iOderService.findAll();
//        mv.addObject("ordersList",ordersList);
//        mv.setViewName("orders-list");
//        return mv;
//    }


    @RequestMapping("/findById.do")
    public ModelAndView findById(@RequestParam(name = "id",required = true) Integer ordersId) throws Exception {
        ModelAndView mv= new ModelAndView();
        Orders orders = iOderService.findById(ordersId);
        mv.addObject("orders",orders);
        mv.setViewName("orders-show");
        return mv;

    }
}
