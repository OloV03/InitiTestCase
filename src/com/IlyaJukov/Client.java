package com.IlyaJukov;

import java.util.List;
import java.util.UUID;

public class Client {

    private List<UUID> uuids;
    private Server server;
    private int startPosition;

    public Client(int N) {
        this.server = new Server();
        this.uuids = server.getUUID(startPosition, N);
    }

    /**
     * Получение N строк для окна отображения
     * @return Список строк для отображения
     */
    private List<Object> getData() {
        updateUUIDs();
        return server.getData(uuids);
    }

    /**
     * Изменение положение скроллера
     * @param startPosition Позиция первой строки в окне отображения клиента
     */
    private void setStartPosition(int startPosition) {
        this.startPosition = startPosition;
        updateUUIDs();
    }

    /**
     * Изменение сортировки
     * @param sortingCondition Условие сортировки
     * @return Обновленный список строк с учетом сортировки
     */
    private List<Object> sortBy(Object sortingCondition) {
        server.sortBy(sortingCondition);
        return getData();
    }

    /**
     * Кол-во строк в таблице на сервере.
     * Необходимо для понимания пределов скроллинга.
     * @return Кол-во строк основной таблицы
     */
    private int getTableSize() {
        return server.getTableSize();
    }

    /**
     * Обновление списка uuid строк
     * @return true в случае успешного обновления,
     * false при возникновении ошибки
     */
    private boolean updateUUIDs() {
        try {
            server.updateUUIDS(uuids, startPosition);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
