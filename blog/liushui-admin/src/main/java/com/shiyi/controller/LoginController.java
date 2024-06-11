package com.shiyi.controller;

import cn.dev33.satoken.stp.StpUtil;
import com.shiyi.annotation.AccessLimit;
import com.shiyi.common.ResponseResult;
import com.shiyi.dto.user.LoginDTO;
import com.shiyi.service.LoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author blue
 * @description:
 * @date 2021/7/30 14:37
 */
@RestController
@Api(tags = "登录-接口")
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;


    @AccessLimit
    @GetMapping("verify")
    @ApiOperation(value = "生成验证码")
    public ResponseResult verify() {
        return loginService.getCaptcha();
    }

    @PostMapping("login")
    public ResponseResult login(@Validated @RequestBody LoginDTO vo) {
        return loginService.login(vo);
    }

    @GetMapping("logout")
    public ResponseResult logout() {
        StpUtil.logout();
        return ResponseResult.success("退出成功");
    }
}
