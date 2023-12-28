# Егоров Владимир Александрович
**Дата сдачи:** 28.12.2023  
**Номер группы(потока):** 4631

1. **Использование команды cat в Linux**
   - Создать два текстовых файла: "Pets" и "Pack animals".
   - Объединить содержимое файлов и переименовать в "Human Friends".
     ```bash
     cat > Pets.txt <<< "dogs, cats, hamsters"
     cat > Pack_animals.txt <<< "horses, camels, donkeys"
     cat Pets.txt Pack_animals.txt > new.txt && cat new.txt
     mv new.txt Human_Friends.txt
     ```
    Пример конечного вывода после команды `ls`: 
    ```bash
    root@GB:/home/vladimir/final_KR# ls
    Human_Friends.txt  Pack_animals.txt  Pets.txt
    ```

2. **Работа с директориями в Linux**
- Создать новую директорию и переместить туда файл "Human Friends".
  ```bash
  mkdir newDirectory && mv Human_Friends.txt newDirectory/
  ```

3. **Работа с MySQL в Linux**
- Подключить дополнительный репозиторий MySQL и установить один из пакетов этого репозитория.
  ```
  # Скачиваем пакет установки репозитория:
  # https://dev.mysql.com/downloads/repo/apt/
  # mysql-apt-config_0.8.29-1_all.deb
  sudo dpkg -i mysql-apt-config_*.deb # Устанавливаем пакет репозитория
  sudo apt update # Обновляем список пакетов APT, чтобы новый репозиторий стал доступен
  sudo apt install mysql-server # Устанавливаем mysql-server
  ```

4. **Управление deb-пакетами**
- Установить и затем удалить deb-пакет, используя команду `dpkg`.
  ```bash
  wget https://dl.google.com/linux/direct/google-chrome-stable_current_amd64.deb # Скачиваем гугл хром
  dpkg -i google-chrome-stable_current_amd64.deb # Устанавливаем
  dpkg -l | grep google-chrome # Смотрим название нашего пакета
  dpkg -r google-chrome-stable # Удаляем
  ```
