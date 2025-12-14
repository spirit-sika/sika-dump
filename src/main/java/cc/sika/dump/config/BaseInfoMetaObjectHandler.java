package cc.sika.dump.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 *
 * @author 小吴来哩
 * @since 2025-12
 */
@Component
public class BaseInfoMetaObjectHandler implements MetaObjectHandler  {
    @Override
    public void insertFill(MetaObject metaObject) {
        strictInsertFill(metaObject, "createTime", LocalDateTime.class, LocalDateTime.now());
        strictInsertFill(metaObject, "createBy", String.class, "system create");
        strictInsertFill(metaObject, "createById", Long.class, -1L);
        strictInsertFill(metaObject, "updateTime", LocalDateTime.class, LocalDateTime.now());
        strictInsertFill(metaObject, "updateBy", String.class, "system update");
        strictInsertFill(metaObject, "updateById", Long.class, -1L);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        strictInsertFill(metaObject, "updateTime", LocalDateTime.class, LocalDateTime.now());
        strictInsertFill(metaObject, "updateBy", String.class, "system update");
        strictInsertFill(metaObject, "updateById", Long.class, -1L);
    }
}
