package ru.lesson.lessions.Interfaces;

/**
 * Created by art on 12.05.16.
 */
public interface Input {

    /**
     *
     * @return
     */
    String next();

    /**
     *
     * @param question
     * @return
     */
    String ask(String question);

    /**
     * Close input stream
     */
    void close();
}
