package com.test.book.log;

import ch.qos.logback.classic.pattern.MessageConverter;
import ch.qos.logback.classic.spi.ILoggingEvent;

/**
 * @author Administrator
 */
public class MaskingPatternLayout extends MessageConverter {

    @Override
    public String convert(ILoggingEvent event) {
        return event.getFormattedMessage();
    }
}
