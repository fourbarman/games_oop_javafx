package ru.job4j;

import org.hamcrest.*;
import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.black.BishopBlack;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class BlackBishopTest {
    @Test
    public void positionTest() {
        Figure blackBishop = new BishopBlack(Cell.F8);
        assertThat(Cell.F8, is(blackBishop.position()));
    }

    @Test
    public void copyTest() {
        Figure blackBishop = new BishopBlack(Cell.F8);
        assertThat(Cell.H6, is(blackBishop.copy(Cell.H6).position()));
    }

    @Test
    public void wayTest() {
        Figure blackBishop = new BishopBlack(Cell.C1);
        blackBishop.way(Cell.C1, Cell.G5);
        Cell actual[] = blackBishop.way(Cell.C1, Cell.G5);
        Cell expected[] = {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        assertThat(actual, is(expected));
    }

    @Test(expected = IllegalStateException.class)
    public void wayTestNotDiagonal() {
        Figure blackBishop = new BishopBlack(Cell.A1);
        blackBishop.way(Cell.A1, Cell.A2);
    }
}
