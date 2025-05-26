package az.nokia.nokia.services.impls;

import az.nokia.nokia.dtos.blogDtos.BlogCreateDto;
import az.nokia.nokia.dtos.blogDtos.BlogDto;
import az.nokia.nokia.dtos.blogDtos.BlogUpdateDto;
import az.nokia.nokia.models.Blog;
import az.nokia.nokia.repository.BlogRepository;
import az.nokia.nokia.services.BlogService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {
    private final ModelMapper modelMapper;
    private final BlogRepository blogRepository;

    public BlogServiceImpl(ModelMapper modelMapper, BlogRepository blogRepository) {
        this.modelMapper = modelMapper;
        this.blogRepository = blogRepository;
    }

    @Override
    public BlogDto findOneBlog(Long id) {
        Blog blog = blogRepository.findById(id).orElseThrow();
        return modelMapper.map(blog, BlogDto.class);
    }

    @Override
    public List<BlogDto> findAllBlogs() {
        List<Blog> blogs = blogRepository.findAll();
        return blogs.stream().map(x -> modelMapper.map(x, BlogDto.class)).toList();
    }

    @Override
    public void deleteBlog(Long id) {
        blogRepository.deleteById(id);
    }

    @Override
    public boolean createBlog(BlogCreateDto blogCreateDto) {
        Blog findBlog = blogRepository.findByTitle(blogCreateDto.getTitle());
        if (findBlog != null) {
            return false;
        }
        try {
            Blog blog = new Blog();
            blog.setTitle(blogCreateDto.getTitle());
            blog.setDescription(blogCreateDto.getDescription());
            blogRepository.save(blog);
            return true;

        } catch (Exception e) {
            return false;
        }
    }


    @Override
    public boolean updateBlog(BlogUpdateDto blogUpdateDto, Long id) {
        Blog findBlog = blogRepository.findById(id).orElseThrow();

        try {
            findBlog.setDescription(blogUpdateDto.getDescription());
            findBlog.setTitle(blogUpdateDto.getTitle());
            blogRepository.save(findBlog);
            return true;

        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public BlogUpdateDto findUpdateDto(Long id) {
        Blog findBlog= blogRepository.findById(id).orElseThrow();
        return modelMapper.map(findBlog,BlogUpdateDto.class);
    }
}
