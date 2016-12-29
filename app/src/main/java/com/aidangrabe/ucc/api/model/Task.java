package com.aidangrabe.ucc.api.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by aidangrabe on 27/11/2016.
 *
 */
public class Task {

    private final long id;
    private final String content;

    @SerializedName("todo-list-name")
    private final String todoListName;

    public Task(long id, String content, String todoListName) {
        this.id = id;
        this.content = content;
        this.todoListName = todoListName;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public String getTodoListName() {
        return todoListName;
    }
}
