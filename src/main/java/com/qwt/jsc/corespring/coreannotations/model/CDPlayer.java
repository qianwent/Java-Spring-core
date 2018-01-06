package com.qwt.jsc.corespring.coreannotations.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Created by Wentao Qian on 1/2/2018.
 */
@Component
public class CDPlayer implements MediaPlayer {

    private CompactDisc cd;

    @Autowired
    public CDPlayer(@Qualifier("discA") CompactDisc cd) {
        this.cd = cd;
    }
    //If no @Qualifier here to specify the bean, then @Primary need to be uncommented out in DiscA
//    public CDPlayer(CompactDisc cd) {
//        this.cd = cd;
//    }

    @Override
    public String play() {
        return cd.getContent();
    }
}
