package az.nokia.nokia.dtos.blogDtos;

import lombok.Data;

@Data
public class BlogCreateDto {
    private String title;
    private String description;
    private String photoUrl;
}
