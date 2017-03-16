package com.example.thienvu.newsarroundtheworld;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by thienvu on 3/6/17.
 */

public class NewsAdapter extends ArrayAdapter<News> {
    private Context mContext;

    public NewsAdapter(Context context, ArrayList<News> news) {
        super(context, 0, news);
        mContext = context;
    }

    /**
     * "view holder" that holds references to each subview
     */
    private class ViewHolder {

        private ImageView newsImage;
        private TextView sectionName;
        private TextView webTitle;

        public ViewHolder(ImageView newsImage, TextView sectionName, TextView webTitle) {
            this.newsImage = newsImage;
            this.sectionName = sectionName;
            this.webTitle = webTitle;
        }
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        News currentNews = getItem(position);

        // Check if there is an existing view (called convertView) that we can reuse,
        if (convertView == null) {
            //if convertView is null, then inflate a new list item layout.
            convertView = LayoutInflater.from(mContext).inflate(R.layout.news_list_items, null);

            final ImageView newsImage = (ImageView) convertView.findViewById(R.id.image_view);
            final TextView sectionName = (TextView) convertView.findViewById(R.id.section_name);
            final TextView webTitle = (TextView) convertView.findViewById(R.id.web_title);

            final ViewHolder viewHolder = new ViewHolder(newsImage, sectionName, webTitle);
            convertView.setTag(viewHolder);
        }

        final ViewHolder viewHolder = (ViewHolder) convertView.getTag();
        Picasso.with(mContext).load(currentNews.getThumbnail()).resize(100, 120).into(viewHolder.newsImage);
        viewHolder.sectionName.setText(currentNews.getSectionName());
        viewHolder.webTitle.setText(currentNews.getWebTitle());

        return convertView;
    }
}
