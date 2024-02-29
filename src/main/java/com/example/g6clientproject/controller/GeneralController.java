package com.example.g6clientproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GeneralController {
    @RequestMapping(path = "/Home")
    public ModelAndView login() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("Login");
        return mav;
    }

    @RequestMapping(path = "/WelcomeSuper")
    public String welcomeSuper() {
        return "SoftwareTable";
    }

    @RequestMapping(path = "/CommentsPage")
    public String commentsPage() {
        return "comments";
    }

    @RequestMapping(path = "/Profile")
    public String profilePage() {
        return "profile";
    }

    @RequestMapping(path = "/UserInfo")
    public String userInfoPage() {
        return "userInfo";
    }

    // @RequestMapping(path = "/Super")
    // public String superHomePage() {return "index";}

    @RequestMapping(path = "/Welcome")
    public String welcomeAdmin() {
        return "SoftwareTable";
    }

    @RequestMapping(path = "/")
    public String firstPage() {
        return "initialPage";
    }

    @RequestMapping(path = "/SuperUser")
    public String superUser() {
        return "userInfo";
    }

    //@RequestMapping(path = "/HardwareView")
    // public String hardwareView() {
    // return "hardwareTable";
    // }
}
/*
    @RequestMapping (path="/Home")
    public ModelAndView home(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("Home");
        return mav;
    }

    @RequestMapping(path="/Site/SearchAsset", method = RequestMethod.GET)
    public ModelAndView assetSearch(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("AssetSearchForm");
        return mav;
    }
    @RequestMapping(path="/Site/AddAsset", method = RequestMethod.GET)
    public ModelAndView addAsset(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("AddAssetForm");
        return mav;
    }
}
 */
