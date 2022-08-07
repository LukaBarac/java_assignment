package com.assignment.javatask.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class PostModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String header;
    private String tag;
    private String text;
    private boolean isLiked;

    @OneToMany(targetEntity = CommentModel.class, cascade = CascadeType.ALL)  // ako zelim da obrisem post da se obrisu i komentari
    @JoinColumn(name = "post_id", referencedColumnName = "id")
    private Set<CommentModel> comments;
}
