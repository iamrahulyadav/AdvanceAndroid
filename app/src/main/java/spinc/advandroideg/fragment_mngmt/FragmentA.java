package spinc.advandroideg.fragment_mngmt;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import spinc.advandroideg.HomeRecyclerAdapter;
import spinc.advandroideg.R;
import spinc.advandroideg.controller.RecyclerClickListener;
import spinc.advandroideg.fragment_mngmt.controller.OnBackClick;
import spinc.advandroideg.mvp_pattern.base.BaseFragment;



/**
 * Created by webwerks on 16/2/17.
 */

public class FragmentA extends BaseFragment implements FragmentManager.OnBackStackChangedListener, RecyclerClickListener,OnBackClick {

    public static final String TAG = "FragmentA";
    View rootView;

    RecyclerView recyclerViewFragmentA;
    LinearLayout llContainerFragmentA;

    HomeRecyclerAdapter homeRecyclerAdapter;
    List<String> listData = new ArrayList<>();


    public static FragmentA newInstance() {

        Bundle args = new Bundle();

        FragmentA fragment = new FragmentA();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_a, container, false);
        initView(rootView);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    protected void initView(View rootview) {
        recyclerViewFragmentA = (RecyclerView) rootview.findViewById(R.id.recyclerViewFragmentA);
        llContainerFragmentA = (LinearLayout) rootview.findViewById(R.id.llContainerFragmentA);

        listData.add("Cupcake");
        listData.add("Donunt");
        listData.add("Eclair");
        listData.add("Froyo");
        listData.add("GIngerBread");
        listData.add("Honey COmb");
        listData.add("Ice cream Sandwich");
        listData.add("Jelly Bean");
        listData.add("Kit Kat");
        listData.add("Lolipop");
        listData.add("Marse Mallo");
        listData.add("Naught");

        recyclerViewFragmentA.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        homeRecyclerAdapter = new HomeRecyclerAdapter(getActivity(), listData, this);
        recyclerViewFragmentA.setAdapter(homeRecyclerAdapter);

        setClicklistener();
    }

    @Override
    protected void setClicklistener() {

    }

    @Override
    public void onBackStackChanged() {
        Log.i(TAG, "onBackStackChanged: A ");
    }

    @Override
    public void onBackClickListener() {
        // here update the fragment which you want to update
        Log.i(TAG, "onBackClickListener: here ");
    }

    @Override
    public void onItemCLick(int position) {
        Toast.makeText(getActivity(), "On Back press in Fragment A", Toast.LENGTH_SHORT).show();
        recyclerViewFragmentA.setVisibility(View.GONE);
        llContainerFragmentA.setVisibility(View.VISIBLE);
        getFragmentManager().beginTransaction().replace(R.id.llContainerFragmentA,FragmentB.newInstance(),FragmentB.TAG).commit();
    }
}
