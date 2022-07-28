package com.xgrimau.storingpasswords.restapi;

import lombok.Data;
import lombok.Setter;
import org.springframework.lang.NonNull;


public class NewUserRequest {

    public String username;
    public String password;
}
