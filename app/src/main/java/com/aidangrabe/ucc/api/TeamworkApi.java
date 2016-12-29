package com.aidangrabe.ucc.api;

import com.aidangrabe.ucc.api.response.TasksResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by aidangrabe on 27/11/2016.
 *
 * This is the interface that will define the endpoints of our API.
 * They get appended on to the base url of the Retrofit Client
 *
 */
public interface TeamworkApi {

    @GET("tasks.json")
    Call<TasksResponse> getAllTasks();

    @GET("tasks.json")
    Call<TasksResponse> getTasksFiltered(@Query("filter") String filter);

}
