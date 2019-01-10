/** Class ConsoleInput
 * Реализаци якласса Log
 * @author nikolay gorbunov
 * @version $Id$
 * @since 0.1

public class Log {
    StringBuilder log = new StringBuilder();;

    public void stringLog(String string) {
        System.out.println(string);
        this.log.append(string).append(System.lineSeparator());
    }

    public StringBuilder getLog() {
        return this.log;
    }

    public void addLog(String string) {
        this.log.append(string);
    }
}
*/

package ru.job4j.tracker;

/** Class ConsoleInput
 * Реализация класса Log
 * @author nikolay gorbunov
 * @version $Id$
 * @since 0.1
*/
public class Log {
    String log = "";

    /**
     * Метод реализации записи вывода строки в консоль и записи её в лог
     * @param string строка которая идёт в лог и в консоль
     */
    public void stringLog(String string) {
        System.out.println(string);
        this.log += string;
        this.log += System.lineSeparator();
    }

    /**
     * Метод получения лога
     */
    public String getLog() {
        return this.log;
    }

    /**
     * Метод реализации записи строки в лог
     * @param string строка которая идёт в лог и в консоль
     */
    public void addLog(String string) {
        this.log += string;
    }
}
