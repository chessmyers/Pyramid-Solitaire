package cs3500.pyramidsolitaire;

import java.io.InputStreamReader;

import cs3500.pyramidsolitaire.controller.PyramidSolitaireController;
import cs3500.pyramidsolitaire.controller.PyramidSolitaireTextualController;
import cs3500.pyramidsolitaire.model.hw02.PyramidSolitaireModel;
import cs3500.pyramidsolitaire.model.hw04.PyramidSolitaireCreator;

/**
 * Creates and plays a new game of pyramid solitaire.
 */
public final class PyramidSolitaire {
  /**
   * Main method to start a game of pyramid solitaire.
   * @param args program arguments to specify the solitaire type and number of rows and draw cards.
   */
  public static void main(String[] args) {
    // FILL IN HERE
    if (args.length != 1 && args.length != 3) {
      System.out.println("Wrong number of arguments");
    } else {
      PyramidSolitaireCreator.GameType type = PyramidSolitaireCreator.GameType.BASIC;
      // correct number of arguments given
      switch (args[0]) {
        case "basic": {
          type = PyramidSolitaireCreator.GameType.BASIC;
          break;
        }
        case "relaxed": {
          type = PyramidSolitaireCreator.GameType.RELAXED;
          break;
        }
        case "tripeaks": {
          type = PyramidSolitaireCreator.GameType.TRIPEAKS;
          break;
        }
        default: System.out.println("Invalid game type given");
      }
      int arg1 = 7;
      int arg2 = 3;
      if (args.length > 1) {
        try {
          arg1 = Integer.parseInt(args[1]);
          arg2 = Integer.parseInt(args[2]);
        } catch (NumberFormatException e) {
          System.out.println("Second and third arguments must be numbers");
        }
      }
      PyramidSolitaireModel model = PyramidSolitaireCreator.create(type);
      PyramidSolitaireController controller =
              new PyramidSolitaireTextualController(new InputStreamReader(System.in), System.out);
      controller.playGame(model, model.getDeck(), true, arg1, arg2);
    }
  }
}