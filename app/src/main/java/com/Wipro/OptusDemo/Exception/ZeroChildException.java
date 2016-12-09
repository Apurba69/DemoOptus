package com.Wipro.OptusDemo.Exception;

/**
 * Created by AP359544 on 12/8/2016.
 */
public class ZeroChildException extends Exception {

    private static final long serialVersionUID = 1L;

    public ZeroChildException() {

    }

    public ZeroChildException(String errorMessage) {
        super(errorMessage);
    }

}