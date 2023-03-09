package org.proxy.video;

import java.util.HashMap;
import java.util.Map;

public class ProxyVideoDownloader implements VideoDownloader{

    private final Map<String, Video> cache = new HashMap<>();
    private final VideoDownloader downloader = new RealVideoDownloader();

    @Override
    public Video getVideo(String videoName) {

        if(!cache.containsKey(videoName)){
            cache.put(videoName, downloader.getVideo(videoName));
        }
        System.out.println("Retrieving video from cache... Video Name : "+ videoName);
        System.out.println("-----------------------");
        return cache.get(videoName);
    }
}
