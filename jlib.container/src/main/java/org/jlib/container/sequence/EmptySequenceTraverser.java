package org.jlib.container.sequence;

import java.util.NoSuchElementException;

import org.jlib.container.NoSuchItemException;
import org.jlib.container.sequence.index.IndexSequenceTraverser;

/**
 * {@link IndexSequenceTraverser} of an {@link EmptySequence}.
 * 
 * @param <Item>
 *        type of items held in the {@link Sequence}
 * 
 * @author Igor Akkerman
 */
public class EmptySequenceTraverser<Item>
extends AbstractSequenceTraverser<Item, EmptySequence<Item>> {

    /** sole instance of this class */
    private static final EmptySequenceTraverser<?> INSTANCE = new EmptySequenceTraverser<>();

    /**
     * Returns the sole instance of this class.
     * 
     * @return sole {@link EmptySequenceTraverser}
     */
    @SuppressWarnings("unchecked")
    public static <Item> EmptySequenceTraverser<Item> getInstance() {
        return (EmptySequenceTraverser<Item>) INSTANCE;
    }

    /**
     * Creates a new {@link EmptySequenceTraverser}.
     */
    protected EmptySequenceTraverser() {
        super(EmptySequence.<Item> getInstance());
    }

    @Override
    public boolean hasPrevious() {
        return false;
    }

    @Override
    public boolean hasNextItem() {
        return false;
    }

    @Override
    public Item getPreviousItem()
    throws NoSuchElementException {
        throw new NoSuchElementException();
    }

    @Override
    public Item getNextItem()
    throws NoSuchItemException {
        throw new NoNextSequenceItemException(getSequence());
    }
}
