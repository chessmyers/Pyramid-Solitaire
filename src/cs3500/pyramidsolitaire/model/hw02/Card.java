package cs3500.pyramidsolitaire.model.hw02;

import java.util.Objects;

/**
 * Represents a card for use in playing Pyramid Solitaire.
 *
 */
public class Card {
  private Rank value;
  private Suit suit;
  private boolean exposed;
  private boolean removed;


  /**
   * Constructs a {@code Card} object.
   * @param value the rank of the card (Ace through King)
   * @param suit the suit of the card (Hearts, Diamonds, Spades, or Diamonds)
   */
  public Card(Rank value, Suit suit) {
    this.value = value;
    this.suit = suit;
    this.exposed = false;
    this.removed = false;
  }

  /**
   * Produces the String representation of this card.
   * @return this card's value and suit represented as a String
   */
  @Override
  public String toString() {
    if (this.removed) {
      return "  ";
    } else {
      return this.value.toString() + this.suit.toString();
    }
  }

  /**
   * Returns whether this Card is equal to the given Object.
   * @param other the object to be compared against
   * @return whether this object is equal to the given object
   */
  @Override
  public boolean equals(Object other) {
    // Quick check
    if (this == other) {
      return true;
    }
    // If other is not the right class
    if (! (other instanceof Card)) {
      return false;
    }

    // Other is a card, but is it the right card
    Card that = (Card) other;
    return this.value == that.value
            && this.suit == that.suit;
  }

  /**
   * Generates a hash code corresponding to this object.
   * @return the generated hash code, based on this Card's value and suit
   */
  @Override
  public int hashCode() {
    return Objects.hash(value, suit);
  }

  /**
   * Exposes this card so moves can be made with it.
   */
  public void expose() {
    this.exposed = true;
  }

  /**
   * Lets us know if this card is exposed (on the bottom row) or not.
   * @return true or false, whether it is on the bottom row or not
   */
  public boolean isExposed() {
    return this.exposed;
  }

  /**
   * Sets this card to be removed from the board, leading to it not being shown by other methods.
   */
  public void remove() {
    this.removed = true;
  }

  /**
   * Returns whether this card is still in play.
   * @return true if it is still in play or false if it has been removed
   */
  public boolean isThere() {
    return !this.removed;
  }

  /**
   * the value of this card, as designated by its suit.
   * @return the integer value of the card (1-13)
   */
  public int cardValue() {
    return this.value.cardValue();
  }

  @Override
  public Card clone() {
    Card c = new Card(this.value, this.suit);
    if (this.exposed) {
      c.expose();
    }
    if (!this.isThere()) {
      c.remove();
    }
    return c;
  }
}