package com.aidangrabe.ucc;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.aidangrabe.ucc.api.model.Task;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aidangrabe on 27/11/2016.
 *
 */
public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskViewHolder> {

    private List<Task> tasks;

    public TaskAdapter() {
        tasks = new ArrayList<>();
    }

    @Override
    public TaskViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(R.layout.task_list_item, parent, false);

        return new TaskViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TaskViewHolder holder, int position) {
        final Task task = tasks.get(position);

        holder.titleLabel.setText(task.getContent());
        holder.subtitleLabel.setText("tasklist: " + task.getTodoListName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "Clicked: " + task.getContent(), Toast.LENGTH_SHORT)
                        .show();
            }
        });
        holder.avatarImage.setImageResource(R.mipmap.ic_launcher);
    }

    @Override
    public int getItemCount() {
        return tasks.size();
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public class TaskViewHolder extends RecyclerView.ViewHolder {

        ImageView avatarImage;
        TextView titleLabel, subtitleLabel;

        public TaskViewHolder(View itemView) {
            super(itemView);

            avatarImage = (ImageView) itemView.findViewById(R.id.avatar);
            titleLabel = (TextView) itemView.findViewById(R.id.title);
            subtitleLabel = (TextView) itemView.findViewById(R.id.subtitle);

        }

    }

}
