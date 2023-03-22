package fun.bitbit.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class Person implements Serializable {
  private int id;
  private String name;
  private String address;
  private String headImgUrl;
}
