import java.util.PriorityQueue;
import java.util.Queue;

public class MedianFinder {
    Queue<Integer> A, B;
    public MedianFinder() {
        A = new PriorityQueue<>(); // 小顶堆，保存较大的一半
        B = new PriorityQueue<>((x, y) -> (y - x)); // 大顶堆，保存较小的一半
    }
    public void addNum(int num) {
        if(A.size() != B.size()) {
            A.add(num);
            B.add(A.poll());
        } else {//数量相等给A加，保证A多一个（奇数情况），中位数从A出
            B.add(num);
            A.add(B.poll());//保证往A中加入的是较大的数
        }
    }
    public double findMedian() {
        /*
        当 m=n（ N 为 偶数）：则中位数为 ( A 的堆顶元素 + B 的堆顶元素 )/2。
        当 m≠n（ N 为 奇数）：则中位数为 A 的堆顶元素
        */

        return A.size() != B.size() ? A.peek() : (A.peek() + B.peek()) / 2.0;
    }

}

