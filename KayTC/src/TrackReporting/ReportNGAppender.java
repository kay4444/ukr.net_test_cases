package TrackReporting;

/**
 * Created by serhii.kaihorodov on 12/9/2015.
 */
import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.Layout;
import org.apache.log4j.spi.LoggingEvent;

public class ReportNGAppender extends AppenderSkeleton {

    protected void append(LoggingEvent loggingEvent) {
        final Layout layout = getLayout();
        final String valueToLog;
        if (layout != null) {
            valueToLog = layout.format(loggingEvent);
        } else {
            valueToLog = loggingEvent.getMessage().toString();
        }

        Logger.log(valueToLog);
    }

    @Override
    public void close() {
    }

    @Override
    public boolean requiresLayout() {
        return true;
    }
}