import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * Demonstration of the use of the {@link java.lang.management.ThreadMXBean} interface to
 * programmatically detect a deadlock in a Java program
 *
 * @author <a href="mailto:everton.cavalcante@ufrn.br">Everton Cavalcante</a>
 */
public class DeadlockDetection {
    /**
     * Main method
     *
     * @param args Command-line arguments
     */
    public static void main(String[] args) {
        final Resource resourceA = new Resource("Resource A");
        final Resource resourceB = new Resource("Resource B");

        // Thread T1 is created with Resource A assigned and wants to hold Resource B
        // Thread T2 is created with Resource B assigned and wants to hold Resource A
        // This represents a deadlock
        Thread t1 = new Thread(() -> resourceA.use(resourceB), "Thread T1");
        Thread t2 = new Thread(() -> resourceB.use(resourceA), "Thread T2");

        t1.start();
        t2.start();

        // Check for deadlocks
        Thread deadlockChecker = new Thread(() -> {
            ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
            while (true) {
                // The findDeadlockedThreads method returns the IDs of threads involved in a deadlock
                long[] deadlockedThreadIds = threadMXBean.findDeadlockedThreads();

                if (deadlockedThreadIds != null) {
                    System.out.println("\nFound " + deadlockedThreadIds.length + " deadlocked threads");
                    ThreadInfo[] infos = threadMXBean.getThreadInfo(deadlockedThreadIds);
                    for (ThreadInfo info : infos) {
                        System.out.print(info.toString());
                    }
                    break; // Stop after detection
                }

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        deadlockChecker.setDaemon(true);
        deadlockChecker.start();
    }
}
