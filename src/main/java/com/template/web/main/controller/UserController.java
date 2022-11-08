package com.template.web.main.controller;

import com.template.web.core.http.api.response.ApiCommonResponse;
import com.template.web.main.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    final UserService userService;

    @GetMapping
    public ResponseEntity<ApiCommonResponse> getUserDetail(@RequestParam String id) {
        return ResponseEntity.ok(userService.getUserDetail(id));
    }

}
