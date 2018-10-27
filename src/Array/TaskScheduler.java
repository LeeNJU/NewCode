package Array;

//题目描述:给定一个字符数组，表示要执行的任务，相同任务之间至少间隔n个空间，求最少需要多少个空间完成所有任务，例如tasks = ["A","A","A","B","B","B"], n = 2
//        A -> B -> idle -> A -> B -> idle -> A -> B
//解法描述:找到出现次数最大的字符，ACCCEEE 2， CE都出现了最多次数，看成一个整体，CE-CE-，中间就是空格的个数，空格的个数可能比剩下的任务多，所以用空格填充

public class TaskScheduler {

    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        int maxCount = 0;
        int maxFrequency = 0;

        for (char c : tasks) {
            ++count[c - 'A'];
            if (count[c - 'A'] > maxFrequency) {
                maxFrequency = count[c - 'A'];
                maxCount = 1;
            } else if (count[c - 'A'] == maxFrequency) {
                ++maxCount;
            }
        }

        int partNum = maxFrequency - 1;
        int partLength = n - (maxCount - 1);
        int emptySlots = partNum * partLength;
        int taskLeft = tasks.length - maxCount * maxFrequency;
        return tasks.length + Math.max(0, emptySlots - taskLeft);
    }
}
