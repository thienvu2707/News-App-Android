package com.example.thienvu.newsarroundtheworld;

/**
 * Created by thienvu on 3/6/17.
 */

public class News {

    private String mThumbnail;
    private String mSectionName;
    private String mWebTitle;
    private String mUrl;

    public News(String thumbnail, String sectionName, String webTitle, String url) {
        mThumbnail = thumbnail;
        mSectionName = sectionName;
        mWebTitle = webTitle;
        mUrl = url;
    }

    public String getThumbnail() {
        return mThumbnail;
    }

    public String getSectionName() {
        return mSectionName;
    }

    public String getWebTitle() {
        return mWebTitle;
    }

    public String getUrl() {
        return mUrl;
    }

}
