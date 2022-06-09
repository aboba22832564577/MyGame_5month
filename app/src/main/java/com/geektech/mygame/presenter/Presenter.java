package com.geektech.mygame.presenter;

import com.geektech.mygame.helper.Injector;
import com.geektech.mygame.model.CounterModel;
import com.geektech.mygame.view.Contracts;

public class Presenter {

    CounterModel model = Injector.getCounterView();
    Contracts.CounterView view;

    public void LetsCheckMath(String answer){
        if (answer.equals(model.getMath())){
            view.ShowTrueToast();
        } else {
            view.ShowFalseToast();
        }
    }

    public void LetsCheckFrench(String answer){
        if (answer.equals(model.getFrench())){
            view.ShowTrueToast();
        } else {
            view.ShowFalseToast();
        }
    }

    public void LetsCheckSpiral(String answer){
        if (answer.equals(model.getSpiral())){
            view.ShowTrueToast();
        } else {
            view.ShowFalseToast();
        }
    }

    public void attachView(Contracts.CounterView view){
        this.view = view;
    }
}
