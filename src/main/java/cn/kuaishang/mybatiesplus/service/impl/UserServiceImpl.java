package cn.kuaishang.mybatiesplus.service.impl;

import cn.kuaishang.mybatiesplus.entity.User;
import cn.kuaishang.mybatiesplus.mapper.UserMapper;
import cn.kuaishang.mybatiesplus.service.UserService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public Page<User> findAllUser(User user) {
        Page<User> page = new Page<>();
        LambdaQueryWrapper<User> lambda = new LambdaQueryWrapper<>();
        lambda.eq(Objects.nonNull(user.getAge()),User::getAge,user.getAge())
                .eq(User::getEmail,user.getEmail())
                .likeRight(Objects.nonNull(user.getName()),User::getName,user.getName());
        return baseMapper.findAll(page,lambda);
    }

    @Override
    public Page<User> pageAllUser(int curPage, int pageSize) {
        Page<User> userPage = new Page<>(curPage,pageSize);
        return baseMapper.selectPage(userPage,new QueryWrapper<User>());
    }
}
