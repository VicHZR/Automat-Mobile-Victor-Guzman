# 📱 Enterprise Mobile Test Automation Suite

<p align="left">
  <a href="https://oracle.com">
    <img src="https://img.shields.io/badge/Oracle-F80000?style=for-the-badge&logo=oracle&logoColor=white" />
  </a>
  <a href="https://appium.io">
    <img src="https://img.shields.io/badge/Appium-EE376D?style=for-the-badge&logo=appium&logoColor=white" />
  </a>
  <a href="https://serenity-bdd.info">
    <img src="https://img.shields.io/badge/Serenity_BDD-0E76A8?style=for-the-badge&logo=java&logoColor=white" />
  </a>
  <a href="https://cucumber.io">
    <img src="https://img.shields.io/badge/Cucumber-23D96C?style=for-the-badge&logo=cucumber&logoColor=white" />
  </a>
</p>

---

## 🚀 Overview

A professional, enterprise-grade **Mobile UI Test Automation Suite** engineered to validate business-critical workflows and user journeys across mobile applications. 

Utilizing **Java** as the programming baseline, **Appium** for mobile device interaction, and **Serenity BDD** for structural framework management, this repository serves as a robust regression environment built to run execution scripts with maximum test reliability and comprehensive visual metrics.

🎯 Focus: **Mobile interface regression, behavior-driven development (BDD) testing, native mobile capability handling, and live execution reporting.**

---

## 🎯 Key Technical Features

- 🏗️ **Screenplay / POM Architecture Alignment:** Advanced design layout designed to separate system interactions and UI selectors completely from assertion step metrics.
- 🥒 **Behavior-Driven Development Workflow:** Plain-text functional specifications written in Gherkin syntax, aligning technical steps with product acceptance constraints.
- 📱 **Scalable Mobile Configurations:** Centralized tracking of app packages, activities, and native driver desired capabilities managed completely through external property files.
- 📊 **Dynamic Living Documentation:** Integrated test runners that parse real-time execution flows into structured, graphic HTML dashboards with step-by-step screenshot tracking.

---

## 🏗️ Technical Folder Architecture

The framework is mapped to maintain clean component separation across operational layers:

```text
Automat-Mobile-Victor-Guzman/
│
├── src/
│   ├── main/java/             # Native page selectors, target app locators, and UI interactions
│   └── test/
│       ├── java/              # Structural test runners and step definitions code mapping
│       └── resources/         # Behavioral user stories and Gherkin criteria (.feature files)
│
├── serenity.properties        # Decoupled environment desired capabilities configuration
├── pom.xml                    # Apache Maven manifest managing frameworks dependencies
└── README.md                  # Technical documentation
```

---

## 📊 Impact (CV-Level Highlights)

- 📈 **Accelerated Release Verification:** Designed robust automated workflows that significantly compress regression testing lifecycles on complex mobile products.
- ⚙️ **Drastically Lowered Script Flakiness:** Configured smart explicit waiting algorithms to manage dynamic asynchronous loading loops within mobile screens.
- 🤝 **Unified Technical Delivery:** Bridged communication barriers between business analysts and engineering groups by deploying readable BDD frameworks.
- 📋 **Automated Defect Triage:** Drastically streamlined debugging cycles through automatic screenshot capture modules active upon unexpected execution exceptions.

---

## ⚙️ Environment Configuration & Run Guide

### 1. System Requirements
Verify your machine ecosystem has the following binaries globally active:
- **Java SE Development Kit (JDK 11 or higher)**
- **Apache Maven 3.8+**
- Android SDK / Appium Node engine paths configured on local environment settings.

### 2. Project Bootstrapping
```bash
git clone https://github.com
cd Automat-Mobile-Victor-Guzman
```

### 3. Fetch dependencies and Compile Manifest
```bash
mvn clean install -DskipTests
```

### 4. Execute the Regression Suites
```bash
mvn clean verify
```
📍 *Once test threads wrap up, review the extensive visual diagnostic reporting outputs inside `target/site/serenity/index.html`.*

---

## 🔐 Mobile Engineering Best Practices Applied

- **Clean Decoupled Architecture:** Eliminates hardcoded screen elements by mapping all target components strictly into dedicated UI locator directories.
- **Isolated State Execution:** Test loops run independently under specialized teardown hooks, clearing software storage files before subsequential jobs start.
- **Robust Multi-Capability Infrastructure:** Built to swap execution targets (Emulators, Real Devices) instantly via environmental property flags.

---

## 👨‍💻 Author

**Victor Guzmán**  
*Computational Scientist | Backend Engineer | Software Quality & Test Automation Specialist*  
- 🔗 **LinkedIn:** [https://linkedin.com](https://www.linkedin.com/in/victor-h-guzm%C3%A1n-a19361187/)
