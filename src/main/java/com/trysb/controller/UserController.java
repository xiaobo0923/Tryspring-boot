package com.trysb.controller;

import com.trysb.vo.ResultVO;
import com.trysb.vo.User;
import com.trysb.vo.User2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/User")
public class UserController {
    @Autowired
    private User2 user;

    @RequestMapping("/getUser")
    public ResultVO getUser(){
        User u = new User();
        u.setAge("18");
        u.setId("123");
        u.setUserName("22222");
        u.setPassword("");
        u.setBirthday(new Date());
        return ResultVO.valueOfSuccess(u,true);
    }

    @RequestMapping("/getUserResource")
    public ResultVO getUserResource(){
        User u = new User();
        return ResultVO.valueOfSuccess(user.getUserName(),true);
    }
}
