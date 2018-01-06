package com.qwt.jsc.corespring.coreannotations.model;

import org.springframework.stereotype.Component;

/**
 * Created by Wentao Qian on 1/6/2018.
 */
@Component("discB")
public class DiscB implements CompactDisc {

    private String title = "Disc B";
    private String artist = "Will";

    @Override
    public String getContent() {
        String content = "Content: " + title + " by " + artist;
        return content;
    }
}
