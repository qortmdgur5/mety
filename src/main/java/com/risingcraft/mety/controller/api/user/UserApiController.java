package com.risingcraft.mety.controller.api.user;

import com.risingcraft.mety.config.auth.PrincipalDetails;
import com.risingcraft.mety.controller.dto.CMRespDto;
import com.risingcraft.mety.controller.dto.user.UserUpdateDto;
import com.risingcraft.mety.domain.data.Data;
import com.risingcraft.mety.domain.user.User;
import com.risingcraft.mety.service.data.DataService;
import com.risingcraft.mety.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class UserApiController {

    private final UserService userService;
    private final DataService dataService;

    @PutMapping("/api/user/{id}")
    public CMRespDto<?> update(@PathVariable int id, UserUpdateDto userUpdateDto, @AuthenticationPrincipal PrincipalDetails principalDetails) {
        User userEntity = userService.회원수정(id, userUpdateDto.toEntity());
        principalDetails.setUser(userEntity);
        return new CMRespDto<>(1, "회원수정완료", userEntity);
    }

    @GetMapping("/api/user/{id}/myRecord")
    public CMRespDto<?> myRecord(@PathVariable int id, @AuthenticationPrincipal PrincipalDetails principalDetails) {
        List<Data> data = dataService.마이기록(id);
        return new CMRespDto<>(1,"마이기록 가져오기 성공", data);
    }
}
