package az.nokia.nokia.dtos.blogDtos;

import lombok.Data;

@Data
public class BlogDto {
    private Long id;
    private String title;
    private String description;
    private String photoUrl;
}
