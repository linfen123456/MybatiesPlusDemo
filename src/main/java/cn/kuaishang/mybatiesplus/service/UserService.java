package cn.kuaishang.mybatiesplus.service;

import cn.kuaishang.mybatiesplus.entity.User;
import cn.kuaishang.mybatiesplus.form.PageUserForm;
import cn.kuaishang.mybatiesplus.form.UserRoleForm;
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

    /**
     * QueryWrapper自定义查询条件
     * select
     *     u.*
     * from user u
     * left join role r on u.role_id=r.id
     * WHERE (
     *          u.name LIKE ?
     *          AND r.id IN (?,?,?,?)
     *          AND (
     *                  r.role_name = ?
     *               OR r.role_name = ?
     *               )
     *        )
     * @param user
     * @return
     */
    List<User> queryListByUserAndRole(UserRoleForm user);

    Page<User> pageByUser(PageUserForm<User> userPageUserForm);
}
