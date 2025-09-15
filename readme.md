# Gherkin Test Project

Автоматизированные тесты для bookstack-gherkin.  
Стек: **Java 17 + Maven + Cucumber + Selenide + JUnit 5 + Allure Report**

---

## 📂 Структура проекта
```
src
└── test
│ └── java
│ │ └── api # Для хранения api тестов
│ │ └── config # Настройки запуска
│ │ └── hooks # Хуки (инициализация Allure, teardown и т.п.)
│ │ └── mocks # Хуки (должны быть реализованы заглушки)
│ │ └── runners # CucumberTest (точка входа для запуска)
│ │ └── steps # CucumberTest (тестовые классы с методами для тестирования)
│ └── resources
│ │ └── features # Gherkin-сценарии (*.feature)
│ │ └── images # изображения для тестовых сценариев (*.feature)
│ │ └── testsdata # Конфигурации и тестовые данные
```
---

## ⚙️ Установка и запуск

### 1. Клонирование репозитория
``` 
git clone git@github.com:xilit/bookstack-gherkin.git
cd Gherkin
```
### 2. Зависимости
Убедись, что установлены:
- Java 17+
- Maven 3.8+
- Chrome (или другой браузер)

### 3. Запуск тестов
``` 
mvn clean test
```

### 4. Параметры запуска
``` 
mvn clean test -DbaseUrl=http://test-stand.local -Dbrowser=firefox -Dheadless=true
```
## 📊 Allure отчет
### 1. Генерация и просмотр отчета 
``` 
mvn allure:serve
```
После прогона тестов результаты будут лежать в:
``` 
target/allure-results/
```
### 3. Генерация статического отчета 
```
mvn allure:report
```
Готовый отчёт появится в:
```
target/site/allure-maven-plugin/
```

## 🛠 Полезные ссылки
[Cucumber docs](https://cucumber.io/docs/)

[Selenide docs](https://selenide.org/)
 
[Allure docs](https://docs.qameta.io/allure/)
