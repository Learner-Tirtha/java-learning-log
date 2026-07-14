package CoreJava.Multithreading.VisibilityProblem;

class MyLock {

    private  boolean locked = true;

    public boolean isLocked() {
        return locked;
    }

    public void unlock() {
        System.out.println(Thread.currentThread().getName() + " released lock");
        locked = false;
    }
}