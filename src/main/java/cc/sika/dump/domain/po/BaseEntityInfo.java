package cc.sika.dump.domain.po;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

/**
 *
 * @author 小吴来哩
 * @since 2025-12
 */
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public abstract class BaseEntityInfo implements cc.sika.dump.domain.po.BaseEntity {

    /**
     * 创建时间 CREATE_TIME
     */
    @TableField("CREATE_TIME")
    private LocalDateTime createTime;

    /**
     * 创建人 CREATE_BY
     */
    @TableField("CREATE_BY")
    private String createBy;

    /**
     * 创建人 Id CREATE_BY_ID
     */
    @TableField("CREATE_BY_ID")
    private Long createById;

    /**
     * 修改时间 UPDATE_TIME
     */
    @TableField("UPDATE_TIME")
    private LocalDateTime updateTime;

    /**
     * 修改人 UPDATE_BY
     */
    @TableField("UPDATE_BY")
    private String updateBy;

    /**
     * 修改人 Id UPDATE_BY_ID
     */
    @TableField("UPDATE_BY_ID")
    private Long updateById;
}

