🏠 Apartment Expense Manager - Android App
This Android application is designed to help manage shared expenses within an apartment. It allows users to track transactions, view balances, add new expenses, and maintain a clear record of who owes what — all through a simple and intuitive interface.

In addition to expense tracking, the app also offers the ability to manage a shared grocery list, making it easier for roommates to coordinate purchases.

🔒 Fully offline: The app works entirely locally and does not require an internet connection. All data is stored on the device using a local database.

✨ Key Features
Add and edit expenses with description, amount, and involved roommates

View individual balances for each roommate

Transaction history

Automatic calculation of each person's debits

Grocery list: add, edit, and check off items collaboratively

Offline-first: no network access required, all data is stored locally

🛠️ Technologies Used
Kotlin: native Android development

Room (DAO): for efficient and structured local database management

MVVM architecture: for clean separation of concerns and maintainable code

LiveData & ViewModel: for a reactive, auto-updating UI

📦 Local Database
The app uses a local SQLite database, accessed via the Room persistence library, to safely manage both expense records and grocery list items without needing any external server or internet access.


