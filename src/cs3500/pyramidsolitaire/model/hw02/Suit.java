package cs3500.pyramidsolitaire.model.hw02;

/**
 * Represents one of the four card suits.
 */
public enum Suit {
    Diamonds("♦"),
    Hearts("♥"),
    Spades("♠"),
    Clubs("♣");

  private String symbol;

  /**
   * Constructs a new Suit, which is either Hearts, Diamonds, Spades, or Clubs.
   * @param symbol the symbol that will be used for this Suit
   */
  Suit(String symbol) {
    this.symbol = symbol;
  }

  /**
   * Produces a String of this Suit's symbol.
   * @return a String that is the symbol of this suit, either heart, spade, club, or diamond
   */
  @Override
  public String toString() {
    return this.symbol;
  }
}