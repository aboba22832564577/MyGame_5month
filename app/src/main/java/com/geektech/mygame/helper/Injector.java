package com.geektech.mygame.helper;

import com.geektech.mygame.model.CounterModel;
import com.geektech.mygame.presenter.Presenter;

public class Injector {

    public static Presenter getPresenter(){
        return new Presenter();
    }

    public static CounterModel getCounterView(){
        return new CounterModel();
    }
}
