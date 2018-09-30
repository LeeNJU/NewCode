package BinarySearch;

//题目描述:给定一个已排好序的字符数组和一个target字符，找到第一个大于target的字符，例如letters = ["c", "f", "j"] target = "a"，返回'c'
//解法描述:二分

public class FindSmallestLetterGreaterThanTarget {

    public char nextGreatestLetter(char[] letters, char target) {
        int left = 0, right = letters.length - 1, middle;
        while (left <= right) {
            middle = left + (right - left) / 2;
            if (letters[middle] <= target) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }

        return letters[left % letters.length];
    }
}
