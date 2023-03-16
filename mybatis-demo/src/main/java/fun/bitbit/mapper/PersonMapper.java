package fun.bitbit.mapper;

import fun.bitbit.bean.Person;
import fun.bitbit.dto.PersonDto;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PersonMapper {

  int insert(Person person);

//  @Select("select * from person where id = #{id}")
  Person selectById(int id);

  List<Person> listAll();

  PersonDto selectPersonDtoById(int id);
}
