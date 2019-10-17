import org.junit.Test;

import cs3500.pyramidsolitaire.model.hw02.BasicPyramidSolitaire;
import cs3500.pyramidsolitaire.model.hw04.PyramidSolitaireCreator;
import cs3500.pyramidsolitaire.model.hw04.RelaxedPyramidSolitaire;
import cs3500.pyramidsolitaire.model.hw04.TriPeaksPyramidSolitaire;

import static org.junit.Assert.assertEquals;

/**
 * Represents tests for a PyramidSolitaireCreator.
 */
public class PyramidSolitaireCreatorTest {


  // No way to test for the exception thrown because it only accepts one of three enum input
  // values. Anything else will throw a compilation error, and so can't be run


  @Test
  public void testCreateBasicInput() {
    assertEquals(true,
            PyramidSolitaireCreator.create(PyramidSolitaireCreator.GameType.BASIC)
                    instanceof BasicPyramidSolitaire);
  }

  @Test
  public void testCreateRelaxedInput() {
    assertEquals(true,
            PyramidSolitaireCreator.create(PyramidSolitaireCreator.GameType.RELAXED)
                    instanceof RelaxedPyramidSolitaire);
  }

  @Test
  public void testCreateTripeaksInput() {
    assertEquals(true,
            PyramidSolitaireCreator.create(PyramidSolitaireCreator.GameType.TRIPEAKS)
                    instanceof TriPeaksPyramidSolitaire);
  }

}