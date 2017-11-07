package com.example.prasanth.sliderlayoutapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;
import com.example.prasanth.sliderlayoutapplication.slider.SliderTextView;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener {

    private SliderLayout sliderLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sliderLayout = (SliderLayout) findViewById(R.id.slider);
        HashMap<String, Integer> imageDetails = new HashMap();
        imageDetails.put("Hannibal", R.drawable.hannibal);
        imageDetails.put("Big Bang Theory", R.drawable.bigbang);
        imageDetails.put("House of Cards", R.drawable.house);
        imageDetails.put("Game of thrones", R.drawable.game_of_thrones);

        sliderLayout.addOnPageChangeListener(this);

        for (String keyName : imageDetails.keySet()) {
            SliderTextView sliderTextView = new SliderTextView(this);
            sliderTextView.description("Hello Brother")
                    .image(imageDetails.get(keyName))
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .setOnSliderClickListener(this);
            sliderLayout.addSlider(sliderTextView);
        }
        sliderLayout.setPresetTransformer(SliderLayout.Transformer.Foreground2Background);
        sliderLayout.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        sliderLayout.setCustomAnimation(new DescriptionAnimation());
        sliderLayout.setDuration(2000);
    }

    @Override
    protected void onStop() {
        // To prevent a memory leak on rotation, make sure to call stopAutoCycle() on the slider before activity or fragment is destroyed
        sliderLayout.stopAutoCycle();
        super.onStop();
    }

    @Override
    public void onSliderClick(BaseSliderView slider) {
        int currentPosition = sliderLayout.getCurrentPosition();
        if (currentPosition == 0) {
            Toast.makeText(this, "You clicked first image", Toast.LENGTH_LONG).show();
        } else
            Toast.makeText(this, "Under Construction", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        Log.d("Slider Demo", "Page Changed: " + position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
