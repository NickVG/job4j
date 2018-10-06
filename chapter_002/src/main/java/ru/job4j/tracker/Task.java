package ru.job4j.tracker;

public class Task extends Item {
    public Task(String taskName, String taskDescription) {
        this.name = taskName;
        this.description = taskDescription;
    }
    public String calculatePrice() {
        return "100%";
    }
}
