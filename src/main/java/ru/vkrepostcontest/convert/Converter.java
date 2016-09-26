package ru.vkrepostcontest.convert;

/**
 *
 * Конвертер объектов и форм
 * @author Stetskevich Roman on 06.09.2016.
 * @since 0.1
 */
public interface Converter<OBJECT, FORM> {

    /**
     * перевод формы в объект
     * @param form
     * @return
     */
    OBJECT formToObject(FORM form);

    /**
     * перевод объекта в форму
     * @param object
     * @return
     */
    FORM objectToForm(OBJECT object);
}
