package com.yabistro.client.ui.home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.yabistro.client.R;
import java.util.ArrayList;

//TODO переести в data а запросы сделать через viewmodel

public class HomeChildRVAdapter extends RecyclerView.Adapter<HomeChildRVAdapter.ViewHolder> {

    ArrayList<String> arrayList;

    public HomeChildRVAdapter(ArrayList<String> arrayList) {
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_home_child_rowlayout, parent, false);
        return new HomeChildRVAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.testItemText.setText(arrayList.get(position));
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView testItemText;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            testItemText = itemView.findViewById(R.id.test_item_text);
        }
    }
}