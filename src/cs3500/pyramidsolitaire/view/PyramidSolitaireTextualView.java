package cs3500.pyramidsolitaire.view;

import java.io.IOException;
import cs3500.pyramidsolitaire.model.hw02.PyramidSolitaireModel;

/**
 * Represents a text-based view for the Pyramid Solitaire Model.
 */
public class PyramidSolitaireTextualView implements PyramidSolitaireView {
  private final PyramidSolitaireModel<?> model;
  private final Appendable out;


  /**
   * Creates a new text-based view for Pyramid Solitaire.
   *
   * @param model the model to create a view for
   */
  public PyramidSolitaireTextualView(PyramidSolitaireModel<?> model) {
    this.model = model;
    this.out = null;
  }

  public PyramidSolitaireTextualView(PyramidSolitaireModel<?> model, Appendable ap) {
    this.model = model;
    this.out = ap;
  }

  /**
   * Produces a String that represents a view for the current state of the model.
   *
   * @return the generated String, appearance reflects whether the game is lost, won, or in play
   */
  @Override
  public String toString() {
    if (model.getNumRows() == -1) {
      // Game has not started yet
      return "";
    }
    if (model.getScore() == 0) {
      // Pyramid is empty
      return "You win!";
    }
    if (model.isGameOver()) {
      // No remaining moves
      return "Game over. Score: " + model.getScore();
    }

    // Draw the game
    String lineSpace = makeSpaces(model.getNumRows() - 1);

    String toDraw = lineSpace;
    for (int row = 0; row < model.getNumRows(); row++) {
      for (int card = 0; card <= model.getRowWidth(row) - 1; card++) {
        Object c = model.getCardAt(row, card);
        if (c == null) {
          toDraw += "  ";
        } else {
          toDraw += c.toString();
        }

        if (card == model.getRowWidth(row) - 1) {
          // at last card in row
          if (row != model.getNumRows()) {
            toDraw += "\n";
            lineSpace = makeSpaces(model.getNumRows() - row - 2);
            toDraw += lineSpace;
          }
        } else {
          Object c2 = model.getCardAt(row, card);
          if ((c2 != null && c2.toString().contains("10"))) {
            toDraw += " ";
          } else {
            toDraw += "  ";
          }
        }
      }
    }
    String drawCards = "";
    for (int i = 0; i < model.getDrawCards().size(); i++) {
      Object c = model.getDrawCards().get(i);
      drawCards += " " + c.toString();
      if (i != model.getDrawCards().size() - 1) {
        if (c.toString().equals("  ")) {
          // card is not visible
          drawCards += " ";
        } else {
          if (!(model.getDrawCards().get(i + 1).toString()).equals("  ")) {
            drawCards += ",";
          }
        }
      }
    }
    String drawDeck = "Draw:" + drawCards;
    drawDeck = drawDeck.trim();

    return toDraw + drawDeck;


  }

  @Override
  public void render() throws IOException {
    this.out.append(this.toString());
  }


  /**
   * Generates a String consisting of twice the given argument number of spaces.
   *
   * @param num half the number of spaces desired in returned String
   * @return String with just 2 * num spaces
   */
  private String makeSpaces(int num) {
    String spaces = "";
    for (int i = 0; i < num; i++) {
      spaces += "  ";
    }
    return spaces;
  }

}