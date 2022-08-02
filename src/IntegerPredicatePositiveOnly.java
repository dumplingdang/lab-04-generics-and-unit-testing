import java.util.function.Predicate;

/**
 * Describe a type Predicate to test whether an Integer is positive.
 * @author Jianfen Deng ON 2020-10-23
 * @version 1.0
 */
public class IntegerPredicatePositiveOnly implements Predicate<Integer> {
    /**
     * Evaluates this predicate on the given argument.
     * @param integer the input argument
     * @return {@code true} if the input argument matches the predicate,
     * otherwise {@code false}
     */
    @Override
    public boolean test(final Integer integer) {
        return integer >= 0;
    }
}
