Program 3 README
April 2, 2020

Written by Emmanuel Borishade
WheelOfFate GUI Project:

Status: 
 -Stable, logical error when user adds a comma between words during "Add" command.
    breaks syncronicity with wheel because wheel.print() in original.Wheel.java 
    returns a string rather than an array

How it Works:
 1. Run WheelGUI on system that can run javafx
 2. Application will open allowing you to add items to a wheel.
 3. First add some items, then perhaps spin it around.
 4. Spinning will delete items from the list so it cannot be chosen again; can be undone with "reload" button.

 Creative Element:
  It actually spins! 
  Buttons and wheel label have css styling (border + color)
  ButtonJobs static class usage
