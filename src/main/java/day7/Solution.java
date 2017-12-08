package day7;

final class Solution {

    private Solution() {
    }

    public static void main(String... args) throws Exception {
        ListingParser parser = new ListingParser();
        Program root = parser.parse("/day7/layout.txt");
        System.out.println("The root node (bottom program) is: " + root.getName());
    }

}
