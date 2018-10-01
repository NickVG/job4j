package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TrackerTest {

    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDescription", 123L);
        tracker.add(item);
        assertThat(tracker.findAll()[0], is(item));
    }


    @Test
    public void whenReplaceNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1", "testDescription", 123L);
        tracker.add(previous);
        Item next = new Item("test2", "testDescription2", 1234L);
        next.setId(previous.getId());
        tracker.replace(previous.getId(), next);
        assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
    }

    //пример реализации теста для удаления заявки.

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

    @Test
    public void whenfindAllTaskAndTasksHaveTheSameName() {
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