package com.example.thienvu.newsarroundtheworld;

import android.content.AsyncTaskLoader;
import android.content.Context;

import java.util.List;

/**
 * Created by thienvu on 3/7/17.
 */

public class NewsLoader extends AsyncTaskLoader<List<News>> {

    /**
     * Query URL
     */
    private String mUrl;

    /**
     * Constructs a new NewsLoader.
     * @param context of the activity
     * @param url     to load data from
     */
    public NewsLoader(Context context, String url) {
        super(context);
        mUrl = url;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Override
    public List<News> loadInBackground() {
        if (mUrl == null) {
            return null;
        }
        List<News> news = QueryUtils.fetchNewsData(mUrl);
        return news;
    }
}
