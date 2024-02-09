# Веб-интерфейс StudentServiceUI

Добро пожаловать в компонент веб-интерфейса StudentServiceUI, части нашей микросервисной архитектуры. Этот модуль отвечает за взаимодействие с фронтендом, обеспечивая безупречный пользовательский опыт. Ниже вы найдете ключевую информацию о данном модуле.

## Обзор

Этот модуль веб-интерфейса создан с использованием проекта [OpenAPI Generator](https://openapi-generator.tech) и интегрирован в фреймворк Spring Boot. Используя мощь [springdoc](https://springdoc.org), мы автоматически генерируем спецификацию OpenAPI v3 на основе классов Controller и Model.

Сгенерированная спецификация доступна по адресу [http://localhost:8081/v3/api-docs/](http://localhost:8081/v3/api-docs/), что позволяет изучить конечные точки API и понять, как взаимодействовать с этим микросервисом.

## Особенности

- Интеграция с фронтендом: Безупречное взаимодействие с фронтендом для предоставления богатого пользовательского опыта.

- Документация Swagger: Изучите документацию API через Swagger UI по адресу [http://localhost:8081/swagger-ui.html](http://localhost:8081/swagger-ui.html).

- Интеграция с Apache Kafka: Используйте Apache Kafka для асинхронного обмена информацией. Сообщения, отправленные в Kafka, обрабатываются и направляются в другое приложение в нашей микросервисной архитектуре, обеспечивая эффективный поток данных.

## Начало работы

1. Клонирование репозитория:
   ```bash
   git clone https://github.com/Elvira333/web_interface.git
2. Запуск приложения
   ```bash
   ./mvnw spring-boot:run

## Конфигурация

Конфигурация приложения определена в файле application.properties. Основные конфигурации включают:

```properties
server.port=8081

spring.autoconfigure.exclude=org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration

spring.jackson.date-format=org.openapitools.RFC3339DateFormat
spring.jackson.serialization.write-dates-as-timestamps=false

spring.kafka.bootstrap-servers=localhost:9092
```
Не стесняйтесь изменять эти свойства в соответствии с вашим окружением и требованиями.

## Документация API

Изучите документацию API с помощью Swagger UI по адресу [http://localhost:8081/swagger-ui.html](http://localhost:8081/swagger-ui.html). Эта документация предоставляет подробную информацию о доступных конечных точках и их использовании.

Примечание: Убедитесь, что RabbitMQ запущен локально, или обновите конфигурацию RabbitMQ в application.properties соответственно.

Этот модуль веб-интерфейса играет важную роль в нашей микросервисной экосистеме, обрабатывая взаимодействие с пользователями и обеспечивая коммуникацию с другими службами. Если у вас есть вопросы или проблемы, пожалуйста, обратитесь к [репозиторию на GitHub](https://github.com/Elvira333/web_interface.git) для получения дополнительной информации.

