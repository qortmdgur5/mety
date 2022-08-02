package com.risingcraft.mety.controller.api.org;

import com.risingcraft.mety.config.auth.OrganizationDetails;
import com.risingcraft.mety.controller.dto.CMRespDto;
import com.risingcraft.mety.controller.dto.org.OrgUpdateDto;
import com.risingcraft.mety.domain.organization.Organization;
import com.risingcraft.mety.domain.user.User;
import com.risingcraft.mety.service.org.OrgService;
import com.risingcraft.mety.service.user.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
@Slf4j
public class OrgApiController {

    private final OrgService orgService;
    private final UserService userService;

    //병원 정보 수정
    @PutMapping("/api/org/{id}")
    public CMRespDto<?> update(@PathVariable int id, OrgUpdateDto orgUpdateDto, @AuthenticationPrincipal OrganizationDetails organizationDetails) {
        Organization orgEntity = orgService.기관정보수정(id, orgUpdateDto.toEntity());
        organizationDetails.setOrg(orgEntity);
        return new CMRespDto<>(1, "기관수정완료", orgEntity);
    }

    //가입신청한 환자 리스트 가져오기  가입대기하는 목록
    @GetMapping("/api/org/{id}/approve")
    public CMRespDto<?> userApproveList(@PathVariable int id, @AuthenticationPrincipal OrganizationDetails organizationDetails,
                                        @PageableDefault(size=10) Pageable pageable,@RequestParam(required = false, defaultValue = "") String nameText,@RequestParam(required = false, defaultValue = "") String medicalText) {
        Page<User> users = userService.환자신청리스트(organizationDetails.getOrg().getId(), pageable, nameText, medicalText);
        return new CMRespDto<>(1, "환자신청리스트 불러오기 성공", users);
    }

    //환자 가입신청 승인
    @PostMapping("/api/org/{id}/approve")
    public void approve(@PathVariable int id, @AuthenticationPrincipal OrganizationDetails organizationDetails) {
        userService.신청승인(id);
    }

    //승인된 환자 리스트 가져오기 환자목록
    @GetMapping("/api/org/{id}/userlist")
    public CMRespDto<?> userList(@PathVariable int id, @AuthenticationPrincipal OrganizationDetails organizationDetails,
                                 @PageableDefault(size=10) Pageable pageable,@RequestParam(required = false, defaultValue = "") String searchText,@RequestParam(required = false, defaultValue = "") String medicalText) {
        Page<User> users = userService.환자리스트(organizationDetails.getOrg().getId(), pageable, searchText, medicalText);
        return new CMRespDto<>(1, "승인된 환자리스트 불러오기 성공", users);
    }


    //환자 치료 활성화
    @PostMapping("/api/org/{id}/activate")
    public void activate(@PathVariable int id, @AuthenticationPrincipal OrganizationDetails organizationDetails) {
        userService.환자활성화(id);
    }

    //환자 치료 비활성화
    @PostMapping("/api/org/{id}/unActivate")
    public void unActivate(@PathVariable int id, @AuthenticationPrincipal OrganizationDetails organizationDetails) {
        userService.환자비활성화(id);
    }
}