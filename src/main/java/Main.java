public class Main {
    public static void main(String[] args) throws InterruptedException {

        System.out.println("Создаю потоки...");

        MyThread myThread = new MyThread();

        ThreadGroup mainGroup = new ThreadGroup("main group");

        final Thread thread1 = new Thread(mainGroup, myThread);
        thread1.setName("Поток 1");
        final Thread thread2 = new Thread(mainGroup, myThread);
        thread2.setName("Поток 2");
        final Thread thread3 = new Thread(mainGroup, myThread);
        thread3.setName("Поток 3");
        final Thread thread4 = new Thread(mainGroup, myThread);
        thread4.setName("Поток 4");

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        // запоминаем текущее время в миллисекундах
        long start = System.currentTimeMillis();
        // останавливаем основной поток программы на 10000 миллисекунд (10 секунд)
        Thread.sleep(10000);

        System.out.println("Завершаю все потоки.");
        mainGroup.interrupt();
        System.out.println("Выполнение программы заняло = " + (System.currentTimeMillis() - start));
    }
}
