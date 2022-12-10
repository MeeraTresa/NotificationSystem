package com.notificationsystem.service;

import com.notificationsystem.model.Feed;
import com.notificationsystem.util.RSSReaderUtil;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

@Service
public class ProducerService {
    @EventListener(ApplicationStartedEvent.class)
    public void generate() throws IOException, InterruptedException {
        String url = "";
        while (true) {
            BufferedReader br = new BufferedReader(new InputStreamReader(new ClassPathResource("RSSFeedURLs.txt").getInputStream()));
            try {
                while ((url = br.readLine()) != null) {
                    List<Feed> feedArticles = RSSReaderUtil.read(url);
                    System.out.println("url : "+url);
                    feedArticles.forEach(a-> System.out.println(a.toString()));
                    System.out.println("==========");
                    Thread.sleep(100);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            Thread.sleep(5000);

        }
    }
}
