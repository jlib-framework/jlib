package org.jlib.container.matrix;

import org.jlib.core.language.InvalidArgumentException;
import org.jlib.core.language.ParametrizedMessage;

/**
 * {@link InvalidArgumentException} referencing a {@link Matrix}.
 *
 * @author Igor Akkerman
 */
public class InvalidMatrixArgumentException
extends InvalidArgumentException {

    private final Matrix matrix;

    /**
     * Creates a new {@link InvalidMatrixArgumentException}.
     *
     * @param matrix
     *        referenced {@link Matrix}
     *
     * @param messageTemplate
     *        {@link String} specifying the message template; {@code {0}} denotes the {@code matrix}
     *
     * @param messageArguments
     *        comma separated sequence of {@link Object} message arguments
     */
    public InvalidMatrixArgumentException(final Matrix matrix, final ParametrizedMessage message) {
        super(message.with(matrix));

        this.matrix = matrix;
    }

    /**
     * Returns the referenced {@link Matrix}.
     *
     * @return referenced {@link Matrix}
     */
    public Matrix getMatrix() {
        return matrix;
    }
}
