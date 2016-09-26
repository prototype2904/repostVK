package ru.vkrepostcontest.service.groups;

/**
 * @author Roman
 * @since 0.1.
 */
public class GroupSearch {
    /**
     * тип сообщества
     */
    public enum Type {
        GROUP("group"), // группы
        PAGE("page"), // паблик
        EVENT("event"); // событие

        private String val;

        Type(String val) {
            this.val = val;
        }

        public String val() {
            return val;
        }
    }

    /**
     * Сортировка результатов поиска
     */
    public enum Sort {
        DEFAULT(0), SPEED(1), PEOPLE(2), LIKES(3), COMMENTS(4), DISCUSSIONS(5);

        private int val;

        Sort(int val) {
            this.val = val;
        }

        public int val() {
            return val;
        }
    }
}
