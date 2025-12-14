package cc.sika.dump.domain.po;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
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
public abstract class BaseEntityInfo implements BaseEntity {

    /**
     * 创建时间 CREATE_TIME
     */
    @TableField(value = "CREATE_TIME", fill = FieldFill.INSERT)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime createTime;

    /**
     * 创建人 CREATE_BY
     */
    @TableField(value = "CREATE_BY", fill = FieldFill.INSERT)
    private String createBy;

    /**
     * 创建人 Id CREATE_BY_ID
     */
    @TableField(value = "CREATE_BY_ID", fill = FieldFill.INSERT)
    private Long createById;

    /**
     * 修改时间 UPDATE_TIME
     */
    @TableField(value = "UPDATE_TIME", fill = FieldFill.INSERT_UPDATE)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime updateTime;

    /**
     * 修改人 UPDATE_BY
     */
    @TableField(value = "UPDATE_BY", fill = FieldFill.INSERT_UPDATE)
    private String updateBy;

    /**
     * 修改人 Id UPDATE_BY_ID
     */
    @TableField(value = "UPDATE_BY_ID", fill = FieldFill.INSERT_UPDATE)
    private Long updateById;
}

