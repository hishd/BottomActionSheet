package com.hishd.actionsheet;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class ActionSheet extends BottomSheetDialogFragment {
    TextView txtTitle;
    TextView txtMessage;
    Button btnMainActionTop;
    Button btnMainActionBottom;
    Button btnDefaultAction;

    Context context;

    String title;
    String message;
    String btnDefaultActionCaption;
    String btnMainActionTopCaption;
    String btnMainActionBottomCaption;

    ActionType btnDefaultActionType;
    ActionType btnMainActionTopActionType;
    ActionType btnMainActionBottomActionType;

    View.OnClickListener btnDefaultActionListener;
    View.OnClickListener btnMainActionTopListener;
    View.OnClickListener btnMainActionBottomListener;

    BottomSheetActions bottomSheetActions;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(BottomSheetDialogFragment.STYLE_NORMAL, R.style.CustomBottomSheetDialogTheme);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.action_sheet_view, container, false);
        txtTitle = view.findViewById(R.id.txtTitle);
        txtMessage = view.findViewById(R.id.txtMessage);
        btnMainActionTop = view.findViewById(R.id.btnMainActionTop);
        btnMainActionBottom = view.findViewById(R.id.btnMainActionBottom);
        btnDefaultAction = view.findViewById(R.id.btnDefaultAction);

        txtTitle.setText(R.string.defaultTitle);
        txtMessage.setText(R.string.defaultMessage);
        btnDefaultAction.setText(R.string.captionDefaultButton);
        btnMainActionBottom.setText(R.string.captionMainBottomButton);
        btnMainActionTop.setText(R.string.captionMainTopButton);
        btnDefaultAction.setAllCaps(false);
        btnMainActionBottom.setAllCaps(false);
        btnMainActionTop.setAllCaps(false);

        btnMainActionBottom.setVisibility(View.GONE);
        if (this.title != null) {
            txtTitle.setText(this.title);
        }
        if (this.message != null) {
            txtMessage.setText(this.message);
        }

        if (this.btnDefaultActionCaption != null) {
            if(this.btnDefaultActionType == ActionType.DESTRUCTIVE) {
                btnDefaultAction.setTextColor(ContextCompat.getColor(this.context, R.color.btn_destructive));
            } else {
                btnDefaultAction.setTextColor(ContextCompat.getColor(this.context, R.color.btn_normal));
            }
            btnDefaultAction.setText(this.btnDefaultActionCaption);
        }
        if (this.btnMainActionTopCaption != null) {
            if(this.btnMainActionTopActionType == ActionType.DESTRUCTIVE) {
                btnMainActionTop.setTextColor(ContextCompat.getColor(this.context, R.color.btn_destructive));
            } else {
                btnMainActionTop.setTextColor(ContextCompat.getColor(this.context, R.color.btn_normal));
            }
            btnMainActionTop.setText(this.btnMainActionTopCaption);
        }
        if (this.btnMainActionBottomCaption != null) {
            btnMainActionBottom.setVisibility(View.VISIBLE);
            if(this.btnMainActionBottomActionType == ActionType.DESTRUCTIVE) {
                btnMainActionBottom.setTextColor(ContextCompat.getColor(this.context, R.color.btn_destructive));
            } else {
                btnMainActionBottom.setTextColor(ContextCompat.getColor(this.context, R.color.btn_normal));
            }
            btnMainActionBottom.setText(this.btnMainActionBottomCaption);
        }

        if(this.btnDefaultActionListener != null) {
            btnDefaultAction.setOnClickListener(this.btnDefaultActionListener);
        }
        if(this.btnMainActionTopListener != null) {
            btnMainActionTop.setOnClickListener(this.btnMainActionTopListener);
        }
        if(this.btnMainActionBottomListener != null) {
            btnMainActionBottom.setOnClickListener(this.btnMainActionBottomListener);
        }

        return view;
    }

//    @Override
//    public void onAttach(@NonNull Context context) {
//        super.onAttach(context);
//        try {
//            bottomSheetActions = (BottomSheetActions) context;
//        } catch (ClassCastException ex) {
//            throw new ClassCastException(context.toString() + " must be implemented from BottomActionSheet");
//        }
//    }

    public ActionSheet setTitle(@NonNull Context context, @NonNull String title) {
        this.context = context;
        this.title = title;
        return this;
    }

    public ActionSheet setMessage(@NonNull Context context, @NonNull String message) {
        this.context = context;
        this.message = message;
        return this;
    }

    public ActionSheet setMainTopAction(@NonNull Context context, @NonNull String caption, ActionType actionType, View.OnClickListener onClickListener) {
        this.context = context;
        this.btnMainActionTopActionType = actionType;
        this.btnMainActionTopCaption = caption;
        this.btnMainActionTopListener = onClickListener;
        return this;
    }

    public ActionSheet setMainBottomAction(@NonNull Context context, @NonNull String caption, ActionType actionType, View.OnClickListener onClickListener) {
        this.context = context;
        this.btnMainActionBottomActionType = actionType;
        this.btnMainActionBottomCaption = caption;
        this.btnMainActionBottomListener = onClickListener;
        return this;
    }

    public ActionSheet setDefaultBottomAction(@NonNull Context context, @NonNull String caption, ActionType actionType, View.OnClickListener onClickListener) {
        this.context = context;
        this.btnDefaultActionType = actionType;
        this.btnDefaultActionCaption = caption;
        this.btnDefaultActionListener = onClickListener;
        return this;
    }

    public enum ActionType {
        NORMAL,
        DESTRUCTIVE
    }

    public interface BottomSheetActions {
        void onMainActionTopClicked();

        void onMainActionBottomClicked();

        void onMainActionDefaultClicked();
    }
}
