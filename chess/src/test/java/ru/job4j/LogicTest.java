package ru.job4j;

import org.junit.Test;
import ru.job4j.chess.Logic;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.black.BishopBlack;
import ru.job4j.chess.firuges.black.PawnBlack;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class LogicTest {
    /*
    Test when the way is clear.
     */
    @Test
    public void whenTheWayIsClear() {
        Logic logic = new Logic();
        Figure bb = new BishopBlack(Cell.C1);
        Figure bp = new PawnBlack(Cell.A1);
        logic.add(bb);
        logic.add(bp);
        boolean rst = logic.move(Cell.C1, Cell.G5);
        assertThat(rst, is(true));
    }
    /*
    Test when the way is not clear.
     */
    @Test
    public void whenTheWayIsNotClear() {
        Logic logic = new Logic();
        Figure bb = new BishopBlack(Cell.C1);
        Figure bp = new PawnBlack(Cell.E3);
        logic.add(bb);
        logic.add(bp);
        boolean rst = logic.move(Cell.C1, Cell.G5);
        assertThat(rst, is(false));
    }
    @Test
    public void whenTheWayEndIsNotClear() {
        Logic logic = new Logic();
        Figure bb = new BishopBlack(Cell.C1);
        Figure bp = new PawnBlack(Cell.G5);
        logic.add(bb);
        logic.add(bp);
        boolean rst = logic.move(Cell.C1, Cell.G5);
        assertThat(rst, is(false));
    }
}
