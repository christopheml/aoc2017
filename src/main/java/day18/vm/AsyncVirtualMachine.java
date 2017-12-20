package day18.vm;

public interface AsyncVirtualMachine {

    void send(long frequency);

    Register register(String name);

    void receive(Register register);

    void jump(long offset);

}
