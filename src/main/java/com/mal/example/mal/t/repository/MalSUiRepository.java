package com.mal.example.mal.t.repository;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.mal.example.mal.t.service.dto.U_ser;

@Repository
public class MalSUiRepository {

    /**
     * ユーザ情報を取得する
     * @return ユーザ情報
     */
    public List<U_ser> getUserList_csv(int id) {
        List<U_ser> users = new ArrayList<U_ser>();
        BufferedReader br = null;
        try {
            ClassLoader classLoader = getClass().getClassLoader();
            InputStream inputStream = classLoader.getResourceAsStream("file/db_dummy.csv");
            if (inputStream == null) {
                throw new FileNotFoundException("db_dummy.csv が見つかりません");
            }
            br = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            String[] data;
            br.readLine();
            while ((line = br.readLine()) != null) {
                data = line.split(",");
                U_ser user = new U_ser();
                int data_id = Integer.parseInt(data[0]);
                user.setId(data_id);
                user.setName(data[1]);
                user.setEmail(data[2]);
                if (id == 0) {
                    users.add(user);
                } else if (id == data_id) {
                    users.add(user);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                br.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return users;
    }

    /***
     * ユーザ情報を保存する
     * @param user
     */
    public void saveUserInfo(U_ser user) {
        List<U_ser> users = new ArrayList<>();
        BufferedReader br = null;
        BufferedWriter bw = null;
        System.out.println("かえるくさ");
        System.out.println(user.getId());
        System.out.println(user.getName());
        System.out.println(user.getEmail());
        System.out.println("かえるくさ");
        try {
            // CSVファイルの読み込み
            ClassLoader classLoader = getClass().getClassLoader();
            InputStream inputStream = classLoader.getResourceAsStream("file/db_dummy.csv");
            URL resource = classLoader.getResource("file/db_dummy.csv");
            String filePath = resource.getPath();
            System.out.println(filePath);
            if (inputStream == null) {
                throw new FileNotFoundException("db_dummy.csv が見つかりません");
            }

            br = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            String[] data;

            // 1行目（ヘッダー）をスキップ
            String header = br.readLine();

            while ((line = br.readLine()) != null) {
                data = line.split(",");
                U_ser oldUser = new U_ser();
                int id = Integer.parseInt(data[0]);
                oldUser.setId(id);

                // 更新対象のユーザー情報を変更
                if (id == user.getId()) {
                    oldUser.setName(user.getName());
                    oldUser.setEmail(user.getEmail());
                } else {
                    oldUser.setName(data[1]);
                    oldUser.setEmail(data[2]);
                }
                users.add(oldUser);
            }

            // CSVファイルへの書き込み準備
            File outputFile = new File(filePath);
            bw = new BufferedWriter(new FileWriter(outputFile));

            // ヘッダーを書き込む
            bw.write(header);
            bw.newLine();

            // ユーザーデータを書き込む
            for (U_ser u : users) {
                bw.write(u.getId() + "," + u.getName() + "," + u.getEmail());
                bw.newLine();
            }

            System.out.println("CSVファイルが更新されました");

        } catch (Exception e) {
            System.out.println("エラー: " + e.getMessage());
        } finally {
            try {
                if (br != null) br.close();
                if (bw != null) bw.close();
            } catch (Exception e) {
                System.out.println("エラー: " + e.getMessage());
            }
        }
    }
}

