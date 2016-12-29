package com.aidangrabe.ucc.tasklist;

/**
 * Created by aidangrabe on 27/11/2016.
 *
 */
public class CompletedTaskListFragment extends TaskListFragment {

    @Override
    protected String getTaskFilter() {
        return "completed";
    }

}
