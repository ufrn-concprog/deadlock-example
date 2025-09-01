/**
 * Main program
 * @author <a href="mailto:everton.cavalcante@ufrn.br">Everton Cavalcante</a>
 */
public class DeadlockExample {
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
    }
}