package com.tanzi.ssm.controller;

import com.tanzi.ssm.domain.Permission;
import com.tanzi.ssm.domain.Role;
import com.tanzi.ssm.service.IRoleservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private IRoleservice roleservice;
    @RequestMapping("/save")
    public String save (Role role) throws Exception{
        roleservice.save(role);
        return "redirect:findAll.do";
    }

    @RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception{
        ModelAndView mv=new ModelAndView();
        List<Role> roleList=roleservice.findAll();
        mv.addObject("roleList",roleList);
        mv.setViewName("role-list");
        return mv;
    }
    @RequestMapping("/findRoleByIdAndAllPermission.do")
    public ModelAndView findRoleByIdAndAllPermission(@RequestParam(name = "id",required = true)Integer roleId)throws Exception{
       ModelAndView mv =new ModelAndView();
        Role role=roleservice.findById(roleId);
        List<Permission> ortherPsermissions = roleservice.findOrtherPermissions(roleId);
        mv.addObject("role" ,role);
        mv.addObject("permissionList",ortherPsermissions);
        mv.setViewName("role-permission-add");
        return mv;
    }
    @RequestMapping("/addPermissionToUser.do")
    public String addPermissionToUser(@RequestParam(name ="roleId" ,required = true)Integer roleId,@RequestParam(name = "ids",required = true)Integer[] permissionids)throws Exception{
        roleservice.addPermissionToRole(roleId,permissionids);
        return "redirect:findAll.do";

    }
}

