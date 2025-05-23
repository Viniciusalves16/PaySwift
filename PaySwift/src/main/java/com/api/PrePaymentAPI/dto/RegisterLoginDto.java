package com.api.PrePaymentAPI.dto;


import com.api.PrePaymentAPI.enumeration.RoleEnum;

public record RegisterLoginDto(String login, String password, RoleEnum role) {


}
