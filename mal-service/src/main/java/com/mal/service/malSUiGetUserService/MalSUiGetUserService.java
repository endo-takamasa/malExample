package com.mal.service.malSUiGetUserService;

import java.util.List;

import com.mal.service.malSUiGetUserService.model.GetUserModelRequest;
import com.mal.service.malSUiGetUserService.model.GetUserModelResponse;

public interface MalSUiGetUserService {

    public List<GetUserModelResponse> getUserListService();

    public GetUserModelResponse getUserService(int id);

    public void saveUserInfo(GetUserModelRequest userRequest);
}
