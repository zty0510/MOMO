package com.adg.momo.Presenter;

public interface IPresenter_word {
    public void setDic(int mode,String page) throws InterruptedException;
    public void nextWord();
    public void wordJudge();
    public void foreSubmit();

}
