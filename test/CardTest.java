import cs3500.pyramidsolitaire.model.hw02.Card;
import cs3500.pyramidsolitaire.model.hw02.Rank;
import cs3500.pyramidsolitaire.model.hw02.Suit;
import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

/**
 * Represents tests for a Card object.
 */
public class CardTest {
  private Card c1;
  private Card c2;
  private Card c3;
  private Card c4;

  @Before
  public void initialize() {
    c1 = new Card(Rank.Three, Suit.Hearts);
    c2 = new Card(Rank.Jack, Suit.Spades);
    c3 = new Card(Rank.Ten, Suit.Clubs);
    c4 = new Card(Rank.Ace, Suit.Diamonds);
  }

  @Test
  public void testToString() {
    assertEquals("3♥", c1.toString());
    assertEquals("J♠", c2.toString());
    assertEquals("10♣", c3.toString());
    assertEquals("A♦", c4.toString());
    c4.remove();
    assertEquals("  ", c4.toString());
  }

  @Test
  public void testEquals() {
    assertEquals(true, c1.equals(c1));
    assertEquals(false, c3.equals(new Integer(5)));
    Object tempc1 = new Card(Rank.Jack, Suit.Spades);
    Object tempc2 = new Card(Rank.Queen, Suit.Diamonds);
    assertEquals(false, c2.equals(tempc2));
    assertEquals(true, c2.equals(tempc1));
  }

  @Test
  public void testHashCode() {
    assertEquals(528425652, c3.hashCode());
    assertEquals(528425652, new Card(Rank.Ten, Suit.Clubs).hashCode());
  }

  @Test
  public void testExpose() {
    assertFalse(c4.isExposed());
    c4.expose();
    assertTrue(c4.isExposed());
  }

  @Test
  public void testIsExposed() {
    assertFalse(c4.isExposed());
    assertFalse(c2.isExposed());
    c4.expose();
    c2.expose();
    assertTrue(c4.isExposed());
    assertTrue(c2.isExposed());
  }

  @Test
  public void testRemove() {
    assertTrue(c1.isThere());
    assertTrue(c3.isThere());
    c1.expose();
    c3.expose();

    c1.remove();
    c3.remove();
    assertFalse(c1.isThere());
    assertFalse(c3.isThere());

  }

  @Test
  public void testIsThere() {
    assertEquals(true, c2.isThere());
    c2.remove();
    assertEquals(false, c2.isThere());
  }

  @Test
  public void testCardValue() {
    assertEquals(3, c1.cardValue());
    assertEquals(11, c2.cardValue());
    assertEquals(10, c3.cardValue());
    assertEquals(1, c4.cardValue());
  }
}