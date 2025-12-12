package cc.sika.dump.consts;

import lombok.Getter;

/**
 * 同步配置类型枚举
 *
 * @author 小吴来哩
 * @since 2025-12
 */
public enum SyncConfigTypeEnum {

    SEND(1, "发送端配置"),
    RECEIVE(2, "接收端配置");

    @Getter
    private final Integer value;
    private final String desc;

    public static SyncConfigTypeEnum valueOf(Integer value) {
        for (SyncConfigTypeEnum type : SyncConfigTypeEnum.values()) {
            if (type.value.equals(value)) {
                return type;
            }
        }
        return null;
    }

    SyncConfigTypeEnum(Integer value, String desc) {
        this.value = value;
        this.desc = desc;
    }
}
