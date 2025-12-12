package cc.sika.dump.consts;

import lombok.Getter;

/**
 * 插件类型枚举
 *
 * @author 小吴来哩
 * @since 2025-12
 */
public enum PluginType {

    SEND_PLUGIN(1, "发送端插件"),
    RECEIVE_PLUGIN(2, "接收端插件"),
    SEND_FILTER(3, "发送端过滤器"),
    RECEIVE_FILTER(4, "接收端过滤器");

    @Getter
    private final Integer value;
    private final String desc;

    public static PluginType valueOf(Integer value) {
        for (PluginType type : PluginType.values()) {
            if (type.value.equals(value)) {
                return type;
            }
        }
        return null;
    }

    PluginType(Integer value, String desc) {
        this.value = value;
        this.desc = desc;
    }
}
