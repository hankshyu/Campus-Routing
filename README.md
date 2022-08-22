# NCTU-routing - A campus route guiding project

<img alt="GitHub License" src="https://img.shields.io/github/license/hankshyu/Campus-Routing?color=orange&logo=github"> <img alt="GitHub release (latest SemVer)" src="https://img.shields.io/github/v/release/hankshyu/Campus-Routing?color=orange&logo=github"> <img alt="GitHub language count" src="https://img.shields.io/github/languages/count/hankshyu/Campus-Routing"> <img alt="GitHub top language" src="https://img.shields.io/github/languages/top/hankshyu/Campus-Routing"> <img alt="Lines of code" src="https://img.shields.io/tokei/lines/github/hankshyu/Campus-Routing"> <img alt="GitHub code size in bytes" src="https://img.shields.io/github/languages/code-size/hankshyu/Campus-Routing"> <img alt="GitHub contributors" src="https://img.shields.io/github/contributors/hankshyu/Campus-Routing?logo=git&color=green"> <img alt="GitHub commit activity" src="https://img.shields.io/github/commit-activity/y/hankshyu/Campus-Routing?logo=git&color=green"> <img alt="GitHub last commit" src="https://img.shields.io/github/last-commit/hankshyu/Campus-Routing?logo=git&color=green">

<img alt="GitHub Repo stars" src="https://img.shields.io/github/stars/hankshyu/Campus-Routing?style=social"> <img alt="GitHub watchers" src="https://img.shields.io/github/watchers/hankshyu/Campus-Routing?style=social">


<h2>Scenario -Am I on the right path?</h2>

### "From here to there via that"
Since the corona-virus struct the world, people would like to keep distances between pedestrians to avoid infections. People tried to minimise the distance they take when travel
between destinations. NCTU desperately needs a guiding system to indicate students between classes to take the right path to the next course. Obviously, students would like to pick up snacks between classes in case of their stomoch rumble.
 
---
## IPO model

- Input: School map / Current Location / Destination
- Process: Pathfinding Algorithms (A* & Greedy)
- Output: Map with path labeled

---
## Configuratons
- Add the file path of a txt file which the Map with path labeled will be stored
---

## Class diagram
![Class Diagram](https://user-images.githubusercontent.com/67572824/86504523-fbf01180-bdeb-11ea-8746-f9cadf4a28d1.jpg)

---
## What's to improve?
- Add more maps to provide users choices(It is easy to do so due to objects)
- Bigger array size to provide smooth experience
- By locating the object of the destination to show the information
- Write a search system to allow user to search for spots, or by big data, suggest common choices for user.
- Adding height parameter to each tile, put climbing into account
- By big data and AI, predict the final destination when input the current location.
- By big data, calulate the most taken path and set it crowded.
- GUI to interact with users

