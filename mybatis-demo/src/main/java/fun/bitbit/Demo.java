package fun.bitbit;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import fun.bitbit.bean.Blog;
import fun.bitbit.bean.Person;
import fun.bitbit.dto.PersonDto;
import fun.bitbit.mapper.BlogMapper;
import fun.bitbit.mapper.PersonMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.session.SqlSessionManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Demo {
  private static final Logger logger = LoggerFactory.getLogger(Demo.class);

  public static void main(String[] args) throws IOException {
    InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
    // 将 mybatis-config.xml 解析为Configuration对象，包含在DefaultSqlSessionFactory中
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream, "local", null);
    SqlSession sqlSession = sqlSessionFactory.openSession(true);

//    SqlSessionManager sqlSessionManager = SqlSessionManager.newInstance(inputStream, "local");
//    sqlSessionManager.startManagedSession();

    // 实际通过Proxy.newProxyInstance(mapperInterface.getClassLoader(), new Class[] { mapperInterface }, mapperProxy) 创建代理
    PersonMapper personMapper = sqlSession.getMapper(PersonMapper.class);
    Person person = personMapper.selectById(1);
    logger.info(person.toString());

    PersonDto personDto = personMapper.selectPersonDtoById(1);
    logger.info(JSON.toJSONString(personDto));

    Page<Person> page = PageHelper.startPage(3, 2);
    personMapper.listAll();
    PageHelper.clearPage();
    logger.info("page total:{}", page.getTotal());
    logger.info("list :{}", page.getResult());


    BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);
    Blog blog = blogMapper.selectBlogDetails(1);
    logger.info(JSON.toJSONString(blog));

    sqlSession.close();
  }
}
