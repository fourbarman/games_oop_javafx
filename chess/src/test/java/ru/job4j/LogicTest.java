package ru.job4j;

import org.junit.Test;
import ru.job4j.chess.Logic;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.black.BishopBlack;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class LogicTest {
    @Test
    public void whenTheWayIsClear() {
        Logic logic = new Logic();
        Figure bb = new BishopBlack(Cell.C8);
        logic.add(bb);
        boolean rst = logic.move(Cell.C8, Cell.H3);
        rst = false;
        //assertThat(rst, is(true));
        assertThat(bb.position(), is(Cell.H3));
    }
}
