import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import cs3500.pyramidsolitaire.model.hw02.BasicPyramidSolitaire;
import cs3500.pyramidsolitaire.model.hw02.Card;
import cs3500.pyramidsolitaire.model.hw02.PyramidSolitaireModel;
import cs3500.pyramidsolitaire.model.hw02.Rank;
import cs3500.pyramidsolitaire.model.hw02.Suit;
import cs3500.pyramidsolitaire.model.hw04.RelaxedPyramidSolitaire;

import static org.junit.Assert.assertEquals;

/**
 * Represents tests for a relaxed game of Pyramid Solitaire
 */
public class RelaxedPyramidSolitaireTest {
  private List<Card> smallCardDeck;

  @Before
  public void initialize() {
    Card aceDiamonds = new Card(Rank.Ace, Suit.Diamonds);
    Card aceHearts = new Card(Rank.Ace, Suit.Hearts);
    Card aceSpades = new Card(Rank.Ace, Suit.Spades);
    Card aceClubs = new Card(Rank.Ace, Suit.Clubs);

    Card twoDiamonds = new Card(Rank.Two, Suit.Diamonds);
    Card twoHearts = new Card(Rank.Two, Suit.Hearts);
    Card twoSpades = new Card(Rank.Two, Suit.Spades);
    Card twoClubs = new Card(Rank.Two, Suit.Clubs);

    Card threeDiamonds = new Card(Rank.Three, Suit.Diamonds);
    Card threeHearts = new Card(Rank.Three, Suit.Hearts);
    Card threeSpades = new Card(Rank.Three, Suit.Spades);
    Card threeClubs = new Card(Rank.Three, Suit.Clubs);

    Card fourDiamonds = new Card(Rank.Four, Suit.Diamonds);
    Card fourHearts = new Card(Rank.Four, Suit.Hearts);
    Card fourSpades = new Card(Rank.Four, Suit.Spades);
    Card fourClubs = new Card(Rank.Four, Suit.Clubs);

    Card fiveDiamonds = new Card(Rank.Five, Suit.Diamonds);
    Card fiveHearts = new Card(Rank.Five, Suit.Hearts);
    Card fiveSpades = new Card(Rank.Five, Suit.Spades);
    Card fiveClubs = new Card(Rank.Five, Suit.Clubs);

    Card sixDiamonds = new Card(Rank.Six, Suit.Diamonds);
    Card sixHearts = new Card(Rank.Six, Suit.Hearts);
    Card sixSpades = new Card(Rank.Six, Suit.Spades);
    Card sixClubs = new Card(Rank.Six, Suit.Clubs);

    Card sevenDiamonds = new Card(Rank.Seven, Suit.Diamonds);
    Card sevenHearts = new Card(Rank.Seven, Suit.Hearts);
    Card sevenSpades = new Card(Rank.Seven, Suit.Spades);
    Card sevenClubs = new Card(Rank.Seven, Suit.Clubs);

    Card eightDiamonds = new Card(Rank.Eight, Suit.Diamonds);
    Card eightHearts = new Card(Rank.Eight, Suit.Hearts);
    Card eightSpades = new Card(Rank.Eight, Suit.Spades);
    Card eightClubs = new Card(Rank.Eight, Suit.Clubs);

    Card nineDiamonds = new Card(Rank.Nine, Suit.Diamonds);
    Card nineHearts = new Card(Rank.Nine, Suit.Hearts);
    Card nineSpades = new Card(Rank.Nine, Suit.Spades);
    Card nineClubs = new Card(Rank.Nine, Suit.Clubs);

    Card tenDiamonds = new Card(Rank.Ten, Suit.Diamonds);
    Card tenHearts = new Card(Rank.Ten, Suit.Hearts);
    Card tenSpades = new Card(Rank.Ten, Suit.Spades);
    Card tenClubs = new Card(Rank.Ten, Suit.Clubs);

    Card jackDiamonds = new Card(Rank.Jack, Suit.Diamonds);
    Card jackHearts = new Card(Rank.Jack, Suit.Hearts);
    Card jackSpades = new Card(Rank.Jack, Suit.Spades);
    Card jackClubs = new Card(Rank.Jack, Suit.Clubs);

    Card queenDiamonds = new Card(Rank.Queen, Suit.Diamonds);
    Card queenHearts = new Card(Rank.Queen, Suit.Hearts);
    Card queenSpades = new Card(Rank.Queen, Suit.Spades);
    Card queenClubs = new Card(Rank.Queen, Suit.Clubs);

    Card kingDiamonds = new Card(Rank.King, Suit.Diamonds);
    Card kingHearts = new Card(Rank.King, Suit.Hearts);
    Card kingSpades = new Card(Rank.King, Suit.Spades);
    Card kingClubs = new Card(Rank.King, Suit.Clubs);


    smallCardDeck = new ArrayList<>(Arrays.asList(aceDiamonds, aceHearts, aceSpades, aceClubs,
            twoDiamonds, twoHearts, twoSpades, twoClubs, threeDiamonds, threeHearts,
            threeSpades, threeClubs, fourDiamonds, fourHearts, fourSpades, fourClubs,
            fiveDiamonds, fiveHearts, fiveSpades, fiveClubs, sixDiamonds, sixHearts,
            sixSpades, sixClubs, sevenDiamonds, sevenHearts, sevenSpades, sevenClubs,
            eightDiamonds, eightHearts, eightSpades, eightClubs, nineDiamonds, nineHearts,
            nineSpades, nineClubs, tenDiamonds, tenHearts, tenSpades, tenClubs, jackDiamonds,
            jackHearts, jackSpades, jackClubs, queenDiamonds, queenHearts,
            queenSpades, queenClubs, kingDiamonds, kingHearts, kingSpades, kingClubs));

  }

  @Test(expected = IllegalStateException.class)
  public void testRemove4ArgNotStartedRelaxed() {
    PyramidSolitaireModel game = new BasicPyramidSolitaire();
    game.remove(1, 2, 3, 4);
  }

  @Test(expected = IllegalStateException.class)
  public void testRemove2ArgNotStartedRelaxed() {
    PyramidSolitaireModel game = new BasicPyramidSolitaire();
    game.remove(1, 2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testRemove4ArgBadArgs1Relaxed() {
    PyramidSolitaireModel game  = new RelaxedPyramidSolitaire();
    game.startGame(this.smallCardDeck, false, 5, 3);
    game.remove(1, 2, -4, 2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testRemove4ArgBadArgs2Relaxed() {
    PyramidSolitaireModel game  = new RelaxedPyramidSolitaire();
    game.startGame(this.smallCardDeck, false, 5, 3);
    game.remove(8, 2, 1, 2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testRemove2ArgBadArgsRelaxed() {
    PyramidSolitaireModel game  = new RelaxedPyramidSolitaire();
    game.startGame(this.smallCardDeck, false, 5, 3);
    game.remove(7, 2);
  }

  @Test
  public void testRemove4ArgsRelaxed() {
    PyramidSolitaireModel game = new RelaxedPyramidSolitaire();
    List<Card> tempDeck = game.getDeck();
    tempDeck.set(0, new Card(Rank.Seven, Suit.Diamonds));
    tempDeck.set(1, new Card(Rank.Six, Suit.Diamonds));
    tempDeck.set(2, new Card(Rank.King, Suit.Clubs));
    tempDeck.set(51, new Card(Rank.Ace, Suit.Spades));
    tempDeck.set(20, new Card(Rank.Ace, Suit.Hearts));
    tempDeck.set(24, new Card(Rank.Ace, Suit.Diamonds));


    game.startGame(tempDeck, false, 3, 2);
    int row1 = 0;
    int card1 = 0;
    int row2 = 1;
    int card2 = 1;
    assertEquals(new Card(Rank.Six, Suit.Diamonds), game.getCardAt(1, 0));
    assertEquals(new Card(Rank.Seven, Suit.Diamonds), game.getCardAt(0, 0));
    game.remove(1,1);
    game.remove(row1,card1,row2,card2);

    assertEquals(null, game.getCardAt(row1, card1));
    assertEquals(null, game.getCardAt(row2, card2));
  }

  @Test
  public void testRemove2ArgsRelaxed() {
    PyramidSolitaireModel game = new RelaxedPyramidSolitaire();
    List<Card> tempDeck = game.getDeck();
    tempDeck.set(6, new Card(Rank.King, Suit.Diamonds));
    tempDeck.set(48, new Card(Rank.Two, Suit.Spades));
    int totalCards = 0;
    for (Card c: tempDeck) {
      if (c.isThere()) {
        totalCards++;
      }
    }
    assertEquals(52, totalCards);
    game.startGame(tempDeck, false, 4, 2);
    int row1 = 3;
    int card1 = 0;
    game.remove(row1,card1);
    totalCards = 0;
    for (Card c: tempDeck) {
      if (c.isThere()) {
        totalCards++;
      }
    }
    assertEquals(52, totalCards);
    assertEquals(null, game.getCardAt(row1, card1));
  }

}