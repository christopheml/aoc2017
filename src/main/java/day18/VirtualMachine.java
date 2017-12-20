package day18;

public interface VirtualMachine {

    void sound(int frequency);

    Register register(String name);

    void recover();

    void jump(int offset);

}
