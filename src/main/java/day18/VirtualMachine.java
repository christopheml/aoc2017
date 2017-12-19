package day18;

interface VirtualMachine {

    void sound(int frequency);

    Register register(String name);

    void recover();

    void jump(int offset);

}
