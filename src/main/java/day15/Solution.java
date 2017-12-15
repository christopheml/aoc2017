package day15;

final class Solution {

    public static void main(String... args) {
        firstPartSolution();
        secondPartSolution();
    }

    private static void firstPartSolution() {
        Generator a = SimpleGenerator.a(512);
        Generator b = SimpleGenerator.b(191);
        Judge judge = new Judge(a, b);
        long count = judge.count(40000000);
        System.out.println("Judge's final count is: " + count);
    }

    private static void secondPartSolution() {
        Generator a = PickyGenerator.a(512);
        Generator b = PickyGenerator.b(191);
        Judge judge = new Judge(a, b);
        long count = judge.count(5000000);
        System.out.println("Judge's final count with picky generators is: " + count);
    }

}
