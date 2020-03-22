package Thread;

import java.util.Queue;

public class Thread2 extends Thread {

    Queue<Integer> queue;

    public Thread2(Queue<Integer> queue)
    {
        this.queue = queue;
    }

    @Override
    public void run()
    {
        while(true)
        {
            synchronized (queue)
            {
                if(queue.size() == 0)
                {
                    break;
                }

                if(queue.peek() % 2 == 0)
                {
                    System.out.println("Thread 2 polls a Number : " + queue.poll());

                }
            }
        }
    }
}