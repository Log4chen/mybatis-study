package fun.bitbit.mapper;

import fun.bitbit.bean.Person;
import fun.bitbit.dto.PersonDto;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PersonMapper {

  int insert(Person person);

//  @Select("select * from person where id = #{id}")
  Person selectById(int id);

  Person selectById2(@Param("id") int id, @Param("a") int a);

  List<Person> listAll();

  PersonDto selectPersonDtoById(int id);
}
