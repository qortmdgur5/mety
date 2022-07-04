package com.risingcraft.mety.controller;

import com.risingcraft.mety.controller.dto.auth.OrgSignupDto;
import com.risingcraft.mety.controller.dto.auth.UserSignupDto;
import com.risingcraft.mety.domain.organization.Organization;
import com.risingcraft.mety.domain.user.User;
import com.risingcraft.mety.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@Controller
public class AuthController {

    private final AuthService authService;

    @GetMapping("/auth/signin")
    public String signinForm() {
        return "auth/signin";
    }

    @GetMapping("/auth/signup")
    public String signupForm() {
        return "auth/signup";
    }

    @PostMapping("/auth/userSignup")
    public String userSingup(@Valid UserSignupDto userSignupDto, BindingResult bindingResult){

        User user = userSignupDto.toEntity();
        authService.유저회원가입(user);
        return "auth/signin";
    }

    @PostMapping("/auth/orgSignup")
    public String orgSingup(@Valid OrgSignupDto orgSignupDto, BindingResult bindingResult){

        Organization org = orgSignupDto.toEntity();
        authService.병원회원가입(org);
        return "auth/signin";
    }


}
