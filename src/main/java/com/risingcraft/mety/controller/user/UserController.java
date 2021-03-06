package com.risingcraft.mety.controller.user;

import com.risingcraft.mety.config.auth.PrincipalDetails;
import com.risingcraft.mety.controller.dto.auth.UserSignupDto;
import com.risingcraft.mety.domain.data.Data;
import com.risingcraft.mety.domain.data.DataRepository;
import com.risingcraft.mety.domain.user.User;
import com.risingcraft.mety.domain.user.UserRepository;
import com.risingcraft.mety.service.AuthService;
import com.risingcraft.mety.service.data.DataService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Supplier;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@RequiredArgsConstructor
@Controller
@Slf4j
public class UserController {

    private final AuthService authService;
    private final UserRepository userRepository;
    private final DataService dataService;

    //유저 로그인 페이지 진입
    @GetMapping("/user/login")
    public String userLoginForm() {
        return "user/login";
    }

    //유저 회원가입 페이지 진입
    @GetMapping("/user/signup")
    public String userSignupForm() {
        return "user/signup";
    }

    //유저 회원가입 진행
    @PostMapping("/user/signup")
    public String userSingup(@Valid UserSignupDto userSignupDto, BindingResult bindingResult){
        User user = userSignupDto.toEntity();
        authService.유저회원가입(user);
        authService.유저병원코드(user.getOrgName(), user.getId());
        return "user/login";
    }

    //유저 메인페이지 진입
    @GetMapping("/user/main")
    public String main() {
        System.out.println("유저 메인페이지 진입");
        return "user/main";
    }

    //로그아웃
    @PostMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }

    //유저 프로필 페이지 진입
    @GetMapping("/user/{id}")
    public String userProfile(@PathVariable int id ,@AuthenticationPrincipal PrincipalDetails principalDetails) {
        userRepository.findById(id).orElseThrow(()->new IllegalArgumentException("해당 사용자가 아닙니다."));
        return "user/profile";
    }

    //유저 프로필 변경 페이지 진입
    @GetMapping("/user/{id}/update")
    public String userUpdate(@PathVariable int id, @AuthenticationPrincipal PrincipalDetails principalDetails){
        return "user/update";
    }

    //유저 마이기록 페이지 진입
    @GetMapping("/user/{id}/myRecord")
    public String myRecord(@PathVariable int id, @AuthenticationPrincipal PrincipalDetails principalDetails) {
        System.out.println("유저 마이기록 페이지 진입");
        return "user/myRecord";
    }

}
