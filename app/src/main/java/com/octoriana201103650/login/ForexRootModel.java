package com.octoriana201103650.login;

import com.google.gson.annotations.SerializedName;

public class ForexRootModel {

    @SerializedName("rates")
    private ForexRatesModel ratesModel;

    public ForexRootModel() {}

    public ForexRatesModel getForexRatesModel() {
        return ratesModel;
    }

    public void setForexRatesModel(ForexRatesModel forexRatesModel) {
        this.ratesModel = ratesModel;
    }
}
