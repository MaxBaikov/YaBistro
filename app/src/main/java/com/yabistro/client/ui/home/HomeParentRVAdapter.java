package com.yabistro.client.ui.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;


import com.yabistro.client.R;

import java.util.ArrayList;

public class HomeParentRVAdapter extends RecyclerView.Adapter<HomeParentRVAdapter.TestParentViewHolder> {

    ArrayList<CafeNetBrands.Brand> parentArrayList;
    Context context;

    public HomeParentRVAdapter(ArrayList<CafeNetBrands.Brand> parentArrayList, Context context) {
        this.parentArrayList = parentArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public TestParentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_home_parent_rowlayout, parent, false);
        return new TestParentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TestParentViewHolder holder, int position) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context);
        holder.testChildRVAdapter.setLayoutManager(layoutManager);
        HomeChildRVAdapter childRVAdapter = new HomeChildRVAdapter(((parentArrayList.get(position)).brandMenu).menuList);
        SnapHelper helper = new PagerSnapHelper();
        helper.attachToRecyclerView(holder.testChildRVAdapter);
        holder.testChildRVAdapter.setAdapter(childRVAdapter);
        childRVAdapter.notifyDataSetChanged();
        holder.brandNumber.setText((parentArrayList.get(position)).brandName);
    }

    @Override
    public int getItemCount() {
        return parentArrayList.size();
    }


    public class TestParentViewHolder extends RecyclerView.ViewHolder {

        RecyclerView testChildRVAdapter;
        TextView brandNumber;

        public TestParentViewHolder(@NonNull View itemView) {
            super(itemView);
            testChildRVAdapter = itemView.findViewById(R.id.test_child_rv_adapter);
            brandNumber = itemView.findViewById(R.id.brand_number);
        }
    }
}
