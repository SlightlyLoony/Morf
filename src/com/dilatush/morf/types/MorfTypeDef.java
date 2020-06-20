package com.dilatush.morf.types;

/**
 * Implemented by classes that define Morf data type nodes.
 *
 * @author Tom Dilatush  tom@dilatush.com
 */
public interface MorfTypeDef {

    /**
     * Returns the {@link Class} object for the
     *
     * @return
     */
    Class<Object> get();


    boolean allowNull();
}
