package com.assignment.javatask.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PostDto {

    private String name;
    private String header;
    private String tag;
    private String text;
}
