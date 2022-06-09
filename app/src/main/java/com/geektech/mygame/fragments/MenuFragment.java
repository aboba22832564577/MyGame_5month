package com.geektech.mygame.fragments;

import static com.geektech.mygame.R.id.firstLevelFragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavHostController;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.geektech.mygame.R;
import com.geektech.mygame.databinding.FragmentMenuBinding;

public class MenuFragment extends Fragment {

    private FragmentMenuBinding binding;
    private NavHostController controller;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentMenuBinding.inflate(inflater);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initController();
        toFirstLevel();
    }

    private void toFirstLevel() {
        binding.lvl1.setOnClickListener(v -> controller.navigate(firstLevelFragment));

        binding.lvl2.setOnClickListener(v -> controller.navigate(R.id.secondLevelFragment));

        binding.lvl3.setOnClickListener(v -> controller.navigate(R.id.thirdLevelFragment));
    }

    private void initController() {
        NavHostFragment navHostController = (NavHostFragment)
                requireActivity().getSupportFragmentManager()
                        .findFragmentById(R.id.fragmentContainerView);
        assert navHostController != null;
        controller = (NavHostController) navHostController.getNavController();
    }
}