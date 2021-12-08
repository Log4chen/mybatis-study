package fun.bitbit.mapper;

import fun.bitbit.bean.Person;

public interface PersonMapper {

  Person selectById(int id);
}
