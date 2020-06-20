package com.dilatush.morf.values;

import com.dilatush.morf.types.MorfTypeDef;

/**
 * @author Tom Dilatush  tom@dilatush.com
 */
public class SimpleMorfValue {


    private Object      value;
    private boolean     locked;
    private MorfTypeDef typeDef;
    private MorfValue   parent;
}
