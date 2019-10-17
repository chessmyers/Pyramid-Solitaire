import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import cs3500.pyramidsolitaire.model.hw02.Card;
import cs3500.pyramidsolitaire.model.hw02.PyramidSolitaireModel;
import cs3500.pyramidsolitaire.model.hw02.Rank;
import cs3500.pyramidsolitaire.model.hw02.Suit;
import cs3500.pyramidsolitaire.model.hw04.TriPeaksPyramidSolitaire;

import static org.junit.Assert.assertEquals;

/**
 * Represents tests for a game of Tripeaks pyramid solitaire.
 */
public class TriPeaksPyramidSolitaireTest {
  private List<Card> bigCardDeck;

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

  // getDeck test methods

  @Test
  public void testGetDeck() {
    assertEquals(this.bigCardDeck, new TriPeaksPyramidSolitaire().getDeck());
  }


  // getRowWidth test methods

  @Test(expected = IllegalStateException.class)
  public void testGetRowWidthNotStarted() {
    TriPeaksPyramidSolitaire game = new TriPeaksPyramidSolitaire();
    assertEquals(game.getRowWidth(4), 4);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testGetRowWidthBadArgument() {
    TriPeaksPyramidSolitaire game = new TriPeaksPyramidSolitaire();
    game.startGame(this.bigCardDeck, true, 7, 2);
    assertEquals(game.getRowWidth(-3), 3);
    assertEquals(game.getRowWidth(7), 4);
  }

  @Test
  public void testGetRowWidth() {
    PyramidSolitaireModel game = new TriPeaksPyramidSolitaire();
    game.startGame(game.getDeck(), true, 8, 3);
    assertEquals(11, game.getRowWidth(2));
    game.startGame(game.getDeck(), true, 7, 2);
    assertEquals(13, game.getRowWidth(6));
  }


}