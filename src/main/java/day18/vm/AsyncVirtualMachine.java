package day18.vm;

public interface AsyncVirtualMachine extends VirtualMachine {

    void send(long frequency);

    void receive(Register register);

}
