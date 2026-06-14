
Claude finished the response
عايز readmeللمشروع ده علمنا ان ال allure report is generated automaticaly after finish executed ادى ريبو المشروع https://github.com/mahmoud-bayoumi9/Saucedemo-QA-Automation-Testing.git

5:17 PM

Searched the web
Searched the web
مش لاقي الريبو بتاعك في النتائج. هحاول أجيب الكود مباشرةً من GitHub API.


Ran 7 commands, searched the web, viewed a file
Ran 7 commands, searched the web, viewed a file
الآن عندي كل المعلومات اللي محتاجها. هكتب README احترافي.


Viewed 2 files, ran a command
Viewed 2 files, ran a command
الآن عندي كل المعلومات. هكتب README احترافي.


Created a file, read a file
Created a file, read a file
الـ README جاهز! 🎉

اتعمل فيه كل حاجة بناءً على الكود الحقيقي بتاعك، وأبرز جزء فيه هو شرح آلية الـ Allure Auto-Generation بالتفصيل:

إزاي بيشتغل الموضوع بالظبط:

testNGListener بيـ implement الـ IExecutionListener
لما التيستات خلصت، onExecutionFinish() بتسجّل JVM Shutdown Hook
الـ Hook ده بيشتغل وقت إغلاق الـ JVM وبيعمل بالترتيب:
copyHistory() → يحافظ على بيانات الـ trends
generateReports(false) → الريبورت الكامل interactive
generateReports(true) → ملف HTML واحد portable
renameReport() → يضيف timestamp للاسم
openReport() → يفتح Allure server أوتوماتيك في CMD جديد
الـ README بيشمل كمان: project structure كاملة، test coverage table، prerequisites، وطريقة التشغيل.


Readme
Document · MD 






Claude is AI and can make mistakes. Please double-check cited sources.


Readme · MD
🧪 Saucedemo QA Automation Testing
A full-featured, end-to-end test automation framework for saucedemo.com, built with Java, Selenium WebDriver, and TestNG — featuring fully automatic Allure Report generation upon test execution completion.

📋 Table of Contents
About the Project
Tech Stack
Project Structure
Test Coverage
How Allure Report is Generated Automatically
Prerequisites
Installation & Setup
Running the Tests
Test Output
Author
📖 About the Project
This project automates the complete user journey on the SauceDemo e-commerce platform. It follows the Page Object Model (POM) design pattern, supports automatic screenshot capture on test success/failure/skip, and generates a rich interactive Allure Report automatically after every test run — no manual commands needed.

🛠️ Tech Stack
Tool / Library	Version	Purpose
Java	21	Programming language
Selenium WebDriver	4.25.0	Browser automation
TestNG	7.11.0	Test framework
Allure TestNG	2.34.0	Test reporting
WebDriverManager	5.9.2	Automatic browser driver setup
AspectJ Weaver	1.9.20.1	AOP support for Allure
Java Faker	1.0.2	Dynamic test data generation
Commons IO	2.11.0	File utilities
Maven Surefire Plugin	3.2.5	Test execution via Maven
📁 Project Structure
Saucedemo-QA-Automation-Testing/
│
├── src/
│   ├── main/java/saucedemo/
│   │   ├── Pages/                    # Page Object classes
│   │   │   ├── LoginPage.java
│   │   │   ├── homepage.java
│   │   │   ├── productPage.java
│   │   │   ├── productDetails.java
│   │   │   ├── CartPage.java
│   │   │   ├── checkOutPageStep1.java
│   │   │   ├── CheckOutPageStep2.java
│   │   │   ├── orderConfirmationPage.java
│   │   │   ├── NavigationPage.java
│   │   │   └── AboutPage.java
│   │   │
│   │   ├── drivers/                  # WebDriver management
│   │   │   ├── GuiDriver.java
│   │   │   ├── abstractDriver.java
│   │   │   └── webDriverProvider.java
│   │   │
│   │   ├── customerListener/
│   │   │   └── testNGListener.java   # 🔑 Allure auto-generation hook
│   │   │
│   │   ├── utiles/
│   │   │   ├── report/
│   │   │   │   ├── AllureReportGenerator.java
│   │   │   │   ├── AllureBinaryManager.java
│   │   │   │   ├── AllureConstant.java
│   │   │   │   ├── AllureAttachment.java
│   │   │   │   └── AllureEnvironmentManager.java
│   │   │   └── Actions/              # Reusable UI action helpers
│   │   │
│   │   ├── media/
│   │   │   ├── screenShotManager.java
│   │   │   └── screenRecordManager.java
│   │   │
│   │   └── validation/               # Assertion utilities
│   │
│   └── test/java/saucedemo/          # Test classes
│       ├── baseTest.java
│       ├── loginTest.java
│       ├── productsTest.java
│       ├── productDetailsTest.java
│       ├── cartTest.java
│       ├── checkoutstep1Test.java
│       ├── checkOutStep2Test.java
│       ├── confirmationOredTest.java
│       └── validationErrorMessage.java
│
├── test-output/
│   ├── allure-results/               # Raw Allure JSON results
│   ├── reports/                      # Single-file HTML report
│   ├── full-reports/                 # Full interactive report
│   └── screenShots/                  # Captured screenshots
│
├── allure-results/                   # Allure raw data
├── pom.xml
└── README.md
✅ Test Coverage
Module	Test Cases
Login	Empty fields, empty username, empty password, invalid credentials, valid login
Products Page	Menu navigation, Add to Cart button, product sorting, navigation to product details
Product Details	Back to Products button, Add to Cart from details page
Cart	Add/remove items, cart badge count, continue shopping
Checkout Step 1	Empty form validation, numeric/special-char rejection, valid checkout data
Checkout Step 2	Order summary validation, cancel button, finish button
Order Confirmation	Success message display, Back Home button redirects to Products page
Validation Errors	Error message format and content across all forms
⚡ How Allure Report is Generated Automatically
No manual allure generate command is needed. The report is produced and opened automatically after every test run.

How It Works
The framework uses a custom TestNG Listener (testNGListener) that implements IExecutionListener. When all tests finish, the onExecutionFinish() method registers a JVM Shutdown Hook that:

Copies history from the previous run (for trend tracking).
Generates the full interactive report → test-output/full-reports/.
Generates a portable single-file HTML report → test-output/reports/.
Renames the single-file report with a timestamp (e.g., AllureReport_2024-11-01_15-30-00.html).
Automatically opens Allure's built-in local server in a new terminal window so you can view the report in your browser immediately.
Tests Finish
     │
     ▼
onExecutionFinish() is called
     │
     ▼
JVM Shutdown Hook registered
     │
     ▼
┌─────────────────────────────────┐
│  copyHistory()                  │  ← preserves trend data
│  generateReports(false)         │  ← full report folder
│  generateReports(true)          │  ← single .html file
│  renameReport()                 │  ← adds timestamp to filename
│  openReport()                   │  ← opens Allure server automatically
└─────────────────────────────────┘
The Allure CLI binary is downloaded and cached automatically on first run by AllureBinaryManager — no manual installation required.

Listener Registration
The listener is registered directly on each test class via the @Listeners annotation:

java
@Listeners(testNGListener.class)
public class loginTest extends baseTest { ... }
Report Output Paths
Report Type	Location
Single-file HTML	test-output/reports/AllureReport_<timestamp>.html
Full interactive	test-output/full-reports/
Raw results (JSON)	test-output/allure-results/
Screenshots	test-output/screenShots/
📦 Prerequisites
Java JDK 21+
Maven 3.8+
Google Chrome (latest)
Windows OS (the auto-open report feature uses cmd.exe)
Internet connection on first run (to download Allure CLI binary automatically)
⚙️ Installation & Setup
bash
# 1. Clone the repository
git clone https://github.com/mahmoud-bayoumi9/Saucedemo-QA-Automation-Testing.git

# 2. Navigate into the project
cd Saucedemo-QA-Automation-Testing

# 3. Install dependencies (Maven will also download the Allure binary on first use)
mvn clean install -DskipTests
▶️ Running the Tests
bash
# Run all tests
mvn test
That's it. Once the test run finishes:

The Allure report is generated automatically.
A new terminal window opens with the Allure local server running.
Your browser can access the report at the URL shown in that terminal (usually http://localhost:<port>).
To run a specific test class:

bash
mvn test -Dtest=loginTest
mvn test -Dtest=cartTest
📊 Test Output
After each run, the test-output/ folder contains:

test-output/
├── allure-results/       # JSON data files per test
├── reports/
│   └── AllureReport_YYYY-MM-DD_HH-mm-ss.html   # Portable single-file report
├── full-reports/
│   ├── index.html        # Full interactive report entry point
│   └── history/          # Trend data for next run
└── screenShots/
    ├── success_<testName>.png
    ├── fail_<testName>.png
    └── skip_<testName>.png
👤 Author
Mahmoud Bayoumi GitHub: @mahmoud-bayoumi9



