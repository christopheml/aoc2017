package day15;

final class Solution {

    public static void main(String... args) {
        Generator a = SimpleGenerator.a(512);
        Generator b = SimpleGenerator.b(191);
        Judge judge = new Judge(a, b);
        long count = judge.count(40000000);
        System.out.println("Judge's final count is: " + count);
    }

}
