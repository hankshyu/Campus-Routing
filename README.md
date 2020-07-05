# NCTU-routing - A route guiding project
## Version 1.0.3
What's New in 1.0.3?
- Bug fixed : The crowded function now works properly.

- Improvement : Users now enter the number representing the building, which is a lot easier.

- Added features :

  - More detailed settings in crowded options! There are level 1 to 10 crowdedness to choose from, which generates pedestrians randomly on the map to imitate the crowded campus!

  - New added relay points to users! You may enter current location, destination and some midway destinations ! The greedy algorithm calculates the path for you automatically!

  - It shows the entire path now so it is clear for users!

---
## Scenario -Am I on the right path?
### "From here to there via that"

 
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

## What's to improve?
- Add more maps to provide users choices(It is easy to do so due to objects)
- Bigger array size to provide smooth experience
- By locating the object of the destination to show the information
- Write a search system to allow user to search for spots, or by big data, suggest common choices for user.
- Adding height parameter to each tile, put climbing into account
- By big data and AI, predict the final destination when input the current location.
- By big data, calulate the most taken path and set it crowded.
- GUI to interact with users

## Copyrights 
- hankshyu(hankshyu@gmail.com)
