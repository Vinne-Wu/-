package com.khpc.cn.web.controller.admin;

import com.khpc.cn.core.entity.JsonResult;
import com.khpc.cn.web.model.bo.UserUpdateBo;
import com.khpc.cn.web.service.AdminService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Map;

/**
 * @author Vinne
 * @date 2020/1/16 23:32
 * @description  管理员功能处理类
 **/
@Controller
@RequestMapping("/admin")
public class AdminController {

    private static Logger logger = Logger.getLogger(AdminController.class);

    @Autowired
    private AdminService adminService;

    /**
     * 管理员首页
     * @return
     */
    @RequestMapping(value = "/adminIndex")
    public String adminIndex(){
        logger.info((new Date()).toString()+"管理员首页");
        return "admin/adminIndex";
    }

    /*********************************  辅助方法：页面布局路径 *********************************/

    /**
     *   左侧功能区模块页面
     */
    @RequestMapping("/skipNav")
    public String skipNav(){
        return "/admin/nav";
    }

    /*************************************  具体跳转页面  *************************************/
    /**
     *   首页模板页面
     */
    @RequestMapping("/skipIndex")
    public String skipIndex(){
        return "/admin/index";
    }

    /**
     *   表单模板页面
     */
    @RequestMapping("/skipForm")
    public String skipForm(){
        return "/admin/form";
    }

    /**
     *   表格模板页面
     */
    @RequestMapping("/skipTable")
    public String skipTable(){
        return "/admin/table";
    }

    /**
     * 个人信息页面
     */
    @RequestMapping("/skipUserInfo")
    public String skipUserInfo(){
        return "admin/userInfos";
    }

    /**
     *   修改密码页面
     */
    @RequestMapping("/skipPsd")
    public String skipPsd(){
        return "/register/modifyPsd";
    }

    /**
     *   指标方案页面
     */
    @RequestMapping("/skipAccount")
    public String skipAccount(){
        return "/admin/accountInfo";
    }


    /**
     *   考核方案审核
     */
    @RequestMapping("/skipExmPlan")
    public String skipExmPlan(){
        return "/admin/examPlan";
    }
    /**
     *   公共参数设置
     */
    @RequestMapping("/skipCommParas")
    public String skipCommParas(){
        return "/admin/comParas";
    }


    /**
     *  奖金分配
     */
    @RequestMapping("/skipBoa")
    public String skipBoa(){
        return "/admin/bonusAssgin";
    }

    /**
     *  数据统计
     */
    @RequestMapping("/skipDas")
    public String skipDas(){
        return "/admin/dataStatistics";
    }

    /*************************************  数据处理模块  *************************************/
    /**
     *  查询所有账户信息（管理员除外）
     * @return
     */
    @RequestMapping("/getAccountInfo")
    @ResponseBody
    public JsonResult<Map<String,Object>> getAccountInfo(){
        return adminService.getAccountInfo();
    }

    /**
     *  检索用户信息 -- 根据名称进行模糊检索
     * @param searchName
     * @return
     */
    @RequestMapping("/searchUser")
    @ResponseBody
    public JsonResult<Map<String,Object>> searchUser(String searchName){
        return  adminService.searchUserByName(searchName);
    }

    /**
     *  检索用户信息 -- 根据id（_id）查询
     * @param id
     * @return
     */
    @RequestMapping("/searchUserById")
    @ResponseBody
    public JsonResult<Map<String,Object>> searchUserById(String id){
        return adminService.searchUserById(id);
    }

    /**
     *  激活用户
     * @param updateBo
     * @return
     */
    @RequestMapping(value = "/activeUser")
    @ResponseBody
    public JsonResult<Map<String,Object>> activeUser(@RequestBody UserUpdateBo updateBo){
        return adminService.activeUser(updateBo);
    }

    /**
     * 账户停用或者启用操作
     * @param id
     * @param state
     * @return
     */
    @RequestMapping("/stopOrStartOperate")
    @ResponseBody
    public JsonResult<Map<String,Object>> stopOrStartOperate(String id,String state){
        return adminService.stopOrStartOperate(id,state);
    }

    /**
     *  检索考核方案
     * @param planName
     * @param khnf
     * @param khyf
     * @return
     */
    @RequestMapping("/searchPlans")
    @ResponseBody
    public JsonResult<Map<String,Object>> searchPlans(String planName,String khnf,String khyf){
        return adminService.searchPlans(planName,khnf,khyf);
    }

    /**
     *  通过或者拒绝方案申请
     * @param planName
     * @param khnf
     * @param khyf
     * @return
     */
    @RequestMapping("/passOrRefuse")
    @ResponseBody
    public JsonResult<Map<String,Object>> passOrRefuse(String planName,String departName,String khnf,String khyf,String code){
        return adminService.passOrRefuse(planName,departName,khnf,khyf,code);
    }
}
