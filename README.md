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
├── drivers/                         # Local drivers, not needed with WebDriverManager (optional)
├── reports/                         # Extent report outputs (optional)
├── src/
│   ├── main/
│   │   └── java/
│   │       ├── api/                 # API testing layer (planned)
│   │       ├── base/                # BasePage, DriverFactory
│   │       ├── mobile/              # Mobile test layer (planned)
│   │       ├── performance/         # JMeter support (planned)
│   │       ├── utils/               # Utility/helper classes
│   │       └── web/                 # Web page View + Action classes
│   └── test/
│       ├── java/
│       │   ├── base/                # Base test classes
│       │   ├── reports/             # ExtentReport config (planned)
│       │   └── webTests/            # Actual test cases
│       └── resources/
│           ├── config.properties    # Configurable parameters
│           ├── TestImage.png        # Sample upload image
│           └── TestVideo.mp4        # Sample upload video
├── test-output/                     # TestNG + Extent output
│   └── ExtentReport.html
├── pom.xml                          # Maven build file
├── testng.xml                       # TestNG suite configuration
└── README.md                        # You’re reading this!

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
- [x] Checkboxes Page (`/checkbox`)
- [x] Date Picker
- [x] Dropdowns
- [x] Scroll page
- [x] Modal Windows
- [x] File Uploads
- [x] Drag & Drop
- [x] Multiple Tabs/Windows
- [x] Form Submission

> Powered by the open-source [Formy Project](https://formy-project.herokuapp.com/) app

---

## ▶️ How to Run Tests

### Prerequisites:
- Java 17+
- Maven installed
✅ No need to download ChromeDriver manually —  
WebDriverManager will handle it automatically at runtime.

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
browser=chrome
baseUrl=https://formy-project.herokuapp.com
platform=web
api.base.url=https://reqres.in
mobile.platform=Android
chrome.driver.path=drivers/chromedriver     #chrome.driver.path not required when using WebDriverManager
test.image.path=resources/TestImage.png
test.video.path=resources/TestVideo.mp4
```

---

## 🚀 Roadmap

- [x] Basic Web UI framework
- [x] Add reporting (ExtentReports or Allure)
- [ ] Add support for API & Appium modules
- [ ] Docker support with Selenium Grid
- [ ] Integrate JMeter for performance test triggering
- [ ] GitHub Actions CI pipeline

---

## 👩‍💻 Author

**Bhumika Rao**  
Passionate about Quality. Uses automation to make it better. I love building things from scratch and breaking others down to dust.
s
---

## 🌟 Show your support

If you like the project, please ⭐️ the repo and share it with fellow testers!
