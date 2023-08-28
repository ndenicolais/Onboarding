# Onboarding
> <b>Author: Nicola De Nicolais</b>

## 📄 Description
Android application built with Kotlin and Jetpack Compose that shows how to create an Onboarding screen design process in Compose.<br/><br/>
Use an onboarding screen allow to show a first-time user how to get the most from your app, present information at app startup.<br/>
The onboarding screen can be understood as a virtual unboxing of an application. Users go through a series of screens which finally directs users to the application interface.<br/>
The purpose of Onboarding screen can have different aspects, for example:<br/>
- Welcome the user who opens the application for the first time.
- Describe the features of the application.
- Describe the features of the application.
- Allow users to register or log in.
- Allow users to customize certain aspects of the application.
- And many other customizations...

## 🔨  How to install and run the project
Clone this repository :<br/>
`
git clone https://github.com/ndenicolais/Onboarding.git
`

Import the project into Android Studio :

1. File -> New -> Import Project
2. Browse to <path_to_project>
3. Click "OK"

Create a new virtual device or connect an Android device to your computer.</br>
Click Run to start the project on the selected device.

## 🛠️ Built with
Kotlin</br>
Jetpack Compose</br>
Dagger Hilt</br>
Pager Layout

## 📚 Package Structure

```
com.denicks21.onboarding        # Root Package
│
├── di                          # DI FOLDER
│   ├── AppModule               # Inject repository in the constructor.
|
├── navigation                  # NAVIGATION FOLDER
│   ├── NavGraph                # Contains all of app destinations and actions.
│   └── NavScreens              # Contains a sealed class with object corresponds to a screen and its routes.
│   └── OnBoardingScreens       # Contains a sealed class with object corresponds to the onboarding's screen and its routes.
|
├── repository                  # REPOSITORY FOLDER
│   ├── DataStoreRepository     # Repository to access Dao.
|
├── screen                      # SCREENS FOLDER
|   │   ├── HomePage            # Main page of the app. It appear after clicking the final button.
|   │   ├── IntroPage           # Splashscreen of the app.
|   │   ├── OnBoardingPage      # Page containing onboarding structure.
│
├── ui                          # UI FOLDER
│   ├── composables             # Composable components folder
|   │   ├── BackPress           # Component that control and prevent back button action.
|   │   ├── FinishButton        # Button that completes the onboarding.
|   │   ├── TopElements         # Top elements of onboarding component.
|
├── theme                       # THEME FOLDER
|   │   ├── Color               # Color palette used by the app.
|   │   ├── Shape               # Components shapes of Compose used by the app.
|   │   ├── Theme               # Theme used by the app.
|   │   ├── Type                # Typography styles for the fonts used by the app.
|
├── viewmodels                  # VIEWMODELS FOLDER
|   │   ├── HomeViewModel       # Model that interact with repository class.
|   │   ├── IntroViewModel      # Model that interact with repository class.
│
├── MainActivity                # Main activity
├── OnBoarding                  # Trigger Hilt's code generation.
```

## 📎 Screenshots
<p float="left">
<img height="500em" src="images/screen.png" title="Onboarding's screen preview">
