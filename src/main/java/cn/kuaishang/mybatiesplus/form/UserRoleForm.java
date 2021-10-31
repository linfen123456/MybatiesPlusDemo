package cn.kuaishang.mybatiesplus.form;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class UserRoleForm implements Serializable {

    /**
     * 姓名
     */
    private String name;
    /**
     * 年龄
     */
    private Integer age;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 角色ID
     */
    private List<Long> roleIdList;

    /**
     * 角色名
     */
    private String roleName;
}
