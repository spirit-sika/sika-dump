package cc.sika.dump.service.impl;

import cc.sika.dump.domain.po.DbConnectInfo;
import cc.sika.dump.mapper.DbConnectInfoMapper;
import cc.sika.dump.service.DbConnectInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 *
 * @author 小吴来哩
 * @since 2025-12
 */
@Service
public class DbConnectInfoServiceImpl extends ServiceImpl<DbConnectInfoMapper, DbConnectInfo>
        implements DbConnectInfoService {
}
