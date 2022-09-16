import com.cyan.mapper.BrandMapper;
import com.cyan.mapper.UserMapper;
import com.cyan.pojo.Brand;
import com.cyan.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

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
}
