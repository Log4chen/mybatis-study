package fun.bitbit.dto;

import fun.bitbit.bean.Person;
import lombok.Data;

@Data
public class PersonDto extends Person {
  private double height;
  private double weight;
}
