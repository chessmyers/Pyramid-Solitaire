package cs3500.pyramidsolitaire.model.hw02;

/**
 * Represents a rank for a playing card, between Ace and King.
 */
public enum Rank {
    Ace(1, "A"),
    Two(2, "2"),
    Three(3, "3"),
    Four(4, "4"),
    Five(5, "5"),
    Six(6, "6"),
    Seven(7, "7"),
    Eight(8, "8"),
    Nine(9, "9"),
    Ten(10, "10"),
    Jack(11, "J"),
    Queen(12, "Q"),
    King(13, "K");

  private int value;
  private String symbol;

  /**
   * Constructs a new rank for a playing card.
   * @param value the numerical value of the card (between 1 and 13)
   * @param symbol The character representation of this card, either a
   */
  Rank(int value, String symbol) {
    this.value = value;
    this.symbol = symbol;
  }

  /**
   * Produces a string representing this Rank.
   * @return the string representation of this Rank, either "A", a number 2-10, "J", "Q", or "K"
   */
  @Override
  public String toString() {
    return this.symbol;
  }

  /**
   * Returns the numerical value of this Rank.
   * @return a number between 1 and 13, the numerical value of this Rank as determined by its rank
   */
  public int cardValue() {
    return this.value;
  }
}