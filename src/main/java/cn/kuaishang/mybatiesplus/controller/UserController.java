package cn.kuaishang.mybatiesplus.controller;

import cn.kuaishang.mybatiesplus.entity.User;
import cn.kuaishang.mybatiesplus.form.PageUserForm;
import cn.kuaishang.mybatiesplus.form.UserRoleForm;
import cn.kuaishang.mybatiesplus.service.UserService;
import cn.kuaishang.mybatiesplus.service.impl.UserServiceImpl;
import cn.kuaishang.mybatiesplus.vo.ResultInfo;
import cn.kuaishang.mybatiesplus.vo.Status;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/findAllUser")
    public ResultInfo findAllUser(@RequestBody User user) {
        Page<User> allUser = userService.findAllUser(user);
        return new ResultInfo(Status.SUCCESS.code,allUser);
    }

    @RequestMapping("/pageAllUser")
    public ResultInfo pageAllUser(int curPage, int pageSize) {
        Page<User> allUser = userService.pageAllUser(curPage,pageSize);
        return new ResultInfo(Status.SUCCESS.code,allUser);
    }
    @RequestMapping("/listByUserAndRole")
    public ResultInfo listByUserAndRole(@RequestBody UserRoleForm userRoleForm) {
        List<User> allUser = userService.queryListByUserAndRole(userRoleForm);
        return new ResultInfo(Status.SUCCESS.code,allUser);
    }

    @RequestMapping("/pageFormByUserAndRole")
    public ResultInfo pageByUser(@RequestBody PageUserForm<User> userPageUserForm) {
        Page<User> allUser = userService.pageByUser(userPageUserForm);
        return new ResultInfo(Status.SUCCESS.code,allUser);
    }
}
