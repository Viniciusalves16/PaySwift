package com.api.PaySwift.dto;


import com.api.PaySwift.enumeration.RoleEnum;

public record RegisterLoginDto(String login, String password, RoleEnum role) {


}
