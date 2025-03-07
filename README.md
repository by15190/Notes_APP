# Notes App

A modern Android notes application built with MVVM architecture and Room database, following Android best practices and Material Design guidelines.

## Features

- Create, read, update, and delete notes
- Rich text formatting support
- Categories and tags for better organization
- Search functionality
- Dark mode support
- Backup and restore capabilities
- Share notes functionality

## Architecture

This application follows the MVVM (Model-View-ViewModel) architecture pattern and incorporates Android Architecture Components:

- **Model**: Represents the data layer using Room database
- **View**: UI layer with Activities and Fragments
- **ViewModel**: Manages UI-related data and business logic
- **Repository**: Single source of truth for data operations

### Tech Stack

- Kotlin
- Android Architecture Components
  - Room Database
  - ViewModel
  - LiveData
  - Coroutines
- Material Design Components
- ViewBinding
- Dependency Injection with Hilt
- Unit Testing with JUnit and Mockito
- UI Testing with Espresso

## Project Structure

```
app/
├── data/
│   ├── local/
│   │   ├── dao/
│   │   ├── entities/
│   │   └── database/
│   └── repository/
├── di/
├── domain/
│   └── model/
├── ui/
│   ├── notes/
│   │   ├── list/
│   │   └── detail/
│   └── common/
└── utils/
```

## Getting Started

### Prerequisites

- Android Studio Arctic Fox or later
- Android SDK 21 or higher
- Kotlin 1.5 or higher

### Installation

1. Clone the repository:
```bash
git clone https://github.com/by1590/Notes_APP.git
```

2. Open the project in Android Studio

3. Sync project with Gradle files

4. Run the app on an emulator or physical device

## Database Schema

### Note Entity
```kotlin
@Entity(tableName = "notes")
data class Note(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val title: String,
    val content: String,
   l̥
)
```

## Contributing

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request


## Acknowledgments

- [Android Architecture Components](https://developer.android.com/topic/libraries/architecture)
- [Material Design](https://material.io/design)
- [Android Room Database](https://developer.android.com/training/data-storage/room)
