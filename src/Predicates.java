import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

/***
 * Describes a type Predicates to test whether an object meets a certain criteria.
 * @author Jianfen Deng
 * @version 1.0
 * @param <T> this describes my type parameter
 */
public final class Predicates<T> {
    private Predicates() {
    }
    /**
     * Remove every object o from someCollection for which
     * aPredicate.test(o) is true.
     * @param someCollection a collection passed in
     * @param aPredicate     a predicate passed in for testing
     * @param <T>            this describes my type parameter
     */
    public static <T> void remove(final Collection<T> someCollection,
                                  final Predicate<T> aPredicate) {
        Iterator<T> iterator = someCollection.iterator();
        while (iterator.hasNext()) {
            T item = iterator.next();
            if (aPredicate.test(item)) {
                iterator.remove();
            }
        }
    }
    /**
     * Remove every object o from someCollection for which
     * aPredicate.test(o) is false.
     * @param someCollection a collection passed in
     * @param aPredicate     a predicate passed in for testing
     * @param <T>            this describes my type parameter
     */
    public static <T> void retain(final Collection<T> someCollection,
                                  final Predicate<T> aPredicate) {
        Iterator<T> iterator = someCollection.iterator();
        while (iterator.hasNext()) {
            T item = iterator.next();
            if (!aPredicate.test(item)) {
                iterator.remove();
            }
        }
    }
    /**
     * Return a list that contains every object o from someCollection for which
     * aPredicate.test(o) is true.
     * @param someCollection a collection passed in
     * @param aPredicate     a predicate passed in for testing
     * @param <T>            this describes my type parameter
     * @return a list that contains every obejct o from someCollection for which aPredicate.test(o)
     * is true
     */
    public static <T> List<T> collect(final Collection<T> someCollection,
                                      final Predicate<T> aPredicate) {
        List<T> list = new ArrayList<>();
        for (T item : someCollection) {
            if (aPredicate.test(item)) {
                list.add(item);
            }
        }
        return list;
    }
    /**
     * Return the index of the first item in someCollection for which
     * aPredicate.test(o) is true, or -1.
     * @param someCollection a collection passed in
     * @param aPredicate     a predicate passed in for testing
     * @param <T>            this describes my type parameter
     * @return the index of the first item in someCollection for which aPredicate.test(o)
     * is true, or -1
     */
    public static <T> int find(final Collection<T> someCollection, final Predicate<T> aPredicate) {
        int index = -1;
//        Iterator<T> iterator = someCollection.iterator();
//        for (int i = 0; i < someCollection.size(); i++) {
//            if (iterator.hasNext()) {
//                T next = iterator.next();
//                if (aPredicate.test(next)) {
//                    index = i;
//                    break;
//                }
//            }
//        }
        List<T> list = (List<T>) someCollection;
        for (int i = 0; i < someCollection.size(); i++) {
            T item = list.get(i);
            if (aPredicate.test(item)) {
                index = i;
                break;
            }
        }
        return index;
    }
}
