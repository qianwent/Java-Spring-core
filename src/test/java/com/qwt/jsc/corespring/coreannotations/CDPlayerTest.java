package com.qwt.jsc.corespring.coreannotations;

import com.qwt.jsc.corespring.coreannotations.config.CDPlayerConfig;
import com.qwt.jsc.corespring.coreannotations.model.CompactDisc;
import com.qwt.jsc.corespring.coreannotations.model.MediaPlayer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

/**
 * Created by Wentao Qian on 1/2/2018.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=CDPlayerConfig.class)
public class CDPlayerTest {

    @Autowired
    MediaPlayer mediaPlayer;

    @Autowired
    CompactDisc cd;

    @Test
    public void cdShouldNotBeNull() {
        assertNotNull(cd);
    }

    @Test
    public void checkInjection() {
        assertEquals("Content: Disc A by Will", mediaPlayer.play());
    }

}
