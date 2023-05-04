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
import com.example.demotask.databinding.FragmentLeftBinding;
import java.util.ArrayList;


public class LeftFragment extends Fragment implements ItemAdapter.ItemClickListener {
    private RecyclerView recyclerView;
    private ArrayList<ModelClass> items = new ArrayList<>();
    private RecyclerView.Adapter adapter;
    FragmentLeftBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_left, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.Recyclerview1);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        items.add(new ModelClass("one"));
        items.add(new ModelClass("two"));
        items.add(new ModelClass("three"));
        items.add(new ModelClass("four"));
        items.add(new ModelClass("five"));

        adapter = new ItemAdapter(items, this);
        recyclerView.setAdapter(adapter);


    }

    @Override
    public void onItemClick(String item, int pos) {
        items.remove(pos);
        adapter.notifyItemRemoved(pos);
        ((RightFragment) getParentFragmentManager().findFragmentById(R.id.frameLayout2)).addRightItem(item);
        adapter.notifyDataSetChanged();

    }

    public void addLeftItem(String item) {
        items.add(new ModelClass(item));
        adapter.notifyDataSetChanged();

    }
}