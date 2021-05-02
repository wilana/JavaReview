package Threads;

public class ThreadsExample {
    // only using thread to maybe create, maybe print to console
    public static void main(String[] args) {

        /*
            THREADS:
                - represents a single path of code execution within a program (which can have 1+)
                    |-> java program with more than one is a multithreaded application (for concurrent processing)
                - Two options: implements Runnable (usually) or Thread
                - When it runs, the program executes all code in a thread in order of methods called
                - single thread ruins on the main thread, but each gets its own area in the JVM
                - each runs mostly independently, other than shared objects
         */

        Thread t1 = new GoodMorningThread();    // extends thread -> downside is inability to extend another class
        EarlyMorningRunnable r1 = new EarlyMorningRunnable();   // implements runnable -> 


        t1.start();
        r1.run();

        for (int i = 1; i<=10; i++)
        {
            System.out.printf("Doing process 1, task #: %2d on thread: %s%n", i,
                    Thread.currentThread());
            try {
                Thread.sleep(800);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


        /*
        Possible issues: Challenges with Threads
            •Race conditions – when threads depend on relative timing by the scheduler
            •Data race – when 2 (or more) threads try to read from the same point in memory
            •Threads can create complexity in the code as the order of code execution
                |-> might not be as obvious when looking at the code
            •Synchronization utilities exist to help reduce the risks,
                |-> but using too much defeats the benefits of the threads and impact scalability
         */
    }
}
