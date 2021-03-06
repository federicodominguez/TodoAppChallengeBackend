package com.mavha.backend.model;

import com.google.gson.annotations.JsonAdapter;
import com.mavha.backend.util.TodoGsonAdapter;

import javax.persistence.*;
import java.util.Objects;

@Entity
@JsonAdapter(TodoGsonAdapter.class)
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private Status status;
    private String image;

    public Todo() {}

    public Todo(String title, String description) {
        this.title = title;
        this.description = description;
        this.status = Status.PENDING;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Todo todo = (Todo) o;
        return Objects.equals(id, todo.id) &&
                Objects.equals(title, todo.title) &&
                Objects.equals(description, todo.description) &&
                status == todo.status &&
                Objects.equals(image, todo.image);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, status, image);
    }
}
