package com.notificationsystem;

import com.notificationsystem.model.Feed;
import com.notificationsystem.util.RSSReaderUtil;
import com.sun.syndication.io.FeedException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 */
@SpringBootApplication
public class App {
    public static void main(String[] args) throws IOException, FeedException {
        System.out.println("Hello World!");
        SpringApplication.run(App.class, args);

        /*
        List<String> targetFeedsList = new ArrayList<>();
        targetFeedsList.add("https://cloudblog.withgoogle.com/rss/");

        for(String url : targetFeedsList){
            List<Feed> results = RSSReaderUtil.read(url);
            System.out.println("url : "+url);
            results.forEach(a-> System.out.println(a.toString()));
            System.out.println("==========");
        }
         */
    }
}
