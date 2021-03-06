package com.syracuse.rameka.scoutapp;

/**
 * This file was used to create a custom view with double text view.
 */

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.syracuse.rameka.scoutapp.R;

public class DoubleTextView extends LinearLayout {
    LinearLayout layout = null;
    TextView leftTextView = null;
    TextView rightTextView = null;
    Context mContext = null;

    public DoubleTextView(Context context) {

        super(context);
        mContext = context;
    }

    public DoubleTextView(Context context, AttributeSet attrs) {
        super(context, attrs);

        mContext = context;

        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.DoubleText);

        String leftText = a.getString(R.styleable.DoubleText_leftText);
        String rightText = a.getString(R.styleable.DoubleText_rightText);

        leftText = leftText == null ? "" : leftText;
        rightText = rightText == null ? "" : rightText;

        String service = Context.LAYOUT_INFLATER_SERVICE;
        LayoutInflater li = (LayoutInflater) getContext().getSystemService(service);

        layout = (LinearLayout) li.inflate(R.layout.double_text, this, true);

        leftTextView = (TextView) layout.findViewById(R.id.left_text);
        rightTextView = (TextView) layout.findViewById(R.id.right_text);

        leftTextView.setText(leftText);
        rightTextView.setText(rightText);

        a.recycle();
    }

    public DoubleTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        mContext = context;
    }

    @SuppressWarnings("unused")
    public void setLeftText(String text) {
        leftTextView.setText(text);
    }

    @SuppressWarnings("unused")
    public void setRightText(String text) {
        rightTextView.setText(text);
    }

    @SuppressWarnings("unused")
    public String getLeftText() {
        return leftTextView.getText().toString();
    }

    @SuppressWarnings("unused")
    public String getRightText() {
        return rightTextView.getText().toString();
    }

}