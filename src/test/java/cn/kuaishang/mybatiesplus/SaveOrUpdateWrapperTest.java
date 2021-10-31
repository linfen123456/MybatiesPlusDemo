package cn.kuaishang.mybatiesplus;

import cn.kuaishang.mybatiesplus.entity.User;
import cn.kuaishang.mybatiesplus.service.UserService;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sundongkai
 * @since 2021-02-04
 */
@SpringBootTest
public class SaveOrUpdateWrapperTest {
    @Autowired
    private UserService userService;
    /**
     *
     */
    @Test
    public void tests() {

        //方式一：
        User user = new User();
        user.setId(1L);
        user.setAge(29);
        user.setEmail("test3update@baomidou.com");

        User user2 = new User();
        user2.setId(2L);
        user2.setAge(29);
        user2.setEmail("test3update@baomidou.com");

        User user3 = new User();
        user3.setId(3L);
        user3.setAge(29);
        user3.setEmail("test3update@baomidou.com");

        List<User> userList = new ArrayList<>();
        userList.add(user);
        userList.add(user2);
        userList.add(user3);
        //通过ID修改
        userService.updateById(user);
        //批量通过ID更新
        userService.updateBatchById(userList);
        //保存或者更新
        userService.saveOrUpdate(user);
        //批量保存更新
        userService.saveOrUpdateBatch(userList);
    }
}
