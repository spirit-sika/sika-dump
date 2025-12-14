package cc.sika.dump.mapper;

import cc.sika.dump.consts.DbTypeEnum;
import cc.sika.dump.domain.po.DbConnectInfo;
import cc.sika.dump.factory.DataSourceFactory;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.text.CharSequenceUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import jakarta.annotation.Resource;
import org.apache.ibatis.executor.BatchResult;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 *
 * @author 小吴来哩
 * @since 2025-12
 */
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class DbConnectInfoTest {

    @Resource
    private DbConnectInfoMapper mapper;

    private static final Long ID = 2000126087686000640L;
    private static final Long ID2 = 2000126087686000641L;

    @Test
    @Order(1)
    void testPostgreSqlInsert() {
        String postgresql = DbTypeEnum.POSTGRESQL.getName();
        String url = DataSourceFactory.getURL(postgresql, "127.0.0.1", 5432, "sika-dump");
        Assertions.assertTrue(CharSequenceUtil.isNotBlank(url));
        DbConnectInfo postgreSqlConnection = DbConnectInfo.builder()
                .id(ID)
                .connectName("unit add test PostgreSql")
                .connectDesc("unit add test PostgreSql")
                .dbName("sika-dump")
                .scheme("public")
                .host("127.0.0.1")
                .port("5432")
                .serverLoginUsername("postgres")
                .serverLoginPassword("wjc52292")
                .serverConnectUrl(url)
                .serverType(postgresql)
                .build();

        int inserted = mapper.insert(postgreSqlConnection);
        Assertions.assertEquals(1, inserted);

        DbConnectInfo connection = mapper.selectById(ID);
        Assertions.assertTrue(BeanUtil.isNotEmpty(connection));
    }

    @Test
    @Order(2)
    void testPostgreSqlUpdate() {
        String newDesc = "unit test PostgreSql update";
        DbConnectInfo connection = mapper.selectById(ID);
        connection.setConnectDesc(newDesc);
        int updated = mapper.updateById(connection);
        Assertions.assertEquals(1, updated);

        DbConnectInfo connectionInfo = mapper.selectById(ID);
        Assertions.assertEquals(newDesc, connectionInfo.getConnectDesc());
    }

    @Test
    @Order(3)
    void testPostgreSqlDelete() {
        int deleted = mapper.deleteById(ID);
        Assertions.assertEquals(1, deleted);
    }

    @Test
    @Order(4)
    void testInsertBatch() {
        String postgresql = DbTypeEnum.POSTGRESQL.getName();
        String url = DataSourceFactory.getURL(postgresql, "127.0.0.1", 5432, "sika-dump");
        DbConnectInfo postgreSqlConnection1 = DbConnectInfo.builder()
                .id(ID)
                .connectName("unit add test PostgreSql")
                .connectDesc("unit add test PostgreSql")
                .dbName("sika-dump")
                .scheme("public")
                .host("127.0.0.1")
                .port("5432")
                .serverLoginUsername("postgres")
                .serverLoginPassword("wjc52292")
                .serverConnectUrl(url)
                .serverType(postgresql)
                .build();

        DbConnectInfo postgreSqlConnection2 = DbConnectInfo.builder()
                .id(ID2)
                .connectName("unit add test PostgreSql")
                .connectDesc("unit add test PostgreSql")
                .dbName("sika-dump")
                .scheme("public")
                .host("127.0.0.1")
                .port("5432")
                .serverLoginUsername("postgres")
                .serverLoginPassword("wjc52292")
                .serverConnectUrl(url)
                .serverType(postgresql)
                .build();

        List<DbConnectInfo> connectInfoList = Arrays.asList(postgreSqlConnection1, postgreSqlConnection2);
        List<BatchResult> inserted = mapper.insert(connectInfoList);

        AtomicLong count = new AtomicLong(0);

        inserted.forEach(item -> count.getAndAdd(item.getUpdateCounts().length));

        Assertions.assertEquals(connectInfoList.size(), count.get());

    }

    @Test
    @Order(5)
    void testUpdateBatch() {

        String newDesc = "unit test PostgreSql update batch";
        List<Long> idList = Arrays.asList(ID, ID2);
        List<DbConnectInfo> connectionsList = mapper.selectList(new LambdaQueryWrapper<DbConnectInfo>().in(DbConnectInfo::getId, idList));
        connectionsList.forEach(item -> item.setConnectDesc(newDesc));

        List<BatchResult> updated = mapper.updateById(connectionsList);
        AtomicLong count = new AtomicLong(0);
        updated.forEach(item -> count.getAndAdd(item.getUpdateCounts().length));

        Assertions.assertEquals(connectionsList.size(), count.get());

    }

    @Test
    @Order(6)
    void testDeleteBatch() {
        List<Long> idList = Arrays.asList(ID, ID2);
        int deleteByIds = mapper.deleteByIds(idList);
        Assertions.assertEquals(idList.size(), deleteByIds);
    }
}
