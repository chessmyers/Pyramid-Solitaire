package cs3500.pyramidsolitaire.model.hw04;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import cs3500.pyramidsolitaire.model.hw02.Card;
import cs3500.pyramidsolitaire.model.hw02.PyramidSolitaireModel;
import cs3500.pyramidsolitaire.model.hw02.Rank;
import cs3500.pyramidsolitaire.model.hw02.Suit;

/**
 * General representation of some type of Pyramid Solitaire game.
 */
public abstract class AbstractPyramidSolitaire implements PyramidSolitaireModel<Card> {
  // Turned this into an array of arrays of Cards
  private List<List<Card>> pyramid;
  private List<Card> stock;
  private List<Card> drawDeck;
  private int startRows;
  private int numDraw;
  // Made this field protected
  protected boolean gameStarted = false;

  private final String GAMENOTSTART = "The game has not yet started!";


  @Override
  public List<Card> getDeck() {
    List<Card> deck = new ArrayList<>();
    for (Rank rank : Rank.values()) {
      for (Suit suit : Suit.values()) {
        deck.add(new Card(rank, suit));
      }
    }
    return deck;
  }

  @Override
  public void startGame(List<Card> deck, boolean shouldShuffle, int numRows, int numDraw) {
    // DO verification to make sure arguments are valid

    // Must be more than 1 but fewer than 9 rows
    if (numRows < 1 || numRows > 9) {
      throw new IllegalArgumentException("You must have between 1 and 9 rows, inclusive");
    }
    int cardsInPyramid = getNumCardsInPyramid(numRows);

    // Draw deck must have between 0 or more but less than or equal to available cards
    if (numDraw < 0 || numDraw > deck.size() - cardsInPyramid) {
      throw new IllegalArgumentException("Must have over 1 but not too many cards in draw deck");
    }

    if (isFullDeck(deck)) {

      List<Card> deckCopy = new ArrayList<>();
      for (Card c : deck) {
        deckCopy.add(c.clone());
      }

      if (shouldShuffle) {
        Collections.shuffle(deckCopy);
      }

      List<Card> stock = new ArrayList<>();
      List<Card> drawDeck = new ArrayList<>();

      List<List<Card>> pyramid = getPyramid(deckCopy, numRows);

      for (int i = cardsInPyramid; i < deckCopy.size(); i++) {
        stock.add(deckCopy.get(i));
      }

      for (int i = 0; i < numDraw; i++) {
        Card c = stock.remove(0);
        drawDeck.add(c);
      }

      this.gameStarted = true;
      this.startRows = numRows;
      this.pyramid = exposeTopCards(pyramid, numRows);
      this.stock = stock;
      this.numDraw = numDraw;
      this.drawDeck = drawDeck;

    } else {
      throw new IllegalArgumentException("Deck must be a full card deck");
    }


  }

  /**
   * Returns true if the given list of Cards has all 52 cards that come in a standard deck.
   * @param deck the deck whose validity will be checked
   * @return whether the given deck has all 52 cards
   */
  protected boolean isFullDeck(List<Card> deck) {
    if (deck.contains(null)) {
      return false;
    }
    if (deck.size() != 52) {
      return false;
    }
    for (Rank rank : Rank.values()) {
      for (Suit suit : Suit.values()) {
        if (!deck.contains(new Card(rank, suit))) {
          return false;
        }
      }
    }
    return true;
  }

  protected int getNumCardsInPyramid(int numRows) {
    int cardsInPyramid = 0;
    for (int i = numRows; i > 0; i--) {
      cardsInPyramid += i;
    }
    return cardsInPyramid;
  }

  protected List<List<Card>> getPyramid(List<Card> deck, int numRows) {
    List<List<Card>> pyramid = new ArrayList<>();
    int index = 0;
    for (int i = 0; i < numRows; i++) {
      pyramid.add(new ArrayList<>());
      for (int j = 0; j <= i; j++) {
        pyramid.get(i).add(deck.get(index));
        index ++;
      }
    }

    return pyramid;
  }


  /**
   * Returns the given deck with its bottom row exposed, so the game can be played with it.
   * @param pyramid the given deck that will have its cards exposed and then be returned
   * @param numRows the number of rows in this pyramid
   * @return given pyramid with the cards on the bottom row exposed and thus playable
   */
  private List<List<Card>> exposeTopCards(List<List<Card>> pyramid, int numRows) {
    for (int i = 0; i < this.getRowWidth(numRows - 1); i++) {
      pyramid.get(numRows - 1).get(i).expose();
    }
    return pyramid;
  }



  @Override
  public void remove(int row1, int card1, int row2, int card2) throws IllegalStateException {
    if (this.gameStarted) {
      // Game has been started
      if (validCardCoords(row1, card1) && validCardCoords(row2, card2)) {
        // Both coords point to valid spots
        if (cardAtSpot(row1, card1, true) && cardAtSpot(row2, card2, true)) {
          // Cards can be removed from these spots
          Card c1 = getCardAt(row1, card1);
          Card c2 = getCardAt(row2, card2);
          if (c1.cardValue() + c2.cardValue() == 13) {
            // Valid move made
            c1.remove();
            c2.remove();
            checkIfExposed();
          } else {
            throw new IllegalArgumentException("Cards must add up to 13");
          }
        } else {
          throw new IllegalArgumentException("You can only remove cards that are exposed");
        }
      } else {
        // Invalid position
        throw new IllegalArgumentException("One or more of these card positions are invalid!");
      }
    } else {
      // game has not been started
      throw new IllegalStateException(GAMENOTSTART);
    }
  }

  @Override
  public void remove(int row, int card) throws IllegalStateException, IllegalArgumentException {
    if (this.gameStarted) {
      // Game has been started
      if (validCardCoords(row, card) && cardAtSpot(row, card, true)) {
        // Valid space
        Card c = getCardAt(row, card);
        if (c.cardValue() == 13) {
          // Card is a king, valid move
          c.remove();
          checkIfExposed();
        } else {
          throw new IllegalArgumentException("Can only remove a King on single move");
        }
      } else {
        // Illegal position
        throw new IllegalArgumentException("This position does not have a card!");
      }
    } else {
      // Game has not yet started
      throw new IllegalStateException(GAMENOTSTART);
    }
  }

  @Override
  public void removeUsingDraw(int drawIndex, int row, int card)
          throws IllegalStateException, IllegalArgumentException {
    if (this.gameStarted) {
      // Game has been started
      if (drawIndex >= 0 && drawIndex < this.numDraw && this.drawDeck.get(drawIndex).isThere()
              && validCardCoords(row, card) && cardAtSpot(row, card, true)) {
        // Cards being checked do exist
        Card c1 = getCardAt(row, card);
        Card c2 = this.drawDeck.get(drawIndex);
        if (c1.cardValue() + c2.cardValue() == 13) {
          // Cards add up to 13, valid move
          c1.remove();
          discardDraw(drawIndex);
          checkIfExposed();
        } else {
          throw new IllegalArgumentException("Draw card and given cards must add up to 13");
        }
      } else {
        // One of the cards doesn't exist
        throw new IllegalArgumentException("One of these cards does not exist");
      }
    } else {
      // Game has not yet started
      throw new IllegalStateException(GAMENOTSTART);
    }
  }

  /**
   * Iterates through the pyramid and marks any uncovered cards as exposed.
   */
  protected void checkIfExposed() {
    for (int row = 0; row < this.getNumRows(); row++) {
      for (int card = 0; card <= row; card++) {
        Card c = this.pyramid.get(row).get(card);
        if (!c.isExposed()) {
          if ((getCardAt(row + 1, card) == null)
                  && getCardAt(row + 1, card + 1) == null) {
            // this card should be exposed
            c.expose();
          }
        }
      }
    }
  }


  @Override
  public void discardDraw(int drawIndex) throws IllegalStateException, IllegalArgumentException {
    if (!this.gameStarted) {
      throw new IllegalStateException(GAMENOTSTART);
    }
    if (drawIndex >= 0 && drawIndex < this.drawDeck.size()
            && this.drawDeck.get(drawIndex).isThere()) {
      if (!this.stock.isEmpty()) {
        this.drawDeck.set(drawIndex, stock.remove(0));
      } else {
        this.drawDeck.get(drawIndex).remove();
      }
    } else {
      throw new IllegalArgumentException("Card index given is out of bounds");
    }
  }

  @Override
  public int getNumRows() {
    if (this.gameStarted) {
      return this.startRows;
    } else {
      return -1;
    }
  }

  @Override
  public int getNumDraw() {
    if (this.gameStarted) {
      return this.numDraw;
    } else {
      return -1;
    }
  }

  @Override
  public int getRowWidth(int row) {
    if (!this.gameStarted) {
      throw new IllegalStateException(GAMENOTSTART);
    }
    if (row < 0 || row > this.startRows - 1) {
      throw new IllegalArgumentException("Invalid row");
    }
    return row + 1;
  }

  @Override
  public boolean isGameOver() throws IllegalStateException {
    if (this.gameStarted) {
      boolean drawDeckEmpty = true;
      for (Card c : this.drawDeck) {
        if (c.isThere()) {
          drawDeckEmpty = false;
        }
      }
      if (!drawDeckEmpty || this.stock.size() > 0) {
        return false;
      } else {
        // draw deck and stocks are empty
        List<Card> available = new ArrayList<>();
        for (List<Card> row : this.pyramid) {
          for (Card c: row) {
            if (c.isExposed() && c.isThere()) {
              available.add(c);
            }
          }
        }

        for (Card c : available) {
          int val = c.cardValue();
          for (Card check : available) {
            if (val == 13 || check.cardValue() == 13 || (val + check.cardValue() == 13)) {
              return false;
            }
          }
        }
        return true;
      }
    } else {
      throw new IllegalStateException(GAMENOTSTART);
    }
  }

  @Override
  public int getScore() throws IllegalStateException {
    if (this.gameStarted) {
      // game has been started
      int score = 0;
      for (List<Card> row : this.pyramid) {
        for (Card c : row) {
          if (c.isThere()) {
            score += c.cardValue();
          }
        }
      }
      return score;
    } else {
      throw new IllegalStateException(GAMENOTSTART);
    }
  }

  @Override
  public Card getCardAt(int row, int card) throws IllegalStateException, IllegalArgumentException {
    if (this.gameStarted) {
      if (validCardCoords(row, card)) {
        if (cardAtSpot(row, card, false)) {
          return this.pyramid.get(row).get(card);
        } else {
          return null;
        }
      } else {
        throw new IllegalArgumentException("Invalid card coordinates or no card at position");
      }
    } else {
      throw new IllegalStateException(GAMENOTSTART);
    }
  }

  /**
   * Returns whether the coordinates of this card are valid on the board.
   * @param row    the index of the row of the card being checked for
   * @param card   the index of the column of the card being checked for
   * @return  whether the given coordinates are valid
   */
  protected boolean validCardCoords(int row, int card) {
    return (!(row < 0 || card < 0 || row >= this.getRowWidth(row)));
  }

  /**
   * Returns whether this spot has a card that is both exposed and still present.
   * @param row the index of the row of the card being checked for
   * @param card the index of the column of the card being checked for
   * @return whether the given coordinates have an exposed, present card
   */
  protected boolean cardAtSpot(int row, int card, boolean checkExposed) {
    Card c = this.pyramid.get(row).get(card);
    if (checkExposed) {
      return c.isThere() && c.isExposed();
    } else {
      return c.isThere();
    }
  }

  @Override
  public List<Card> getDrawCards() throws IllegalStateException {
    if (this.gameStarted) {
      ArrayList<Card> copy = new ArrayList<>(this.drawDeck.size());
      for (Card c : this.drawDeck) {
        copy.add(c.clone());
      }
      return copy;
    } else {
      throw new IllegalStateException(GAMENOTSTART);
    }
  }
}
