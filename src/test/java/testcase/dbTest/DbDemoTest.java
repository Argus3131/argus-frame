package testcase.dbTest;

import config.ReportLogger;
import modules.dbCheck.common.SqlSessionLocalFactory;
import modules.dbCheck.dao.CouponMapper;
import modules.dbCheck.dao.OrderMapper;
import modules.dbCheck.po.Coupon;
import modules.dbCheck.po.Order;
import org.apache.ibatis.session.SqlSession;
import org.testng.annotations.Test;
import testcase.webTest.BaiduTest;

import java.math.BigDecimal;

/**
 * @author Argus
 * @className DbDemoTest
 * @description: TODO
 * @date 2020/11/22 21:46
 * @Version V1.0
 */
public class DbDemoTest {
    private static final ReportLogger reportLogger = ReportLogger.getReportLogger(DbDemoTest.class);

    @Test(testName = "测试数据库查询", priority = 0)
    public void testSelect1() {
        SqlSession sqlSession = SqlSessionLocalFactory.getSqlSession();
        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
        Order order = orderMapper.selectByPrimaryKey(283);
        reportLogger.info("查询的Order对象信息:%s",order.toString());
        sqlSession.close();
    }


    @Test(testName = "测试数据库新增", priority = 1)
    public void testInsert2() {
        SqlSession sqlSession = SqlSessionLocalFactory.getMultipleSqlSession();
        CouponMapper couponMapper = sqlSession.getMapper(CouponMapper.class);
        Coupon coupon = couponMapper.selectByPrimaryKey(3);
        coupon.setId(15);
        coupon.setTitle("无门槛减5券");
        coupon.setMinus(new BigDecimal("5.00"));
        couponMapper.insert(coupon);
        Coupon result = couponMapper.selectByPrimaryKey(15);
        // 事务提交
        sqlSession.commit();
        reportLogger.info("查询的Order对象信息:%s",result.toString());
        sqlSession.close();
    }


}