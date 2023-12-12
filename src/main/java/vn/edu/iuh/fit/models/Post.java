package vn.edu.iuh.fit.models;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.*;

import java.time.Instant;
import java.util.Set;
@Entity
@Table(name = "post")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private Boolean published;
    @Column(columnDefinition = "tinytext")
    private String content;
    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Post parent;
    @Column(name = "mate_title",length = 100)
    private String metaTitle;
    @Column(columnDefinition = "tinytext")
    private String summary;
    @Column(name = "create_at",nullable = false)
    private Instant createAt;
    @OneToMany(mappedBy = "parent")
    @ToString.Exclude
    private Set<Post> posts;
    @Column(length = 75,nullable = false)
    private String title;
    @ManyToOne
    @JoinColumn(name = "author_id",nullable = false)
    private User author;
    @Column(name = "update_at")
    private Instant updateAt;
    @Column(name = "published_at")
    private Instant publishedAt;

    public Post(Boolean published, Instant createAt, String title, User author) {
        this.published = published;
        this.createAt = createAt;
        this.title = title;
        this.author = author;
    }
}
