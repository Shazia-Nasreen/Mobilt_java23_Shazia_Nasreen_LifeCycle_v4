Project Report: Android Application with SharedPreferences
This project involves creating an Android application that utilizes SharedPreferences to manage user login data and preferences. The app consists of three main activities: LoginActivity, RegistrationActivity, and FormActivity, each providing essential features for the user.

LoginActivity: The app starts with the LoginActivity, where users can log in using a predefined username and password. If the user is already logged in, they are automatically redirected to the FormActivity using SharedPreferences to store the login status. Invalid credentials trigger a toast message, prompting the user to re-enter their credentials.

RegistrationActivity: Users can create an account in this activity by entering a new username and password. The input is validated, and if successful, the credentials are saved in SharedPreferences. A success message is shown, and the user is prompted to proceed to the login screen.

FormActivity: Once logged in, the user is directed to the FormActivity, where they can fill out a form with personal information such as age, email, gender, and license status. The form data is saved in SharedPreferences, and a confirmation message is displayed upon successful data submission.

Additionally, the app includes a Logout feature, where the user can log out by clearing the login status from SharedPreferences, ensuring a secure and smooth user experience.
![mindmap](https://github.com/user-attachments/assets/102a8903-b261-4556-a213-194c1f38ade0)
