package com.revature.model;

public enum Model {
    //HONDAS
    //------
    ACCORD ("ACCORD"),
    CIVIC ("CIVIC"),
    S2000 ("S2000"),
    PILOT ("PILOT"),
     //CADILLAC
    ESCALADE("ESCALADE"),
    ELDORADO("ELDORADO"),
    CTS("CTS"),
    CATERA("CATERA"),
     //FORD
    ESCAPE("ESCAPE"),
    EDGE("EDGE"),
    ESCORT("ESCORT"),
    BRONCO("BRONCO"),
    //GMC
    SAFARI("SAFARI"),
    RALLY("RALLY"),
    ENVOY("ENVOY"),
    CONVOY("CONVOY");






    public final String value;

    Model(String value){
        this.value = value;
    }

}
