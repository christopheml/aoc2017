package day18;

public interface AsyncVirtualMachine {

    void send(long frequency);

    Register register(String name);

    void receive(Register register);

    void jump(long offset);

}
