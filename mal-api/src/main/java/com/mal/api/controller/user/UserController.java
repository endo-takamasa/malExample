package com.mal.api.controller.user;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mal.api.controller.user.payload.UserResponse;
import com.mal.service.malSUiGetUserService.MalSUiGetUserService;
import com.mal.service.malSUiGetUserService.model.GetUserModelResponse;

@RestController
public class UserController {

    @Autowired
    MalSUiGetUserService malSUiGetUserService;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<UserResponse> getUserList() {
        System.out.println("/users start");
        System.out.println(LocalDateTime.now());
        List<GetUserModelResponse> getUserModelRequest = malSUiGetUserService.getUserListService();
        List<UserResponse> outDto = new ArrayList<UserResponse>();
        for (GetUserModelResponse getUserModelResponse : getUserModelRequest) {
            UserResponse userResponse = new UserResponse();
            userResponse.setId(getUserModelResponse.getId());
            userResponse.setName(getUserModelResponse.getName());
            userResponse.setEmail(getUserModelResponse.getEmail());
            outDto.add(userResponse);
            System.out.println(userResponse.getId());
            System.out.println(userResponse.getName());
            System.out.println(userResponse.getEmail());
            System.out.println("/users end");
        }
        return outDto;
    }

    // @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    // public UserResponse getUser(@PathVariable("id") int id) {
    //     System.out.println("users/" + id);
    //     GetUserModelResponse getUserModelRequest = malSUiGetUserService.getUserService(id);
    //     UserResponse userResponse = new UserResponse();
    //     userResponse.setId(getUserModelRequest.getId());
    //     userResponse.setName(getUserModelRequest.getName());
    //     userResponse.setEmail(getUserModelRequest.getEmail());
    //     return userResponse;
    // }
    // @RequestMapping(value = "/editUser", method = RequestMethod.PUT)
    // public void saveUserInfo(
    //         @ModelAttribute @Validated UserRequest userRequest, BindingResult result) throws Exception {
    //     System.out.println("editUser");
    //     GetUserModelRequest getUserModelRequest = new GetUserModelRequest();
    //     getUserModelRequest.setId(userRequest.getId());
    //     getUserModelRequest.setName(userRequest.getName());
    //     getUserModelRequest.setEmail(userRequest.getEmail());
    //     malSUiGetUserService.saveUserInfo(getUserModelRequest);
    //     Thread.sleep(5000);
    // }
}
