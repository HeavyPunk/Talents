package com.digitalthunder.ui.events;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.digitalthunder.R;
import com.digitalthunder.ui.events.contest.Contest;
import com.digitalthunder.ui.events.contest.ContestFragment;
import com.digitalthunder.ui.opportunities.OpportunitiesFragment;

import java.util.ArrayList;

public class EventsFragment extends Fragment {

    ImageView contestImage, mentorsImage;

    @SuppressLint("ClickableViewAccessibility")
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View root = inflater.inflate(R.layout.fragment_events, container, false);

        contestImage = root.findViewById(R.id.picture_contest);
        mentorsImage = root.findViewById(R.id.picture_mentors);

        contestImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getFragmentManager();
                if (fragmentManager != null) {
                    ContestFragment contestFragment = new ContestFragment();
                    fragmentManager
                            .beginTransaction()
                            .replace(R.id.nav_host_fragment, contestFragment)
                            .commit();
                }
            }
        });

        mentorsImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        return root;
    }
}