
# **MovieMood**

## Table of Contents

1. [App Overview](#App-Overview)
1. [Product Spec](#Product-Spec)
1. [Wireframes](#Wireframes)
1. [Build Notes](#Build-Notes)

## App Overview

### Description 

**MovieMood is a mobile app that recommends movies based on how the user feels. Users select a mood (Happy, Chill, Sad, or Excited), and the app retrieves tailored movie lists from TheMovieDB (TMDB). Each result shows posters, titles, and ratings. Selecting a movie opens a detailed screen with full overview, release date, rating, and large poster art. The app makes choosing films easier, helping users discover what fits their mood instantly.**

### App Evaluation

<!-- Evaluation of your app across the following attributes -->

- **Category: Entertainment/Lifestyle**
- **Mobile: Great use of mobile UI through mood buttons, swipeable cards, and scrolling posters. Designed for on‑the‑go discovery and quick browsing.**
- **Story: Solves a relatable problem which is choosing a movie. The emotional tie in of mood enhances engagement.**
- **Market: Broad audience including college students, movie lovers, and streaming users.**
- **Habit: Medium–high; users may check the app frequently for ideas before watching.**
- **Scope: Clear MVP, mood selection, movie list display using TheMovieDB API, and movie details screen. Optional features like watchlists or trailers can be added later.**

## Product Spec

### 1. User Features (Required and Optional)

Required Features:

- User selects a mood (e.g., happy, chill, sad, excited).
- App fetches a list of recommended movies using TheMovieDB API.
- Movie RecyclerView shows movie poster, title, overview preview, and rating (converted from TMDB score to 5-star scale).
- User can tap a movie to see a detail page with overview, genre, release date, and large poster.
- Light UI theme across main list and detail screen.
- Basic navigation between Home (mood selector), Results (movie list), and Details screens.


### 2. Chosen API(s)

- TheMovieDB API (TMDB)
  - Used to retrieve movie data (titles, posters, overviews, ratings, genres, release dates).
  - Require Feature: Displaying movie results by mood.
- Endpoint examples:
    - /discover/movie?sort_by=popularity.desc&with_genres=
    - /search/movie?query=
    - https://image.tmdb.org/t/p/w500{poster_path}

### 3. User Interaction

Required Feature

- **Select Mood **
  - => **User taps a mood icon or button (e.g., “Happy”).**
  - => **App calls TMDB API for movies that match that mood.**
  - => **Returns a scrollable list of movie cards.**
- **View Movie Details**
  - => **User taps a movie card.**
  - => **Opens a detailed screen showing title, description, rating, release year, and large poster.**
- **Navigate Home → Results → Details → Back**
    - => **Simple navigation bar or back arrow.**


## Wireframes

<!-- Add picture of your hand sketched wireframes in this section -->
<img src="./MoodApp Wireframe/home.svg" width=600>
<img src="./MoodApp Wireframe/loading.svg" width=600>
<img src="./MoodApp Wireframe/mood_selection.svg" width=600>
<img src="./MoodApp Wireframe/movie_detail.svg" width=600>
<img src="./MoodApp Wireframe/recommendations.svg" width=600>
<img src="./MoodApp Wireframe/settings.svg" width=600>

## Build Notes

- Use Android Studio + Kotlin (or Swift if iOS group) to build UI and API integration.
- TMDB API key stored securely (not hardcoded in codebase).
- Consider using RecyclerView for movie list display.
- MVP delivery: mood selection → movie list → movie detail.



For Milestone 2, here is the progress of our app!       
**![MoodMatch Demo](https://github.com/user-attachments/assets/df302880-a62e-4997-ad62-9b3b53b517a2)
**

## License

Copyright **2025** **Ondrea Wagner**

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
