package cs3500.pyramidsolitaire.model.hw04;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import cs3500.pyramidsolitaire.model.hw02.Card;
import cs3500.pyramidsolitaire.model.hw02.Rank;
import cs3500.pyramidsolitaire.model.hw02.Suit;

/**
 * Represents tests for the protected methods of tripeaks pyramid solitaire
 */
public class TriPeaksPyramidSolitairePrivateTest {
  private List<Card> bigCardDeck;
  TriPeaksPyramidSolitaire game = new TriPeaksPyramidSolitaire();


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


    bigCardDeck = new ArrayList<>(Arrays.asList(aceDiamonds, aceDiamonds, aceHearts, aceHearts,
            aceSpades, aceSpades, aceClubs, aceClubs, twoDiamonds, twoDiamonds,
            twoHearts, twoHearts, twoSpades, twoSpades, twoClubs, twoClubs,
            threeDiamonds, threeDiamonds, threeHearts, threeHearts, threeSpades, threeSpades,
            threeClubs, threeClubs, fourDiamonds, fourDiamonds, fourHearts, fourHearts,
            fourSpades, fourSpades, fourClubs, fourClubs, fiveDiamonds, fiveDiamonds,
            fiveHearts, fiveHearts, fiveSpades, fiveSpades, fiveClubs, fiveClubs, sixDiamonds,
            sixDiamonds, sixHearts, sixHearts, sixSpades, sixSpades, sixClubs, sixClubs,
            sevenDiamonds, sevenDiamonds, sevenHearts, sevenHearts, sevenSpades, sevenSpades,
            sevenClubs, sevenClubs, eightDiamonds, eightDiamonds, eightHearts, eightHearts,
            eightSpades, eightSpades, eightClubs, eightClubs, nineDiamonds, nineDiamonds,
            nineHearts, nineHearts, nineSpades, nineSpades, nineClubs, nineClubs, tenDiamonds,
            tenDiamonds, tenHearts, tenHearts, tenSpades, tenSpades, tenClubs, tenClubs,
            jackDiamonds, jackDiamonds, jackHearts, jackHearts, jackSpades, jackSpades, jackClubs,
            jackClubs, queenDiamonds, queenDiamonds, queenHearts, queenHearts,
            queenSpades, queenSpades, queenClubs, queenClubs, kingDiamonds, kingDiamonds,
            kingHearts, kingHearts, kingSpades, kingSpades, kingClubs, kingClubs));
  }

  @Test
  public void testIsFullDeck() {
    assertEquals(true, game.isFullDeck(bigCardDeck));
    bigCardDeck.add(new Card(Rank.Ace, Suit.Clubs));
    assertEquals(false, game.isFullDeck(bigCardDeck));
    bigCardDeck.remove(bigCardDeck.size() - 1);
    assertEquals(true, game.isFullDeck(bigCardDeck));
    bigCardDeck.remove(bigCardDeck.size() - 1);
    bigCardDeck.add(null);
    assertEquals(false, game.isFullDeck(bigCardDeck));
  }

  @Test
  public void testGetNumCardsInPyramid() {
    assertEquals(7, game.getNumCardsInPyramid(2));
    assertEquals(12, game.getNumCardsInPyramid(3));
    assertEquals(24, game.getNumCardsInPyramid(4));
    assertEquals(33, game.getNumCardsInPyramid(5));
    assertEquals(51, game.getNumCardsInPyramid(6));
    assertEquals(64, game.getNumCardsInPyramid(7));
    assertEquals(88, game.getNumCardsInPyramid(8));
  }

  @Test
  public void testGetPyramid() {
    List<List<Card>> testDeck = new ArrayList<>(2);
    testDeck.add(new ArrayList<>(3));
    testDeck.add(new ArrayList<>(4));
    testDeck.get(0).add(new Card(Rank.Ace, Suit.Diamonds));
    testDeck.get(0).add(new Card(Rank.Ace, Suit.Diamonds));
    testDeck.get(0).add(new Card(Rank.Ace, Suit.Hearts));
    testDeck.get(1).add(new Card(Rank.Ace, Suit.Hearts));
    testDeck.get(1).add(new Card(Rank.Ace, Suit.Spades));
    testDeck.get(1).add(new Card(Rank.Ace, Suit.Spades));
    testDeck.get(1).add(new Card(Rank.Ace, Suit.Clubs));
    assertEquals(testDeck, game.getPyramid(game.getDeck(), 2));
  }
}
