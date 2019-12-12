package com.christyantofernando.diffutil_boxes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.christyantofernando.diffutil_boxes.adapter.NumberedBoxesAdapter;
import com.christyantofernando.diffutil_boxes.model.NumberedBox;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button btnShuffle;
    RecyclerView recyclerView;
    NumberedBoxesAdapter numberedBoxesAdapter;
    
    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        recyclerView = findViewById(R.id.rv_boxes);
        btnShuffle = findViewById(R.id.btn_shuffle);
        
        btnShuffle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                numberedBoxesAdapter.updateBoxes(getBoxes());
            }
        });
        
        numberedBoxesAdapter = new NumberedBoxesAdapter();
        recyclerView.setLayoutManager(new GridLayoutManager(this, 4));
        recyclerView.setAdapter(numberedBoxesAdapter);
        numberedBoxesAdapter.updateBoxes(getBoxes());
    }
    
    private List<NumberedBox> getBoxes () {
        int[] colors = {R.color.amethys, R.color.blue, R.color.emerald, R.color.red, R.color.silver, R.color.sunflower, R.color.turquoise};
        List<NumberedBox> numberedBoxes = new ArrayList<>();
    
        int lowerBound = new Random().nextInt(10) + 10;
        int upperBound = new Random().nextInt(10) + 50;
        
        for (int i = lowerBound; i < upperBound; i++) {
            int rand = new Random().nextInt(colors.length);
            numberedBoxes.add(new NumberedBox(i, colors[rand]));
        }
        Collections.shuffle(numberedBoxes);
        return numberedBoxes;
    }
}
