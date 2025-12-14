package cc.sika.dump.service.impl;

import cc.sika.dump.domain.po.SyncConfig;
import cc.sika.dump.mapper.SyncConfigMapper;
import cc.sika.dump.service.SyncConfigService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 *
 * @author 小吴来哩
 * @since 2025-12
 */
@Service
public class SyncConfigServiceImpl extends ServiceImpl<SyncConfigMapper, SyncConfig>
        implements SyncConfigService {
}
