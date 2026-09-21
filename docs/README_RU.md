[EN](../README.md) | RU

## void-funtime-deobf 🔓

![Python](https://img.shields.io/badge/Python-3776AB?style=flat-square&logo=python&logoColor=white)
![Java](https://img.shields.io/badge/Java-ED8B00?style=flat-square&logo=openjdk&logoColor=white)

**Void Modification** (Funtime, Fabric, Minecraft **1.21.4**) — оригинальный JAR, декompил (CFR), отчёты по mixin/refmap и скрипт локальной деобфускации.

В репозитории лежит `Void-1.1.1.jar` (**Git LFS**). После клона: `git lfs pull`.

---

## ⚠️ Публикация — только на свой страх и риск

Сцена **Funtime** и соседние чит-сообщества (Telegram, Discord, «маркетплейсы», репаки) — не нейтральная среда:

- мошенничество и фишинг под видом «слитых» билдов;
- вредоносное ПО в лаунчерах и «краках»;
- давление на тех, кто выкладывает артеfactы (деанон, спам, угрозы, takedown);
- юридические риски (ToS игры, авторские права на мод).

**Не рекомендуем** публичный GitHub/GitLab без понимания последствий. Если публикуете — приватный форк, без личных данных, готовность к удалению репо и к обращениям не только с GitHub, но и из чатов сцены. Исследование лучше **офлайн**, на VM, не с основного Telegram/Discord.

---

## 🚀 Быстрый старт

```bash
git clone <url>
cd void-funtime-deobf
git lfs pull

./deobfuscate.sh
```

Полный дамп `CLASSESS/` / `LABMA/`:

```bash
python3 deobfuscate_void.py --scope all --heap 8g
```

---

## 📁 Структура

См. [README EN](../README.md#-structure).

---

## 📜 Лицензия

| Часть | Лицензия |
|-------|----------|
| Скрипты и документация | [MIT](../LICENSE) — © 2026 xvDosha |
| **Void Modification** (JAR и декompил мода) | **All rights reserved**, автор **fokori** — MIT не распространяется на бинарник и bytecode мода |
