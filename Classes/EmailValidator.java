package Classes;

import java.util.regex.*;

public class EmailValidator {
    
    private Pattern pattern;
    private Matcher matcher;
    private static final String EMAIL_PATTERN = "^[a-zA-Z0-9]+[a-zA-Z0-9._-]*@[a-zA-Z0-9]+[a-zA-Z0-9._-]*\\.[a-zA-Z]{2,}$";
    public EmailValidator() {
        pattern = Pattern.compile(EMAIL_PATTERN);
    }

    public boolean validate(final String email) {
        matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
