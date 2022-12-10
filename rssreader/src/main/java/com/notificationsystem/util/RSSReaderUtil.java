package com.notificationsystem.util;

import com.notificationsystem.model.Feed;
import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.FeedException;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RSSReaderUtil {
    public static List<Feed> read(String feedURL) throws IOException, FeedException{
        URL feedSource = new URL(feedURL);
        SyndFeedInput input = new SyndFeedInput();
        SyndFeed feed = input.build(new XmlReader(feedSource));
        List<Feed> results = new ArrayList<>();
        Iterator iterator = feed.getEntries().iterator();
        while (iterator.hasNext()){
            SyndEntry syndEntry = (SyndEntry) iterator.next();
            results.add(mapToFeed(syndEntry));
        }
        return results;
    }
    private static Feed mapToFeed(SyndEntry syndEntry) {
        Feed article = new Feed();
        article.setTitle(syndEntry.getTitle());
        article.setDescription((syndEntry.getDescription().toString()));
        article.setLink(syndEntry.getLink());
        return article;
    }
}
