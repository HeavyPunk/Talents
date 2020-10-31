package com.digitalthunder.ui.events.contest;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.digitalthunder.R;
import com.digitalthunder.ui.events.contest.Contest;
import com.digitalthunder.ui.events.contest.ContestAdapter;
import com.digitalthunder.ui.events.contest.ContestThread;

import java.util.ArrayList;

public class ContestFragment extends Fragment {

    public static ArrayList<Contest> olimpiads = null;

    Button searchButton;
    TextView searchSpace;
    RecyclerView recyclerView;
    Thread downloading;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        final View root = inflater.inflate(R.layout.fragment_contest, container, false);
        searchButton = root.findViewById(R.id.search_button);
        searchSpace = root.findViewById(R.id.searchSpace);

        if(searchSpace != null) {
            downloading = new Thread(new ContestThread(searchSpace.getText().toString()));
            downloading.start();
            try {
                while (olimpiads == null) ;
                if (!olimpiads.toString().equals(""))
                    Log.d("Main threat!!!", olimpiads.toString());
                else
                    Log.d("Main threat!!!", "null");
            } catch (Exception e) {
                e.printStackTrace();
                Log.d("Main threat!!!", "ERROR");
            }
            Log.d("Fragment", "All created");
            recyclerView = root.findViewById(R.id.olimpiades_recycle);
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            final ContestAdapter adapter = new ContestAdapter(olimpiads);
            recyclerView.setAdapter(adapter);
        }

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (downloading != null) {
                    if(searchSpace != null) {
                        downloading = new Thread(new ContestThread(searchSpace.getText().toString()));
                        downloading.start();
                        try {
                            while (olimpiads == null) ;
                            if (!olimpiads.toString().equals(""))
                                Log.d("Main threat!!!", olimpiads.toString());
                            else
                                Log.d("Main threat!!!", "null");
                        } catch (Exception e) {
                            e.printStackTrace();
                            Log.d("Main threat!!!", "ERROR");
                        }
                        Log.d("Fragment", "All created");
                        recyclerView = root.findViewById(R.id.olimpiades_recycle);
                        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                        final ContestAdapter adapter = new ContestAdapter(olimpiads);
                        recyclerView.setAdapter(adapter);
                    }
                }
            }
        });
        return root;
    }
}