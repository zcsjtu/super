package Thread;

import java.util.ArrayDeque;
import java.util.Queue;

public class ThreadTest {

    static Queue<Integer> queue = new ArrayDeque<>();

    public static void main(String[] args)
    {

        for(int i = 1; i <= 10; i++)
        {
            queue.add(i);
        }

        new Thread(new Thread1(queue)).start();

        new Thread2(queue).start();
    }
}
