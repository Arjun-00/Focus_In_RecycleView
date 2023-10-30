package com.posibolt.focusinrecycleview.adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.posibolt.focusinrecycleview.R;
import com.posibolt.focusinrecycleview.modelclass.Item;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    public List<Item> itemDatas;

    public MyAdapter(List<Item> listItem){
        this.itemDatas = listItem;
    }
    @NonNull
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_item_view,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.MyViewHolder holder, int position) {

        holder.userName.setText(itemDatas.get(position).getName());
        holder.userId.setText(itemDatas.get(position).getNumber().toString());

    }

    @Override
    public int getItemCount() {
        return itemDatas.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView userName;
        TextView userId;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            userName = itemView.findViewById(R.id.userName);
            userId = itemView.findViewById(R.id.userId);
        }
    }
}
