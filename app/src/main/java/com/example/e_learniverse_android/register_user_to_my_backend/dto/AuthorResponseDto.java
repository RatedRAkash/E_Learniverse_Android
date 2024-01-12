package com.example.e_learniverse_android.register_user_to_my_backend.dto;

import java.io.Serializable;

/**
 * Created by AnantaAkashPodder on 24/12/2023.
 */

public class AuthorResponseDto implements Serializable {

    //TODO: "AuthorDto" 3rd Party Api te jey Call dibi taar Response hisave Accept korbo...

    private Long id;

    private String name;

    private Integer age;

    public AuthorResponseDto() {

    }

    public AuthorResponseDto(Long id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "AuthorDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}