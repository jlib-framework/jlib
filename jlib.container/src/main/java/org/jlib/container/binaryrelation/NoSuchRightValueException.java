package org.jlib.container.binaryrelation;

/**
 * Exception thrown when a {@link BinaryRelation} does not contain an
 * {@link Association} with the requested right value.
 * 
 * @author Igor Akkerman
 */
public class NoSuchRightValueException
extends NoSuchAssociationException {

    /** serialVersionUID */
    private static final long serialVersionUID = -723559454379105926L;

    /**
     * Creates a new {@link NoSuchRightValueException}.
     * 
     * @param binaryRelation
     *        referenced {@link BinaryRelation}
     * 
     * @param leftValue
     *        LeftValue of the {@link Association}
     * 
     * @param rightValue
     *        RightValue of the {@link Association}
     */
    public NoSuchRightValueException(final BinaryRelation<?, ?> binaryRelation, final Object leftValue,
                                     final Object rightValue) {
        super(binaryRelation, leftValue, rightValue);
    }
}
