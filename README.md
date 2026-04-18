This project is a Spring Boot web application designed to process raw Excel files containing student exam results in a specific template (Ayşeabla Schools format). It cleans the data, ranks students based on their total net scores, and generates a streamlined, professional report.

🚀 Features
Data Cleansing: Automatically detects and filters out invalid rows, such as class averages (e.g., "5A") or "Total Student" counts, ensuring they do not interfere with the ranking.

Detailed Subject Analysis: Specifically extracts net scores for Mathematics, Science, Turkish, Social Studies, Religious Culture (DKAB), and English from the raw data and dynamically maps them to the new report.

Smart Ranking: Sorts students in descending order based on their total net points.

User-Friendly Web Interface: Offers a seamless file upload and instant download experience through a browser, eliminating the need for complex terminal commands.

In-Memory Processing: Uploaded files are processed directly in memory (RAM) via byte[] streams without being saved to the server's disk, ensuring high performance and data security.

🛠️ Tech Stack
Backend: Java 21, Spring Boot

Data Processing: Apache POI (OOXML)

Frontend: HTML5, CSS3

Dependency Management & Build: Maven

