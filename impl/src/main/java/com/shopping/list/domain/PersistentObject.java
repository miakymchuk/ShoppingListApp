package com.shopping.list.domain;

/**
 * http://www.onjava.com/pub/a/onjava/2006/09/13/dont-let-hibernate-steal-your-identity.html?page=3
 * */
public interface PersistentObject {
    public String getId();
    public void setId(String id);

    public Integer getVersion();
    public void setVersion(Integer version);
}
