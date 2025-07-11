# 🧪 unified-java-automation-framework

A unified Java-based test automation framework that supports:

- 🌐 Web UI Testing using Selenium + TestNG
- 📱 Mobile UI Testing using Appium (to be added)
- 🔗 API Testing using RestAssured (to be added)
- 🚀 Performance Testing using JMeter (to be added)

Built from scratch with modular design, Page Object Model (View + Action), and real-world test cases based on [Formy Project](https://formy-project.herokuapp.com/).

---

## 📁 Project Structure

```
unified-java-automation-framework/
├── pom.xml
├── config/
│   └── config.properties
├── drivers/
│   └── chromedriver (local executable)
├── src/
│   ├── main/
│   │   └── java/
│   │       └── utils/
│   └── test/
│       ├── java/
│       │   ├── base/
│       │   ├── web/
│       │   └── webTests/
│       └── resources/
│           └── testng.xml
```

---

## 🔧 Tech Stack

| Layer         | Tool / Library         |
|---------------|------------------------|
| Language      | Java 17+               |
| Web Testing   | Selenium WebDriver     |
| Test Runner   | TestNG                 |
| API Testing   | RestAssured            |
| Mobile Testing| Appium (Java client)   |
| Logging       | Log4j                  |
| Performance   | JMeter (planned)       |
| Build Tool    | Maven                  |
| IDE           | IntelliJ IDEA          |
| Version Ctrl  | Git + GitHub           |

---

## ✅ Features

- ✅ Page Object Model with View + Action class
- ✅ TestNG-based parallel execution support
- ✅ Driver initialization using `config.properties`
- ✅ Local ChromeDriver support (self-contained)
- 🐳 Docker/Selenium Grid support (planned)
- 🧪 JMeter CLI triggering (upcoming)
- 📄 Logs, Screenshots, and Reports (planned)

---

## 📌 Test Coverage (So Far)

- [x] Buttons Page (`/buttons`)
- [ ] Checkboxes Page (`/checkbox`) — in progress
- [ ] Dropdowns
- [ ] Form Submission
- [ ] Modal Windows
- [ ] File Uploads
- [ ] Datepicker
- [ ] Drag & Drop
- [ ] Multiple Tabs/Windows

> Powered by the open-source [Formy Project](https://formy-project.herokuapp.com/) app

---

## ▶️ How to Run Tests

### Prerequisites:
- Java 17+
- Maven installed
- ChromeDriver placed in `/drivers/` folder

### Run from CLI:
```bash
mvn clean test
```

### Run specific suite:
Configure `testng.xml` and execute:
```bash
mvn test -DsuiteXmlFile=testng.xml
```

---

## 📄 Configuration

Edit `config.properties` to customize run:

```properties
chrome.driver.path=drivers/chromedriver
browser=chrome
headless=false
webAutomationUrl=https://formy-project.herokuapp.com/
```

---

## 🚀 Roadmap

- [x] Basic Web UI framework
- [ ] Add support for API & Appium modules
- [ ] Docker support with Selenium Grid
- [ ] Integrate JMeter for performance test triggering
- [ ] Add reporting (ExtentReports or Allure)
- [ ] GitHub Actions CI pipeline

---

## 👩‍💻 Author

**Bhumika Rao**  
Passionate about Quality. Uses automation to make it better. I love building things from scratch and breaking others down to dust.
s
---

## 🌟 Show your support

If you like the project, please ⭐️ the repo and share it with fellow testers!
