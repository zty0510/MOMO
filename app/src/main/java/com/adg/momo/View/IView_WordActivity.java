package com.adg.momo.View;

import android.content.Context;

public interface IView_WordActivity {
    public void setText(String text);
    public String getEditText();
    public String getTV_Chinese();
    public Context getContext();
    public void setEditText(String text);
    public void clearInputText();
    public WordActivity getActivity();
}
