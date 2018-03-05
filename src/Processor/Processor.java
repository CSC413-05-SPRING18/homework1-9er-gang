package Processor;

public abstract class Processor {

    public String args;

    public Processor(String args) {
        this.args = args;
    }

    public abstract String process();
}
