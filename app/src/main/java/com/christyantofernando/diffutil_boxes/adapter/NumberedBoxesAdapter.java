package com.christyantofernando.diffutil_boxes.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.christyantofernando.diffutil_boxes.R;
import com.christyantofernando.diffutil_boxes.model.NumberedBox;

import java.util.ArrayList;
import java.util.List;

public class NumberedBoxesAdapter extends RecyclerView.Adapter<NumberedBoxesAdapter.ViewHolder> {
    private List<NumberedBox> numberedBoxes = new ArrayList<>();
    
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder (@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_box, parent, false));
    }
    
    @Override
    public void onBindViewHolder (@NonNull ViewHolder holder, int position) {
        holder.bind(numberedBoxes.get(position));
    }
    
    @Override
    public int getItemCount () {
        return numberedBoxes.size();
    }
    
    public void updateBoxes(List<NumberedBox> numberedBoxes){
        DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(new DiffCallback(this.numberedBoxes, numberedBoxes));
        this.numberedBoxes = numberedBoxes;
        diffResult.dispatchUpdatesTo(this);
    }
    
    class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvNumber;
        
        ViewHolder (@NonNull View itemView) {
            super(itemView);
            tvNumber = itemView.findViewById(R.id.tv_number);
        }
        
        void bind (NumberedBox numberedBox){
            tvNumber.setText(String.valueOf(numberedBox.getNumber()));
            itemView.setBackgroundColor(itemView.getContext().getResources().getColor(numberedBox.getColorRes()));
        }
    }
}
