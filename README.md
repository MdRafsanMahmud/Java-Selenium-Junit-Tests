# 🧪 Selenium-JUnit Automation Project

This repository contains professional-level automation projects using **Java**, **JUnit 5**, and **Selenium WebDriver**. The goal of these projects is to showcase real-world UI automation capabilities such as **form interaction**, **date picker automation**, **dynamic table scraping**, and **data persistence**, all tested under the JUnit framework.

---

## 📁 Project Overview

### ✅ 1. Web Form Automation (Video Included)

🔗 **Test URL**: [https://demo.wpeverest.com/user-registration/guest-registration-form/](https://demo.wpeverest.com/user-registration/guest-registration-form/)

#### 🔍 Description:
This test automates a user registration form that includes:
- Input fields (first name, last name, email, phone, nationality, etc.)
- Secure password entry
- Two date picker widgets for Date of Birth and Date of Arrival

#### ⚙️ Implementation Highlights:
- Form fields are located using a combination of:
  - `By.tagName()`
  - `By.className()`
  - `By.cssSelector()`
  - `By.id()`
    
- Dynamic dropdowns (Month & Year) handled using `Select` and `Keys`
- Date selection uses `aria-label` attributes to pinpoint correct days
- `Thread.sleep()` used to ensure DOM stability before interacting
- Assertions can be added for validation (e.g., successful submission)

---
### ✅ 2. DSE Price Table Extractor (Video Included)

🔗 **Target URL**: [https://dsebd.org/latest_share_price_scroll_by_value.php](https://dsebd.org/latest_share_price_scroll_by_value.php)

#### 🔍 Description:
This test focuses on **scraping a live dynamic table** from the Dhaka Stock Exchange (DSE) webpage and writing it to a local file.

#### ⚙️ Implementation Highlights:
- The table is located using:
  ```java
  WebElement table = driver.findElement(By.cssSelector(".table-responsive.inner-scroll table"));
  ```
- All table rows are retrieved using:
  ```java
  List<WebElement> rows = table.findElements(By.tagName("tr"));
  ```
- Each row’s `<td>` cells are iterated and extracted.
- Extracted data is:
  - Printed to the console
  - Saved to `src/test/resources/share_prices.txt` using `BufferedWriter`
- Ensures clean and structured data collection from dynamic content tables.

---

## 🛠️ Technologies Used

| Tool/Library        | Purpose                                     |
|---------------------|---------------------------------------------|
| Java 17+            | Programming language                        |
| Selenium WebDriver  | Browser automation                          |
| JUnit 5             | Test structure and annotations              |
| Gradle              | Build tool and dependency management        |
| ChromeDriver        | WebDriver for Chrome                        |
| HTML/CSS Selectors  | DOM element location strategies             |
| File I/O (Java)     | Writing scraped data to `src/test/resources/share_prices.txt` using `BufferedWriter`|

---


---

## 🎥 Demo Videos

### Web Form Automation
https://github.com/user-attachments/assets/f06b5412-81d6-437f-8107-d8c2dbb45f2e

## DSE Table Extractor
https://github.com/user-attachments/assets/a158a502-5b39-494d-b97c-4386ed0c381e

---
## ✅ Test Structure and Design

- 🧪 `@Test` methods are annotated for test detection
- 🧷 `@BeforeAll` and `@AfterAll` used for WebDriver setup/teardown
- 🧠 Efficient use of `List<WebElement>` to navigate multiple input fields
- 📅 Uses `Select`, `Keys`, and `aria-label` to handle modern date pickers
- 📦 Test results and generated files are stored in the `build` and `resources` folders respectively
---
## 🧾 Output

- ✅ Scraped table data saved as:  
  `src/test/resources/share_prices.txt`
---

## 👨‍💻 Author
**Md Rafsan Mahmud**
- 🔗 [LinkedIn](https://www.linkedin.com/in/mdrafsanmahmud/)
- ✉️ [Email](mailto:mdrafsanmahmud99@gmail.com)

---
