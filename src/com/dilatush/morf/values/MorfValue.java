package com.dilatush.morf.values;

import com.dilatush.morf.types.MorfTypeDef;

/**
 * <p>Implemented by classes that represent Morf values.</p>
 *
 * <p><code>MorfValue</code> instances represent either a simple value (such as an integer, String, enumeration, etc.) or a collection (maps, arrays,
 * or both) of Morf values.  Morf collections can contain either simple values or other Morf collections (or both), so arbitrarily deep structures
 * can be represented.</p>
 *
 * <p>This interface has a somewhat unusual design feature: a number of methods that are optionally implemented by various instances.  This was an
 * intentional choice to make chaining of getters and setters simpler. For instance, one can write a piece of code like this:<pre><code>
 *     MorfValue config = getConfig();
 *     int tries = (int) config.get( "general" ).get( "tries" ).get();
 * </code></pre>
 * That code will retrieve an integer value that is three levels deep in a configuration file, inside a map that is itself in another map.  Many
 * (perhaps most) libraries representing non-Java structures (for instance, JSON libraries) would require either separate lines of code to
 * dereference the maps, or awkward and hard-to-read casting.  One consequence of this choice is that mistakes in that sort of chained code will
 * likely lead to an {@link UnsupportedOperationException} being thrown at runtime.  The author is inclined to believe that's a good tradeoff.
 * Reasonable people may disagree, and they should feel free to write their own library.
 *
 * <p>Morf values may be "locked", which essentially makes the value immutable.  If a container is locked, then its contents are also locked.  Note
 * that locking a Morf value <i>only</i> prevents the set methods from working -- it does <i>not</i> prevent a value retrieved by get method from
 * being changed, if that value is itself mutable.</p>
 *
 * @author Tom Dilatush  tom@dilatush.com
 */
public interface MorfValue {


    /**
     * <p>Returns the Java value of a simple Morf value (i.e., not a collection of Morf values).  The returned value may be of any Java
     * type, but it is guaranteed to be either <code>null</code> (if the {@link MorfTypeDef} in this Morf value allows nulls) or a type
     * assignable to the Java type in the {@link MorfTypeDef} in this Morf value.</p>
     *
     * <p>If this method is called on a Morf value that is <i>not</i> simple (i.e., a Morf value collection), throws an
     * {@link UnsupportedOperationException}.</p>
     *
     * @return the Java value of this Morf value.
     */
    Object get() throws UnsupportedOperationException;


    /**
     * <p>Sets the Java value of a simple Morf value (that is, not a collection of Morf values) to the given value, if it is not locked.  The given
     * value may be <code>null</code> (if the {@link MorfTypeDef} in this Morf value allows nulls), or a type assignable to the Java type in the
     * {@link MorfTypeDef} in this Morf value.</p>
     *
     * <p>For any of the following circumstances, calling this method will throw an {@link UnsupportedOperationException}:<ul>
     *     <li>this is not a simple Morf value (i.e., this is a collection of Morf values)</li>
     *     <li>this value is locked</li>
     *     <li>the given value is a <code>null</code>, and this Morf value's {@link MorfTypeDef} does not allow nulls</li>
     *     <li>the given value is a type that is not assignable to the type specified by this Morf value's {@link MorfTypeDef}</li>
     * </ul>
     *
     * @param _value the new Java value for this Morf value.
     */
    void set( Object _value );


    /**
     * <p>Returns the Morf value associated with the given key in a mapped collection of Morf values (either a simple map or an ordered map).  The
     * returned value may be of any Morf value type, simple or collection, but it is guaranteed to not be <code>null</code>.</p>
     *
     * <p>If this method is called on a Morf value that is <i>not</i> a mapped collection of Morf values, or if the given key does not exist in the
     * mapped collection, throws an {@link UnsupportedOperationException}.</p>
     *
     * @param _key the key for the Morf value to be retrieved.
     * @return the retrieved Morf value.
     */
    MorfValue get( String _key ) throws UnsupportedOperationException;


    // TODO: finish this description...
    /**
     * <p>Sets the Morf value associated with the given key to the given Morf value, if it is not locked.  The given value may not be
     * <code>null</code>, and must be of a type assignable to the Java type in the {@link MorfTypeDef} in this Morf value.  In addition, if the
     * given Morf value is a {@link SimpleMorfValue}, then the Java type </p>
     *
     * <p>For any of the following circumstances, calling this method will throw an {@link UnsupportedOperationException}:<ul>
     *     <li>this is not a mapped collection of Morf values)</li>
     *     <li>this value is locked</li>
     *     <li>the given value is a <code>null</code></li>
     *     <li>the given value is a type that is not assignable to the type specified by this Morf value's {@link MorfTypeDef}</li>
     * </ul>
     *
     * @param _key the key for the new Morf value to be associated with.
     * @param _value the new Morf value to be associated with the given key.
     */
    void set( String _key, MorfValue _value );


    /**
     * <p>Returns the Morf value associated with the given index in an ordered collection of Morf values (either an array or an ordered map).  The
     * returned value may be of any Morf value type, simple or collection, but it is guaranteed to not be <code>null</code>.</p>
     *
     * <p>If this method is called on a Morf value that is <i>not</i> an array collection of Morf values, or if the given index does not exist in
     * the array collection (i.e., the index is negative or greater than the largest indexed value), throws an {@link UnsupportedOperationException}.
     * </p>
     *
     * @return the retrieved Morf value.
     */
    MorfValue get( int _index ) throws UnsupportedOperationException;


    /**
     * <p>Sets the array entry at the given index to the given Morf value, if it is not locked.  The given value may not be <code>null</code>Java value of a simple Morf value (that is, not a collection of Morf values), if it is not locked.  The given value may be
     * <code>null</code> (if the {@link MorfTypeDef} in this Morf value allows nulls), or a type assignable to the Java type in the
     * {@link MorfTypeDef} in this Morf value.</p>
     *
     * <p>For any of the following circumstances, calling this method will throw an {@link UnsupportedOperationException}:<ul>
     *     <li>this is not a simple Morf value (i.e., this is a collection of Morf values)</li>
     *     <li>this value is locked</li>
     *     <li>the given value is a <code>null</code>, and this Morf value's {@link MorfTypeDef} does not allow nulls</li>
     *     <li>the given value is a type that is not assignable to the type specified by this Morf value's {@link MorfTypeDef}</li>
     * </ul>
     *
     * @param _value the new Java value for this Morf value.
     */
    void set( int _index, MorfValue _value );


    /**
     * Returns the parent Morf value of this Morf value, or <code>null</code> if this Morf value is the root Morf value.
     *
     * @return the parent Morf value of this Morf value, or <code>null</code> if this Morf value is the root Morf value.
     */
    MorfValue parent();


    /**
     * Returns the root Morf value.
     *
     * @return the root Morf value.
     */
    MorfValue root();


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
