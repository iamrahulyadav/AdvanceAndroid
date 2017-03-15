package spinc.advandroideg.fragment_mngmt;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.AppCompatButton;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import spinc.advandroideg.R;
import spinc.advandroideg.fragment_mngmt.controller.OnBackClick;
import spinc.advandroideg.mvp_pattern.base.BaseFragment;


/**
 * Created by webwerks on 16/2/17.
 */

public class FragmentA extends BaseFragment implements FragmentManager.OnBackStackChangedListener, View.OnClickListener,OnBackClick {

    public static final String TAG = "FragmentA";
    View rootView;

    AppCompatButton buttonAddB;
    LinearLayout llContainerFragmentA;

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
        buttonAddB = (AppCompatButton) rootview.findViewById(R.id.buttonAddB);
        llContainerFragmentA = (LinearLayout) rootview.findViewById(R.id.llContainerFragmentA);


        setClicklistener();
    }

    @Override
    protected void setClicklistener() {
        buttonAddB.setOnClickListener(this);
    }

    @Override
    public void onBackStackChanged() {
        Log.i(TAG, "onBackStackChanged: A ");
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.buttonAddB:
                getFragmentManager().beginTransaction().replace(R.id.llContainerFragmentA,FragmentB.newInstance(),FragmentB.TAG).commit();
                break;
        }
    }


    @Override
    public void onBackClickListener() {
        // here update the fragment which you want to update
    }
}
