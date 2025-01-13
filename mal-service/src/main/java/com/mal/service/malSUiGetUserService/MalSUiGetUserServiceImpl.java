package com.mal.service.malSUiGetUserService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mal.repository.user.UserInfoRepository;
import com.mal.repository.user.entity.UserEntry;
import com.mal.service.malSUiGetUserService.model.GetUserModelRequest;
import com.mal.service.malSUiGetUserService.model.GetUserModelResponse;

@Service
public class MalSUiGetUserServiceImpl implements MalSUiGetUserService {

    @Autowired
    UserInfoRepository userInfoRepository;

    @Override
    public List<GetUserModelResponse> getUserListService() {
        List<UserEntry> userEntryList = userInfoRepository.getUserList();
        List<GetUserModelResponse> listUser = new ArrayList<GetUserModelResponse>();

        for (UserEntry userEntry : userEntryList) {
            GetUserModelResponse getUserModelResponse = new GetUserModelResponse();
            getUserModelResponse.setId(userEntry.getId());
            getUserModelResponse.setName(userEntry.getName());
            getUserModelResponse.setEmail(userEntry.getEmail());
            listUser.add(getUserModelResponse);
        }
        return listUser;
    }

    @Override
    public GetUserModelResponse getUserService(int id) {
        // UserEntry userEntry = userInfoRepository.getUser(id);
        GetUserModelResponse getUserModelResponse = new GetUserModelResponse();
        // getUserModelResponse.setId(userEntry.getId());
        // getUserModelResponse.setName(userEntry.getName());
        // getUserModelResponse.setEmail(userEntry.getEmail());
        return getUserModelResponse;
    }

    @Override
    public void saveUserInfo(GetUserModelRequest getUserModelRequest) {
        // UserEntry userEntry = new UserEntry();
        // userInfoRepository.saveUserInfo(userEntry);
    }
}
