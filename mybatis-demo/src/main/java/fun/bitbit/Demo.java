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
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    SqlSession sqlSession = sqlSessionFactory.openSession(true);
    PersonMapper personMapper = sqlSession.getMapper(PersonMapper.class);
    Person person = personMapper.selectById(1);
    logger.info(person.toString());

    sqlSession.close();
  }
}
