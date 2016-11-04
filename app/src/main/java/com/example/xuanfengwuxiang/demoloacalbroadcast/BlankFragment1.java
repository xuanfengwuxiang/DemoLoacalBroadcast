package com.example.xuanfengwuxiang.demoloacalbroadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.LocalBroadcastManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class BlankFragment1 extends Fragment {

    private TextView mTv;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = View.inflate(getActivity(),R.layout.fragment_blank_fragment1, null);
        mTv = (TextView) view.findViewById(R.id.tv);
        BroadcastReceiver cameraPicBroadcastReceiver = new BroadcastReceiver() {
            public void onReceive(Context context, Intent intent) {

                String txt = intent.getStringExtra("BlankFragment");
                mTv.setText(txt);
            }

        };
        IntentFilter intentFilter = new IntentFilter("com.heima.hh");

        final LocalBroadcastManager localBroadcastManager = LocalBroadcastManager.getInstance(getActivity());

        localBroadcastManager.registerReceiver(cameraPicBroadcastReceiver,intentFilter);
        return view;
    }


}
