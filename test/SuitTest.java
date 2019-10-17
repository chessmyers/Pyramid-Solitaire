import cs3500.pyramidsolitaire.model.hw02.Suit;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Test methods for a Suit.
 */
public class SuitTest {

  @Test
  public void testToString() {
    Suit c = Suit.Clubs;
    Suit d = Suit.Diamonds;
    Suit h = Suit.Hearts;
    Suit s = Suit.Spades;

    assertEquals("♣", c.toString());
    assertEquals("♦", d.toString());
    assertEquals("♥", h.toString());
    assertEquals("♠", s.toString());
  }
}