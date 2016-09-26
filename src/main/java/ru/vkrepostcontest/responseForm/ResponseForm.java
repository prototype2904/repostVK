package ru.vkrepostcontest.responseForm;

/**
 * Главный класс ответа на запрос
 *
 * @author Roman
 * @since 0.1
 */
public abstract class ResponseForm {

    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
