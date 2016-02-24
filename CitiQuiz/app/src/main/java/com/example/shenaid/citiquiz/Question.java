package com.example.shenaid.citiquiz;

/**
 * Created by Bryan Charlie on 2/22/2016.
 */
public class Question {
    private boolean mAnswer;
    private int mResID;
    private int toast;

    public Question(boolean mAnswer, int mResID, int toast){
        this.mAnswer = mAnswer;
        this.mResID = mResID;
        this.toast = toast;
    }

    public boolean getAnswer(){
        return mAnswer;
    }

    public int getResID(){
        return mResID;
    }

    public int getToast(){
        return toast;
    }
}
