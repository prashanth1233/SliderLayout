package com.example.prasanth.sliderlayoutapplication.slider;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.example.prasanth.sliderlayoutapplication.R;

/**
 * Created by Prasanth on 11/7/2017.
 */

public class SliderTextView extends BaseSliderView {
    private Context context;

    public SliderTextView(Context context) {
        super(context);
        this.context = context;
    }

    @Override
    public View getView() {
        View view = LayoutInflater.from(context).inflate(R.layout.slider_text_view, null);
        ImageView sampleImage = view.findViewById(R.id.sampleImage);
        TextView sampleText = view.findViewById(R.id.sampleText);
        /*sampleImage.setImageResource(R.drawable.first);
        sampleText.setText("Hello");*/
        sampleText.setText(getDescription());
        bindEventAndShow(view, sampleImage);
        return view;
    }
}
