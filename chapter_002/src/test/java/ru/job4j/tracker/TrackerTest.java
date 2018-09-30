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

    //Давайте рассмотрим пример реализации теста для замены заявки.

    @Test
    public void whenReplaceNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1", "testDescription", 123L);
        // Добавляем заявку в трекер. Теперь в объект проинициализирован id.
        tracker.add(previous);
        // Создаем новую заявку.
        Item next = new Item("test2", "testDescription2", 1234L);
        // Проставляем старый id из previous, который был сгенерирован выше.
        next.setId(previous.getId());
        // Обновляем заявку в трекере.
        tracker.replace(previous.getId(), next);
        // Проверяем, что заявка с таким id имеет новые имя test2.
        assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
    }

    //Давайте рассмотрим пример реализации теста для замены заявки.

    @Test
    public void whenDeleteTask() {
        Tracker tracker = new Tracker();
        Item oneTask = new Item("test1", "testDescription", 123L);
        // Добавляем заявку в трекер. Теперь в объект проинициализирован id.
        tracker.add(oneTask);
        // Создаем новую заявку.
        Item twoTask = new Item("test2", "testDescription2", 1234L);
        tracker.add(twoTask);
        Item threeTask = new Item("test3", "testDescription3", 12345L);
        tracker.add(threeTask);
        // Проставляем старый id из previous, который был сгенерирован выше.
        tracker.delete(oneTask.getId());
        // Проверяем, что заявка с таким id имеет новые имя test2.
        assertThat(tracker.idQuantity(), is(2));
    }


}
