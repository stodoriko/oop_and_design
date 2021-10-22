package ru.netology;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RadioTest {


    //Если текущая радиостанция - 9 и клиент нажал на кнопку next (следующая) на пульте, то текущей должна стать 0-ая;
    // в остальных случаях радио переключается просто на следующую станцию.
    @Test
    public void shouldComeToBeginningIfEqualMax() {
        Radio radio = new Radio();
        radio.setOn(true);
        if (radio.isOn()) {
            radio.setCurrentChannel(9);
        }

        int expected = radio.getRadioChannelMin();
        radio.switchToNextChannel();

        int actual = radio.getCurrentChannel();
        assertEquals(expected, actual);
    }

    //Если текущая радиостанция - меньше 9 и клиент нажал на кнопку next (следующая) на пульте, то текущей должна стать следующая;
    @Test
    public void shouldSwitchForward() {
        Radio radio = new Radio();

        radio.setCurrentChannel(8);

        int expected = radio.getRadioChannelMax();
        radio.switchToNextChannel();

        int actual = radio.getCurrentChannel();
        assertEquals(expected, actual);
    }

    //Если текущая радиостанция - больше 9 и клиент нажал на кнопку next (следующая) на пульте, то текущей должна остаться прежней;
    @Test
    public void shouldNotSwitchIfMoreThanMax() {
        Radio radio = new Radio();

        radio.setCurrentChannel(10);

        int expected = radio.getRadioChannelMax();
        radio.switchToNextChannel();

        int actual = radio.getCurrentChannel();
        assertEquals(expected, actual);
    }


    // Если текущая радиостанция - 0 и клиент нажал на кнопку prev (предыдущая) на пульте, то текущей должна стать 9-ая;
    // в остальных случаях радиопереключается просто на предыдущую станцию/ (создайте отдельный метод для этой операции)
    @Test
    public void shouldComeToEndIfEqualMin() {
        Radio radio = new Radio();

        radio.setCurrentChannel(0);

        int expected = radio.getRadioChannelMax();
        radio.switchToPrevChannel();

        int actual = radio.getCurrentChannel();
        assertEquals(expected, actual);
    }

    // Если текущая радиостанция - больше 0 и клиент нажал на кнопку prev (предыдущая) на пульте, то текущей должна стать предыдущая
    @Test
    public void shouldSwitchBack() {
        Radio radio = new Radio();

        radio.setCurrentChannel(1);

        int expected = radio.getRadioChannelMin();
        radio.switchToPrevChannel();

        int actual = radio.getCurrentChannel();
        assertEquals(expected, actual);
    }

    //Если текущая радиостанция - меньше 0 и клиент нажал на кнопку меньше минимальной, то текущей должна остаться прежняя;
    @Test
    public void shouldNotSwitchIfLessThanMin() {
        Radio radio = new Radio();

        radio.setCurrentChannel(-1);

        int expected = radio.getRadioChannelMin();
        radio.switchToPrevChannel();

        int actual = radio.getCurrentChannel();
        assertEquals(expected, actual);
    }


    // Если уровень громкости звука достиг максимального значения, то дальнейшее нажатие на + не должно ни к чему приводить
    @Test
    public void shouldNotAddingVolumeIfMax() {
        Radio radio = new Radio();

        radio.setCurrentVolume(10);

        int expected = radio.getVolumeMax();
        radio.increaseVolume();

        int actual = radio.getCurrentVolume();
        assertEquals(expected, actual);
    }

    // Если уровень громкости звука НЕ достиг максимального значения
    @Test
    public void shouldAddingVolume() {
        Radio radio = new Radio();

        radio.setCurrentVolume(9);

        int expected = radio.getVolumeMax();
        radio.increaseVolume();

        int actual = radio.getCurrentVolume();
        assertEquals(expected, actual);
    }


    // Если уровень громкости звука достиг минимального значения, то дальнейшее нажатие на - не должно ни к чему приводить
    @Test
    public void shouldNotTurnDownVolumeIfMax() {
        Radio radio = new Radio();

        radio.setCurrentVolume(0);

        int expected = radio.getVolumeMin();
        radio.decreaseVolume();

        int actual = radio.getCurrentVolume();
        assertEquals(expected, actual);
    }

    // Если уровень громкости звука НЕ достиг минимального значения
    @Test
    public void shouldTurnDownVolume() {
        Radio radio = new Radio();

        radio.setCurrentVolume(1);

        int expected = radio.getVolumeMin();
        radio.decreaseVolume();

        int actual = radio.getCurrentVolume();
        assertEquals(expected, actual);
    }
}