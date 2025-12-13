package cc.sika.dump.domain.po;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 *
 * @author 小吴来哩
 * @since 2025-12
 */
public interface BaseEntity extends Serializable {

    Serializable getId();

    LocalDateTime getCreateTime();

    void setCreateTime(LocalDateTime createTime);

    String getCreateBy();

    void setCreateBy(String createBy);

    Long getCreateById();

    void setCreateById(Long createId);

    LocalDateTime getUpdateTime();

    void setUpdateTime(LocalDateTime updateTime);

    String getUpdateBy();

    void setUpdateBy(String updateBy);

    Long getUpdateById();

    void setUpdateById(Long updateId);

}
