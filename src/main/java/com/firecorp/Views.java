package com.firecorp;

interface Operations {
    public void createUser(String name, String email, String phone, String address);
}


class Views implements Operations {

    @Override
    public void createUser(String name, String email, String phone, String address) {
        
    }

    public void bookLpg() {
        
    }
}

