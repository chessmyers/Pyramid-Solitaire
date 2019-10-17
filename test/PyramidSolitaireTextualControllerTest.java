import org.junit.Test;

import java.io.IOException;
import java.io.StringReader;

import java.util.List;

import cs3500.pyramidsolitaire.controller.PyramidSolitaireController;
import cs3500.pyramidsolitaire.controller.PyramidSolitaireTextualController;
import cs3500.pyramidsolitaire.model.hw02.BasicPyramidSolitaire;
import cs3500.pyramidsolitaire.model.hw02.Card;
import cs3500.pyramidsolitaire.model.hw02.PyramidSolitaireModel;
import cs3500.pyramidsolitaire.model.hw02.Rank;
import cs3500.pyramidsolitaire.model.hw02.Suit;

import static org.junit.Assert.assertEquals;


/**
 * Represents tests for a textual game of pyramid solitaire.
 */
public class PyramidSolitaireTextualControllerTest {




  static Interaction prints(String... lines) {
    return (input, output) -> {
      for (String line : lines) {
        output.append(line).append('\n');
      }
    };
  }

  static Interaction inputs(String in) {
    return (input, output) -> input.append(in);

  }

  void testPlayGame(PyramidSolitaireModel model, Interaction... interactions) throws IOException {
    StringBuilder fakeUserInput = new StringBuilder();
    StringBuilder expectedOutput = new StringBuilder();

    for (Interaction interaction : interactions) {
      interaction.apply(fakeUserInput, expectedOutput);
    }


    StringReader input = new StringReader(fakeUserInput.toString());
    StringBuilder actualOutput = new StringBuilder();

    PyramidSolitaireController controller =
            new PyramidSolitaireTextualController(input, actualOutput);
    controller.playGame(model, model.getDeck(), false, 6, 3);

    assertEquals(expectedOutput.toString(), actualOutput.toString());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testNullModelGiven() throws IOException {
    testPlayGame(null, null);

  }

  @Test
  public void testQuitGameInput() throws IOException {
    testPlayGame(new BasicPyramidSolitaire(),
            inputs("q"),
            prints("          A♦\n" +
                    "        A♥  A♠\n" +
                    "      A♣  2♦  2♥\n" +
                    "    2♠  2♣  3♦  3♥\n" +
                    "  3♠  3♣  4♦  4♥  4♠\n" +
                    "4♣  5♦  5♥  5♠  5♣  6♦\n" +
                    "Draw: 6♥, 6♠, 6♣\n" +
                    "Score: 66\n" +
                    "Game quit!\n" +
                    "State of game when quit:\n" +
                    "          A♦\n" +
                    "        A♥  A♠\n" +
                    "      A♣  2♦  2♥\n" +
                    "    2♠  2♣  3♦  3♥\n" +
                    "  3♠  3♣  4♦  4♥  4♠\n" +
                    "4♣  5♦  5♥  5♠  5♣  6♦\n" +
                    "Draw: 6♥, 6♠, 6♣\n" +
                    "Score: 66"));
  }

  @Test
  public void testInvalidCommand() throws IOException {
    testPlayGame(new BasicPyramidSolitaire(),
          inputs("dnjkdsnajkd"),
          prints("Invalid move. Play again. This is not a valid command"));
  }

  @Test
  public void testMultipleInvalidCommands() throws IOException {
    testPlayGame(new BasicPyramidSolitaire(),
            inputs("dnjkd  dsads ds d sd sad sd sa"),
            prints("Invalid move. Play again. This is not a valid command"));
  }

  @Test
  public void testGoodCommandAmongMultipleInvalidCommands() throws IOException {
    testPlayGame(new BasicPyramidSolitaire(),
            inputs("fjdf fds fds f rm1 ndjs fdsfds"),
            prints("Please reenter argument #1"));
  }

  // Rm1 Testing

  @Test
  public void testGoodCommandBadInputInvalidMoveRm1() throws IOException {
    testPlayGame(new BasicPyramidSolitaire(),
            inputs("rm1 ddssad"),
            prints("Please reenter argument #1"),
            inputs("ffds"),
            prints("Please reenter argument #1"),
            inputs("feeieie"),
            prints("Please reenter argument #1"),
            inputs("5"),
            prints("Please reender argument #2"),
            inputs("ood is fun"),
            prints("Please reenter argument #2"),
            inputs("7"),
            prints("Invalid move. Play again. rm1 requires a row and column of a king\n" +
                    "Please reenter arguments"));
  }


  @Test
  public void testGoodCommandGoodInputAmongBadInputInvalidMoveRm1() throws IOException {
    testPlayGame(new BasicPyramidSolitaire(),
            inputs("njfnjfds fsdkf rm1 fsdfds 1 f fds  4"),
            prints("Invalid move. Play again. rm1 requires a row and column of a king\n" +
                    "Please reenter arguments:"));
  }

  @Test
  public void testGoodCommandGoodInputAmongBadInputValidMoveRm1() throws IOException {
    PyramidSolitaireModel game = new BasicPyramidSolitaire();
    List<Card> deck = game.getDeck();
    deck.set(8, new Card(Rank.King, Suit.Diamonds));
    deck.set(48, new Card(Rank.Three, Suit.Diamonds));
    game.startGame(deck, false, 4, 8);
    testPlayGame(new BasicPyramidSolitaire(),
            inputs("njfnjfds fsdkf rm1 fsdfds 4 f fds 3"),
            prints("      A♦\n" +
                    "    A♥  A♠\n" +
                    "  A♣  2♦  2♥\n" +
                    "2♠  2♣      3♥\n" +
                    "Draw: 3♠, 3♣, 4♦, 4♥, 4♠, 4♣, 5♦, 5♥\n" +
                    "Score: 15"));
  }


  @Test
  public void testGoodCommandGoodInputValidMoveRm1() throws IOException {
    PyramidSolitaireModel game = new BasicPyramidSolitaire();
    List<Card> deck = game.getDeck();
    deck.set(8, new Card(Rank.King, Suit.Diamonds));
    deck.set(48, new Card(Rank.Three, Suit.Diamonds));
    game.startGame(deck, false, 4, 8);
    testPlayGame(game,
            inputs("rm1 4 3"),
            prints("      A♦\n" +
                    "    A♥  A♠\n" +
                    "  A♣  2♦  2♥\n" +
                    "2♠  2♣      3♥\n" +
                    "Draw: 3♠, 3♣, 4♦, 4♥, 4♠, 4♣, 5♦, 5♥\n" +
                    "Score: 15"));
  }

  // Rm2 Testing

  @Test
  public void testGoodCommandBadInputsInvalidMoveRm2() throws IOException {
    testPlayGame(new BasicPyramidSolitaire(),
            inputs("rm2 ddssad"),
            prints("Please reenter argument #1"),
            inputs("ffds"),
            prints("Please reenter argument #1"),
            inputs("fjisfiee"),
            prints("Please reenter argument #1"),
            inputs("5"),
            prints("Please reender argument #2"),
            inputs("ood is fun"),
            prints("Please reenter argument #2"),
            inputs("7"),
            prints("Please reenter argument #3"),
            inputs("fdsfdsf"),
            prints("Please reenter argument #3"),
            inputs("2"),
            prints("Please reenter argument #4"),
            inputs("weeeee"),
            prints("Please reenter argument #4"),
            inputs("7"),
            prints("Invalid move. Play again. rm2 requires coordinates of two " +
                    "exposed cards " +
                    "that add up to 13\n" +
                    "Please reenter arguments"));
  }

  @Test
  public void testGoodCommandGoodInputAmongBadInputInvalidMoveRm2() throws IOException {
    testPlayGame(new BasicPyramidSolitaire(),
            inputs("fsfdsfd fsvnvnvnvn rm2 fsdfggds 5 f fds  4 opo 2 dnsjfndjs iiii 3"),
            prints("Invalid move. Play again. rm2 requires " +
                    "coordinates of two exposed cards " +
                    "that add up to 13\n" +
                    "Please reenter arguments"));
  }

  @Test
  public void testGoodCommandGoodInputAmongBadInputValidMoveRm2() throws IOException {
    PyramidSolitaireModel game = new BasicPyramidSolitaire();
    List<Card> deck = game.getDeck();

    game.startGame(deck, false, 7, 8);

    testPlayGame(new BasicPyramidSolitaire(),
            inputs("fsfdsfd fsvnvnvnvn rm2 fsdfggds 7 f fds 1 opo 7 dnsjfndjs iiii 4"),
            prints("            A♦\n" +
                    "          A♥  A♠\n" +
                    "        A♣  2♦  2♥\n" +
                    "      2♠  2♣  3♦  3♥\n" +
                    "    3♠  3♣  4♦  4♥  4♠\n" +
                    "  4♣  5♦  5♥  5♠  5♣  6♦\n" +
                    "    6♠  6♣      7♥  7♠  7♣\n" +
                    "Draw: 8♦, 8♥, 8♠, 8♣, 9♦, 9♥, 9♠, 9♣\n" +
                    "Score: 99"));
  }

  @Test
  public void testGoodCommandGoodInputAmongGoodInputValidMoveRm2() throws IOException {
    PyramidSolitaireModel game = new BasicPyramidSolitaire();
    List<Card> deck = game.getDeck();

    game.startGame(deck, false, 7, 8);

    testPlayGame(new BasicPyramidSolitaire(),
            inputs("rm2 7 1 7 4"),
            prints("            A♦\n" +
                    "          A♥  A♠\n" +
                    "        A♣  2♦  2♥\n" +
                    "      2♠  2♣  3♦  3♥\n" +
                    "    3♠  3♣  4♦  4♥  4♠\n" +
                    "  4♣  5♦  5♥  5♠  5♣  6♦\n" +
                    "    6♠  6♣      7♥  7♠  7♣\n" +
                    "Draw: 8♦, 8♥, 8♠, 8♣, 9♦, 9♥, 9♠, 9♣\n" +
                    "Score: 99"));
  }



  // Rmwd Testing

  @Test
  public void testGoodCommandBadInputsInvalidMoveRmwd() throws IOException {
    testPlayGame(new BasicPyramidSolitaire(),
            inputs("rmwd ddssad"),
            prints("Please reenter argument #1"),
            inputs("ffds"),
            prints("Please reenter argument #1"),
            inputs("fjisfiee"),
            prints("Please reenter argument #1"),
            inputs("5"),
            prints("Please reender argument #2"),
            inputs("ood is fun"),
            prints("Please reenter argument #2"),
            inputs("7"),
            prints("Please reenter argument #3"),
            inputs("fdsfdsf"),
            prints("Please reenter argument #3"),
            inputs("2"),
            prints("Invalid move. Play again. rmwd requires the coords of a" +
                    " card and draw deck that add up to 13\n" +
                    "Please reenter arguments"));
  }

  @Test
  public void testGoodCommandGoodInputAmongBadInputInvalidMoveRmwd() throws IOException {
    testPlayGame(new BasicPyramidSolitaire(),
            inputs("fsfdsfd fsvnvnvnvn rmwd fsdfggds 2 f fds  4 opo 1 dnsjfndjs iiii"),
            prints("Invalid move. Play again. rmwd requires the coords of a" +
                    " card and draw deck that add up to 13\n" +
                    "Please reenter arguments"));
  }

  @Test
  public void testGoodCommandGoodInputAmongBadInputValidMoveRmwd() throws IOException {
    PyramidSolitaireModel game = new BasicPyramidSolitaire();
    List<Card> deck = game.getDeck();

    game.startGame(deck, false, 6, 8);

    testPlayGame(new BasicPyramidSolitaire(),
            inputs("fsfdsfd fsvnvnvnvn rmwd fsdfggds 4 f fds 6 opo 6 dnsjfndjs iiii"),
            prints("          A♦\n" +
                    "        A♥  A♠\n" +
                    "      A♣  2♦  2♥\n" +
                    "    2♠  2♣  3♦  3♥\n" +
                    "  3♠  3♣  4♦  4♥  4♠\n" +
                    "4♣  5♦  5♥  5♠  5♣    \n" +
                    "Draw: 6♥, 6♠, 6♣, 8♥, 7♥, 7♠, 7♣, 8♦\n" +
                    "Score: 60"));

  }

  @Test
  public void testGoodCommandGoodInputAmongGoodInputValidMoveRmwd() throws IOException {
    PyramidSolitaireModel game = new BasicPyramidSolitaire();
    List<Card> deck = game.getDeck();

    Appendable ap = new StringBuilder();
    Readable rd = new StringReader("rmwd 4 6 6 ");
    PyramidSolitaireController c = new PyramidSolitaireTextualController(rd, ap);

    c.playGame(game, game.getDeck(), false, 6, 8);

    assertEquals("ggg", ap.toString());
  }


  // DD Testing

  @Test
  public void testGoodCommandBadInputsInvalidMoveDD() throws IOException {
    testPlayGame(new BasicPyramidSolitaire(),
            inputs("fdsf dd ddssad"),
            prints("Please reenter argument #1"),
            inputs("ffds"),
            prints("Please reenter argument #1"),
            inputs("fjisfiee"),
            prints("Please reenter argument #1"),
            inputs("20"),
            prints("Invalid move. Play again. dd requires the index of a card in the " +
                    "drawdeck to be discarded\n" +
                    "Please reenter arguments"));
  }

  @Test
  public void testGoodCommandGoodInputAmongBadInputInvalidMoveDD() throws IOException {
    testPlayGame(new BasicPyramidSolitaire(),
            inputs("fsfdsfd fsvnvnvnvn dd fsdfggds 30 f fds s iiii"),
            prints("Invalid move. Play again. dd requires the index of a card in the " +
                    "drawdeck to be discarded\n" +
                    "Please reenter arguments"));
  }

  @Test
  public void testGoodCommandGoodInputAmongBadInputValidMoveDD() throws IOException {
    PyramidSolitaireModel game = new BasicPyramidSolitaire();
    List<Card> deck = game.getDeck();

    game.startGame(deck, false, 6, 8);

    testPlayGame(new BasicPyramidSolitaire(),
            inputs("fsfdsfd fsvnvnvnvn dd fsdfggds 2  fdsfds f sd fds fds "),

            prints("          A♦\n" +
                    "        A♥  A♠\n" +
                    "      A♣  2♦  2♥\n" +
                    "    2♠  2♣  3♦  3♥\n" +
                    "  3♠  3♣  4♦  4♥  4♠\n" +
                    "4♣  5♦  5♥  5♠  5♣  6♦\n" +
                    "Draw: 6♥, 7♦, 6♣\n" +
                    "Score: 66"));


  }

  @Test
  public void testGoodCommandGoodInputAmongGoodInputValidMoveDD() throws IOException {
    PyramidSolitaireModel game = new BasicPyramidSolitaire();
    List<Card> deck = game.getDeck();

    game.startGame(deck, false, 6, 8);

    testPlayGame(new BasicPyramidSolitaire(),
            inputs("dd 2"),
            prints("          A♦\n" +
                    "        A♥  A♠\n" +
                    "      A♣  2♦  2♥\n" +
                    "    2♠  2♣  3♦  3♥\n" +
                    "  3♠  3♣  4♦  4♥  4♠\n" +
                    "4♣  5♦  5♥  5♠  5♣  6♦\n" +
                    "Draw: 6♥, 7♦, 6♣\n" +
                    "Score: 66"));
  }

  // Tests for constructor

  @Test(expected = IllegalArgumentException.class)
  public void testConstructorGivenNullReadable() {
    Readable rd = null;
    Appendable ap = new StringBuilder();
    PyramidSolitaireController controller = new PyramidSolitaireTextualController(rd, ap);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructorGivenNullAppendable() {
    Readable rd = new StringReader("hello");
    Appendable ap = null;
    PyramidSolitaireController controller = new PyramidSolitaireTextualController(rd, ap);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testPlayGameNullModel() {
    Readable rd = new StringReader("hello");
    Appendable ap = new StringBuilder();
    PyramidSolitaireController controller = new PyramidSolitaireTextualController(rd, ap);
    PyramidSolitaireModel model = null;
    PyramidSolitaireModel modelForDeck = new BasicPyramidSolitaire();

    controller.playGame(model, modelForDeck.getDeck(), false, 4, 6);
  }

  @Test(expected = IllegalStateException.class)
  public void testPlayGameNullDeck() {
    Readable rd = new StringReader("hello");
    Appendable ap = new StringBuilder();
    PyramidSolitaireController controller = new PyramidSolitaireTextualController(rd, ap);
    PyramidSolitaireModel model = new BasicPyramidSolitaire();

    controller.playGame(model, null, false, 4, 6);
  }


  // Quit Testing

  @Test
  public void testQuittingFromAmongGarbageCapitalQ() throws IOException {
    testPlayGame(new BasicPyramidSolitaire(),
            inputs("fdsf fsdf sd f sdfds  Q fdsf dsfd s"),
            prints("Game quit!\n" +
                    "State of game when quit:\n" +
                    "          A♦\n" +
                    "        A♥  A♠\n" +
                    "      A♣  2♦  2♥\n" +
                    "    2♠  2♣  3♦  3♥\n" +
                    "  3♠  3♣  4♦  4♥  4♠\n" +
                    "4♣  5♦  5♥  5♠  5♣  6♦\n" +
                    "Draw: 6♥, 6♠, 6♣\n" +
                    "Score: 66"));
  }

  @Test
  public void testQuittingFromAmongGarbageLowercaseQ() throws IOException {
    testPlayGame(new BasicPyramidSolitaire(),
            inputs("fdsf fsdf sd f sdfds  q fdsf dsfd s"),
            prints("Game quit!\n" +
                    "State of game when quit:\n" +
                    "          A♦\n" +
                    "        A♥  A♠\n" +
                    "      A♣  2♦  2♥\n" +
                    "    2♠  2♣  3♦  3♥\n" +
                    "  3♠  3♣  4♦  4♥  4♠\n" +
                    "4♣  5♦  5♥  5♠  5♣  6♦\n" +
                    "Draw: 6♥, 6♠, 6♣\n" +
                    "Score: 66"));
  }

  @Test
  public void testQuittingByItselfLowercaseQ() throws IOException {
    testPlayGame(new BasicPyramidSolitaire(),
            inputs("q"),
            prints("Game quit!\n" +
                    "State of game when quit:\n" +
                    "          A♦\n" +
                    "        A♥  A♠\n" +
                    "      A♣  2♦  2♥\n" +
                    "    2♠  2♣  3♦  3♥\n" +
                    "  3♠  3♣  4♦  4♥  4♠\n" +
                    "4♣  5♦  5♥  5♠  5♣  6♦\n" +
                    "Draw: 6♥, 6♠, 6♣\n" +
                    "Score: 66"));
  }

  @Test
  public void testQuittingByItselfUppercaseQ() throws IOException {
    testPlayGame(new BasicPyramidSolitaire(),
            inputs("Q"),
            prints("Game quit!\n" +
                    "State of game when quit:\n" +
                    "          A♦\n" +
                    "        A♥  A♠\n" +
                    "      A♣  2♦  2♥\n" +
                    "    2♠  2♣  3♦  3♥\n" +
                    "  3♠  3♣  4♦  4♥  4♠\n" +
                    "4♣  5♦  5♥  5♠  5♣  6♦\n" +
                    "Draw: 6♥, 6♠, 6♣\n" +
                    "Score: 66"));
  }

  // Game Winning/Game Over

  @Test
  public void testGameOver() throws IOException {
    PyramidSolitaireModel game = new BasicPyramidSolitaire();
    game.startGame(game.getDeck(), false, 9, 6);
    testPlayGame(game,
            inputs("dd 1"),
            prints("                A♦\n" +
                    "              A♥  A♠\n" +
                    "            A♣  2♦  2♥\n" +
                    "          2♠  2♣  3♦  3♥\n" +
                    "        3♠  3♣  4♦  4♥  4♠\n" +
                    "      4♣  5♦  5♥  5♠  5♣  6♦\n" +
                    "    6♥  6♠  6♣  7♦  7♥  7♠  7♣\n" +
                    "  8♦  8♥  8♠  8♣  9♦  9♥  9♠  9♣\n" +
                    "10♦ 10♥ 10♠ 10♣ J♦  J♥  J♠  J♣  Q♦\n" +
                    "Draw: K♣, Q♠, Q♣, K♦, K♥, K♠\n" +
                    "Score: 276"),
            inputs("dd 1"),
            prints("                A♦\n" +
                    "              A♥  A♠\n" +
                    "            A♣  2♦  2♥\n" +
                    "          2♠  2♣  3♦  3♥\n" +
                    "        3♠  3♣  4♦  4♥  4♠\n" +
                    "      4♣  5♦  5♥  5♠  5♣  6♦\n" +
                    "    6♥  6♠  6♣  7♦  7♥  7♠  7♣\n" +
                    "  8♦  8♥  8♠  8♣  9♦  9♥  9♠  9♣\n" +
                    "10♦ 10♥ 10♠ 10♣ J♦  J♥  J♠  J♣  Q♦\n" +
                    "Draw:     Q♠, Q♣, K♦, K♥, K♠\n" +
                    "Score: 276"),
            inputs("dd 2"),
            prints("                A♦\n" +
                    "              A♥  A♠\n" +
                    "            A♣  2♦  2♥\n" +
                    "          2♠  2♣  3♦  3♥\n" +
                    "        3♠  3♣  4♦  4♥  4♠\n" +
                    "      4♣  5♦  5♥  5♠  5♣  6♦\n" +
                    "    6♥  6♠  6♣  7♦  7♥  7♠  7♣\n" +
                    "  8♦  8♥  8♠  8♣  9♦  9♥  9♠  9♣\n" +
                    "10♦ 10♥ 10♠ 10♣ J♦  J♥  J♠  J♣  Q♦\n" +
                    "Draw:         Q♣, K♦, K♥, K♠\n" +
                    "Score: 276"),
            inputs("dd 3"),
            prints("                A♦\n" +
                    "              A♥  A♠\n" +
                    "            A♣  2♦  2♥\n" +
                    "          2♠  2♣  3♦  3♥\n" +
                    "        3♠  3♣  4♦  4♥  4♠\n" +
                    "      4♣  5♦  5♥  5♠  5♣  6♦\n" +
                    "    6♥  6♠  6♣  7♦  7♥  7♠  7♣\n" +
                    "  8♦  8♥  8♠  8♣  9♦  9♥  9♠  9♣\n" +
                    "10♦ 10♥ 10♠ 10♣ J♦  J♥  J♠  J♣  Q♦\n" +
                    "Draw:             K♦, K♥, K♠\n" +
                    "Score: 276"),
            inputs("dd 4"),
            prints("                A♦\n" +
                    "              A♥  A♠\n" +
                    "            A♣  2♦  2♥\n" +
                    "          2♠  2♣  3♦  3♥\n" +
                    "        3♠  3♣  4♦  4♥  4♠\n" +
                    "      4♣  5♦  5♥  5♠  5♣  6♦\n" +
                    "    6♥  6♠  6♣  7♦  7♥  7♠  7♣\n" +
                    "  8♦  8♥  8♠  8♣  9♦  9♥  9♠  9♣\n" +
                    "10♦ 10♥ 10♠ 10♣ J♦  J♥  J♠  J♣  Q♦\n" +
                    "Draw:                 K♥, K♠\n" +
                    "Score: 276"),
            inputs("dd 5"),
            prints("                A♦\n" +
                    "              A♥  A♠\n" +
                    "            A♣  2♦  2♥\n" +
                    "          2♠  2♣  3♦  3♥\n" +
                    "        3♠  3♣  4♦  4♥  4♠\n" +
                    "      4♣  5♦  5♥  5♠  5♣  6♦\n" +
                    "    6♥  6♠  6♣  7♦  7♥  7♠  7♣\n" +
                    "  8♦  8♥  8♠  8♣  9♦  9♥  9♠  9♣\n" +
                    "10♦ 10♥ 10♠ 10♣ J♦  J♥  J♠  J♣  Q♦\n" +
                    "Draw:                     K♠\n" +
                    "Score: 276"),
            inputs("dd 6"),
            prints("Game over. Score: 276"));
  }

  @Test
  public void testGameWinning() throws IOException {
    PyramidSolitaireModel game = new BasicPyramidSolitaire();
    List<Card> deck = game.getDeck();
    deck.set(3, new Card(Rank.Queen, Suit.Diamonds));
    deck.set(4, new Card(Rank.Queen, Suit.Hearts));
    deck.set(5, new Card(Rank.Queen, Suit.Spades));
    deck.set(44, new Card(Rank.Ace, Suit.Clubs));
    deck.set(45, new Card(Rank.Two, Suit.Diamonds));
    deck.set(46, new Card(Rank.Two, Suit.Hearts));

    game.startGame(deck, false, 2, 6);
    testPlayGame(game,
            inputs("rmwd 1 2 1"),
            prints("  A♦\n" +
                    "    A♠\n" +
                    "Draw: 3♥, Q♥, Q♠, 2♠, 2♣, 3♦\n" +
                    "Score: 2"),
            inputs("rmwd 2 2 2"),
            prints("  A♦\n" +
                    "      \n" +
                    "Draw: 3♥, 3♠, Q♠, 2♠, 2♣, 3♦\n" +
                    "Score: 2"),
            inputs("rmwd 3 1 1"),
            prints("You win!")
    );
  }










}