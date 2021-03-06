package com.geektech.mygame.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavHostController;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.geektech.mygame.R;
import com.geektech.mygame.databinding.FragmentThirdLevelBinding;
import com.geektech.mygame.helper.Injector;
import com.geektech.mygame.presenter.Presenter;
import com.geektech.mygame.view.Contracts;

public class ThirdLevelFragment extends Fragment implements Contracts.CounterView {

    private FragmentThirdLevelBinding binding;
    private Presenter presenter;
    private NavHostController controller;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentThirdLevelBinding.inflate(inflater);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initPresenter();
        initController();
        initSet();
    }

    private void initController() {
        NavHostFragment navHostController = (NavHostFragment)
                requireActivity().getSupportFragmentManager()
                        .findFragmentById(R.id.fragmentContainerView);
        assert navHostController != null;
        controller = (NavHostController) navHostController.getNavController();
    }

    private void initSet() {
        binding.btnSet.setOnClickListener(v -> {
            String answer = binding.edAnswer.getText().toString();
                presenter.LetsCheckMath(answer);
        });

        binding.btnBack.setOnClickListener(v -> {
            controller.navigateUp();
        });
    }

    private void initPresenter() {
        presenter = Injector.getPresenter();
        presenter.attachView(this);
    }

    @Override
    public void ShowTrueToast() {
        Toast.makeText(getContext(), "?????? ?????????? ????????????????????!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void ShowFalseToast() {
        Toast.makeText(getContext(), "?????? ?????????? ????????????????????????!", Toast.LENGTH_SHORT).show();
    }
}