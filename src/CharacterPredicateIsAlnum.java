import java.util.function.Predicate;

/**
 * Provides COMP 2526 students a template for creating
 * predicates.
 *
 * @author BCIT
 * @version 2020
 */
public class CharacterPredicateIsAlnum implements Predicate<Character> {

    /**
     * Returns true if the Character is alphanumeric, else false.
     * @param character a Character
     * @return true if character is alphanumeric, else false.
     */
    @Override
    public boolean test(final Character character) {
        return Character.isLetterOrDigit(character);
    }
}
