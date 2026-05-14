package kr.ac.kopo.actionbarfragmenttest;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class MyTabFragment extends Fragment {
    String tabName;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tabName = getArguments().getString("tabName");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        LinearLayout baseLayout = new LinearLayout(getActivity());
        baseLayout.setOrientation(LinearLayout.VERTICAL);
        baseLayout.setLayoutParams(new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));
        baseLayout.setGravity(Gravity.CENTER);

        ImageView img1 = new ImageView(getActivity());
        img1.setAdjustViewBounds(true);
        baseLayout.addView(img1);

        if (tabName.equals("Dog")) {
            baseLayout.setBackgroundColor(Color.GREEN);
            img1.setImageResource(R.drawable.dog);
        }
        if (tabName.equals("Cat")) {
            baseLayout.setBackgroundColor(Color.RED);
            img1.setImageResource(R.drawable.cat);
        }
        if (tabName.equals("Horse")) {
            baseLayout.setBackgroundColor(Color.rgb(204, 114, 61));
            img1.setImageResource(R.drawable.horse);
        }

        return baseLayout;
    }
}