package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Tracker Test.
 *
 * @author Nikolay Gorbunov (mailto:krot19831983@mail.ru)
 * @version $Id$
 * @since 0.1
 */

public class TrackerTest {

    /**
     *Тест для проверки работоспсобности метода по созданию заявок.
     */

    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDescription", 123L);
        tracker.add(item);
        assertThat(tracker.findAll()[0], is(item));
    }
    /**Тест для проверки работоспсобности замены заявки.
     *
     */
    @Test
    public void whenReplaceNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1", "testDescription", 123L);
        tracker.add(previous);
        Item next = new Item("test2", "testDescription2", 1234L);
        tracker.replace(previous.getId(), next);
        assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
    }

    /**Тест для проверки работоспсобности удаления заявки.
     *
     */

    @Test
    public void whenDeleteTask() {
        Tracker tracker = new Tracker();
        Item oneTask = new Item("test1", "testDescription", 123L);
        tracker.add(oneTask);
        Item twoTask = new Item("test2", "testDescription2", 1234L);
        tracker.add(twoTask);
        Item threeTask = new Item("test3", "testDescription3", 12345L);
        tracker.add(threeTask);
        tracker.delete(oneTask.getId());
        Item[] result = {twoTask, threeTask};
        assertThat(tracker.idQuantity(), is(2));
        assertThat(tracker.findAll(), is(result));
    }

    /**Тест для проверки Посика заявок по имени.
     *
     */

    @Test
    public void whenFindByNameTask() {
        Tracker tracker = new Tracker();
        Item oneTask = new Item("test1", "testDescription", 123L);
        tracker.add(oneTask);
        Item twoTask = new Item("test2", "testDescription2", 1234L);
        tracker.add(twoTask);
        Item threeTask = new Item("test3", "testDescription3", 12345L);
        tracker.add(threeTask);
        Item fourTask = new Item("test3", "testDescription3312", 123451L);
        tracker.add(fourTask);
        Item[] result = {threeTask, fourTask};
        assertThat(tracker.findByName("test3"), is(result));
}
    /**Тест для проверки работоспсобности поиска заявок по имени.
     *
     */

    @Test
    public void whenFindAllTaskAndTasksHaveTheSameName() {
        Tracker tracker = new Tracker();
        Item oneTask = new Item("test1", "testDescription", 123L);
        tracker.add(oneTask);
        Item twoTask = new Item("test2", "testDescription2", 1234L);
        tracker.add(twoTask);
        Item threeTask = new Item("test3", "testDescription3", 12345L);
        tracker.add(threeTask);
        Item fourTask = new Item("test3", "testDescription3312", 123451L);
        tracker.add(fourTask);
        Item[] result = {oneTask, twoTask, threeTask, fourTask};
        assertThat(tracker.findAll(), is(result));
    }
}