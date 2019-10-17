import cs3500.pyramidsolitaire.model.hw02.Rank;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Represents tests for the Rank of a Card.
 */
public class RankTest {
  Rank ace = Rank.Ace;
  Rank two = Rank.Two;
  Rank three = Rank.Three;
  Rank four = Rank.Four;
  Rank five = Rank.Five;
  Rank six = Rank.Six;
  Rank seven = Rank.Seven;
  Rank eight = Rank.Eight;
  Rank nine = Rank.Nine;
  Rank ten = Rank.Ten;
  Rank jack = Rank.Jack;
  Rank queen = Rank.Queen;
  Rank king = Rank.King;

  @Test
  public void testToString() {
    assertEquals("A", ace.toString());
    assertEquals("2", two.toString());
    assertEquals("3", three.toString());
    assertEquals("4", four.toString());
    assertEquals("5", five.toString());
    assertEquals("6", six.toString());
    assertEquals("7", seven.toString());
    assertEquals("8", eight.toString());
    assertEquals("9", nine.toString());
    assertEquals("10", ten.toString());
    assertEquals("J", jack.toString());
    assertEquals("Q", queen.toString());
    assertEquals("K", king.toString());
  }

  @Test
  public void testCardValue() {
    assertEquals(1, ace.cardValue());
    assertEquals(2, two.cardValue());
    assertEquals(3, three.cardValue());
    assertEquals(4, four.cardValue());
    assertEquals(5, five.cardValue());
    assertEquals(6, six.cardValue());
    assertEquals(7, seven.cardValue());
    assertEquals(8, eight.cardValue());
    assertEquals(9, nine.cardValue());
    assertEquals(10, ten.cardValue());
    assertEquals(11, jack.cardValue());
    assertEquals(12, queen.cardValue());
    assertEquals(13, king.cardValue());
  }
}