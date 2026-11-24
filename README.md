# SkillPilots — Responsive CSS Styling for Thymeleaf Pages

## Run
Requirements: Java 17+ and Maven. Extract the ZIP, open this folder in VS Code, then run `mvn spring-boot:run`. Visit http://localhost:8080/books.

## Task implementation
1. Shared stylesheet: `src/main/resources/static/css/styles.css`.
2. Both Thymeleaf pages load it using `<link rel="stylesheet" th:href="@{/css/styles.css}">`.
3. Flexbox handles the page heading, form actions and responsive alignment.
4. CSS media queries make the book table stack into readable rows on small screens.
5. View the pages on desktop and narrow mobile widths to check the layout.

## Pages
- `/books` — list books and use Add, Edit, Delete.
- `/books/new` — add a book.
- `/books/{id}/edit` — edit a book.

The project uses an in-memory H2 database; records reset when the app stops.
