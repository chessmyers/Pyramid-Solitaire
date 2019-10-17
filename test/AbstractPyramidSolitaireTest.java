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
import cs3500.pyramidsolitaire.model.hw04.TriPeaksPyramidSolitaire;

import static org.junit.Assert.*;

/**
 * Represents tests for an Abstract Pyramid Solitaire.
 */
public abstract class AbstractPyramidSolitaireTest {

  private List<Card> smallCardDeck;
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

    Card aceDiamonds2 = new Card(Rank.Ace, Suit.Diamonds);
    Card aceHearts2 = new Card(Rank.Ace, Suit.Hearts);
    Card aceSpades2 = new Card(Rank.Ace, Suit.Spades);
    Card aceClubs2 = new Card(Rank.Ace, Suit.Clubs);

    Card twoDiamonds2 = new Card(Rank.Two, Suit.Diamonds);
    Card twoHearts2 = new Card(Rank.Two, Suit.Hearts);
    Card twoSpades2 = new Card(Rank.Two, Suit.Spades);
    Card twoClubs2 = new Card(Rank.Two, Suit.Clubs);

    Card threeDiamonds2 = new Card(Rank.Three, Suit.Diamonds);
    Card threeHearts2 = new Card(Rank.Three, Suit.Hearts);
    Card threeSpades2 = new Card(Rank.Three, Suit.Spades);
    Card threeClubs2 = new Card(Rank.Three, Suit.Clubs);

    Card fourDiamonds2 = new Card(Rank.Four, Suit.Diamonds);
    Card fourHearts2 = new Card(Rank.Four, Suit.Hearts);
    Card fourSpades2 = new Card(Rank.Four, Suit.Spades);
    Card fourClubs2 = new Card(Rank.Four, Suit.Clubs);

    Card fiveDiamonds2 = new Card(Rank.Five, Suit.Diamonds);
    Card fiveHearts2 = new Card(Rank.Five, Suit.Hearts);
    Card fiveSpades2 = new Card(Rank.Five, Suit.Spades);
    Card fiveClubs2 = new Card(Rank.Five, Suit.Clubs);

    Card sixDiamonds2 = new Card(Rank.Six, Suit.Diamonds);
    Card sixHearts2 = new Card(Rank.Six, Suit.Hearts);
    Card sixSpades2 = new Card(Rank.Six, Suit.Spades);
    Card sixClubs2 = new Card(Rank.Six, Suit.Clubs);

    Card sevenDiamonds2 = new Card(Rank.Seven, Suit.Diamonds);
    Card sevenHearts2 = new Card(Rank.Seven, Suit.Hearts);
    Card sevenSpades2 = new Card(Rank.Seven, Suit.Spades);
    Card sevenClubs2 = new Card(Rank.Seven, Suit.Clubs);

    Card eightDiamonds2 = new Card(Rank.Eight, Suit.Diamonds);
    Card eightHearts2 = new Card(Rank.Eight, Suit.Hearts);
    Card eightSpades2 = new Card(Rank.Eight, Suit.Spades);
    Card eightClubs2 = new Card(Rank.Eight, Suit.Clubs);

    Card nineDiamonds2 = new Card(Rank.Nine, Suit.Diamonds);
    Card nineHearts2 = new Card(Rank.Nine, Suit.Hearts);
    Card nineSpades2 = new Card(Rank.Nine, Suit.Spades);
    Card nineClubs2 = new Card(Rank.Nine, Suit.Clubs);

    Card tenDiamonds2 = new Card(Rank.Ten, Suit.Diamonds);
    Card tenHearts2 = new Card(Rank.Ten, Suit.Hearts);
    Card tenSpades2 = new Card(Rank.Ten, Suit.Spades);
    Card tenClubs2 = new Card(Rank.Ten, Suit.Clubs);

    Card jackDiamonds2 = new Card(Rank.Jack, Suit.Diamonds);
    Card jackHearts2 = new Card(Rank.Jack, Suit.Hearts);
    Card jackSpades2 = new Card(Rank.Jack, Suit.Spades);
    Card jackClubs2 = new Card(Rank.Jack, Suit.Clubs);

    Card queenDiamonds2 = new Card(Rank.Queen, Suit.Diamonds);
    Card queenHearts2 = new Card(Rank.Queen, Suit.Hearts);
    Card queenSpades2 = new Card(Rank.Queen, Suit.Spades);
    Card queenClubs2 = new Card(Rank.Queen, Suit.Clubs);

    Card kingDiamonds2 = new Card(Rank.King, Suit.Diamonds);
    Card kingHearts2 = new Card(Rank.King, Suit.Hearts);
    Card kingSpades2 = new Card(Rank.King, Suit.Spades);
    Card kingClubs2 = new Card(Rank.King, Suit.Clubs);


    smallCardDeck = new ArrayList<>(Arrays.asList(aceDiamonds, aceHearts, aceSpades, aceClubs,
            twoDiamonds, twoHearts, twoSpades, twoClubs, threeDiamonds, threeHearts,
            threeSpades, threeClubs, fourDiamonds, fourHearts, fourSpades, fourClubs,
            fiveDiamonds, fiveHearts, fiveSpades, fiveClubs, sixDiamonds, sixHearts,
            sixSpades, sixClubs, sevenDiamonds, sevenHearts, sevenSpades, sevenClubs,
            eightDiamonds, eightHearts, eightSpades, eightClubs, nineDiamonds, nineHearts,
            nineSpades, nineClubs, tenDiamonds, tenHearts, tenSpades, tenClubs, jackDiamonds,
            jackHearts, jackSpades, jackClubs, queenDiamonds, queenHearts,
            queenSpades, queenClubs, kingDiamonds, kingHearts, kingSpades, kingClubs));

    bigCardDeck = new ArrayList<>(Arrays.asList(aceDiamonds, aceDiamonds2, aceHearts, aceHearts2,
            aceSpades, aceSpades2, aceClubs, aceClubs2, twoDiamonds, twoDiamonds2,
            twoHearts, twoHearts2, twoSpades,  twoSpades2, twoClubs, twoClubs2,
            threeDiamonds, threeDiamonds2, threeHearts, threeHearts2, threeSpades, threeSpades2,
            threeClubs, threeClubs2, fourDiamonds, fourDiamonds2, fourHearts, fourHearts2,
            fourSpades, fourSpades2, fourClubs, fourClubs2, fiveDiamonds, fiveDiamonds2,
            fiveHearts, fiveHearts2, fiveSpades, fiveSpades2, fiveClubs, fiveClubs2, sixDiamonds,
            sixDiamonds2, sixHearts, sixHearts2, sixSpades, sixSpades2, sixClubs, sixClubs2,
            sevenDiamonds, sevenDiamonds2, sevenHearts, sevenHearts2, sevenSpades, sevenSpades2,
            sevenClubs, sevenClubs2, eightDiamonds, eightDiamonds2, eightHearts, eightHearts2,
            eightSpades, eightSpades2, eightClubs, eightClubs2, nineDiamonds, nineDiamonds2,
            nineHearts, nineHearts2, nineSpades, nineSpades2, nineClubs, nineClubs2, tenDiamonds,
            tenDiamonds2, tenHearts, tenHearts2, tenSpades, tenSpades2, tenClubs, tenClubs2,
            jackDiamonds, jackDiamonds2, jackHearts, jackHearts2, jackSpades, jackSpades2,
            jackClubs, jackClubs2, queenDiamonds, queenDiamonds2, queenHearts, queenHearts2,
            queenSpades, queenSpades2, queenClubs, queenClubs2, kingDiamonds, kingDiamonds2,
            kingHearts, kingHearts2, kingSpades, kingSpades2, kingClubs, kingClubs2));
  }

  // getDeck test methods

  @Test
  public void getDeck() {
    assertEquals(this.smallCardDeck, new BasicPyramidSolitaire().getDeck());
    assertEquals(this.smallCardDeck, new RelaxedPyramidSolitaire().getDeck());
    assertEquals(this.bigCardDeck, new TriPeaksPyramidSolitaire().getDeck());
  }


  // BASIC startGame test methods

  @Test(expected = IllegalArgumentException.class)
  public void testStartGameBadNumRowsBasic() {
    BasicPyramidSolitaire game = new BasicPyramidSolitaire();
    game.startGame(this.smallCardDeck, false, -4, 3);
    game.startGame(this.smallCardDeck, false, 11, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testStartGameBadNumDrawBasic() {
    BasicPyramidSolitaire game = new BasicPyramidSolitaire();
    game.startGame(this.smallCardDeck, false, 4, 4);
    game.startGame(this.smallCardDeck, false, 6, -2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testStartGameBadDeckBasic() {
    BasicPyramidSolitaire game = new BasicPyramidSolitaire();
    this.smallCardDeck.remove(0);
    this.smallCardDeck.add(new Card(Rank.Six, Suit.Hearts));
    game.startGame(this.smallCardDeck, false, 3, 2);
  }

  @Test
  public void testStartGameGoodArgsBasic() {
    BasicPyramidSolitaire game = new BasicPyramidSolitaire();
    game.startGame(this.smallCardDeck, false, 5, 3);
    Card fourClub = new Card(Rank.Four, Suit.Clubs);
    Card fiveDiamonds = new Card(Rank.Five, Suit.Diamonds);
    Card fiveHearts = new Card(Rank.Five, Suit.Hearts);
    assertEquals(new ArrayList<>(Arrays.asList(fourClub,
            fiveDiamonds, fiveHearts)), game.getDrawCards());
    assertEquals(5, game.getNumRows());
    assertEquals(3, game.getNumDraw());

  }


  // RELAXED startGame test methods

  @Test(expected = IllegalArgumentException.class)
  public void testStartGameBadNumRowsRelaxed() {
    PyramidSolitaireModel game = new RelaxedPyramidSolitaire();
    game.startGame(this.smallCardDeck, false, -4, 3);
    game.startGame(this.smallCardDeck, false, 11, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testStartGameBadNumDrawRelaxed() {
    PyramidSolitaireModel game = new RelaxedPyramidSolitaire();
    game.startGame(this.smallCardDeck, false, 4, 4);
    game.startGame(this.smallCardDeck, false, 6, -2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testStartGameBadDeckRelaxed() {
    PyramidSolitaireModel game = new RelaxedPyramidSolitaire();
    this.smallCardDeck.remove(0);
    this.smallCardDeck.add(new Card(Rank.Six, Suit.Hearts));
    game.startGame(this.smallCardDeck, false, 3, 2);
  }

  @Test
  public void testStartGameGoodArgsRelaxed() {
    PyramidSolitaireModel game = new RelaxedPyramidSolitaire();
    game.startGame(this.smallCardDeck, false, 5, 3);
    Card fourClub = new Card(Rank.Four, Suit.Clubs);
    Card fiveDiamonds = new Card(Rank.Five, Suit.Diamonds);
    Card fiveHearts = new Card(Rank.Five, Suit.Hearts);
    assertEquals(new ArrayList<>(Arrays.asList(fourClub,
            fiveDiamonds, fiveHearts)), game.getDrawCards());
    assertEquals(5, game.getNumRows());
    assertEquals(3, game.getNumDraw());
  }


  // TRIPEAKS startGame test methods

  @Test(expected = IllegalArgumentException.class)
  public void testStartGameBadNumRowsTriPeaks() {
    PyramidSolitaireModel game = new TriPeaksPyramidSolitaire();
    game.startGame(this.bigCardDeck, false, -4, 3);
    game.startGame(this.bigCardDeck, false, 11, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testStartGameBadNumDrawTriPeaks() {
    PyramidSolitaireModel game = new TriPeaksPyramidSolitaire();
    game.startGame(this.bigCardDeck, false, 4, 4);
    game.startGame(this.bigCardDeck, false, 6, -2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testStartGameBadDeckTriPeaks() {
    PyramidSolitaireModel game = new TriPeaksPyramidSolitaire();
    this.bigCardDeck.remove(0);
    this.bigCardDeck.add(new Card(Rank.Six, Suit.Hearts));
    game.startGame(this.bigCardDeck, false, 3, 2);
  }

  @Test
  public void testStartGameGoodArgsTriPeaks() {
    PyramidSolitaireModel game = new TriPeaksPyramidSolitaire();
    game.startGame(this.bigCardDeck, false, 5, 3);
    Card fiveDiamonds = new Card(Rank.Five, Suit.Diamonds);
    Card fiveHearts = new Card(Rank.Five, Suit.Hearts);
    assertEquals(new ArrayList<>(Arrays.asList(fiveDiamonds,
            fiveHearts, fiveHearts)), game.getDrawCards());
    assertEquals(5, game.getNumRows());
    assertEquals(3, game.getNumDraw());
  }



  // BASIC remove test methods

  @Test(expected = IllegalStateException.class)
  public void testRemove4ArgNotStartedBasic() {
    PyramidSolitaireModel game = new BasicPyramidSolitaire();
    game.remove(1, 2, 3, 4);
  }

  @Test(expected = IllegalStateException.class)
  public void testRemove2ArgNotStartedBasic() {
    PyramidSolitaireModel game = new BasicPyramidSolitaire();
    game.remove(1, 2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testRemove4ArgBadArgs1Basic() {
    basic(this.smallCardDeck, false, 5, 3)
            .remove(1, 2, -4, 2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testRemove4ArgBadArgs2Basic() {
    basic(this.smallCardDeck, false, 5, 3)
            .remove(8, 2, 1, 2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testRemove2ArgBadArgsBasic() {
    basic(this.smallCardDeck, false, 5, 3).remove(7, 2);
  }

  @Test
  public void testRemove4ArgsBasic() {
    PyramidSolitaireModel game = new BasicPyramidSolitaire();
    List<Card> tempDeck = game.getDeck();
    tempDeck.set(19, new Card(Rank.Seven, Suit.Diamonds));
    tempDeck.set(24, new Card(Rank.Five, Suit.Clubs));
    int totalCards = 0;
    for (Card c: tempDeck) {
      if (c.isThere()) {
        totalCards++;
      }
    }
    assertEquals(52, totalCards);
    game.startGame(tempDeck, false, 6, 2);
    int row1 = 5;
    int card1 = 4;
    int row2 = 5;
    int card2 = 5;
    game.remove(row1,card1,row2,card2);
    totalCards = 0;
    for (Card c: tempDeck) {
      if (c.isThere()) {
        totalCards++;
      }
    }
    assertEquals(52, totalCards);
    assertEquals(null, game.getCardAt(row1, card1));
    assertEquals(null, game.getCardAt(row2, card2));
  }

  @Test
  public void testRemove2ArgsBasic() {
    PyramidSolitaireModel game = new BasicPyramidSolitaire();
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


  // RELAXED remove test methods in class RelaxedPyramidSolitaireTest


  // TRIPEAKS remove test methods


  @Test(expected = IllegalStateException.class)
  public void testRemove4ArgNotStartedTriPeaks() {
    PyramidSolitaireModel game = new TriPeaksPyramidSolitaire();
    game.remove(1, 2, 3, 4);
  }

  @Test(expected = IllegalStateException.class)
  public void testRemove2ArgNotStartedTriPeaks() {
    PyramidSolitaireModel game = new TriPeaksPyramidSolitaire();
    game.remove(1, 2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testRemove4ArgBadArgs1TriPeaks() {
    tripeaks(this.bigCardDeck, false, 5, 3)
            .remove(1, 2, -4, 2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testRemove4ArgBadArgs2TriPeaks() {
    tripeaks(this.bigCardDeck, false, 5, 3)
            .remove(8, 2, 1, 2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testRemove2ArgBadArgsTriPeaks() {
    tripeaks(this.bigCardDeck, false, 5, 3).remove(7, 2);
  }

  @Test
  public void testRemove4ArgsTriPeaks() {
    PyramidSolitaireModel game = new TriPeaksPyramidSolitaire();
    List<Card> deck = game.getDeck();
    game.startGame(deck, false, 6, 2);
    int row1 = 5;
    int card1 = 1;
    int row2 = 5;
    int card2 = 9;
    assertEquals(new Card(Rank.Six, Suit.Diamonds), game.getCardAt(row1, card1));
    assertEquals(new Card(Rank.Seven, Suit.Diamonds), game.getCardAt(row2, card2));
    game.remove(row1,card1,row2,card2);

    assertEquals(null, game.getCardAt(row1, card1));
    assertEquals(null, game.getCardAt(row2, card2));
  }

  @Test
  public void testRemove2ArgsTriPeaks() {
    TriPeaksPyramidSolitaire game = new TriPeaksPyramidSolitaire();

    List<Card> deck = game.getDeck();
    deck.set(7, new Card(Rank.King, Suit.Clubs));
    deck.set(103, new Card(Rank.Ace, Suit.Clubs));
    game.startGame(deck, false, 3, 2);

    int row1 = 2;
    int card1 = 0;
    assertEquals(new Card(Rank.King, Suit.Clubs), game.getCardAt(row1, card1));

    game.remove(row1,card1);
    assertEquals(null, game.getCardAt(row1, card1));
  }



  // BASIC removeUsingDraw test methods

  @Test(expected = IllegalStateException.class)
  public void testRemoveUsingDrawNotStartedBasic() {
    PyramidSolitaireModel game = new BasicPyramidSolitaire();
    game.removeUsingDraw(2, 1, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testRemoveUsingDrawBadArgs1Basic() {
    PyramidSolitaireModel game = new BasicPyramidSolitaire();
    game.startGame(this.smallCardDeck, false, 5, 2);
    game.removeUsingDraw(-1, 1, 1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testRemoveUsingDrawBadArgs2Basic() {
    PyramidSolitaireModel game = new BasicPyramidSolitaire();
    game.startGame(this.smallCardDeck, false, 5, 1);
    game.removeUsingDraw(2, 3, 1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testRemoveUsingDrawBadArgs3Basic() {
    PyramidSolitaireModel game = new BasicPyramidSolitaire();
    game.startGame(this.smallCardDeck, false, 5, 2);
    game.removeUsingDraw(1, -3, -4);
  }

  @Test
  public void testRemoveUsingDrawStartedBasic() {
    BasicPyramidSolitaire game = new BasicPyramidSolitaire();
    game.startGame(this.smallCardDeck, false, 6, 3);
    int row = 5;
    int card = 5;
    int drawInd = 0;
    game.discardDraw(0);
    assertEquals(game.getCardAt(row, card).isThere(), true);
    assertEquals(game.getDrawCards().get(drawInd), new Card(Rank.Seven, Suit.Diamonds));
    game.removeUsingDraw(drawInd, row, card);
    assertEquals(game.getDrawCards().get(drawInd), new Card(Rank.Seven, Suit.Hearts));
  }


  // RELAXED removeUsingDraw test methods

  @Test(expected = IllegalStateException.class)
  public void testRemoveUsingDrawNotStartedRelaxed() {
    PyramidSolitaireModel game = new RelaxedPyramidSolitaire();
    game.removeUsingDraw(2, 1, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testRemoveUsingDrawBadArgs1Relaxed() {
    PyramidSolitaireModel game = new RelaxedPyramidSolitaire();
    game.startGame(this.smallCardDeck, false, 5, 2);
    game.removeUsingDraw(-1, 1, 1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testRemoveUsingDrawBadArgs2Relaxed() {
    PyramidSolitaireModel game = new RelaxedPyramidSolitaire();
    game.startGame(this.smallCardDeck, false, 5, 1);
    game.removeUsingDraw(2, 3, 1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testRemoveUsingDrawBadArgs3Relaxed() {
    PyramidSolitaireModel game = new RelaxedPyramidSolitaire();
    game.startGame(this.smallCardDeck, false, 5, 2);
    game.removeUsingDraw(1, -3, -4);
  }

  @Test
  public void testRemoveUsingDrawStartedRelaxed() {
    RelaxedPyramidSolitaire game = new RelaxedPyramidSolitaire();
    game.startGame(this.smallCardDeck, false, 6, 3);
    int row = 5;
    int card = 5;
    int drawInd = 0;
    game.discardDraw(0);
    assertEquals(game.getCardAt(row, card).isThere(), true);
    assertEquals(game.getDrawCards().get(drawInd), new Card(Rank.Seven, Suit.Diamonds));
    game.removeUsingDraw(drawInd, row, card);
    assertEquals(game.getDrawCards().get(drawInd), new Card(Rank.Seven, Suit.Hearts));
  }


  // TRIPEAKS removeUsingDraw test methods

  @Test(expected = IllegalStateException.class)
  public void testRemoveUsingDrawNotStartedTripeaks() {
    PyramidSolitaireModel game = new TriPeaksPyramidSolitaire();
    game.removeUsingDraw(2, 1, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testRemoveUsingDrawBadArgs1Tripeaks() {
    PyramidSolitaireModel game = new TriPeaksPyramidSolitaire();
    game.startGame(this.bigCardDeck, false, 5, 2);
    game.removeUsingDraw(-1, 1, 1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testRemoveUsingDrawBadArgs2Tripeaks() {
    PyramidSolitaireModel game = new TriPeaksPyramidSolitaire();
    game.startGame(this.bigCardDeck, false, 5, 1);
    game.removeUsingDraw(2, 3, 1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testRemoveUsingDrawBadArgs3Tripeaks() {
    PyramidSolitaireModel game = new TriPeaksPyramidSolitaire();
    game.startGame(this.bigCardDeck, false, 5, 2);
    game.removeUsingDraw(1, -3, -4);
  }

  @Test
  public void testRemoveUsingDrawStartedTripeaks() {
    TriPeaksPyramidSolitaire game = new TriPeaksPyramidSolitaire();
    game.startGame(this.bigCardDeck, false, 6, 3);
    int row = 5;
    int card = 5;
    int drawInd = 0;
    game.discardDraw(0);
    assertEquals(game.getCardAt(row, card).isThere(), true);
    assertEquals(game.getDrawCards().get(drawInd), new Card(Rank.Seven, Suit.Clubs));
    game.removeUsingDraw(drawInd, row, card);
    assertEquals(game.getDrawCards().get(drawInd), new Card(Rank.Seven, Suit.Clubs));
  }

  // BASIC discardDraw test methods

  @Test(expected = IllegalStateException.class)
  public void testDiscardDrawNotStartedBasic() {
    PyramidSolitaireModel game = new BasicPyramidSolitaire();
    game.discardDraw(1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testDiscardDrawBadArgs1Basic() {
    PyramidSolitaireModel game = new BasicPyramidSolitaire();
    game.startGame(this.smallCardDeck, true, 4, 2);
    game.discardDraw(-3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testDiscardDrawBadArgs2Basic() {
    PyramidSolitaireModel game = new BasicPyramidSolitaire();
    game.startGame(this.smallCardDeck, true, 4, 1);
    game.discardDraw(2);
  }

  @Test
  public void testDiscardDrawStartedBasic() {
    PyramidSolitaireModel game = new BasicPyramidSolitaire();
    game.startGame(this.smallCardDeck, false, 5, 3);
    List<Card> drawDeck;
    drawDeck = new ArrayList<>(Arrays.asList(new Card(Rank.Four, Suit.Clubs),
            new Card(Rank.Five, Suit.Diamonds), new Card(Rank.Five, Suit.Hearts)));
    assertEquals(drawDeck, game.getDrawCards());

    int replaceIndex = 1;
    game.discardDraw(replaceIndex);
    drawDeck.set(replaceIndex, new Card(Rank.Five, Suit.Spades));
    assertEquals(drawDeck, game.getDrawCards());


    game.startGame(this.smallCardDeck, false, 9, 2);
    game.discardDraw(0);
    game.discardDraw(1);
    game.discardDraw(0);
    game.discardDraw(1);
    game.discardDraw(0);
    game.discardDraw(1);
    game.discardDraw(0);
    Card c1 = new Card(Rank.King, Suit.Clubs);
    c1.remove();
    Card c2 = new Card(Rank.King, Suit.Spades);
    c2.remove();
    assertEquals(new ArrayList<>(Arrays.asList(c1, c2)), game.getDrawCards());
  }

  // RELAXED discardDraw test methods

  @Test(expected = IllegalStateException.class)
  public void testDiscardDrawNotStartedRelaxed() {
    PyramidSolitaireModel game = new RelaxedPyramidSolitaire();
    game.discardDraw(1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testDiscardDrawBadArgs1Relaxed() {
    PyramidSolitaireModel game = new RelaxedPyramidSolitaire();
    game.startGame(this.smallCardDeck, true, 4, 2);
    game.discardDraw(-3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testDiscardDrawBadArgs2Relaxed() {
    PyramidSolitaireModel game = new RelaxedPyramidSolitaire();
    game.startGame(this.smallCardDeck, true, 4, 1);
    game.discardDraw(2);
  }

  @Test
  public void testDiscardDrawStartedRelaxed() {
    PyramidSolitaireModel game = new RelaxedPyramidSolitaire();
    game.startGame(this.smallCardDeck, false, 5, 3);
    List<Card> drawDeck;
    drawDeck = new ArrayList<>(Arrays.asList(new Card(Rank.Four, Suit.Clubs),
            new Card(Rank.Five, Suit.Diamonds), new Card(Rank.Five, Suit.Hearts)));
    assertEquals(drawDeck, game.getDrawCards());

    int replaceIndex = 1;
    game.discardDraw(replaceIndex);
    drawDeck.set(replaceIndex, new Card(Rank.Five, Suit.Spades));
    assertEquals(drawDeck, game.getDrawCards());


    game.startGame(this.smallCardDeck, false, 9, 2);
    game.discardDraw(0);
    game.discardDraw(1);
    game.discardDraw(0);
    game.discardDraw(1);
    game.discardDraw(0);
    game.discardDraw(1);
    game.discardDraw(0);
    Card c1 = new Card(Rank.King, Suit.Clubs);
    c1.remove();
    Card c2 = new Card(Rank.King, Suit.Spades);
    c2.remove();
    assertEquals(new ArrayList<>(Arrays.asList(c1, c2)), game.getDrawCards());
  }

  // TRIPEAKS discardDraw test methods

  @Test(expected = IllegalStateException.class)
  public void testDiscardDrawNotStartedTripeaks() {
    PyramidSolitaireModel game = new TriPeaksPyramidSolitaire();
    game.discardDraw(1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testDiscardDrawBadArgs1Tripeaks() {
    PyramidSolitaireModel game = new TriPeaksPyramidSolitaire();
    game.startGame(this.bigCardDeck, true, 4, 2);
    game.discardDraw(-3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testDiscardDrawBadArgs2Tripeaks() {
    PyramidSolitaireModel game = new TriPeaksPyramidSolitaire();
    game.startGame(this.bigCardDeck, true, 4, 1);
    game.discardDraw(2);
  }

  @Test
  public void testDiscardDrawStartedTripeaks() {
    PyramidSolitaireModel game = new TriPeaksPyramidSolitaire();
    game.startGame(this.bigCardDeck, false, 5, 3);
    List<Card> drawDeck;
    drawDeck = new ArrayList<>(Arrays.asList(new Card(Rank.Five, Suit.Diamonds),
            new Card(Rank.Five, Suit.Hearts), new Card(Rank.Five, Suit.Hearts)));
    assertEquals(drawDeck, game.getDrawCards());

    int replaceIndex = 1;
    game.discardDraw(replaceIndex);
    drawDeck.set(replaceIndex, new Card(Rank.Five, Suit.Spades));
    assertEquals(drawDeck, game.getDrawCards());


    game.startGame(this.bigCardDeck, false, 8, 2);
    game.discardDraw(0);
    game.discardDraw(1);
    game.discardDraw(0);
    game.discardDraw(1);
    game.discardDraw(0);
    game.discardDraw(1);
    game.discardDraw(0);
    game.discardDraw(1);
    game.discardDraw(0);
    game.discardDraw(1);
    game.discardDraw(0);
    game.discardDraw(1);
    game.discardDraw(0);
    game.discardDraw(1);
    game.discardDraw(0);
    game.discardDraw(1);
    Card c1 = new Card(Rank.King, Suit.Clubs);
    c1.remove();
    Card c2 = new Card(Rank.King, Suit.Clubs);
    c2.remove();
    assertEquals(new ArrayList<>(Arrays.asList(c1, c2)), game.getDrawCards());
  }

  // BASIC getNumRows test methods

  @Test
  public void testGetNumRowsBasic() {
    PyramidSolitaireModel game = new BasicPyramidSolitaire();
    assertEquals(-1, game.getNumRows());
    game.startGame(this.smallCardDeck, true, 4, 2);
    assertEquals(4, game.getNumRows());
  }

  // RELAXED getNumRows test methods

  @Test
  public void testGetNumRowsRelaxed() {
    PyramidSolitaireModel game = new RelaxedPyramidSolitaire();
    assertEquals(-1, game.getNumRows());
    game.startGame(this.smallCardDeck, true, 7, 2);
    assertEquals(7, game.getNumRows());
  }

  // TRIPEAKS getNumRows test methods

  @Test
  public void testGetNumRowsTripeaks() {
    PyramidSolitaireModel game = new TriPeaksPyramidSolitaire();
    assertEquals(-1, game.getNumRows());
    game.startGame(this.bigCardDeck, true, 3, 2);
    assertEquals(3, game.getNumRows());
  }

  // BASIC getNumDraw test methods

  @Test
  public void testGetNumDrawBasic() {
    PyramidSolitaireModel game = new BasicPyramidSolitaire();
    assertEquals(-1, game.getNumDraw());
    game.startGame(this.smallCardDeck, false, 8, 3);
    assertEquals(3, game.getNumDraw());
    game.startGame(this.smallCardDeck, true, 3, 1);
    assertEquals(1, game.getNumDraw());
  }

  // RELAXED getNumDraw test methods

  @Test
  public void testGetNumDrawRelaxed() {
    PyramidSolitaireModel game = new RelaxedPyramidSolitaire();
    assertEquals(-1, game.getNumDraw());
    game.startGame(this.smallCardDeck, false, 8, 3);
    assertEquals(3, game.getNumDraw());
    game.startGame(this.smallCardDeck, true, 3, 1);
    assertEquals(1, game.getNumDraw());
  }

  // TRIPEAKS getNumDraw test methods

  @Test
  public void testGetNumDrawTripeaks() {
    PyramidSolitaireModel game = new TriPeaksPyramidSolitaire();
    assertEquals(-1, game.getNumDraw());
    game.startGame(this.bigCardDeck, false, 8, 3);
    assertEquals(3, game.getNumDraw());
    game.startGame(this.bigCardDeck, true, 3, 1);
    assertEquals(1, game.getNumDraw());
  }

  // BASIC getRowWidth test methods

  @Test(expected = IllegalStateException.class)
  public void testGetRowWidthNotStartedBasic() {
    PyramidSolitaireModel game = new BasicPyramidSolitaire();
    assertEquals(game.getRowWidth(4), 4);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testGetRowWidthBadArgumentBasic() {
    PyramidSolitaireModel game = new BasicPyramidSolitaire();
    game.startGame(this.bigCardDeck, true, 7, 2);
    assertEquals(game.getRowWidth(-3), 3);
    assertEquals(game.getRowWidth(7), 4);
  }

  @Test
  public void getRowWidthBasic() {
    PyramidSolitaireModel game = new BasicPyramidSolitaire();
    game.startGame(game.getDeck(), true, 8, 3);
    assertEquals(8, game.getRowWidth(7));
  }

  // RELAXED getRowWidth test methods

  @Test(expected = IllegalStateException.class)
  public void testGetRowWidthNotStartedRelaxed() {
    PyramidSolitaireModel game = new RelaxedPyramidSolitaire();
    assertEquals(game.getRowWidth(4), 4);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testGetRowWidthBadArgumentRelaxed() {
    PyramidSolitaireModel game = new RelaxedPyramidSolitaire();
    game.startGame(this.bigCardDeck, true, 7, 2);
    assertEquals(game.getRowWidth(-3), 3);
    assertEquals(game.getRowWidth(7), 4);
  }

  @Test
  public void getRowWidthRelaxed() {
    PyramidSolitaireModel game = new RelaxedPyramidSolitaire();
    game.startGame(game.getDeck(), true, 8, 3);
    assertEquals(8, game.getRowWidth(7));
  }

  // TRIPEAKS getRowWidth test methods in respective class TriPeaksPyramidSolitaireTest

  // BASIC isGameOver test methods

  @Test(expected = IllegalStateException.class)
  public void testIsGameOverNotStartedBasic() {
    PyramidSolitaireModel game = new BasicPyramidSolitaire();
    assertFalse( game.isGameOver());
  }

  @Test
  public void testIsGameOverStartedBasic() {
    PyramidSolitaireModel game = new BasicPyramidSolitaire();
    game.startGame(this.smallCardDeck, false, 9, 3);
    assertEquals(false, game.isGameOver());
    game.discardDraw(0);
    game.discardDraw(1);
    game.discardDraw(2);
    game.discardDraw(0);
    game.discardDraw(1);
    game.discardDraw(2);
    game.discardDraw(0);
    assertEquals(true, game.isGameOver());
  }

  // RELAXED isGameOver tested in respective class RelaxedPyramidSolitaireTest

  // TRIPEAKS isGameOver test methods

  @Test(expected = IllegalStateException.class)
  public void testIsGameOverNotStartedTripeaks() {
    PyramidSolitaireModel game = new TriPeaksPyramidSolitaire();
    assertFalse( game.isGameOver());
  }

  @Test
  public void testIsGameOverStartedTripeaks() {
    PyramidSolitaireModel game = new TriPeaksPyramidSolitaire();
    game.startGame(this.bigCardDeck, false, 8, 2);
    assertEquals(false, game.isGameOver());
    game.discardDraw(0);
    game.discardDraw(1);
    game.discardDraw(0);
    game.discardDraw(1);
    game.discardDraw(0);
    game.discardDraw(1);
    game.discardDraw(0);
    game.discardDraw(1);
    game.discardDraw(0);
    game.discardDraw(1);
    game.discardDraw(0);
    game.discardDraw(1);
    game.discardDraw(0);
    game.discardDraw(1);
    game.discardDraw(0);
    game.discardDraw(1);
    assertEquals(true, game.isGameOver());
  }

  // BASIC getScore test methods

  @Test(expected = IllegalStateException.class)
  public void testGetScoreNotStartedBasic() {
    PyramidSolitaireModel game = new BasicPyramidSolitaire();
    assertEquals(4, game.getScore());
  }

  @Test
  public void testGetScoreGameStartedBasic() {
    PyramidSolitaireModel game = new BasicPyramidSolitaire();
    game.startGame(this.bigCardDeck, false, 3, 3);
    assertEquals(8, game.getScore());
    game.startGame(this.bigCardDeck, false, 8, 2);
    assertEquals(180, game.getScore());
    this.bigCardDeck.get(6).remove();
    this.bigCardDeck.get(7).remove();
    this.bigCardDeck.get(3).remove();
    game.startGame(this.bigCardDeck, false, 4, 2);
    assertEquals(13, game.getScore());
  }

  // RELAXED getScore test methods

  @Test(expected = IllegalStateException.class)
  public void testGetScoreNotStartedRelaxed() {
    PyramidSolitaireModel game = new RelaxedPyramidSolitaire();
    assertEquals(4, game.getScore());
  }

  @Test
  public void testGetScoreGameStartedRelaxed() {
    PyramidSolitaireModel game = new RelaxedPyramidSolitaire();
    game.startGame(this.bigCardDeck, false, 3, 3);
    assertEquals(8, game.getScore());
    game.startGame(this.bigCardDeck, false, 8, 2);
    assertEquals(180, game.getScore());
    this.bigCardDeck.get(6).remove();
    this.bigCardDeck.get(7).remove();
    this.bigCardDeck.get(3).remove();
    game.startGame(this.bigCardDeck, false, 4, 2);
    assertEquals(13, game.getScore());
  }

  // TRIPEAKS getScore test methods

  @Test(expected = IllegalStateException.class)
  public void testGetScoreNotStartedTripeaks() {
    PyramidSolitaireModel game = new TriPeaksPyramidSolitaire();
    assertEquals(4, game.getScore());
  }

  @Test
  public void testGetScoreGameStartedTripeaks() {
    PyramidSolitaireModel game = new TriPeaksPyramidSolitaire();
    game.startGame(this.bigCardDeck, false, 3, 3);
    assertEquals(8, game.getScore());
    game.startGame(this.bigCardDeck, false, 8, 2);
    assertEquals(180, game.getScore());
    this.bigCardDeck.get(6).remove();
    this.bigCardDeck.get(7).remove();
    this.bigCardDeck.get(3).remove();
    game.startGame(this.bigCardDeck, false, 4, 2);
    assertEquals(13, game.getScore());
  }

  // BASIC getCardAt test methods

  @Test(expected = IllegalStateException.class)
  public void testGetCardAtNotStartedBasic() {
    PyramidSolitaireModel game = new BasicPyramidSolitaire();
    assertEquals(new Card(Rank.Ace, Suit.Diamonds), game.getCardAt(3, 3));
  }

  @Test(expected = IllegalArgumentException.class)
  public void testGetCardAddBadArgs1Basic() {
    PyramidSolitaireModel game = new BasicPyramidSolitaire();
    game.startGame(this.smallCardDeck, false, 4, 2);
    assertEquals(new Card(Rank.Eight, Suit.Clubs), game.getCardAt(2, 3));
  }

  @Test(expected = IllegalArgumentException.class)
  public void testGetCardAddBadArgs2Basic() {
    PyramidSolitaireModel game = new BasicPyramidSolitaire();
    game.startGame(this.smallCardDeck, false, 4, 2);
    assertEquals(new Card(Rank.Eight, Suit.Clubs), game.getCardAt(1, -3));
  }

  @Test(expected = IllegalArgumentException.class)
  public void testGetCardAddBadArgs3Basic() {
    PyramidSolitaireModel game = new BasicPyramidSolitaire();
    game.startGame(this.smallCardDeck, false, 4, 2);
    assertEquals(new Card(Rank.Eight, Suit.Clubs), game.getCardAt(-3, 1));
  }

  @Test(expected = IllegalArgumentException.class)
  public void testGetCardAddBadArgs4Basic() {
    PyramidSolitaireModel game = new BasicPyramidSolitaire();
    game.startGame(this.smallCardDeck, false, 4, 2);
    assertEquals(new Card(Rank.Eight, Suit.Clubs), game.getCardAt(6, 3));
  }


  @Test
  public void testGetCardAtWorksBasic() {
    PyramidSolitaireModel game = new BasicPyramidSolitaire();
    game.startGame(this.smallCardDeck, false, 5, 2);
    assertEquals(new Card(Rank.Ace, Suit.Diamonds), game.getCardAt(0, 0));
    assertEquals(new Card(Rank.Four, Suit.Diamonds), game.getCardAt(4, 2));
  }

  // RELAXED getCardAt test methods

  @Test(expected = IllegalStateException.class)
  public void testGetCardAtNotStartedRelaxed() {
    PyramidSolitaireModel game = new RelaxedPyramidSolitaire();
    assertEquals(new Card(Rank.Ace, Suit.Diamonds), game.getCardAt(3, 3));
  }

  @Test(expected = IllegalArgumentException.class)
  public void testGetCardAddBadArgs1Relaxed() {
    PyramidSolitaireModel game = new RelaxedPyramidSolitaire();
    game.startGame(this.smallCardDeck, false, 4, 2);
    assertEquals(new Card(Rank.Eight, Suit.Clubs), game.getCardAt(2, 3));
  }

  @Test(expected = IllegalArgumentException.class)
  public void testGetCardAddBadArgs2Relaxed() {
    PyramidSolitaireModel game = new RelaxedPyramidSolitaire();
    game.startGame(this.smallCardDeck, false, 4, 2);
    assertEquals(new Card(Rank.Eight, Suit.Clubs), game.getCardAt(1, -3));
  }

  @Test(expected = IllegalArgumentException.class)
  public void testGetCardAddBadArgs3Relaxed() {
    PyramidSolitaireModel game = new RelaxedPyramidSolitaire();
    game.startGame(this.smallCardDeck, false, 4, 2);
    assertEquals(new Card(Rank.Eight, Suit.Clubs), game.getCardAt(-3, 1));
  }

  @Test(expected = IllegalArgumentException.class)
  public void testGetCardAddBadArgs4Relaxed() {
    PyramidSolitaireModel game = new RelaxedPyramidSolitaire();
    game.startGame(this.smallCardDeck, false, 4, 2);
    assertEquals(new Card(Rank.Eight, Suit.Clubs), game.getCardAt(6, 3));
  }


  @Test
  public void testGetCardAtWorksRelaxed() {
    PyramidSolitaireModel game = new RelaxedPyramidSolitaire();
    game.startGame(this.smallCardDeck, false, 5, 2);
    assertEquals(new Card(Rank.Ace, Suit.Diamonds), game.getCardAt(0, 0));
    assertEquals(new Card(Rank.Four, Suit.Diamonds), game.getCardAt(4, 2));
  }

  // TRIPEAKS getCardAt test methods

  @Test(expected = IllegalStateException.class)
  public void testGetCardAtNotStartedTripeaks() {
    PyramidSolitaireModel game = new TriPeaksPyramidSolitaire();
    assertEquals(new Card(Rank.Ace, Suit.Diamonds), game.getCardAt(3, 3));
  }

  @Test(expected = IllegalArgumentException.class)
  public void testGetCardAddBadArgs1Tripeaks() {
    PyramidSolitaireModel game = new TriPeaksPyramidSolitaire();
    game.startGame(this.bigCardDeck, false, 4, 2);
    assertEquals(new Card(Rank.Eight, Suit.Clubs), game.getCardAt(2, 3));
  }

  @Test(expected = IllegalArgumentException.class)
  public void testGetCardAddBadArgs2Tripeaks() {
    PyramidSolitaireModel game = new TriPeaksPyramidSolitaire();
    game.startGame(this.bigCardDeck, false, 4, 2);
    assertEquals(new Card(Rank.Eight, Suit.Clubs), game.getCardAt(1, -3));
  }

  @Test(expected = IllegalArgumentException.class)
  public void testGetCardAddBadArgs3Tripeaks() {
    PyramidSolitaireModel game = new TriPeaksPyramidSolitaire();
    game.startGame(this.bigCardDeck, false, 4, 2);
    assertEquals(new Card(Rank.Eight, Suit.Clubs), game.getCardAt(-3, 1));
  }

  @Test(expected = IllegalArgumentException.class)
  public void testGetCardAddBadArgs4Tripeaks() {
    PyramidSolitaireModel game = new TriPeaksPyramidSolitaire();
    game.startGame(this.bigCardDeck, false, 4, 2);
    assertEquals(new Card(Rank.Eight, Suit.Clubs), game.getCardAt(6, 3));
  }


  @Test
  public void testGetCardAtWorks() {
    PyramidSolitaireModel game = new TriPeaksPyramidSolitaire();
    game.startGame(this.bigCardDeck, false, 5, 2);
    assertEquals(new Card(Rank.Ace, Suit.Diamonds), game.getCardAt(0, 0));
    assertEquals(new Card(Rank.Four, Suit.Diamonds), game.getCardAt(4, 2));
  }

  // BASIC getDrawCards test methods

  @Test(expected = IllegalStateException.class)
  public void testGetDrawCardsNotStartedBasic() {
    PyramidSolitaireModel game = new RelaxedPyramidSolitaire();
    assertEquals(this.bigCardDeck, game.getDrawCards());
  }

  @Test
  public void testGetDrawCardsStartedBasic() {
    PyramidSolitaireModel game = new RelaxedPyramidSolitaire();
    List<Card> drawCards;
    game.startGame(this.bigCardDeck, false, 4, 1);
    drawCards = new ArrayList<>(Arrays.asList(new Card(Rank.Three, Suit.Spades)));
    assertEquals(drawCards, game.getDrawCards());

    game.startGame(this.bigCardDeck, false, 3, 2);
    drawCards = new ArrayList<>(Arrays.asList(new Card(Rank.Two, Suit.Spades),
            new Card(Rank.Two, Suit.Clubs)));
    assertEquals(drawCards, game.getDrawCards());

    game.startGame(this.bigCardDeck, false, 5, 3);
    drawCards = new ArrayList<>(Arrays.asList(new Card(Rank.Four, Suit.Clubs),
            new Card(Rank.Five, Suit.Diamonds), new Card(Rank.Five, Suit.Hearts)));
    assertEquals(drawCards, game.getDrawCards());
  }

  // RELAXED getDrawCards test methods

  @Test(expected = IllegalStateException.class)
  public void testGetDrawCardsNotStartedRelaxed() {
    PyramidSolitaireModel game = new RelaxedPyramidSolitaire();
    assertEquals(this.bigCardDeck, game.getDrawCards());
  }

  @Test
  public void testGetDrawCardsStartedRelaxed() {
    PyramidSolitaireModel game = new RelaxedPyramidSolitaire();
    List<Card> drawCards;
    game.startGame(this.bigCardDeck, false, 4, 1);
    drawCards = new ArrayList<>(Arrays.asList(new Card(Rank.Three, Suit.Spades)));
    assertEquals(drawCards, game.getDrawCards());

    game.startGame(this.bigCardDeck, false, 3, 2);
    drawCards = new ArrayList<>(Arrays.asList(new Card(Rank.Two, Suit.Spades),
            new Card(Rank.Two, Suit.Clubs)));
    assertEquals(drawCards, game.getDrawCards());

    game.startGame(this.bigCardDeck, false, 5, 3);
    drawCards = new ArrayList<>(Arrays.asList(new Card(Rank.Four, Suit.Clubs),
            new Card(Rank.Five, Suit.Diamonds), new Card(Rank.Five, Suit.Hearts)));
    assertEquals(drawCards, game.getDrawCards());
  }

  // TRIPEAKS getDrawCards test methods

  @Test(expected = IllegalStateException.class)
  public void testGetDrawCardsNotStartedTripeaks() {
    PyramidSolitaireModel game = new TriPeaksPyramidSolitaire();
    assertEquals(this.bigCardDeck, game.getDrawCards());
  }

  @Test
  public void testGetDrawCardsStartedTripeaks() {
    PyramidSolitaireModel game = new TriPeaksPyramidSolitaire();
    List<Card> drawCards;
    game.startGame(this.bigCardDeck, false, 4, 1);
    drawCards = new ArrayList<>(Arrays.asList(new Card(Rank.Three, Suit.Spades)));
    assertEquals(drawCards, game.getDrawCards());

    game.startGame(this.bigCardDeck, false, 3, 2);
    drawCards = new ArrayList<>(Arrays.asList(new Card(Rank.Two, Suit.Spades),
            new Card(Rank.Two, Suit.Clubs)));
    assertEquals(drawCards, game.getDrawCards());

    game.startGame(this.bigCardDeck, false, 5, 3);
    drawCards = new ArrayList<>(Arrays.asList(new Card(Rank.Four, Suit.Clubs),
            new Card(Rank.Five, Suit.Diamonds), new Card(Rank.Five, Suit.Hearts)));
    assertEquals(drawCards, game.getDrawCards());
  }






  protected abstract PyramidSolitaireModel basic(List<Card> deck,
                                                 boolean shuffle, int numRows, int drawCards);

  protected abstract PyramidSolitaireModel relaxed(List<Card> deck,
                                                   boolean shuffle, int numRows, int drawCards);

  protected abstract PyramidSolitaireModel tripeaks(List<Card> deck,
                                                    boolean shuffle, int numRows, int drawCards);

  /**
   * Factory class for pyramid solitaire
   */
  public static final class TestGames extends AbstractPyramidSolitaireTest {

    @Override
    protected PyramidSolitaireModel basic(List<Card> deck,
                                          boolean shuffle, int numRows, int drawCards) {
      PyramidSolitaireModel basic = new BasicPyramidSolitaire();
      basic.startGame(deck, shuffle, numRows, drawCards);
      return basic;
    }

    @Override
    protected PyramidSolitaireModel relaxed(List<Card> deck,
                                            boolean shuffle, int numRows, int drawCards) {
      PyramidSolitaireModel relaxed = new BasicPyramidSolitaire();
      relaxed.startGame(deck, shuffle, numRows, drawCards);
      return relaxed;
    }

    @Override
    protected PyramidSolitaireModel tripeaks(List<Card> deck,
                                             boolean shuffle, int numRows, int drawCards) {
      PyramidSolitaireModel tripeaks = new BasicPyramidSolitaire();
      tripeaks.startGame(deck, shuffle, numRows, drawCards);
      return tripeaks;
    }
  }
}