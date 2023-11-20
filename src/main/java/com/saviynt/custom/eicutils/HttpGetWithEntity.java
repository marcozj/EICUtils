/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.saviynt.custom.eicutils;

import java.net.URI;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpPost;

/**
 *
 * @author marcozhang
 */
public class HttpGetWithEntity extends HttpEntityEnclosingRequestBase {

    public final static String GET_METHOD = "GET";
    
    public HttpGetWithEntity() {
        super();
    }
    
    public HttpGetWithEntity(final URI uri) {
        super();
        setURI(uri);
    }
    
    public HttpGetWithEntity(final String uri) {
        super();
        setURI(URI.create(uri));
    }

    @Override
    public String getMethod() {
        return GET_METHOD;
    }
}