# ComposeOnBoarding
> <b>Author: Nicola De Nicolais</b>

## 📍 Description
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
git clone https://github.com/ndenicolais/ComposeOnBoarding.git
`

Import the project into Android Studio :

1. File -> New -> Import Project
2. Browse to <path_to_project>
3. Click "OK"

## 🛠️ Built with
#### Dagger Hilt

Hilt is a dependency injection library for Android that reduces the boilerplate of doing manual dependency injection in your project. Hilt provides a standard way to use DI in your application by providing containers for every Android class in your project and managing their lifecycles automatically. Hilt is built on top of the popular DI library Dagger to benefit from the compile-time correctness, runtime performance, scalability, and Android Studio support that Dagger provides.

### Jetpack Compose
#### Navigation

Navigation refers to the interactions that allow users to navigate across, into, and back out from the different pieces of content within your app. Android Jetpack's Navigation component helps you implement navigation, from simple button clicks to more complex patterns, such as app bars and the navigation drawer.

#### ViewModel

The ViewModel class is a business logic or screen level state holder. It exposes state to the UI and encapsulates related business logic. Its principal advantage is that it caches state and persists it through configuration changes. This means that your UI doesn’t have to fetch data again when navigating between activities, or following configuration changes, such as when rotating the screen.

#### Pager
A library which provides paging layouts for Jetpack Compose. It has similar proprieties of Android's ViewPager.

## 📚 Package Structure

```
com.denicks21.roomdatabase      # ROOT PACKAGE
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
│   ├── components              # Composable components folder
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
<img height="500em" src="screenshots/Screenshot01.png" title="Onboarding's screen preview">
<img height="500em" src="screenshots/Screenshot02.png" title="Onboarding's screen preview">
<img height="500em" src="screenshots/Screenshot03.png" title="Onboarding's screen preview">

## 📃 License
MIT License

Copyright 2023 Nicola De Nicolais

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.