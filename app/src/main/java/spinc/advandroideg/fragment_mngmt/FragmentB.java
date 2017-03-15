package spinc.advandroideg.fragment_mngmt;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;


import spinc.advandroideg.R;
import spinc.advandroideg.mvp_pattern.base.BaseFragment;

/**
 * Created by webwerks on 16/2/17.
 */

public class FragmentB extends BaseFragment implements FragmentManager.OnBackStackChangedListener,View.OnClickListener {
    public static final String TAG = "FragmentB";
    View rootView;
    FrameLayout frameContainerB;
    AppCompatButton buttonAddD_in_fragmentB;
    AppCompatButton buttonAddC_in_fragmentB;


    public static FragmentB newInstance() {

        Bundle args = new Bundle();

        FragmentB fragment = new FragmentB();
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
        rootView = inflater.inflate(R.layout.fragment_b,container,false);
        initView(rootView);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    protected void initView(View rootview) {
        frameContainerB = (FrameLayout) rootview.findViewById(R.id.frameContainerB);
        buttonAddD_in_fragmentB = (AppCompatButton) rootview.findViewById(R.id.buttonAddD_in_fragmentB);
        buttonAddC_in_fragmentB = (AppCompatButton) rootview.findViewById(R.id.buttonAddC_in_fragmentB);
        setClicklistener();
    }

    @Override
    protected void setClicklistener() {
        buttonAddD_in_fragmentB.setOnClickListener(this);
        buttonAddC_in_fragmentB.setOnClickListener(this);
    }

    @Override
    public void onBackStackChanged() {
        Log.i(TAG, "onBackStackChanged: B ");
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.buttonAddC_in_fragmentB :
                getFragmentManager().beginTransaction().replace(R.id.frameContainerB,FragmentC.newInstance(),FragmentC.TAG).commit();
                break;
            case R.id.buttonAddD_in_fragmentB :
                getFragmentManager().beginTransaction().replace(R.id.frameContainerB,FragmentD.newInstance(),FragmentD.TAG).commit();
                break;
        }
    }
}
