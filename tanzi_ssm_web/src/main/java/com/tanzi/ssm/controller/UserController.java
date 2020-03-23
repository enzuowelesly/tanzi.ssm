package com.tanzi.ssm.controller;

import com.tanzi.ssm.domain.Role;
import com.tanzi.ssm.domain.UserInfo;
import com.tanzi.ssm.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService iUserService;
    @RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception {
        ModelAndView mv=new ModelAndView();
         List<UserInfo> userInfoList =iUserService.findAll();
         mv.addObject("userList",userInfoList);
         mv.setViewName("user-list");
        return mv;
    }
    @RequestMapping("/save.do")
    public String save(UserInfo userInfo) throws  Exception{
        iUserService.save(userInfo);
        return "redirect:findAll.do";
    }
    @RequestMapping("/findById.do")
    public ModelAndView findById (Integer id ) throws Exception{
        ModelAndView mv=new ModelAndView();
        UserInfo userInfo = iUserService.findById(id);
        mv.addObject("user",userInfo);
        mv.setViewName("user-show");
        return mv;
    }
    @RequestMapping("/findUserByIdAndAllRole.do")
    public ModelAndView findUserByIdAndAllRole(@RequestParam(name = "id",required = true) Integer userId) throws  Exception{
        ModelAndView mv =new ModelAndView();
        UserInfo userInfo=iUserService.findById(userId);
        List<Role>  ortherRoles =iUserService.findOtherRoles(userId);
        mv.addObject("user",userInfo);
        mv.addObject("roleList",ortherRoles);
        mv.setViewName("user-role-add");
        return mv;
    }
    @RequestMapping("/addRoleToUser.do")
    public String addRoleToUser(@RequestParam(name = "userId") Integer userId, @RequestParam(name = "ids") Integer[] roleIds) throws  Exception{
        iUserService.addRoleToUser(userId,roleIds);
        return "redirect:findAll.do";

    }
}
