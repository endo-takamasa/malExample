package com.mal.example.mal.t.service;

import java.util.List;

import com.mal.example.mal.t.service.dto.U_ser;

public interface MalSUiService {
	public List<U_ser> getUserListService();
	public U_ser getUserService(int id);
	public void saveUserInfo(U_ser user);
}
