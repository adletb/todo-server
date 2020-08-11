package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Todo {
    @Id
    @GeneratedValue
    private Long id;

    private String title;

    private boolean completed;

    public Todo() {
    }

    public Todo(String title, boolean completed) {
        this.title = title;
        this.completed = completed;
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

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    @Override
    public boolean equals(Object o){
        if (this == o)
            return true;
        if (!(o instanceof Todo))
            return false;
        Todo todo = (Todo) o;
        return Objects.equals(this.id, todo.id)
                && Objects.equals(this.title, todo.title)
                && Objects.equals(this.completed, todo.completed);

    }

    @Override
    public int hashCode(){
        return Objects.hash(this.id, this.title, this.completed);
    }

    @Override
    public String toString(){
        return "Todo{" + "id=" + this.id +", title='" + this.title
                + '\'' + ", completed='" + this.completed + '\'' + '}';
    }
}
