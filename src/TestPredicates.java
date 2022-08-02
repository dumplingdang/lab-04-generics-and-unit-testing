import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * To test a type Predicates.
 * @author Jianfen Deng ON 2020-10-21
 * @version 1.0
 */
class TestPredicates {
    private Predicate<String>  aPredicate;
    private Predicate<Integer> aPredicate2;
    @BeforeEach
    void setUp() {
        aPredicate  = new StringPredicateLength();
        aPredicate2 = new IntegerPredicatePositiveOnly();
    }
    @AfterEach
    void tearDown() {
    }
    //test remove method
    @Test
    void testRemoveOneUsingStringAndLengthPredicate() {
        ArrayList<String> collection = new ArrayList<>();
        collection.add("hi");
        collection.add("how");
        collection.add("are");
        collection.add("you");
        collection.add("friend");
        Predicates.remove(collection, aPredicate);
        assertEquals(4, collection.size());
        for (String str : collection) {
            assertTrue(str.length() < 5);
        }
    }
    @Test
    void testRemoveNoneUsingStringAndLengthPredicate() {
        ArrayList<String> collection = new ArrayList<>();
        collection.add("hey");
        collection.add("how");
        collection.add("are");
        collection.add("you");
        collection.add("bro");
        Predicates.remove(collection, aPredicate);
        assertEquals(5, collection.size());
    }
    @Test
    void testRemoveFromEmptyUsingStringAndLengthPredicate() {
        ArrayList<String> collection = new ArrayList<>();
        Predicates.remove(collection, aPredicate);
        assertEquals(0, collection.size());
    }
    @Test
    void testRemoveOneUsingIntegerPredicatePositiveOnly() {
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(-1);
        integers.add(-2);
        integers.add(-3);
        integers.add(-4);
        integers.add(4);
        Predicates.remove(integers, aPredicate2);
        assertEquals(4, integers.size());
    }
    @Test
    void testRemoveNoneUsingIntegerPredicatePositiveOnly() {
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(-1);
        integers.add(-2);
        integers.add(-3);
        integers.add(-4);
        integers.add(-5);
        Predicates.remove(integers, aPredicate2);
        assertEquals(5, integers.size());
    }
    @Test
    void testRemoveFromEmptyUsingIntegerPredicatePositiveOnly() {
        ArrayList<Integer> integers = new ArrayList<>();
        Predicates.remove(integers, aPredicate2);
        assertEquals(0, integers.size());
    }
    //test retain method
    @Test
    void testRetainOneUsingStringAndLengthPredicate() {
        ArrayList<String> collection = new ArrayList<>();
        collection.add("hi");
        collection.add("how");
        collection.add("are");
        collection.add("you");
        collection.add("friend");
        Predicates.retain(collection, aPredicate);
        assertEquals(1, collection.size());
    }
    @Test
    void testRetainOneUsingIntegerPredicatePositiveOnly() {
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(-1);
        integers.add(-2);
        integers.add(-3);
        integers.add(-4);
        integers.add(4);
        Predicates.retain(integers, aPredicate2);
        assertEquals(1, integers.size());
    }
    @Test
    void testRetainAllUsingStringAndLengthPredicate() {
        ArrayList<String> collection = new ArrayList<>();
        collection.add("hello");
        collection.add("lousy");
        collection.add("world");
        collection.add("goodBye");
        collection.add("goodWorld");
        Predicates.retain(collection, aPredicate);
        assertEquals(5, collection.size());
    }
    @Test
    void testRetainAllUsingIntegerPredicatePositiveOnly() {
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        integers.add(4);
        integers.add(5);
        Predicates.retain(integers, aPredicate2);
        assertEquals(5, integers.size());
    }
    @Test
    void testRetainNoneFromEmptyUsingStringAndLengthPredicate() {
        ArrayList<String> collection = new ArrayList<>();
        Predicates.retain(collection, aPredicate);
        assertEquals(0, collection.size());
    }
    @Test
    void testRetainNoneFromEmptyUsingIntegerPredicatePositiveOnly() {
        ArrayList<Integer> integers = new ArrayList<>();
        Predicates.retain(integers, aPredicate2);
        assertEquals(0, integers.size());
    }
    //test collect method
    @Test
    void testCollectOneUsingStringAndLengthPredicate() {
        ArrayList<String> collection      = new ArrayList<>();
        ArrayList<String> expectedCollect = new ArrayList<>(List.of("friend"));
        collection.add("hi");
        collection.add("how");
        collection.add("are");
        collection.add("you");
        collection.add("friend");
        List<String> newCollect = Predicates.collect(collection, aPredicate);
        assertEquals(expectedCollect, newCollect);
    }
    @Test
    void testCollectOneUsingIntegerPredicatePositiveOnly() {
        ArrayList<Integer> integers         = new ArrayList<>();
        ArrayList<Integer> expectedIntegers = new ArrayList<>(List.of(4));
        integers.add(-1);
        integers.add(-2);
        integers.add(-3);
        integers.add(-4);
        integers.add(4);
        List<Integer> newIntegers = Predicates.collect(integers, aPredicate2);
        assertEquals(expectedIntegers, newIntegers);
    }
    @Test
    void testCollectNoneUsingStringAndLengthPredicate() {
        ArrayList<String> collection      = new ArrayList<>();
        ArrayList<String> expectedCollect = new ArrayList<>();
        collection.add("hey");
        collection.add("how");
        collection.add("are");
        collection.add("you");
        collection.add("bro");
        List<String> newCollect = Predicates.collect(collection, aPredicate);
        assertEquals(expectedCollect, newCollect);
    }
    @Test
    void testCollectNoneUsingIntegerPredicatePositiveOnly() {
        ArrayList<Integer> integers         = new ArrayList<>();
        ArrayList<Integer> expectedintegers = new ArrayList<>();
        integers.add(-1);
        integers.add(-2);
        integers.add(-3);
        integers.add(-4);
        integers.add(-5);
        List<Integer> newIntegers = Predicates.collect(integers, aPredicate2);
        assertEquals(expectedintegers, newIntegers);
    }
    @Test
    void testCollectEmptyUsingStringAndLengthPredicate() {
        ArrayList<String> collection      = new ArrayList<>();
        ArrayList<String> expectedCollect = new ArrayList<>();
        List<String>      newCollect      = Predicates.collect(collection, aPredicate);
        assertEquals(expectedCollect, newCollect);
    }
    @Test
    void testCollectEmptyUsingIntegerPredicatePositiveOnly() {
        ArrayList<Integer> integers         = new ArrayList<>();
        ArrayList<Integer> expectedintegers = new ArrayList<>();
        List<Integer>      newIntegers      = Predicates.collect(integers, aPredicate2);
        assertEquals(expectedintegers, newIntegers);
    }
    //test find method
    @Test
    void testFindLastIndexUsingStringAndLengthPredicate() {
        ArrayList<String> collection = new ArrayList<>();
        collection.add("hi");
        collection.add("how");
        collection.add("are");
        collection.add("you");
        collection.add("friend");
        int index = Predicates.find(collection, aPredicate);
        assertEquals(4, index);
    }
    @Test
    void testFindLastIndexUsingIntegerPredicatePositiveOnly() {
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(-1);
        integers.add(-2);
        integers.add(-3);
        integers.add(-4);
        integers.add(4);
        int index = Predicates.find(integers, aPredicate2);
        assertEquals(4, index);
    }
    @Test
    void testFindNegativeIndexFromNoneUsingStringAndLengthPredicate() {
        ArrayList<String> collection = new ArrayList<>();
        collection.add("hey");
        collection.add("how");
        collection.add("are");
        collection.add("you");
        collection.add("bro");
        int index = Predicates.find(collection, aPredicate);
        assertEquals(-1, index);
    }
    @Test
    void testFindNegativeIndexFromNoneUsingIntegerPredicatePositiveOnly() {
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(-1);
        integers.add(-2);
        integers.add(-3);
        integers.add(-4);
        integers.add(-5);
        int index = Predicates.find(integers, aPredicate2);
        assertEquals(-1, index);
    }
    @Test
    void testFindNegativeIndexFromEmptyUsingStringAndLengthPredicate() {
        ArrayList<String> collection = new ArrayList<>();
        int index = Predicates.find(collection, aPredicate);
        assertEquals(-1, index);
    }
    @Test
    void testFindNegativeIndexUsingIntegerPredicatePositiveOnly() {
        ArrayList<Integer> integers = new ArrayList<>();
        int index = Predicates.find(integers, aPredicate2);
        assertEquals(-1, index);
    }
}
