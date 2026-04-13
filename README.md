# Spring SCA Test App (Docker)

Тестовое приложение на Spring Core 6.2.5 для проверки SCA-инструментов.

## Быстрый старт

### 1. Собрать образ

```bash
cd spring-sca-test
docker build -t spring-sca-test:1.0.0 .
```

### 2. Запустить контейнер

```bash
docker run --rm spring-sca-test:1.0.0
```

Ожидаемый вывод:
```
Hello, SCA Tool! This app uses Spring Core 6.2.5 for SCA testing.
Spring Core version: 6.2.5
```

### 3. Сканирование SCA

**Вариант A — сканировать Docker-образ напрямую:**

```bash
# Trivy
trivy image spring-sca-test:1.0.0

# Grype
grype spring-sca-test:1.0.0

# Docker Scout
docker scout cves spring-sca-test:1.0.0
```

**Вариант B — сканировать pom.xml / JAR без Docker:**

```bash
# Trivy по файловой системе
trivy fs --scanners vuln .

# OWASP Dependency-Check
dependency-check --project spring-sca-test --scan pom.xml
```

**Вариант C — экспортировать образ в tar для офлайн-сканера:**

```bash
docker save spring-sca-test:1.0.0 -o spring-sca-test.tar
# передать .tar в ваш SCA-инструмент
```

## Зависимости в образе

| Библиотека         | Версия | Зачем                              |
|--------------------|--------|------------------------------------|
| spring-core        | 6.2.5  | Основная цель проверки             |
| spring-context     | 6.2.5  | Транзитивные: beans, aop, expression |
| spring-web         | 6.2.5  | Дополнительные транзитивные        |
| jackson-databind   | 2.17.0 | JSON-сериализация                  |
| slf4j + logback    | 2.0.12 / 1.5.3 | Логирование                |
| snakeyaml          | 2.2    | YAML-парсинг (проверка на CVE)     |
