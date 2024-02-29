package com.example.g6clientproject.controller;


import com.example.g6clientproject.form.AddHardwareForm;
import com.example.g6clientproject.message.ResponseMessage;
import com.example.g6clientproject.repository.HardwareRepository;
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
public class HardwareController {

    private HardwareRepository hardwareRepo;

    @Autowired
    public HardwareController(HardwareRepository hRepo) {
        hardwareRepo = hRepo;
    }

    // this method will search for a name in the databse
    @RequestMapping(path = "/Hardware", method = RequestMethod.GET)
    public ModelAndView search(@RequestParam(value = "name", defaultValue = "null") String nameString) {
        ModelAndView mav = new ModelAndView();
        mav.addObject(hardwareRepo.findHardwareByName(nameString));
        mav.setViewName("A" + "HardwareTable");
        return mav;
    }
    // this method will add items to the database
    @RequestMapping(path = "/Hardware", method = RequestMethod.POST)
    public ModelAndView addHardware(AddHardwareForm addHardwareForm, BindingResult br) {
        ModelAndView mav = new ModelAndView();
        if (br.hasErrors()) {
            mav.setViewName("Login");
        } else {
            if (hardwareRepo.addHardware(addHardwareForm)) {
                System.out.println("added Hardware");
                mav.addObject("Hardware", hardwareRepo.findAllHardware());
                mav.setViewName("AllHardwareDetails");
            } else {
                mav.setViewName("Home");
            }
        }
        return mav;
    }
    // this method will search for a specific item in the database
    @RequestMapping(path = "/HardwareView", method = RequestMethod.GET)
    public ModelAndView search() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("hardware", hardwareRepo.findAllHardware());
        mav.setViewName("HardwareTable");
        return mav;
    }

    //this method will delete hardware item in the database by id
    @RequestMapping(path = "/HardwareDelete", method = RequestMethod.POST)
    public ResponseEntity<ResponseMessage> deleteHardware(@RequestParam int id
    ) {
        try {
            hardwareRepo.deleteHardwareByid(id);
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage("Delete successfully"));
        } catch (Exception ex){
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage("Delete fails!"));
        }
    }

    //this method will update hardware item in the database
    @RequestMapping(path = "/HardwareUpdate", method = RequestMethod.POST)
    public ResponseEntity<ResponseMessage> updateHardware(@RequestParam int id,
                                                            @RequestParam String name,
                                                            @RequestParam String hardware,
                                                            @RequestParam String availability,
                                                            @RequestParam String checkin
    ) {
        try {
            hardwareRepo.updateHardware(id, name, hardware, availability, checkin);
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage("Update is success"));
        } catch (Exception ex){
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage("Update fails!"));
        }
    }

    @RequestMapping(path = "/HardwareCreate", method = RequestMethod.GET)
    public ModelAndView create() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("hardware", hardwareRepo.findAllHardware());
        mav.setViewName("HardwareCreateForm");
        return mav;
    }

    //this method will create hardware item in the database
    @RequestMapping(path = "/HardwareCreate", method = RequestMethod.POST)
    public ResponseEntity<ResponseMessage> createAssetTable(@RequestParam String name,
                                                            @RequestParam String hardware,
                                                            @RequestParam String availability,
                                                            @RequestParam String checkin
    ) {
        try {
            hardwareRepo.createHardware(name, hardware, availability, checkin);
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage("Update is success"));
        } catch (Exception ex){
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage("Update fails!"));
        }
    }
}
