package spinc.advandroideg;

import android.content.Context;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import spinc.advandroideg.controller.RecyclerClickListener;

/**
 * Created by webwerks on 14/3/17.
 */

public class HomeRecyclerAdapter extends RecyclerView.Adapter<HomeRecyclerAdapter.HomeViewHolder> {

    Context context;
    List<String> listData;
    RecyclerClickListener recyclerClickListener;

    public HomeRecyclerAdapter(Context context, List<String> listData, RecyclerClickListener recyclerClickListener) {
        this.context = context;
        this.listData = listData;
        this.recyclerClickListener = recyclerClickListener;
    }

    @Override
    public HomeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.itemview_home, parent, false);

        return new HomeViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(HomeViewHolder holder, final int position) {
        holder.textViewTitleHomeItem.setText(listData.get(position));
        holder.cardviewRootItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recyclerClickListener.onItemCLick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class HomeViewHolder extends RecyclerView.ViewHolder {

        CardView cardviewRootItem;
        AppCompatTextView textViewTitleHomeItem;

        public HomeViewHolder(View itemView) {
            super(itemView);
            cardviewRootItem = (CardView) itemView.findViewById(R.id.cardviewRootItem);
            textViewTitleHomeItem = (AppCompatTextView) itemView.findViewById(R.id.textViewTitleHomeItem);
        }
    }
}
