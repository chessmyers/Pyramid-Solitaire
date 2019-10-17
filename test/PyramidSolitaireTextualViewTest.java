import cs3500.pyramidsolitaire.model.hw02.BasicPyramidSolitaire;
import cs3500.pyramidsolitaire.model.hw02.Card;
import cs3500.pyramidsolitaire.model.hw02.PyramidSolitaireModel;
import cs3500.pyramidsolitaire.model.hw04.RelaxedPyramidSolitaire;
import cs3500.pyramidsolitaire.model.hw04.TriPeaksPyramidSolitaire;
import cs3500.pyramidsolitaire.view.PyramidSolitaireTextualView;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Represents tests for a Pyramid Solitaire Textual View.
 */
public class PyramidSolitaireTextualViewTest {

  PyramidSolitaireModel<Card> basicModel = new BasicPyramidSolitaire();
  PyramidSolitaireModel<Card> triPeakModel = new TriPeaksPyramidSolitaire();
  PyramidSolitaireModel<Card> relaxedModel = new RelaxedPyramidSolitaire();
  List<Card> basicDeck = basicModel.getDeck();
  List<Card> triPeakDeck = triPeakModel.getDeck();

  @Before
  public void initialize() {
    basicDeck = basicModel.getDeck();
    triPeakDeck = triPeakModel.getDeck();
  }

  @Test
  public void testToStringNotStartedBasic() {
    PyramidSolitaireTextualView pstv = new PyramidSolitaireTextualView(basicModel);
    assertEquals("", pstv.toString());
  }

  @Test
  public void testToStringNotStartedTripeaks() {
    PyramidSolitaireTextualView pstv = new PyramidSolitaireTextualView(triPeakModel);
    assertEquals("", pstv.toString());
  }

  @Test
  public void testToStringNotStartedRelaxed() {
    PyramidSolitaireTextualView pstv = new PyramidSolitaireTextualView(relaxedModel);
    assertEquals("", pstv.toString());
  }

  @Test
  public void testToStringHaveWonBasic() {
    for (Card c : basicDeck) {
      c.remove();
    }
    basicModel.startGame(basicDeck, false, 7, 2);
    PyramidSolitaireTextualView pstv = new PyramidSolitaireTextualView(basicModel);

    assertEquals("You win!", pstv.toString());
  }

  @Test
  public void testToStringHaveWonTripeaks() {
    for (Card c : triPeakDeck) {
      c.remove();
    }
    triPeakModel.startGame(triPeakDeck, false, 7, 2);
    PyramidSolitaireTextualView pstv = new PyramidSolitaireTextualView(triPeakModel);

    assertEquals("You win!", pstv.toString());
  }

  @Test
  public void testToStringHaveWonRelaxed() {
    for (Card c : basicDeck) {
      c.remove();
    }
    relaxedModel.startGame(basicDeck, false, 7, 2);
    PyramidSolitaireTextualView pstv = new PyramidSolitaireTextualView(relaxedModel);

    assertEquals("You win!", pstv.toString());
  }

  @Test
  public void testToStringGameOverBasic() {
    basicModel.startGame(basicDeck, false, 9, 3);
    basicModel.discardDraw(0);
    basicModel.discardDraw(1);
    basicModel.discardDraw(2);
    basicModel.discardDraw(0);
    basicModel.discardDraw(1);
    basicModel.discardDraw(2);
    basicModel.discardDraw(0);
    PyramidSolitaireTextualView pstv = new PyramidSolitaireTextualView(basicModel);
    assertEquals(true, basicModel.isGameOver());
    int score = basicModel.getScore();
    String gameString = "Game over. Score: " + score;
    assertEquals(gameString, pstv.toString());
  }

  @Test
  public void testToStringGameOverTripeaks() {
    triPeakModel.startGame(triPeakDeck, false, 8, 2);
    triPeakModel.discardDraw(0);
    triPeakModel.discardDraw(1);
    triPeakModel.discardDraw(0);
    triPeakModel.discardDraw(1);
    triPeakModel.discardDraw(0);
    triPeakModel.discardDraw(1);
    triPeakModel.discardDraw(0);
    triPeakModel.discardDraw(1);
    triPeakModel.discardDraw(0);
    triPeakModel.discardDraw(1);
    triPeakModel.discardDraw(0);
    triPeakModel.discardDraw(1);
    triPeakModel.discardDraw(0);
    triPeakModel.discardDraw(1);
    triPeakModel.discardDraw(0);
    triPeakModel.discardDraw(1);
    PyramidSolitaireTextualView pstv = new PyramidSolitaireTextualView(triPeakModel);
    assertEquals(true, triPeakModel.isGameOver());
    int score = triPeakModel.getScore();
    String gameString = "Game over. Score: " + score;
    assertEquals(gameString, pstv.toString());
  }

  @Test
  public void testToStringGameOverRelaxed() {
    relaxedModel.startGame(basicDeck, false, 9, 3);
    relaxedModel.discardDraw(0);
    relaxedModel.discardDraw(1);
    relaxedModel.discardDraw(2);
    relaxedModel.discardDraw(0);
    relaxedModel.discardDraw(1);
    relaxedModel.discardDraw(2);
    relaxedModel.discardDraw(0);
    PyramidSolitaireTextualView pstv = new PyramidSolitaireTextualView(relaxedModel);
    assertEquals(true, relaxedModel.isGameOver());
    int score = relaxedModel.getScore();
    String gameString = "Game over. Score: " + score;
    assertEquals(gameString, pstv.toString());
  }

  @Test
  public void testToStringNormalBasic() {
    basicModel.startGame(basicDeck, false, 7, 3);
    PyramidSolitaireTextualView pstv = new PyramidSolitaireTextualView(basicModel);
    String result = "            A♦\n" +
                      "          A♥  A♠\n" +
                      "        A♣  2♦  2♥\n" +
                      "      2♠  2♣  3♦  3♥\n" +
                      "    3♠  3♣  4♦  4♥  4♠\n" +
                      "  4♣  5♦  5♥  5♠  5♣  6♦\n" +
                      "6♥  6♠  6♣  7♦  7♥  7♠  7♣\n" +
                      "Draw: 8♦, 8♥, 8♠";
    assertEquals(result, pstv.toString());
    basicModel.startGame(basicDeck, false, 9, 1);
    String result2 = "                A♦\n" +
                       "              A♥  A♠\n" +
                       "            A♣  2♦  2♥\n" +
                       "          2♠  2♣  3♦  3♥\n" +
                       "        3♠  3♣  4♦  4♥  4♠\n" +
                       "      4♣  5♦  5♥  5♠  5♣  6♦\n" +
                       "    6♥  6♠  6♣  7♦  7♥  7♠  7♣\n" +
                       "  8♦  8♥  8♠  8♣  9♦  9♥  9♠  9♣\n" +
                       "10♦ 10♥ 10♠ 10♣ J♦  J♥  J♠  J♣  Q♦\n" +
                       "Draw: Q♥";
    assertEquals(result2, pstv.toString());
    basicModel.startGame(basicDeck, false, 2, 0);
    String result3 = "  A♦\n" +
                       "A♥  A♠\n" +
                       "Draw:";
    assertEquals(result3, pstv.toString());
  }

  @Test
  public void testToStringNormalTripeaks() {
    triPeakModel.startGame(triPeakDeck, false, 8, 1);
    PyramidSolitaireTextualView pstv = new PyramidSolitaireTextualView(triPeakModel);
    String result = "              A♦              A♦              A♥\n" +
            "            A♥  A♠          A♠  A♣          A♣  2♦\n" +
            "          2♦  2♥  2♥      2♠  2♠  2♣      2♣  3♦  3♦\n" +
            "        3♥  3♥  3♠  3♠  3♣  3♣  4♦  4♦  4♥  4♥  4♠  4♠\n" +
            "      4♣  4♣  5♦  5♦  5♥  5♥  5♠  5♠  5♣  5♣  6♦  6♦  6♥\n" +
            "    6♥  6♠  6♠  6♣  6♣  7♦  7♦  7♥  7♥  7♠  7♠  7♣  7♣  8♦\n" +
            "  8♦  8♥  8♥  8♠  8♠  8♣  8♣  9♦  9♦  9♥  9♥  9♠  9♠  9♣  9♣\n" +
            "10♦ 10♦ 10♥ 10♥ 10♠ 10♠ 10♣ 10♣ J♦  J♦  J♥  J♥  J♠  J♠  J♣  J♣\n" +
            "Draw: Q♦";
    assertEquals(result, pstv.toString());
  }

  @Test
  public void testToStringNormalRelaxed() {
    relaxedModel.startGame(basicDeck, false, 7, 3);
    PyramidSolitaireTextualView pstv = new PyramidSolitaireTextualView(relaxedModel);
    String result = "            A♦\n" +
            "          A♥  A♠\n" +
            "        A♣  2♦  2♥\n" +
            "      2♠  2♣  3♦  3♥\n" +
            "    3♠  3♣  4♦  4♥  4♠\n" +
            "  4♣  5♦  5♥  5♠  5♣  6♦\n" +
            "6♥  6♠  6♣  7♦  7♥  7♠  7♣\n" +
            "Draw: 8♦, 8♥, 8♠";
    assertEquals(result, pstv.toString());
    relaxedModel.startGame(basicDeck, false, 9, 1);
    String result2 = "                A♦\n" +
            "              A♥  A♠\n" +
            "            A♣  2♦  2♥\n" +
            "          2♠  2♣  3♦  3♥\n" +
            "        3♠  3♣  4♦  4♥  4♠\n" +
            "      4♣  5♦  5♥  5♠  5♣  6♦\n" +
            "    6♥  6♠  6♣  7♦  7♥  7♠  7♣\n" +
            "  8♦  8♥  8♠  8♣  9♦  9♥  9♠  9♣\n" +
            "10♦ 10♥ 10♠ 10♣ J♦  J♥  J♠  J♣  Q♦\n" +
            "Draw: Q♥";
    assertEquals(result2, pstv.toString());
    relaxedModel.startGame(basicDeck, false, 2, 0);
    String result3 = "  A♦\n" +
            "A♥  A♠\n" +
            "Draw:";
    assertEquals(result3, pstv.toString());
  }
}