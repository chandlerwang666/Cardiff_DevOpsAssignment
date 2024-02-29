package com.example.g6clientproject.controller;

import com.example.g6clientproject.form.AddSoftwareForm;
import com.example.g6clientproject.message.ResponseMessage;
import com.example.g6clientproject.repository.SoftwareRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SoftwareController {

    private SoftwareRepository softwareRepo;

    @Autowired
    public SoftwareController(SoftwareRepository sRepo) {
        softwareRepo = sRepo;
    }


//     Model and view to search all software by employees name
//    @RequestMapping(path = "/SoftwareTable", method = RequestMethod.GET)
//    public ModelAndView search(@RequestParam(value = "name", defaultValue = "null") String nameString) {
//        ModelAndView mav = new ModelAndView();
//        mav.addObject(softwareRepo.findSoftwareByName(nameString));
//        mav.setViewName("SoftwareTable"); // template name
//        return mav;
//    }

    @RequestMapping(path = "/Software", method = RequestMethod.GET)
    public ModelAndView search() {
        ModelAndView mav = new ModelAndView();
        System.out.println("test");
        mav.addObject("Software", softwareRepo.findAllSoftware());
        mav.setViewName("index");
        return mav;
    }


    // Model and view add software
    @RequestMapping(path = "/Software", method = RequestMethod.POST)
    public ModelAndView addSoftware(AddSoftwareForm addSoftwareForm, BindingResult br) {
        ModelAndView mav = new ModelAndView();
        if (br.hasErrors()) {
            mav.setViewName("Login"); // template name
        } else {
            if (softwareRepo.addSoftware(addSoftwareForm)) {
                System.out.println("added software");
                mav.addObject("software", softwareRepo.findAllSoftware());
                mav.setViewName("AllSoftwareDetails");
            } else {
                mav.setViewName("Home");
            }
        }
        return mav;
    }

    // Model and view searching for all software
    @RequestMapping(path = "/SoftwareTable", method = RequestMethod.GET)
    public ModelAndView searchAll() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("softwares", softwareRepo.findAllSoftware());
        System.out.println(softwareRepo.findAllSoftware());
        mav.setViewName("SoftwareTable"); // template name
        return mav;
    }

    @RequestMapping(path = "/Welcome", method = RequestMethod.GET)
    public ModelAndView welcomeAdmin() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("softwares", softwareRepo.findAllSoftware());
        System.out.println(softwareRepo.findAllSoftware());
        mav.setViewName("SoftwareTable"); // template name
        return mav;
    }

    @RequestMapping(path = "/WelcomeSuper", method = RequestMethod.GET)
    public ModelAndView welcomeSuper() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("softwares", softwareRepo.findAllSoftware());
        System.out.println(softwareRepo.findAllSoftware());
        mav.setViewName("SoftwareTable"); // template name
        return mav;
    }

    //this method will delete software item in the database by id
    @RequestMapping(path = "/SoftwareDelete", method = RequestMethod.POST)
    public ResponseEntity<ResponseMessage> deleteSoftware(@RequestParam int id
    ) {
        try {
            softwareRepo.deleteSoftwareByid(id);
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage("Delete successfully"));
        } catch (Exception ex){
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage("Delete fails!"));
        }
    }

    //this method will update software item in the database
    @RequestMapping(path = "/SoftwareUpdate", method = RequestMethod.POST)
    public ResponseEntity<ResponseMessage> updateSoftware(@RequestParam int id,
                                                          @RequestParam String employee,
                                                          @RequestParam String software,
                                                          @RequestParam String availability,
                                                          @RequestParam String renewal

    ) {
        try {
            softwareRepo.updateSoftware(id, employee, software, availability, renewal);
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage("Update is success"));
        } catch (Exception ex){
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage("Update fails!"));
        }
    }

    @RequestMapping(path = "/SoftwareCreate", method = RequestMethod.GET)
    public ModelAndView create() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("hardware", softwareRepo.findAllSoftware());
        mav.setViewName("SoftwareCreateForm");
        return mav;
    }

    //this method will create software item in the database
    @RequestMapping(path = "/SoftwareCreate", method = RequestMethod.POST)
    public ResponseEntity<ResponseMessage> createSoftware(@RequestParam String employee,
                                                          @RequestParam String software,
                                                          @RequestParam String available,
                                                          @RequestParam String renewal

    ) {
        try {
            softwareRepo.createSoftware(employee, software, available, renewal);
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage("Update was successful"));
        } catch (Exception ex){
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(ex.getMessage()));
        }
    }
}





