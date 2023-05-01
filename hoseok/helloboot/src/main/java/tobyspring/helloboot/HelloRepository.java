package tobyspring.helloboot;

public interface HelloRepository {

    Hello findHello(String name);

    void increaseCount(String name);

    default int countOf(String name) {
        Hello hello = findHello(name);
        if (hello == null) {
            return 0;
        }
        return hello.getCount();
    }

}
