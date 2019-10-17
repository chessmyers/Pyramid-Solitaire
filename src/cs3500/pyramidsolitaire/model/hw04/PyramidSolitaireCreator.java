package cs3500.pyramidsolitaire.model.hw04;

import cs3500.pyramidsolitaire.model.hw02.BasicPyramidSolitaire;
import cs3500.pyramidsolitaire.model.hw02.PyramidSolitaireModel;

/**
 * A factory for creation of models for a game of pyramid solitaire.
 */
public class PyramidSolitaireCreator {
  /**
   * The possible types of pyramid solitaire that can be played.
   */
  public enum GameType {
    BASIC,
    RELAXED,
    TRIPEAKS
  }

  /**
   * creates the model for a game of pyramid solitaire, type of which depends on given GameType.
   * @param type the type of pyramid solitaire game to create a model for
   * @return a model for a new game of pyramid solitaire
   */
  public static PyramidSolitaireModel create(GameType type) {
    PyramidSolitaireModel model;
    switch (type) {
      case BASIC: {
        model = new BasicPyramidSolitaire();
        break;
      }
      case RELAXED: {
        model = new RelaxedPyramidSolitaire();
        break;
      }
      case TRIPEAKS: {
        model = new TriPeaksPyramidSolitaire();
        break;
      }
      default: throw new IllegalArgumentException("Wrong Game Type Given");
    }
    return model;
  }
}
