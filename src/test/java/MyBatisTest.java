import com.cyan.mapper.BrandMapper;
import com.cyan.mapper.UserMapper;
import com.cyan.pojo.Brand;
import com.cyan.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyBatisTest {
    @Test
    public void testSelectAll() throws Exception {
        //1.加载MyBatis 配置文件，获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

//        //3.执行sql语句
//        List<User> users = sqlSession.selectList("userMapper.selectAll");
//        System.out.println(users);

        //代理模式
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = userMapper.selectAll();
        System.out.println(users);
        //4.释放资源
        sqlSession.close();
    }

    @Test
    public void testSelectById() throws Exception {
        int id = 2;
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //代理模式
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        Brand brand = brandMapper.selectById(id);
        System.out.println(brand);
        //4.释放资源
        sqlSession.close();
    }

//    若查询结果为空集，
//    检查sql是否拼接错误，
//    可能数据库连接的字符编码有误，连接信息添加：useUnicode=true&amp;characterEncoding=UTF-8
    @Test
    public void testSelectByCondition() throws IOException {
        //接收参数
        int status = 1;
        String companyName = "华为";
        String brandName = "华为";

        // 处理参数
        companyName = "%" + companyName + "%";
        brandName = "%" + brandName + "%";

        //1. 获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //2. 获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //3. 获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //4. 执行方法
        //方式一 ：接口方法参数使用 @Param 方式调用的方法
//        List<Brand> brands = brandMapper.selectByCondition(status, companyName, brandName);
        //方式二 ：接口方法参数是 实体类对象 方式调用的方法
        //封装对象
//        Brand brand = new Brand();
//        brand.setStatus(status);
//        brand.setCompanyName(companyName);
//        brand.setBrandName(brandName);
//
//        List<Brand> brands = brandMapper.selectByCondition(brand);

        //方式三 ：接口方法参数是 map集合对象 方式调用的方法
        Map<String, java.io.Serializable> map = new HashMap<String, java.io.Serializable>();
        map.put("status" , status);
        map.put("companyName", companyName);
        map.put("brandName" , brandName);
        List<Brand> brands = brandMapper.selectByCondition(map);

        System.out.println(brands);

        //5. 释放资源
        sqlSession.close();
    }
}
