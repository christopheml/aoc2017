package day18.vm;

public interface VirtualMachine {
    Register register(String name);

    void jump(long offset);
}
