# MercadoLibre Automation / BDD Project

A Java + Gherkin‑based project designed to automate or test functionality related to **MercadoLibre** workflows using **Behavior‑Driven Development (BDD)** principles.

This repository uses Java as the primary language and includes **Gherkin feature files** for defining test scenarios in human‑readable format.

## 🧠 Project Overview

This project provides a framework to define and execute behavior‑driven scenarios (using Gherkin) with Java. It’s ideal for:

- Writing **specification‐style acceptance tests** against MercadoLibre endpoints or UI.  
- Integrating BDD into Java test automation workflows.  
- Structuring tests that are easy to understand for both technical and non‑technical stakeholders.

## 🚀 Features

- **Java Test Framework** – Leverages Java for implementing test logic.  
- **Gherkin Support** – Uses feature files (`.feature`) to define test behavior in BDD style.  
- **Scalable Architecture** – Easily extendable with additional scenarios, page objects, step definitions, etc.  
- **Gradle Build System** – Simplifies building, running tests, and managing dependencies.

---

## 📂 Repository Structure
```text
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── framework
│   │   │           ├── core                # Independent Framework Engine
│   │   │           │   ├── driver
│   │   │           │   │   ├── Browser.java          # Abstract base
│   │   │           │   │   ├── ChromeBrowser.java
│   │   │           │   │   ├── FirefoxBrowser.java
│   │   │           │   │   ├── EdgeBrowser.java
│   │   │           │   │   ├── WebDriverFactory.java # Creation logic
│   │   │           │   │   └── WebDriverManager.java # Lifecycle management
│   │   │           │   ├── actions
│   │   │           │   │   └── WebDriverAction.java  # Wrapper for click, type, wait
│   │   │           │   └── reporting
│   │   │           │       └── ReportGenerator.java  # Allure/Extent reports
│   │   │           ├── mercadolibre        # Domain Specific Logic
│   │   │           │   ├── api
│   │   │           │   │   └── ApiClient.java        # RestAssured/API Logic
│   │   │           │   └── ui
│   │   │           │       └── pages             # Page Object Model
│   │   │           │           ├── common
│   │   │           │           │   ├── BasePage.java
│   │   │           │           │   └── Header.java   # Better than "Navigate"
│   │   │           │           └── search
│   │   │           │               ├── SearchPage.java
│   │   │           │               └── ResultsPage.java
│   │   │           └── utils                 # Shared Utilities
│   │   │               ├── config
│   │   │               │   ├── EnvConfig.java        # Properties reader
│   │   │               │   └── Constants.java
│   │   │               ├── WaitUtils.java
│   │   │               └── ScreenshotUtils.java
│   │   └── resources
│   │       ├── features                    # Gherkin Scenarios
│   │       │   ├── api
│   │       │   └── ui
│   │       │       └── search_item.feature
│   │       ├── config                      # Environment Files
│   │       │   ├── qa.properties
│   │       │   └── prod.properties
│   │       └── log4j2.xml                  # Logging Config
│   └── test
│       ├── java
│       │   └── com
│       │       └── mercadolibre
│       │           ├── runners             # Test Execution
│       │           │   └── MainRunner.java
│       │           └── steps                # Step Definitions
│       │               ├── hooks
│       │               │   └── TestHooks.java
│       │               ├── api
│       │               │   └── ApiSteps.java
│       │               └── ui
│       │                   ├── CommonSteps.java
│       │                   └── SearchSteps.java
```
---

## 🛠️ Prerequisites

Before you start, make sure you have installed:

- **JDK 11+**
- **Gradle** (optional if using the Gradle wrapper)
- **Git**

---

## 📦 Install & Run

1. Clone the repository

   ```bash
   git clone https://github.com/GustavoZHA/mercadolibre.git
   cd mercadolibre
   ```
   
2. Build the project

   ```bash
    ./gradlew build
   ```

3. Execute tests/BDD scenarios

   ```bash
    ./gradlew test
   ```
      
