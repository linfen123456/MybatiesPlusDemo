package cn.kuaishang.mybatiesplus.form;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;

@Data
public class PageUserForm<T> extends Page<T> {
    private String name;
    private Integer age;
}
