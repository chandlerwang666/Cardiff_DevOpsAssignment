package com.example.g6clientproject.controller;

import com.example.g6clientproject.form.AddUserForm;
import com.example.g6clientproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    private UserRepository userRepo;

    @Autowired
    public UserController(UserRepository uRepo) {
        userRepo = uRepo;
    }

    // this method will search for a name in the database
    @RequestMapping(path = "/User", method = RequestMethod.GET)
    public ModelAndView search(@RequestParam(value = "email", defaultValue = "null") String emailString) {
        ModelAndView mav = new ModelAndView();
        mav.addObject(userRepo.findUserByEmail(emailString));
        mav.setViewName("A" + "userInfo");
        return mav;
    }
    // this method will add items to the database
    @RequestMapping(path = "/User", method = RequestMethod.POST)
    public ModelAndView addUser(AddUserForm addUserForm, BindingResult br) {
        ModelAndView mav = new ModelAndView();
        if (br.hasErrors()) {
            mav.setViewName("Login");
        } else {
            if (userRepo.addUser(addUserForm)) {
                System.out.println("added User");
                mav.addObject("user", userRepo.findAllUser());
                mav.setViewName("userInfo");
            } else {
                mav.setViewName("Home");
            }
        }
        return mav;
    }
    // this method will search for a specific item in the database
    @RequestMapping(path = "/UserInfo", method = RequestMethod.GET)
    public ModelAndView search() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("user", userRepo.findAllUser());
        mav.setViewName("userInfo");
        return mav;
    }
}
