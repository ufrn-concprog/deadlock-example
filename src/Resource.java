/**
 * Class representing a resource to be held by a thread
 *
 * @author <a href="mailto:everton.cavalcante@ufrn.br">Everton Cavalcante</a>
 */
public class Resource {
    /**  A name for the resource   */
    private final String name;

    /**
     * Parameterized constructor
     *
     * @param name Name to assign to the resource
     */
    public Resource(String name) {
        this.name = name;
    }

    /**
     * Representation of the use of the resource by a thread. This method executes in mutual exclusion due to
     * the use of the <em>synchronized</em> keyword.
     * When a method or a block of code is declared as synchronized, like this one, Java acquires a lock on a
     * specific object (in this case, <em>resource</em>), and only the thread that holds this lock can execute the
     * synchronized code. Other threads attempting to enter will be blocked until the lock is released by the
     * currently executing thread.
     *
     * @param resource Reference to the resource
     */
    synchronized void use(final Resource resource) {
        System.out.println(Thread.currentThread().getName() + " is attempting to lock " + this.name);
        synchronized (this) {
            System.out.println(Thread.currentThread().getName() + " locked " + this.name);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + " is attempting to lock " + resource);
            synchronized (resource) {
                System.out.println(Thread.currentThread().getName() + " locked " + resource);
            }
        }
    }

    @Override
    public String toString() {
        return this.name;
    }
}
