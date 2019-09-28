package com.example.lockservice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class ListAdapter extends BaseAdapter {
    private final List<LocksPOJO> locks;
    private final Context context;
    private final LayoutInflater inflater;
    //конструктор для класса listadapter
    public ListAdapter(Context context, List<LocksPOJO> locks){
        this.context = context;
        this.locks = locks;
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    //возвращаем размер списка
    @Override
    public int getCount() {
        return locks.size();
    }
    //возвращаем конкретный элемент
    @Override
    public Object getItem(int i) {
        return locks.get(i);
    }
    //возвращаем идентификатор конкретного элемента
    @Override
    public long getItemId(int i) {
        return i;
    }
    //возвращаем view, т.е. задаем правила инициализации каждого listItem
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View rowItem = inflater.inflate(R.layout.list_item, viewGroup, false);
        TextView t2 = rowItem.findViewById(R.id.t2);
        TextView t3 = rowItem.findViewById(R.id.t3);
        TextView t4 = rowItem.findViewById(R.id.t4);
        TextView t5 = rowItem.findViewById(R.id.t5);

        LocksPOJO lock = locks.get(i);
        t2.setText(lock.getLId().toString());
        t3.setText(lock.getUserId().toString());
        t4.setText(lock.getEmail());
        t5.setText(lock.getLastEcho());
        return rowItem;
    }
}
