package com.dilatush.morf.values;

import com.dilatush.morf.collections.MorfArray;
import com.dilatush.morf.collections.MorfCollection;
import com.dilatush.morf.collections.MorfMap;
import com.dilatush.morf.typedefs.MorfTypeDef;

/**
 * Implemented by classes that provide Morf values.
 *
 * @author Tom Dilatush  tom@dilatush.com
 */
public interface MorfValue {

    /**
     * <p>Returns the Java value of this Morf value.  This value may be of any Java type, but it is guaranteed to be either <code>null</code> (if the
     * <code>MorfTypeDef</code> in this Morf value allows nulls) or a type assignable to the Java type in the MorfTypeDef in this Morf value.</p>
     *
     * <p><code>MorfValue</code> instances represent either a single value (such as an integer, String, enumeration, etc.) or a collection of other
     * Morf values.  When the value represented is a collection, it is an instance of a class that implements {@link MorfCollection}, along with one
     * or both of {@link MorfMap} or {@link MorfArray}.  Morf collections can contain either single values or other Morf collections, so arbitrarily
     * deep structures can be represented.</p>
     *
     * @return the Java value of this Morf value.
     */
    Object get();


    /**
     * <p>Sets the Java value of this Morf value (if it is mutable), or throws an {@link UnsupportedOperationException} if it is immutable.</p>
     *
     * @param value the new Java value for this Morf value.
     */
    void set( Object value );


    /**
     * Returns the parent of this Morf value, or <code>null</code> if this Morf value is the root value.
     *
     * @return the parent of this Morf value, or <code>null</code> if this Morf value is the root value.
     */
    MorfValue parent();


    /**
     * Returns the {@link MorfTypeDef} for this Morf value.
     *
     * @return the {@link MorfTypeDef} for this Morf value.
     */
    MorfTypeDef typeDef();


    /**
     * Returns <code>true</code> if this Morf value is locked (immutable), otherwise returns <code>false</code>.
     *
     * @return returns <code>true</code> if this Morf value is locked (immutable).
     */
    boolean isLocked();


    /**
     * Lock this Morf value, preventing any changes.  In other words, makes this Morf value immutable.  Any contained Morf values will also be locked,
     * recursively.  Note that locking a Morf value <i>only</i> prevents the {@link #set(Object)} method from working -- it does <i>not</i> prevent
     * a value retrieved by {@link #get()} from being changed, if that value is itself mutable.
     */
    void lock();
}
