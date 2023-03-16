package fun.bitbit.mapper;

import fun.bitbit.bean.Blog;

public interface BlogMapper {
  Blog selectBlogDetails(int id);
}
