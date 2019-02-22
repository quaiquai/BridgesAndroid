package com.example.bridgesgametest;

public enum NamedSymbol {
    man("man"), w("w"), i("i"), n("n"), e("e"), r("r"),
    s("s"), c("c"), o("o"), W("W"), S("S"), bug3("bug3");

    private String bitName;

    NamedSymbol(String str){
        this.bitName = str;
    }

    public String getBitName(){
        return bitName;
    }
}
