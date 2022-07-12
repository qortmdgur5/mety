package com.risingcraft.mety.controller.org;

import com.risingcraft.mety.config.auth.OrganizationDetails;
import com.risingcraft.mety.config.auth.PrincipalDetails;
import com.risingcraft.mety.controller.dto.auth.OrgSignupDto;
import com.risingcraft.mety.domain.organization.Organization;
import com.risingcraft.mety.domain.organization.OrganizationRepository;
import com.risingcraft.mety.service.AuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@RequiredArgsConstructor
@Controller
@Slf4j
public class OrgController {

    private final AuthService authService;
    private final OrganizationRepository organizationRepository;

    @GetMapping("/org/login")
    public String orgLoginForm() {
        return "org/login";
    }

    @GetMapping("/org/signup")
    public String orgSignupForm() {
        return "org/signup";
    }

    @PostMapping("/org/signup")
    public String orgSingup(@Valid OrgSignupDto orgSignupDto, BindingResult bindingResult){
        Organization org = orgSignupDto.toEntity();
        authService.병원회원가입(org);
        return "org/login";
    }

    //기관 메인페이지 진입
    @GetMapping("/org/main")
    public String main() {
        System.out.println("기관 메인페이지 진입");
        return "org/main";
    }

    //기관 프로필 페이지 진입
    @GetMapping("/org/{id}")
    public String orgProfile(@PathVariable int id , @AuthenticationPrincipal OrganizationDetails organizationDetails) {
        organizationRepository.findById(id).orElseThrow(()->new IllegalArgumentException("해당 사용자가 아닙니다."));
        log.info("orgprofile={}", organizationDetails.getOrg());
        return "org/profile";
    }
}
