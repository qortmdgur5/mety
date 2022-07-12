package com.risingcraft.mety.controller.api.user;

import com.risingcraft.mety.config.auth.PrincipalDetails;
import com.risingcraft.mety.controller.dto.CMRespDto;
import com.risingcraft.mety.controller.dto.user.UserUpdateDto;
import com.risingcraft.mety.domain.user.User;
import com.risingcraft.mety.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class UserApiController {

    private final UserService userService;

    @PutMapping("/api/user/{id}")
    public CMRespDto<?> update(@PathVariable int id, UserUpdateDto userUpdateDto, @AuthenticationPrincipal PrincipalDetails principalDetails) {
        User userEntity = userService.회원수정(id, userUpdateDto.toEntity());
        principalDetails.setUser(userEntity);
        return new CMRespDto<>(1, "회원수정완료", userEntity);

    }
}
