package ru.digitalleague.core.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class TaxiDriverInfoModel {

    /**
     * Идентификатор водителя.
     */
    private Long driverId;

    /**
     * Фамилия.
     */
    private String lastName;

    /**
     * Имя.
     */
    private String firstName;

    /**
     * Уровень.
     */
    private int level;

    /**
     * Модель авто (должна быть ENUM).
     */
    private String carModel;

    /**
     * Дата создания.
     */
    private LocalDate createDttm;
}
