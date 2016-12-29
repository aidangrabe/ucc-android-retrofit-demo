package com.aidangrabe.ucc.tasklist;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.aidangrabe.ucc.TaskAdapter;
import com.aidangrabe.ucc.api.TeamworkApiService;
import com.aidangrabe.ucc.api.TeamworkApi;
import com.aidangrabe.ucc.api.response.TasksResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by aidangrabe on 27/11/2016.
 *
 */
public abstract class TaskListFragment extends Fragment {

    private RecyclerView recyclerView;
    private TaskAdapter taskAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        recyclerView = new RecyclerView(getContext());
        setupRecyclerView();
        downloadTasks();
        return recyclerView;
    }

    private void setupRecyclerView() {
        taskAdapter = new TaskAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(taskAdapter);
    }

    private void downloadTasks() {
        TeamworkApi api = TeamworkApiService.create();
        api.getTasksFiltered(getTaskFilter()).enqueue(new Callback<TasksResponse>() {
            @Override
            public void onResponse(Call<TasksResponse> call, Response<TasksResponse> response) {
                if (!response.isSuccessful()) {
                    onFailure(call, null);
                    return;
                }

                taskAdapter.setTasks(response.body().tasks);
                taskAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<TasksResponse> call, Throwable t) {
                Toast.makeText(getContext(), "Error downloading tasks", Toast.LENGTH_SHORT)
                        .show();
            }
        });
    }

    protected abstract String getTaskFilter();

}
