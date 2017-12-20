package day18;

public interface VirtualMachine {

    void sound(long frequency);

    Register register(String name);

    void recover();

    void jump(long offset);

}
