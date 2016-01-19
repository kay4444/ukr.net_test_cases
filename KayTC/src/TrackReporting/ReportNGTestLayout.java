package TrackReporting;

/**
 * Created by serhii.kaihorodov on 12/9/2015.
 */
import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.spi.LoggingEvent;


class ReportNGTestLayout extends PatternLayout{
//    @Override
//    public String format(LoggingEvent event) {
//        String newMsg= StringEscapeUtils.escapeHtml4(event.getMessage().toString());
//        LoggingEvent encodedEvent = new LoggingEvent(event.fqnOfCategoryClass, new Category(event.categoryName),event.timeStamp, event.level, newMsg, event.getThrowableInformation().getThrowable());
//        String baseFmt = super.format(encodedEvent).replace("@{{","<").replace("@}}",">");
//        return "<div class=step${event.level.toString()}>${baseFmt}</div><br/>";

    @Override
    public String format(LoggingEvent event) {
        String newMsg= StringEscapeUtils.escapeHtml4(event.getMessage().toString());
        LoggingEvent encodedEvent = new LoggingEvent(event.fqnOfCategoryClass, event.getLogger(), event.timeStamp, event.level, newMsg, event.getThrowableInformation().getThrowable());
        String baseFmt = super.format(encodedEvent).replace("@{{","<").replace("@}}",">");
        return "<div class=step${event.level.toString()}>${baseFmt}</div><br/>";
    }
}