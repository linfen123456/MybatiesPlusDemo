package cn.kuaishang.mybatiesplus.mapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import java.util.Collection;

import cn.kuaishang.mybatiesplus.entity.Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author miemie
 * @since 2018-08-10
 */
@Mapper
public interface RoleMapper extends BaseMapper<Role> {

    List<Role> selectAllByIdIn(@Param("idList") Collection<Long> idList);
}
