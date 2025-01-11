package com.mal.example.mal.t.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mal.example.mal.t.repository.MalSUiRepository;
import com.mal.example.mal.t.service.MalSUiService;
import com.mal.example.mal.t.service.dto.U_ser;

@Service
public class MalSUiServiceImpl implements MalSUiService{

	@Autowired
    MalSUiRepository malSUiRepository;

	@Override
	public List<U_ser> getUserListService() {
		List<U_ser> listUser = malSUiRepository.getUserList_csv(0);
		return listUser;
	}
	@Override
	public U_ser getUserService(int id) {
		List<U_ser> listUser = malSUiRepository.getUserList_csv(id);
		return listUser.get(0);
	}

	@Override
	public void saveUserInfo(U_ser user) {
		malSUiRepository.saveUserInfo(user);
	}
}
