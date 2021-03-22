package com.latam.millas.Logger;

import java.util.logging.Formatter;
import java.util.logging.LogRecord;
import java.util.Date;

public class LoggerFormatter extends Formatter {

    @Override
    public String format(LogRecord record) {
        return record.getThreadID() + "::" + record.getSourceClassName() + "::"
                + record.getSourceMethodName() + "::"
                + new Date(record.getMillis()) + "::"
                + record.getMessage() + "\n";
    }
}
