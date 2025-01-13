package com.mal.repository.user.entity;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserEntry {

    private int id;
    private String name;
    private String email;
    private List<UserEntry> userEntryList;

    public UserEntry(Integer id, String name, String email) {
        this.id = id;  // Integerをintに変換
        this.name = name;
        this.email = email;
    }

    public UserEntry() {
        // デフォルトコンストラクタ（MyBatisの自動マッピング用）
    }
}
