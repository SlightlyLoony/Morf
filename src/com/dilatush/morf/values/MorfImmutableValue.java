package com.dilatush.morf.values;

import com.dilatush.morf.collections.MorfArray;
import com.dilatush.morf.collections.MorfCollection;
import com.dilatush.morf.collections.MorfMap;
import com.dilatush.morf.typedefs.MorfTypeDef;

/**
 * @author Tom Dilatush  tom@dilatush.com
 */
public class MorfImmutableValue implements MorfValue {

    private final Object      value;
    private final MorfTypeDef type;
    private final MorfValue   parent;


    public MorfImmutableValue( final MorfValue _parent, final MorfTypeDef _type, final Object _value ) {
        parent = _parent;
        value  = _value;
        type   = _type;
    }


    public MorfImmutableValue( final MorfTypeDef _type, final Object _value ) {
        this( null, _type, _value );
    }


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
    @Override
    public Object get() {
        return value;
    }


    /**
     * <p>Sets the Java value of this Morf value (if it is mutable), or throws an {@link UnsupportedOperationException} if it is immutable.</p>
     *
     * @param value the new Java value for this Morf value.
     */
    @Override
    public void set( final Object value ) {
        throw new UnsupportedOperationException( "Cannot set value of MorfImmutableValue" );
    }


    /**
     * Returns the parent of this Morf value, or <code>null</code> if this Morf value is the root value.
     *
     * @return the parent of this Morf value, or <code>null</code> if this Morf value is the root value.
     */
    @Override
    public MorfValue parent() {
        return parent;
    }


    /**
     * Returns the {@link MorfTypeDef} for this Morf value.
     *
     * @return the {@link MorfTypeDef} for this Morf value.
     */
    @Override
    public MorfTypeDef type() {
        return type;
    }


    /**
     * Returns an immutable version of this Morf value.  If this Morf value is already immutable, returns itself.  Otherwise, a new immutable Morf
     * value is constructed and returned, copying the Morf type definitions, structure, and Java values for every value in this Morf value.
     *
     * @return an immutable version of this Morf value.
     */
    @Override
    public MorfValue getImmutable() {
        return null;  // TODO: implement this!
    }
}
