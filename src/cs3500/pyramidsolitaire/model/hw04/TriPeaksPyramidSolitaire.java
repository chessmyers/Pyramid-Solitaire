package cs3500.pyramidsolitaire.model.hw04;

import java.util.ArrayList;
import java.util.List;

import cs3500.pyramidsolitaire.model.hw02.Card;
import cs3500.pyramidsolitaire.model.hw02.Rank;
import cs3500.pyramidsolitaire.model.hw02.Suit;

/**
 * Represents the model for a game of pyramid solitaire with three peaks and double the cards.
 */
public class TriPeaksPyramidSolitaire extends AbstractPyramidSolitaire {

  /**
   * Returns a 104-card deck for tri-peaks pyramid solitaire.
   *
   * @return the deck for the game as an ArrayList
   */
  @Override
  public List<Card> getDeck() {
    List<Card> deck = new ArrayList<>();
    for (Rank rank : Rank.values()) {
      for (Suit suit : Suit.values()) {
        deck.add(new Card(rank, suit));
        deck.add(new Card(rank, suit));
      }
    }
    return deck;
  }


  /**
   * Returns whether the given deck is full (has 104 cards--2 of each from a 52-card deck).
   *
   * @param deck the deck whose validity will be checked
   * @return whether the given deck is valid or not
   */
  @Override
  protected boolean isFullDeck(List<Card> deck) {
    if (deck.contains(null) || deck.size() != 104) {
      return false;
    }

    for (Rank rank : Rank.values()) {
      for (Suit suit : Suit.values()) {
        Card c = new Card(rank, suit);
        if (!deck.contains(c) || deck.indexOf(c) == deck.lastIndexOf(c)) {
          return false;
        }
      }
    }
    return true;
  }

  /**
   * Returns the number of cards that would be in a tri-peaks pyramid of the given # of rows.
   *
   * @param numRows the number of rows to get a card count for
   * @return the number of cards that would be in the pyramid
   */
  @Override
  protected int getNumCardsInPyramid(int numRows) {
    int sum = 0;
    for (int i = numRows; i > 0; i--) {
      sum += i;
    }
    sum *= 2;
    if (numRows % 2 == 1) {
      sum--;
    }
    sum += Math.pow(numRows / 2, 2);

    return sum;
  }

  /**
   * Creates a new pyramid for tri-peaks pyramid solitaire.
   *
   * @param deck    the deck to create a pyramid from
   * @param numRows the number of rows that should be in the pyramid
   * @return the pyramid represented as a 2D ArrayList
   */
  @Override
  protected List<List<Card>> getPyramid(List<Card> deck, int numRows) {
    List<List<Card>> pyramid = new ArrayList<>();
    int index = 0;
    int topRowWidth = numRows % 2 == 0 ? numRows + 1 : numRows;
    for (int i = 0; i < numRows; i++) {
      pyramid.add(new ArrayList<>());
      for (int j = 0; j < topRowWidth + i; j++) {
        if (i < numRows / 2 - 1) {
          // if were in one of the peak rows
          if (i == 0) {
            // in the top row
            if (j == 0 || j == topRowWidth - 1 || j == numRows / 2) {
              pyramid.get(i).add(deck.get(index));
              index++;
            } else {
              Card c = new Card(Rank.Ace, Suit.Clubs);
              c.remove();
              pyramid.get(i).add(c);
            }
          } else {
            int rowWidth = numRows + i + (numRows % 2 == 0 ? 1 : 0);
            // not all cards present but not top row
            if ((j > i && j < (rowWidth / 2) - 1)
                    || (j < (rowWidth - i - 1) && j > (rowWidth / 2) + (i - 1))) {
              Card c = new Card(Rank.Ace, Suit.Clubs);
              c.remove();
              pyramid.get(i).add(c);
            } else {
              pyramid.get(i).add(deck.get(index));
              index++;
            }
          }
        } else {
          pyramid.get(i).add(deck.get(index));
          index++;
        }
      }
    }
    return pyramid;
  }

  /**
   * The width of a given row from a tri-peaks pyramid solitaire setup.
   *
   * @param row the row to get the width of
   * @return the width of the given row, in number of cards
   */
  @Override
  public int getRowWidth(int row) {
    if (!this.gameStarted) {
      throw new IllegalStateException("The game has not been started");
    }
    if (row < 0 || row > this.getNumRows() - 1) {
      throw new IllegalArgumentException("Invalid row");
    }

    return this.getNumRows() + row + (this.getNumRows() % 2 == 0 ? 1 : 0);

  }


}
