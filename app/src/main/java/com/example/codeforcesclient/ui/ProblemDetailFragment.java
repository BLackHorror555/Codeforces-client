package com.example.codeforcesclient.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.codeforcesclient.R;
import com.example.codeforcesclient.data.local.model.Problem;

public class ProblemDetailFragment extends Fragment {

    private static final String URL_BEGIN = "http://codeforces.com/problemset/problem/";

    private final String mURL;
    private WebView mBrowser;

    ProblemDetailFragment(Problem aProblem) {
        mURL = URL_BEGIN + aProblem.getContestId() + "/" + aProblem.getIndex();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_problem_detail_view, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mBrowser = view.findViewById(R.id.problem_detail_web_view);
        mBrowser.getSettings().setLoadWithOverviewMode(true);
        mBrowser.getSettings().setUseWideViewPort(true);
        mBrowser.getSettings().setBuiltInZoomControls(true);
        mBrowser.getSettings().setDisplayZoomControls(false);
        mBrowser.setWebViewClient(new CustomWebViewClient());
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mBrowser.loadUrl(mURL);
    }

    static class CustomWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            return true;
        }
    }
}
