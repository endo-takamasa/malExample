package com.mal.example.mal.t.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mal.example.mal.t.service.MalSUiService;
import com.mal.example.mal.t.service.dto.U_ser;

@RestController
public class MalSUiController {

    @Autowired
    MalSUiService malSUiService;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<U_ser> getUserList() { 
      System.out.println("users");
      // kobetu
      List<U_ser> outDto = malSUiService.getUserListService();
      // kyoutuu
      List<U_ser> outDto = malSUiService.getUserListService();
      return outDto;
    }
    
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public U_ser getUser(@PathVariable("id") int id) { 
      System.out.println("users/" + id);
      U_ser outDto = malSUiService.getUserService(id);
      return outDto;
    }
    
    @RequestMapping(value = "/editUser", method = RequestMethod.PUT)
    public void saveUserInfo(@ModelAttribute @Validated U_ser user, BindingResult result) throws Exception { 
      System.out.println("editUser");
      malSUiService.saveUserInfo(user);
      Thread.sleep(5000);
    }
}
