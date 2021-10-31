package cn.kuaishang.mybatiesplus.mapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import cn.kuaishang.mybatiesplus.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author miemie
 * @since 2018-08-10
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

    Page<User> findAll(Page<User> page, LambdaQueryWrapper<User> queryWrapper);

    List<User> queryAllByAgeAndNameAndRoleId(@Param("age") Integer age, @Param("name") String name, @Param("roleId") Long roleId);
}
