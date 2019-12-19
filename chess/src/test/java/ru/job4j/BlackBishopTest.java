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
    @Test
    public void wayTestNotDiagonal() {
        Figure blackBishop = new BishopBlack(Cell.A1);
        blackBishop.way(Cell.A1, Cell.A2);
        Cell actual[] = blackBishop.way(Cell.A1, Cell.A2);
        Cell expected[] = {Cell.A2};
        assertThat(actual, is(expected));
    }

    @Test
    public void wayTest1() {
        Figure blackBishop = new BishopBlack(Cell.D4);
        blackBishop.way(Cell.D4, Cell.A1);
        Cell actual[] = blackBishop.way(Cell.D4, Cell.A1);
        Cell expected[] = {Cell.C3, Cell.B2, Cell.A1};
        assertThat(actual, is(expected));
    }
}
