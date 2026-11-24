package com.skillpilots;
import jakarta.persistence.*; import jakarta.validation.constraints.*;
@Entity public class Book {
@Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
@NotBlank(message="Book title is required") @Size(min=2,max=100,message="Title must be between 2 and 100 characters") private String title;
@NotBlank(message="Author name is required") @Size(min=2,max=60,message="Author must be between 2 and 60 characters") private String author;
public Long getId(){return id;} public void setId(Long id){this.id=id;}
public String getTitle(){return title;} public void setTitle(String title){this.title=title;}
public String getAuthor(){return author;} public void setAuthor(String author){this.author=author;}
}