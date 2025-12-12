package cc.sika.dump.utils;

import cn.hutool.core.lang.Snowflake;
import org.springframework.stereotype.Component;

/**
 *
 * @author 小吴来哩
 * @since 2025-12
 */
@Component
@SuppressWarnings("unused")
public class IdGenerator {

    private final Snowflake snowflake;

    /**
     * 生成19位长度的数字唯一 ID
     * @return 19位长度的数字唯一 ID
     */
    public Long newId() {
        return snowflake.nextId();
    }

    /**
     * 生成19位长度的数字唯一 ID (String类型)
     * @return 19位长度的数字唯一 ID (String类型)
     */
    public String newStrId() {
        return snowflake.nextIdStr();
    }

    private IdGenerator() {
        snowflake = new Snowflake(1, 2);
    }

}