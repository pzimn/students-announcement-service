package com.student.service.web.model;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.sql.Time;
import java.sql.Timestamp;

import javax.persistence.*;

@Entity
@Table(name = "comment")
@EntityListeners(AuditingEntityListener.class)
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;


    @Column(name = "author_id")
    private int authorId;


    @Column(name = "target_id")
    private int targetId;


    @Column
    private int rate;

    //@NotBlank
    @Column
    private String content;
    @Column
    private Timestamp date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public int getTargetId() {
        return targetId;
    }

    public void setTargetId(int targetId) {
        this.targetId = targetId;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content =content;
    }

//
    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date =date;
    }



    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", authorId=" + authorId +
                ", targetId=" + targetId +
                ", rate=" + rate +
                ", content='" + content + '\'' +
                ", date='" + date + '\'' +

                '}';
    }
}
