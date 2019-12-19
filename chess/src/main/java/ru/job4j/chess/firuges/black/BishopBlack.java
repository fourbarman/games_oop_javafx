package ru.job4j.chess.firuges.black;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

/**
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
//        throw new IllegalStateException(
//                String.format("Could not way by diagonal from %s to %s", source, dest)
//        );
        if (!isDiagonal(source, dest)) {
            throw new IllegalStateException(
                    String.format("Could not way by diagonal from %s to %s", source, dest)
            );
        }
        int size = Math.abs(dest.x - source.x); // 3
        Cell[] steps = new Cell[size];
        int deltaX = (dest.x - source.x) / size; // -1
        int deltaY = (dest.y - source.y) / size; // -1
        for (int index = 0; index < size; index++) {
            int x = source.x + deltaX * index + 1; //
            int y = source.y + deltaY * index + 1; //
            for (Cell cell : Cell.values()) {
                if (cell.x == x && cell.y == y) {
                    steps[index] = cell;
                }
            }
        }
        return steps;
    }

    public boolean isDiagonal(Cell source, Cell dest) {
        return (Math.abs(source.x - dest.x) == Math.abs(source.y - dest.y));
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
