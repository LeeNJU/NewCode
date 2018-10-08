package Array;

//题目描述:设计一个计数器，有两个函数hit和getHits，hit的参数为时间点，单位为秒，每调用hit函数就表示有一次hit，
//        每调用getHits函数，就返回300秒以内的hit数。注意可能会在同一时间调用hit函数
//解法描述:用两个大小为300的数组保存hit的时间和数量，每调用hit的时候，时间点timestamp对300取余，先检查times
//        数组，如果时间点的值与当前的时间点相同，表示是同一时间点多次调用，相应的hit加1，如果时间点不同，表示
//        时间点已经超过300了，把相应的hit数设为1。最后得到300秒以内的hit数的时候，遍历times数组，把时间在
//        300秒以内的hit进行相加

public class DesignHitCounter {

    private int[] times;
    private int[] hits;

    public DesignHitCounter() {
        times = new int[300];
        hits = new int[300];
    }

    public void hit(int timestamp) {
        int index = timestamp % 300;
        if (times[index] != timestamp) {
            times[index] = timestamp;
            hits[index] = 1;
        } else {
            ++hits[index];
        }
    }

    public int getHits(int timestamp) {
        int result = 0;
        for (int i = 0; i < 300; ++i) {
            if (timestamp - times[i] < 300) {
                result += hits[i];
            }
        }
        return result;
    }
}
