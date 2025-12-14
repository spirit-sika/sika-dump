package cc.sika.dump.service.impl;

import cc.sika.dump.domain.po.PluginConfig;
import cc.sika.dump.mapper.PluginConfigMapper;
import cc.sika.dump.service.PluginConfigService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 *
 * @author 小吴来哩
 * @since 2025-12
 */
@Service
public class PluginConfigServiceImpl extends ServiceImpl<PluginConfigMapper, PluginConfig>
        implements PluginConfigService {
}
