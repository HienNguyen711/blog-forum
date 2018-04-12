package com.project.blogforum.domain;


import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.elasticsearch.annotations.Document;


import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "post")
public class Post implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    @NotEmpty
    private String title;

    @Column(name = "subtitle")
    private String subtitle;

    @Column(name = "content")
    private String content;

    @Column(name = "summary")
    private String summany;

    @Column(name = "date", length = 50)
    private String date;

    // join author = user
    @Column(name = "author", length = 50)
    private String author;

    // comment
    @OneToMany
    @JoinColumn(name = "post_id", referencedColumnName = "id")
    @OrderBy
    @Size(min=1, max = 10)
    private List<Comment> commentList;

    @OneToMany
    @JoinColumn(name = "post_id",referencedColumnName = "id")
    private List<Tag> tagList;

    public Post() {
    }

    public Post(String title, String subtitle, String content, String date, String author) {
        this.title = title;
        this.subtitle = subtitle;
        this.content = content;
        this.date = date;
        this.author = author;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Post)) return false;
        Post post = (Post) o;
        return Objects.equals(id, post.id) &&
                Objects.equals(title, post.title) &&
                Objects.equals(subtitle, post.subtitle) &&
                Objects.equals(content, post.content) &&
                Objects.equals(date, post.date) &&
                Objects.equals(author, post.author) &&
                Objects.equals(commentList, post.commentList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, subtitle, content, date, author, commentList);
    }

    @Override
    public String toString() {
        return "Post{" +
                "commentList=" + commentList +
                ", author='" + author + '\'' +
                ", date='" + date + '\'' +
                ", content='" + content + '\'' +
                ", subtitle='" + subtitle + '\'' +
                ", title='" + title + '\'' +
                ", id=" + id +
                '}';
    }
}
