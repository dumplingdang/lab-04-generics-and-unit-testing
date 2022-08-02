import java.util.function.Predicate;

/**
 * Describes a predicate to test whether the length of a string is equal or more than 5.
 * @author Jianfen Deng ON 2020-10-23
 * @version 1.0
 */
public class StringPredicateLength implements Predicate<String> {
    /**
     * Evaluates this predicate on the given argument.
     * @param s the input argument
     * @return {@code true} if the input argument matches the predicate,
     * otherwise {@code false}
     */
    @Override
    public boolean test(final String s) {
        final int stringLength = 5;
        return s.length() >= stringLength;
    }
}
