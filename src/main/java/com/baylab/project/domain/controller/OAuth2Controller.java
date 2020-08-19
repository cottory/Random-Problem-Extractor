package com.baylab.project.domain.controller;

import com.baylab.project.domain.service.KakaoApiService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.HashMap;

@Controller
public class OAuth2Controller {

    @Resource
    private KakaoApiService kakaoApiService;

    @RequestMapping(value="/")
    public String index() {
        return "home";
    }

    @RequestMapping(value="/login")
    public String login(@RequestParam("code") String code) {
        try {
            System.out.println("code : " + code);
            final String access_Token = kakaoApiService.getAccessToken(code);
            System.out.println("controller access_token : " + access_Token);

            HashMap<String, Object> userInfo = kakaoApiService.getUserInfo(access_Token);

            System.out.println("login Controller : " + userInfo);

            return "home";
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "loginFailure";
    }

}
