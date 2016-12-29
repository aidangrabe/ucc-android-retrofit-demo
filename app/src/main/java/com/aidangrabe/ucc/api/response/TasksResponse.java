package com.aidangrabe.ucc.api.response;

import com.aidangrabe.ucc.api.model.Task;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by aidangrabe on 27/11/2016.
 *
 */
public class TasksResponse {

    @SerializedName("todo-items")
    public final List<Task> tasks;

    public TasksResponse(List<Task> tasks) {
        this.tasks = tasks;
    }

}
