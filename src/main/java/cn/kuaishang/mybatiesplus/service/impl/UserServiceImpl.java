package cn.kuaishang.mybatiesplus.service.impl;

import cn.kuaishang.mybatiesplus.entity.User;
import cn.kuaishang.mybatiesplus.form.PageUserForm;
import cn.kuaishang.mybatiesplus.form.UserRoleForm;
import cn.kuaishang.mybatiesplus.mapper.UserMapper;
import cn.kuaishang.mybatiesplus.service.UserService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Slf4j
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public Page<User> findAllUser(User user) {
        Page<User> page = new Page<>();
        LambdaQueryWrapper<User> lambda = new LambdaQueryWrapper<>();
        lambda.eq(Objects.nonNull(user.getAge()),User::getAge,user.getAge())
                .eq(User::getEmail,user.getEmail())
                .likeRight(Objects.nonNull(user.getName()),User::getName,user.getName());
        return baseMapper.pageAll(page,lambda);
    }

    @Override
    public Page<User> pageAllUser(int curPage, int pageSize) {
        Page<User> userPage = new Page<>(curPage,pageSize);
        return baseMapper.selectPage(userPage,new QueryWrapper<User>());
    }

    @Override
    public List<User> queryListByUserAndRole(UserRoleForm user) {
        QueryWrapper<UserRoleForm> queryWrapper = new QueryWrapper<UserRoleForm>();
        queryWrapper.like(Objects.nonNull(user.getName()),"u.name", user.getName());
        queryWrapper.eq(Objects.nonNull(user.getAge()),"u.age", user.getAge());
        queryWrapper.eq(Objects.nonNull(user.getEmail()),"u.email", user.getEmail());
        queryWrapper.in(Objects.nonNull(user.getRoleIdList()),"r.id", user.getRoleIdList());
        queryWrapper.nested(r -> r.eq("r.role_name", "管理员")
                .or().eq("r.role_name", "程序员"));

        log.info("WHERE是否为空：{}",queryWrapper.isEmptyOfWhere()+"");
        log.info("带WHERE语句：{}",queryWrapper.getCustomSqlSegment());
        log.info("没有WHERE语句：{}",queryWrapper.getSqlSegment());
        log.info("参数值：[{}]",queryWrapper.getParamNameValuePairs().toString());
        return baseMapper.queryListByUserAndRole(queryWrapper);
    }

    @Override
    public Page<User> pageByUser(PageUserForm<User> userPageUserForm) {
        return baseMapper.pageByUser(userPageUserForm);
    }

}
