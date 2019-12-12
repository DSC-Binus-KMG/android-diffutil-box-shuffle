package com.christyantofernando.diffutil_boxes.adapter;

import androidx.recyclerview.widget.DiffUtil;

import com.christyantofernando.diffutil_boxes.model.NumberedBox;

import java.util.List;

public class DiffCallback extends DiffUtil.Callback {
    List<NumberedBox> oldList;
    List<NumberedBox> newList;
    
    public DiffCallback (List<NumberedBox> oldList, List<NumberedBox> newList) {
        this.oldList = oldList;
        this.newList = newList;
    }
    
    @Override
    public int getOldListSize () {
        return oldList.size();
    }
    
    @Override
    public int getNewListSize () {
        return newList.size();
    }
    
    @Override
    public boolean areItemsTheSame (int oldItemPosition, int newItemPosition) {
        return oldList.get(oldItemPosition).getNumber() == newList.get(newItemPosition).getNumber();
    }
    
    @Override
    public boolean areContentsTheSame (int oldItemPosition, int newItemPosition) {
        return oldList.get(oldItemPosition).getNumber() == newList.get(newItemPosition).getNumber();
    }
}
