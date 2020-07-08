package com.cyoung90.bookcase.web.dto;

import java.time.LocalDateTime;

import com.cyoung90.bookcase.domain.posts.Posts;

import lombok.Getter;

@Getter
public class PostsListResponseDto {
   private Long id;
   private String title;
   private String author;
   private LocalDateTime updatedDate;

   public PostsListResponseDto(Posts entity) {
       this.id = entity.getId();
       this.title = entity.getTitle();
       this.author = entity.getAuthor();
       this.updatedDate = entity.getUpdatedDate();
   }
}