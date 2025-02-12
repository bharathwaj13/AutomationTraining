package org.onboard.oops1;

public class StandardBase extends Base{

    public StandardBase(){
        super("Standard",100.05f);
    }

    @Override
    public String getDescription() {
        return "Base is of Standard Type";
    }
}
