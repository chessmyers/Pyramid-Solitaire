package cs3500.pyramidsolitaire.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import cs3500.pyramidsolitaire.model.hw02.PyramidSolitaireModel;
import cs3500.pyramidsolitaire.view.PyramidSolitaireTextualView;
import cs3500.pyramidsolitaire.view.PyramidSolitaireView;

/**
 * Represents the controller for a textual game of pyramid solitaire.
 */
public class PyramidSolitaireTextualController implements PyramidSolitaireController {
  private Readable rd;
  private Appendable ap;


  /**
   * Constructs a new text-based controller for Pyramid Solitaire.
   * @param rd a readable to allow for user input
   * @param ap an appendable that output will be appended to
   * @throws IllegalArgumentException if either argument is null
   */
  public PyramidSolitaireTextualController(Readable rd, Appendable ap)
          throws IllegalArgumentException {
    if (rd == null || ap == null) {
      throw new IllegalArgumentException("One of these arguments is null");
    }
    this.rd = rd;
    this.ap = ap;
  }

  @Override
  public <K> void playGame(PyramidSolitaireModel<K> model, List<K> deck, boolean shuffle,
                           int numRows, int numDraw)
          throws IllegalArgumentException, IllegalStateException {
    if (model == null) {
      throw new IllegalArgumentException("Cannot play with null model");
    }
    if (deck == null) {
      throw new IllegalStateException("Cannot play with empty deck");
    }
    // Model is alright
    model.startGame(deck, shuffle, numRows, numDraw);

    Scanner sc = new Scanner(this.rd);
    PyramidSolitaireView view = new PyramidSolitaireTextualView(model, this.ap);

    boolean gameIsQuit = false;
    while (model.getScore() != 0 && !model.isGameOver() && !gameIsQuit) {
      try {
        view.render();
        this.ap.append("\nScore: " + model.getScore() + "\n");
      } catch (IOException e) {
        throw new IllegalStateException("Error in inputs");
      }

      String move = sc.next();

      gameIsQuit = this.processInput(move, sc, model);
    }

    try {
      if (gameIsQuit) {
        this.ap.append("Game quit!\nState of game when quit:\n");
      }
      view.render();
      if (gameIsQuit) {
        this.ap.append("\nScore: " + model.getScore() + "\n");
      }
    } catch (IOException e) {
      throw new IllegalStateException("Error in getting input");
    }
  }

  /**
   * Processes given player input to return whether the game has been quit.
   * @param move the given move by the player to process
   * @param scan the scanner to check for subsequent input
   * @param model the model to update
   * @param <K> what the given model uses to represent game elements
   * @return whether the game has been quit
   */
  private <K> boolean processInput(String move, Scanner scan, PyramidSolitaireModel<K> model) {
    ArrayList<Integer> processedInput;
    switch (move) {
      case "rm1": {
        // validate input
        processedInput = this.validateInput(2, scan);
        if (processedInput == null) {
          // Q was in string, quit game
          return true;
        }
        try {
          model.remove(processedInput.get(0) - 1, processedInput.get(1) - 1);
        } catch (IllegalArgumentException e) {
          try {
            this.ap.append("Invalid move. Play again. rm1 requires a row and column of a king\n");
            this.ap.append("Please reenter arguments:\n");
            this.processInput("rm1", scan, model);
          } catch (IOException ioe) {
            throw new IllegalStateException("I/O Exception");
          }
        }
        break;
      }
      case "rm2": {
        processedInput = this.validateInput(4, scan);
        if (processedInput == null) {
          // Q was in string, quit game
          return true;
        }
        try {
          model.remove(processedInput.get(0) - 1, processedInput.get(1) - 1,
                  processedInput.get(2) - 1, processedInput.get(3) - 1);
        } catch (IllegalArgumentException e) {
          try {
            this.ap.append("Invalid move. Play again. rm2 requires coordinates of two exposed " +
                    "cards that add up to 13\n");
            this.ap.append("Please reenter arguments:\n");
            this.processInput("rm2", scan, model);
          } catch (IOException ioe) {
            throw new IllegalStateException("I/O Exception");
          }
        }
        break;
      }
      case "rmwd": {
        // validate input
        processedInput = this.validateInput(3, scan);
        if (processedInput == null) {
          // Q was in string, quit game
          return true;
        }
        try {
          model.removeUsingDraw(processedInput.get(0) - 1,
                  processedInput.get(1) - 1, processedInput.get(2) - 1);
        } catch (IllegalArgumentException e) {
          try {
            this.ap.append("Invalid move. Play again. rmwd requires the coords of a card" +
                    "and draw deck that add up to 13\n");
            this.ap.append("Please reenter arguments:\n");
            this.processInput("rmwd", scan, model);
          } catch (IOException ioe) {
            throw new IllegalStateException("I/O Exception");
          }
        }
        break;
      }
      case "dd": {
        // validate input
        processedInput = this.validateInput(1, scan);
        if (processedInput == null) {
          // Q was in string, quit game
          return true;
        }
        try {
          model.discardDraw(processedInput.get(0) - 1);
        } catch (IllegalArgumentException e) {
          try {
            this.ap.append("Invalid move. Play again. dd requires the index of a card in the draw" +
                    "deck to be discarded\n");
            this.ap.append("Please reenter arguments:\n");
            this.processInput("dd", scan, model);
          } catch (IOException ioe) {
            throw new IllegalStateException("I/O Exception");
          }
        }
        break;
      }
      case "q": case "Q": {
        return true;
      }
      default: {
        try {
          if (scan.hasNext()) {
            this.processInput(scan.next(), scan, model);
          } else {
            this.ap.append("Invalid move. Play again. This is not a valid command\n");
          }


        } catch (IOException e) {
          throw new IllegalStateException("Could not append to appendable");
        }
      }
    }
    return false;
  }

  /**
   * Validates the input provided by the given scanner.
   * @param argNum the number of arguments to look for in the given input
   * @param scan the scanner to check for input
   * @return a list of the integer arguments from the given scanner
   */
  private ArrayList<Integer> validateInput(int argNum, Scanner scan) {
    ArrayList<Integer> returnInputs = new ArrayList<>();
    int count = argNum;
    String userInput;
    String line = scan.nextLine();
    Scanner lineScan = new Scanner(line);
    while (count > 0) {
      if (!lineScan.hasNext()) {
        // get another input
        try {
          this.ap.append("Please reenter argument #" + (argNum - count + 1) + "\n");
          line = scan.nextLine();
          lineScan = new Scanner(line);
        } catch (IOException e) {
          throw new IllegalStateException("Could not append to appendable");
        }
      }

      if (line.contains("q") || line.contains("Q")) {
        return null;
      }
      userInput = lineScan.next();
      try {
        returnInputs.add(Integer.parseInt(userInput));
        count--;
      } catch (NumberFormatException e) {
        // non-integer input
      }

    }

    return returnInputs;
  }
}