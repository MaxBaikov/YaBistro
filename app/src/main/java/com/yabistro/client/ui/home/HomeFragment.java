package com.yabistro.client.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.SnapHelper;

import com.yabistro.client.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater);
        HomeParentRVAdapter testRecyclerViewAdapter = new HomeParentRVAdapter(CafeNetBrands.brands, requireContext());
        SnapHelper helper = new PagerSnapHelper();
        helper.attachToRecyclerView(binding.testParentRvAdapter);

        binding.testParentRvAdapter.setLayoutManager
                (new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        binding.testParentRvAdapter.setAdapter(testRecyclerViewAdapter);

        return binding.getRoot();

//        final TextView textView = root.findViewById(R.id.text_home);
//        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });

    }
}


