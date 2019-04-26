package com.zbyk.dialogdefinebymilkzs;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.Group;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Create by zuoqi@bhz.com.cn on 2019/4/26 11:07
 */
public class SimpleDialog extends DialogFragment {

    private String type = "all";

    private View.OnClickListener okClickListener;
    private View.OnClickListener cancelClickListener;
    private String title;
    private String content;

    private static SimpleDialog simpleDialog = new SimpleDialog();

    public static SimpleDialog getInstance(){
        return simpleDialog;
    }

    public void showWithAll(FragmentManager fm, View.OnClickListener okClickListener, String title, String content){
        this.type = "all";
        this.okClickListener = okClickListener;
        this.cancelClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (simpleDialog != null){
                    simpleDialog.dismiss();
                }
            }
        };
        this.title = title;
        this.content = content;
        simpleDialog.show(fm,"");
    }

    public void showWithAll(FragmentManager fm, String tag, View.OnClickListener okClickListener, View.OnClickListener cancelClickListener,String title,String content){
        this.type = "all";
        this.okClickListener = okClickListener;
        this.cancelClickListener = cancelClickListener;
        this.title = title;
        this.content = content;
        simpleDialog.show(fm,tag);
    }

    public void showWithNoTitle(FragmentManager fm,View.OnClickListener okClickListener,String content){
        this.type = "no_title";
        this.okClickListener = okClickListener;
        this.cancelClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (simpleDialog != null){
                    simpleDialog.dismiss();
                }
            }
        };
        this.content = content;
        simpleDialog.show(fm,"");
    }

    public void showWithNoTitle(FragmentManager fm, String tag, View.OnClickListener okClickListener, View.OnClickListener cancelClickListener,String content){
        this.type = "no_title";
        this.okClickListener = okClickListener;
        this.cancelClickListener = cancelClickListener;
        this.content = content;
        simpleDialog.show(fm,tag);
    }

    public void showWithNoCancel(FragmentManager fm,String title,String content){
        this.type = "no_cancel";
        this.okClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (simpleDialog != null){
                    simpleDialog.dismiss();
                }
            }
        };
        this.content = content;
        this.title = title;
        simpleDialog.show(fm,"");
    }

    public void showWithNoCancel(FragmentManager fm, String tag, View.OnClickListener okClickListener,String title,String content){
        this.type = "no_cancel";
        this.okClickListener = okClickListener;
        this.content = content;
        this.title = title;
        simpleDialog.show(fm,tag);
    }

    public void showWithNoCancelTitle(FragmentManager fm,String content){
        this.type = "no_cancel_title";
        this.okClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (simpleDialog != null){
                    simpleDialog.dismiss();
                }
            }
        };
        this.content = content;
        simpleDialog.show(fm,"");
    }

    public void showWithNoCancelTitle(FragmentManager fm, String tag, View.OnClickListener okClickListener,String content){
        this.type = "no_cancel_title";
        this.okClickListener = okClickListener;
        this.content = content;
        simpleDialog.show(fm,tag);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view ;

        switch (type){
            case "all":{
                view = inflater.inflate(R.layout.dialog_simple_all,container);
                TextView tvTitle = view.findViewById(R.id.tv_dialog_title);
                TextView tvContent = view.findViewById(R.id.tv_dialog_show_content);
                tvTitle.setText(title);
                tvContent.setText(content);
                view.findViewById(R.id.bt_dialog_ok).setOnClickListener(okClickListener);
                view.findViewById(R.id.bt_dialog_cancel).setOnClickListener(cancelClickListener);
            }break;
            case "no_title":{
                view = inflater.inflate(R.layout.dialog_simple_all,container);
                Group group = view.findViewById(R.id.group_dialog_no_title);
                group.setVisibility(View.GONE);
                TextView tvContent = view.findViewById(R.id.tv_dialog_show_content);
                tvContent.setText(content);
                view.findViewById(R.id.bt_dialog_ok).setOnClickListener(okClickListener);
                view.findViewById(R.id.bt_dialog_cancel).setOnClickListener(cancelClickListener);
            }break;
            case "no_cancel":{
                view = inflater.inflate(R.layout.dialog_simple_no_cancel,container);
                TextView tvTitle = view.findViewById(R.id.tv_dialog_title);
                TextView tvContent = view.findViewById(R.id.tv_dialog_show_content);
                tvTitle.setText(title);
                tvContent.setText(content);
                view.findViewById(R.id.bt_dialog_ok).setOnClickListener(okClickListener);
            }break;
            case "no_cancel_title":{
                view = inflater.inflate(R.layout.dialog_simple_no_cancel,container);
                Group group = view.findViewById(R.id.group_dialog_no_title);
                group.setVisibility(View.GONE);
                TextView tvContent = view.findViewById(R.id.tv_dialog_show_content);
                tvContent.setText(content);
                view.findViewById(R.id.bt_dialog_ok).setOnClickListener(okClickListener);
            }break;
            default:{
                view = inflater.inflate(R.layout.dialog_simple_all,container);

            }
        }
        return view;
    }
}
