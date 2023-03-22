package fun.bitbit;

import fun.bitbit.bean.Person;
import fun.bitbit.mapper.PersonMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;

public class CacheDemo {
  private static final Logger logger = LoggerFactory.getLogger(CacheDemo.class);

  public static void main(String[] args) throws IOException {
    InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
    // 将 mybatis-config.xml 解析为Configuration对象，包含在DefaultSqlSessionFactory中
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream, "local", null);
    SqlSession sqlSession = sqlSessionFactory.openSession(true);

    System.out.println(sqlSessionFactory.getConfiguration().isCacheEnabled());
    System.out.println(sqlSessionFactory.getConfiguration().getEnvironment().getId());

//    SqlSessionManager sqlSessionManager = SqlSessionManager.newInstance(inputStream, "local");
//    sqlSessionManager.startManagedSession();

    // 实际通过Proxy.newProxyInstance(mapperInterface.getClassLoader(), new Class[] { mapperInterface }, mapperProxy) 创建代理
    PersonMapper personMapper = sqlSession.getMapper(PersonMapper.class);

    logger.info("=================美丽的分割线=====================");
    System.out.println(personMapper.selectById(1));

    logger.info("=================美丽的分割线=====================");
    System.out.println(personMapper.selectById(1));

    sqlSession.commit();

//    person.setName("kitty");
//    sqlSession.clearCache();
    logger.info("=================美丽的分割线=====================");
    System.out.println(personMapper.selectById(1));

    logger.info("=================美丽的分割线=====================");
    System.out.println(sqlSession.getMapper(PersonMapper.class).selectById(1));

    sqlSession.close();
  }
}
