package com.shiyi.service;


import com.shiyi.common.ResponseResult;
import com.shiyi.dto.user.LoginDTO;

/**
 * @author blue
 * @description:
 * @date 2021/7/30 14:58
 */
public interface LoginService {

    /**
     * 登录
     * @param vo
     * @return
     */
    ResponseResult login(LoginDTO vo);

    /**
     * 生成随机验证码
     * @return
     */
    ResponseResult getCaptcha();
}
