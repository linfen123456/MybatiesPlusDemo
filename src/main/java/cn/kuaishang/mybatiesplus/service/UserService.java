package cn.kuaishang.mybatiesplus.service;

import cn.kuaishang.mybatiesplus.entity.User;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface UserService  extends IService<User> {

    /**
     * 查询全部
     * @return
     */
    Page<User> findAllUser(User user);

    /**
     * 分页查询
     * @param curPage
     * @param pageSize
     * @return
     */
    public Page<User> pageAllUser(int curPage, int pageSize);
}
