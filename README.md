# FixtureDrawer

Fixture drawing application for a soccer league

* Gets teams from REST API
* Shows teams on main screen
* Draws fixture and displays weekly matchups in swipeable view


<h3>Tech</h3>

* [MVVM Architecture](https://developer.android.com/jetpack/guide)
* [Hilt](https://dagger.dev/hilt/) - Dependency Injection
* [RxJava](https://github.com/ReactiveX/RxJava) - Asynchronous Programming
* [Retrofit](https://square.github.io/retrofit/) - Networking
* [Glide](https://bumptech.github.io/glide/) - Image Loading
* [ViewPager](https://developer.android.com/guide/navigation/navigation-swipe-view-2) - For Swipeable UI

<h3>Fixture Algorithm</h3>

* Take the first team in team list and match with last item of the list.
* While holding the first team at index 0, set the last team's index to 1 and put the other teams in the same order.
* Iterate the above statements for each matchup and each week.
* _If the team size is odd, add a fake team with "id = -1" and apply the same algorithm. Matchups with the fake team counts as bye._

<h3>Mock API</h3>

https://6204cfde161670001741af6f.mockapi.io/api/teams

