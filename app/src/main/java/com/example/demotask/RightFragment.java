package com.example.demotask;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.demotask.databinding.FragmentRightBinding;

import java.util.ArrayList;


public class RightFragment extends Fragment implements ItemAdapter.ItemClickListener {

    private RecyclerView recyclerView;
    private ArrayList<ModelClass> selectedItems = new ArrayList<>();
    private ItemAdapter adapter;
    FragmentRightBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_right, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.Recyclerview2);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        adapter = new ItemAdapter(selectedItems, this);

        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(String item, int pos) {
        selectedItems.remove(pos);
        ((LeftFragment) getParentFragmentManager().findFragmentById(R.id.frameLayout1)).addLeftItem(item);
        adapter.notifyDataSetChanged();
    }

    public void addRightItem(String item) {
        selectedItems.add(new ModelClass(item));
        adapter.notifyDataSetChanged();
    }
}