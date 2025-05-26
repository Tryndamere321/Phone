package az.nokia.nokia.services;

import az.nokia.nokia.dtos.blogDtos.BlogCreateDto;
import az.nokia.nokia.dtos.blogDtos.BlogDto;
import az.nokia.nokia.dtos.blogDtos.BlogUpdateDto;

import java.util.List;

public interface BlogService {
    BlogDto findOneBlog(Long id);
    List<BlogDto> findAllBlogs();
    void deleteBlog(Long id);
    boolean createBlog(BlogCreateDto blogCreateDto);
    boolean updateBlog(BlogUpdateDto blogUpdateDto,Long id);
    BlogUpdateDto findUpdateDto(Long id);
}
