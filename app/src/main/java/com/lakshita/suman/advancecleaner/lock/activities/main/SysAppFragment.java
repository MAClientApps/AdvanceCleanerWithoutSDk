package com.lakshita.suman.advancecleaner.lock.activities.main;

import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.lakshita.suman.advancecleaner.R;
import com.lakshita.suman.advancecleaner.lock.adapters.MainAdapter;
import com.lakshita.suman.advancecleaner.lock.base.BaseFragment;
import com.lakshita.suman.advancecleaner.lock.model.CommLockInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xian on 2017/3/1.
 */

public class SysAppFragment extends BaseFragment {

    private RecyclerView mRecyclerView;
    @Nullable
    private List<CommLockInfo> data, list;
    @Nullable
    private MainAdapter mMainAdapter;

    @NonNull
    public static SysAppFragment newInstance(List<CommLockInfo> list) {
        SysAppFragment sysAppFragment = new SysAppFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("data", (ArrayList<? extends Parcelable>) list);
        sysAppFragment.setArguments(bundle);
        return sysAppFragment;
    }

    @Override
    protected int getContentViewId() {
        return R.layout.fragment_lock_app_list;
    }

    @Override
    protected void init(View rootView) {
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        data = getArguments().getParcelableArrayList("data");
        mMainAdapter = new MainAdapter(getContext());
        mRecyclerView.setAdapter(mMainAdapter);
        list = new ArrayList<>();
        for (CommLockInfo info : data) {
            if (info.isSysApp()) {
                list.add(info);
            }
        }
        mMainAdapter.setLockInfos(list);
    }
}
