package com.IlyaJukov;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class Server {

    /**
     * Словарь для доступа к строкам по UUID
      */
    private HashMap<UUID, Object> uuidMap = new HashMap<>();

    /**
     * Основная таблица с данными
     */
    private List<Object> dataTable = new ArrayList<>();

    /**
     * Кол-во строк в основной таблице
     * @return Кол-во строк таблицы
     */
    public int getTableSize() {
        return dataTable.size();
    }

    /**
     * Обновление uuid-ов строк в окне отображения на клиенте
     * @param uuids Список проверяемых uuid
     * @param start Стартовая позиция окна отображения на клиенте
     */
    public void updateUUIDS(List<UUID> uuids, int start) {

        for (int i = 0; i < uuids.size(); i++) {
            int position = start + i; // Позиция строки в общей таблице

            if (dataTable.get(position).getUUID() != uuids.get(i)) {
                uuids.set(i, dataTable.get(position).getUUID());
            }
        }
    }

    /**
     * Получение списка строк для отображения
     * @param uuids uuid необходимых строк
     * @return Список строк
     */
    public List<Object> getData(List<UUID> uuids) {

        List<Object> res = new ArrayList<>();

        for (UUID uuid : uuids) {
            res.add(uuidMap.get(uuid));
        }
        return res;
    }

    /**
     * Получение части списка uuid.
     * Может быть применено при первоначальной загрузке страницы или перезагрузке
     * @param start Начальная позиция строки в основной таблице
     * @param N Количество строк для отображения
     * @return Список uuid-ов строк для отображения
     */
    public List<UUID> getUUID(int start, int N) {
        return dataTable.subList(start, N).stream()
                .map(x -> x.getUUID())
                .toList();
    }

    /**
     * Внесение изменений в таблицу
     * @param modification Изменение основной таблицы
     */
    public void updateTable(Object modification) {
        /**
         * При удалении/добавлении строк, uuid строки удаляется/добавляется в uuidMap
         */
    }

    /**
     * Сортировка таблицы
     * @param sortingCondition Условие сортировки
     */
    public void sortBy(Object sortingCondition) { }
}
