package testcase.dbTest;

import modules.dbCheck.common.SqlSessionLocalFactory;
import modules.dbCheck.dao.CouponMapper;
import modules.dbCheck.dao.OrderMapper;
import modules.dbCheck.po.Coupon;
import modules.dbCheck.po.Order;
import org.apache.ibatis.session.SqlSession;
import org.testng.annotations.Test;
import utils.LogUtil;

import java.math.BigDecimal;

/**
 * @author Argus
 * @className DbDemoTest
 * @description: TODO
 * @date 2020/11/22 21:46
 * @Version V1.0
 */
public class DbDemoTest {

    @Test(testName = "测试数据库查询", priority = 1)
    public void testSelect1() {
        SqlSession sqlSession = SqlSessionLocalFactory.getSqlSession();
        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
        Order order = orderMapper.selectByPrimaryKey(283);
        LogUtil.APP.info("查询的Order对象信息:{}",order);
        sqlSession.close();
    }


    @Test
    public void testInsert2() {
        SqlSession sqlSession = SqlSessionLocalFactory.getMultipleSqlSession();
        CouponMapper couponMapper = sqlSession.getMapper(CouponMapper.class);
        Coupon coupon = couponMapper.selectByPrimaryKey(3);
        coupon.setId(13);
        coupon.setTitle("无门槛减5券");
        coupon.setMinus(new BigDecimal("5.00"));
        couponMapper.insert(coupon);
        Coupon result = couponMapper.selectByPrimaryKey(13);
        // 事务提交
        sqlSession.commit();
        LogUtil.APP.info("查询的Order对象信息:{}",result);
        sqlSession.close();
    }


}