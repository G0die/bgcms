package edu.bgcms.controller.permission;


import edu.bgcms.dao.PermissionMapper;
import edu.bgcms.dao.RoleMapper;
import edu.bgcms.dao.RolePermissionMapper;
import edu.bgcms.dto.AjaxMsg;
import edu.bgcms.dto.PermissionDto;
import edu.bgcms.model.shiro.Permission;
import edu.bgcms.model.shiro.Role;
import edu.bgcms.model.shiro.RolePermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/permission")
public class PermissionController {
    @Autowired
    RoleMapper roleMapper;

    @Autowired
    PermissionMapper permissionMapper;
    @Autowired
    RolePermissionMapper rolePermissionMapper;

    @RequestMapping("/rolerList")
    public String toIndex() {
        return "/permission/rolerList";
    }

    @ResponseBody
    @RequestMapping("/getRoleList")
    public AjaxMsg getRoleList() {
        AjaxMsg ajaxMsg = new AjaxMsg();
        List<Role> roles = new ArrayList<>();
        try{
            roles  = roleMapper.getAllRole();
        }catch (Exception e){
            e.printStackTrace();
            ajaxMsg.setStatus(0);
            ajaxMsg.setMsg("获取角色列表失败");
            return ajaxMsg;
        }
        ajaxMsg.setStatus(1);
        ajaxMsg.setData(roles);
        return ajaxMsg;
    }


    @ResponseBody
    @RequestMapping("/getPermissionListByRole")
    public AjaxMsg getPermissionListByRole(String roleId) {
        AjaxMsg ajaxMsg = new AjaxMsg();
        List<PermissionDto> permissions = new ArrayList<>();
        try{
            permissions  = permissionMapper.selectByRole(roleId);
        }catch (Exception e){
            e.printStackTrace();
            ajaxMsg.setStatus(0);
            ajaxMsg.setMsg("获取权限列表失败");
            return ajaxMsg;
        }
        ajaxMsg.setStatus(1);
        ajaxMsg.setData(permissions);
        return ajaxMsg;
    }

    @ResponseBody
    @RequestMapping("/getAllPermissionList")
    public List<Permission> getAllPermissionList() {
        List<Permission> permissions = permissionMapper.getAllPermissionList();
        return permissions;
    }

    /**
     * 添加角色和权限关联
     * @return
     */
    @ResponseBody
    @RequestMapping("/addRP")
    public AjaxMsg addRP(RolePermission rp) {
        AjaxMsg ajaxMsg = new AjaxMsg();
        try{
            rolePermissionMapper.insert(rp);
        }catch (Exception e){
            e.printStackTrace();
            ajaxMsg.setStatus(0);
            ajaxMsg.setMsg("添加权限失败");
            return ajaxMsg;
        }
        ajaxMsg.setStatus(1);
        ajaxMsg.setMsg("添加权限成功");
        return ajaxMsg;
    }
    @ResponseBody
    @RequestMapping("/addRole")
    public AjaxMsg addRole(Role role) {
        AjaxMsg ajaxMsg = new AjaxMsg();
        try{
            roleMapper.insert(role);
        }catch (Exception e){
            e.printStackTrace();
            ajaxMsg.setStatus(0);
            ajaxMsg.setMsg("添加角色失败");
            return ajaxMsg;
        }
        ajaxMsg.setStatus(1);
        ajaxMsg.setMsg("添加角色成功");
        return ajaxMsg;
    }


    @ResponseBody
    @RequestMapping("/delRole")
    public AjaxMsg delRole(int roleId) {
        AjaxMsg ajaxMsg = new AjaxMsg();
        try{
            rolePermissionMapper.deleteByRoleId(roleId);
            roleMapper.deleteByPrimaryKey(roleId);
        }catch (Exception e){
            e.printStackTrace();
            ajaxMsg.setStatus(0);
            ajaxMsg.setMsg("删除角色失败");
            return ajaxMsg;
        }
        ajaxMsg.setStatus(1);
        ajaxMsg.setMsg("删除角色成功");
        return ajaxMsg;
    }
    @ResponseBody
    @RequestMapping("/delRP")
    public AjaxMsg delRp(int rpId) {
        AjaxMsg ajaxMsg = new AjaxMsg();
        try{
            rolePermissionMapper.deleteByPrimaryKey(rpId);
        }catch (Exception e){
            e.printStackTrace();
            ajaxMsg.setStatus(0);
            ajaxMsg.setMsg("取消授权失败");
            return ajaxMsg;
        }
        ajaxMsg.setStatus(1);
        ajaxMsg.setMsg("取消授权成功");
        return ajaxMsg;
    }
}
