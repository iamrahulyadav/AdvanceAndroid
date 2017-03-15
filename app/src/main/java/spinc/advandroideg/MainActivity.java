package spinc.advandroideg;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.FrameLayout;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import spinc.advandroideg.controller.RecyclerClickListener;

public class MainActivity extends AppCompatActivity implements RecyclerClickListener {

    RecyclerView recyclerViewHome;
    FrameLayout frameContainer;
    List<String> listHomeItems;
    HomeRecyclerAdapter homeRecyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewHome = (RecyclerView) findViewById(R.id.recyclerViewHome);
        frameContainer = (FrameLayout) findViewById(R.id.frameContainer);

        String[] homeItemrray = getResources().getStringArray(R.array.homeItemArray);
        listHomeItems = new ArrayList<String>(Arrays.asList(homeItemrray));

        recyclerViewHome.setLayoutManager(new GridLayoutManager(this, 2));
        homeRecyclerAdapter = new HomeRecyclerAdapter(this, listHomeItems, this);
        recyclerViewHome.setAdapter(homeRecyclerAdapter);
    }

    @Override
    public void onItemCLick(int position) {
        switch (position) {
            // bitmap memory management
            case 0:

                break;
            // MVVM
            case 1:

                break;
            // MVP
            case 2:

                break;
            //
            case 3:

                break;
        }
    }
}
