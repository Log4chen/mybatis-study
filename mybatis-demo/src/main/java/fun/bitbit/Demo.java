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

public class Demo {
  private static final Logger logger = LoggerFactory.getLogger(Demo.class);

  public static void main(String[] args) throws IOException {
    InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
    // 将 mybatis-config.xml 解析为Configuration对象，包含在DefaultSqlSessionFactory中
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream, null, null);
    SqlSession sqlSession = sqlSessionFactory.openSession();
    // 实际通过Proxy.newProxyInstance(mapperInterface.getClassLoader(), new Class[] { mapperInterface }, mapperProxy) 创建代理
    PersonMapper personMapper = sqlSession.getMapper(PersonMapper.class);
    Person person = personMapper.selectById(1);
    logger.info(person.toString());

    sqlSession.close();
  }
}
