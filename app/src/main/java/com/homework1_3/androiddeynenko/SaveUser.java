package com.homework1_3.androiddeynenko;

import java.util.ArrayList;

public class SaveUser {

    ArrayList<SaveUser> saveUsers = new ArrayList<>();

    private String name;
    private int age;

    public SaveUser(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void saveNewUser(SaveUser saveUser){
        saveUsers.add(saveUser);
    }
}
