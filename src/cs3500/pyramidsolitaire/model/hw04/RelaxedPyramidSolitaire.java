package cs3500.pyramidsolitaire.model.hw04;

import cs3500.pyramidsolitaire.model.hw02.Card;

/**
 * Represents the model for a game of pyramid solitaire with more relaxed removal rules.
 */
public class RelaxedPyramidSolitaire extends AbstractPyramidSolitaire {


  @Override
  public void remove(int row1, int card1, int row2, int card2) {
    if (this.gameStarted) {
      // Game has been started
      if (validCardCoords(row1, card1) && validCardCoords(row2, card2)
              && cardAtSpot(row1, card1, false)
              && cardAtSpot(row2, card2, false)) {
        // Both coords point to valid spots
        Card c1 = getCardAt(row1, card1);
        Card c2 = getCardAt(row2, card2);
        if (c1.isExposed() && c2.isExposed()) {
          // both cards are exposed, attempt move
          checkIfRightSum(c1, c2);
        } else if (c1.isExposed() || c2.isExposed()) {
          // only one card is exposed, check if valid move
          if (Math.abs(row1 - row2) == 1 && Math.abs(card1 - card2) <= 1) {
            int biggerRow;
            int biggerRowCard;
            int smallerRowCard;
            if (row1 > row2) {
              biggerRow = row1;
              biggerRowCard = card1;
              smallerRowCard = card2;
            } else {
              biggerRow = row2;
              biggerRowCard = card2;
              smallerRowCard = card1;
            }
            if (biggerRowCard == smallerRowCard) {
              if (getCardAt(biggerRow, biggerRowCard + 1) == null) {
                // both cards are exposed, attempt move
                checkIfRightSum(c1, c2);
              } else {
                throw new IllegalArgumentException("You can only remove cards when either " +
                        "both or exposed or one is exposed");
              }
            }
            else if (biggerRowCard == smallerRowCard + 1) {
              if (getCardAt(biggerRow, biggerRowCard - 1) == null) {
                // both cards are exposed, attempt move
                checkIfRightSum(c1, c2);
              } else {
                throw new IllegalArgumentException("You can only remove cards when either " +
                        "both or exposed or one is exposed");
              }
            }
            else {
              throw new IllegalArgumentException("These cards cannot be removed as a pair");
            }
          }
        } else {
          throw new IllegalArgumentException("You can only remove cards when either " +
                  "both or exposed or one is exposed");
        }
      } else {
        // Invalid position
        throw new IllegalArgumentException("One or more of these card positions are invalid!");
      }
    } else {
      // game has not been started
      throw new IllegalStateException("The game has not been started!");
    }
  }

  private void checkIfRightSum(Card c1, Card c2) {
    if (c1.cardValue() + c2.cardValue() == 13) {
      c1.remove();
      c2.remove();
      checkIfExposed();
    } else {
      throw new IllegalArgumentException("Cards must add up to 13");
    }
  }


}