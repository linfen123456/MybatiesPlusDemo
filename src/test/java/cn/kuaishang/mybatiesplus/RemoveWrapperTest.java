package cn.kuaishang.mybatiesplus;

import cn.kuaishang.mybatiesplus.entity.User;
import cn.kuaishang.mybatiesplus.service.UserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

/**
 * @author sundongkai
 * @since 2021-02-04
 */
@SpringBootTest
public class RemoveWrapperTest {
    @Autowired
    private UserService userService;

    /**
     * UPDATE user SET age=?, email=? WHERE (name = ?)
     */
    @Test
    public void tests() {

        //方式一：条件删除
        //通过QueryWrapper
        userService.remove(new QueryWrapper<User>().eq("id","1"));

        //通过LambdaUpdateWrapper
        userService.remove(new LambdaUpdateWrapper<User>().eq(User::getId,"1"));

        //方式二：实体ID删除
        User user = new User();
        user.setId(1L);
        user.setAge(29);
        user.setEmail("test3update@baomidou.com");
        userService.removeById(user);

        //方式三：ID删除
        userService.removeById(1L);

        //方式四：批量ID删除
        List<Long> ids = Arrays.asList(1L, 2L, 3L);
        userService.removeByIds(ids);

    }

}
