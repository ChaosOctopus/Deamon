package com.yangping.Domain.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.yangping.Domain.R;
import com.yangping.Domain.bean.TaskBean;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yangping on 2020/7/23
 */
public class TasksAdapter extends RecyclerView.Adapter<TasksAdapter.TaskViewHolder> {
    private List<TaskBean> mTaskBeans = new ArrayList<>();
    private Context mContext;

    public TasksAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public void setTaskBeans(List<TaskBean> taskBeans) {
        mTaskBeans = taskBeans;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new TaskViewHolder(View.inflate(mContext, R.layout.item_task,null));
    }

    @Override
    public void onBindViewHolder(@NonNull TaskViewHolder holder, int position) {
        holder.mTextView.setText(mTaskBeans.get(position).getTaskName());
    }

    @Override
    public int getItemCount() {
        return mTaskBeans.size();
    }

    class TaskViewHolder extends RecyclerView.ViewHolder{
        public TextView mTextView;
        public TaskViewHolder(@NonNull View itemView) {
            super(itemView);
            mTextView = itemView.findViewById(R.id.item_name);
        }
    }
}
