import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    public static final String DEFAULT_DELIMITER = ",|:";
    public static final String CUSTOM_DELIMITER_REGEXP = "//(.)\n(.*)";

    public static int splitAndSum(final String text) {
        int result = 0;
        if (text == null || text.isBlank()) {
            result = 0;
        } else {
            final Matcher m = Pattern.compile(CUSTOM_DELIMITER_REGEXP).matcher(text);
            if (m.find()) {
                final String customDelimiter = m.group(1);
                String[] values = m.group(2).split(customDelimiter);
                for (String value : values) {
                    result += Integer.parseInt(value);
                }
            } else {
                String[] values = text.split(DEFAULT_DELIMITER);
                for (String value : values) {
                    final int number = Integer.parseInt(value);
                    if (number < 0) {
                        throw new RuntimeException("음수는 허용하지 않습니다.");
                    }
                    result += number;
                }
            }
        }
        return result;
    }
}
