package cn.kuaishang.mybatiesplus;

import cn.kuaishang.mybatiesplus.entity.User;
import cn.kuaishang.mybatiesplus.mapper.UserMapper;
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
public class SaveWrapperTest {

    @Autowired
    private UserService userService;

    /**
     * Save
     */
    @Test
    public void tests() {

        User user1 = new User();
        user1.setAge(29);
        user1.setName("Join");
        user1.setEmail("test1@baomidou.com");

        User user2 = new User();
        user2.setAge(12);
        user2.setName("Sam");
        user2.setEmail("test2@baomidou.com");

        User user3 = new User();
        user3.setAge(11);
        user3.setName("Lily");
        user3.setEmail("test3@baomidou.com");

        List<User> userList = new ArrayList<>();
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);

        // 插入一条记录（选择字段，策略插入）
        userService.save(user1);
        // 插入（批量）
        userService.saveBatch(userList);
        // 插入（批量）
        userService.saveBatch(userList,2);
    }
}
