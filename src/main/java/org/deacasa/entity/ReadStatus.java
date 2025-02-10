package org.deacasa.entity;

public enum ReadStatus {
    UNREAD("Nu e citit"),
    READ("Citit");
    private  String description;
    ReadStatus(String description){
        this.description=description;
    }
    public  String getDescription(){
        return description;
    }
}
