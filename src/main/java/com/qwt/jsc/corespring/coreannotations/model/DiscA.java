package com.qwt.jsc.corespring.coreannotations.model;

import org.springframework.stereotype.Component;

/**
 * Created by Wentao Qian on 1/2/2018.
 */
@Component
public class DiscA implements CompactDisc {

    private String title = "Disc A";
    private String artist = "Will";

    @Override
    public String getContent() {
        String content = "Content: " + title + " by " + artist;
        return content;
    }
}
