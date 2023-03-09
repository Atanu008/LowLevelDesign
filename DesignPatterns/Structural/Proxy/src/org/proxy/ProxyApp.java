package org.proxy;

import org.proxy.internet.Internet;
import org.proxy.internet.ProxyInternet;
import org.proxy.video.ProxyVideoDownloader;
import org.proxy.video.VideoDownloader;

//Git Gub : https://github.com/geekific-official/geekific-youtube/blob/main/pattern-structural-proxy/src/main/java/com/youtube/geekific/MainApp.java
//Video : https://www.youtube.com/watch?v=TS5i-uPXLs8&t=124s

public class ProxyApp {
    public static void main(String[] args) {
        Internet internet = new ProxyInternet();
        internet.connectTo("google.com");
        internet.connectTo("banned.com");


        System.out.println("==========================================");

        VideoDownloader videoDownloader = new ProxyVideoDownloader();
        videoDownloader.getVideo("A");
        videoDownloader.getVideo("A");
        videoDownloader.getVideo("likeNsub");
        videoDownloader.getVideo("likeNsub");
        videoDownloader.getVideo("B");
    }
}
