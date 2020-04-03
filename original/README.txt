Program 1 README
Feb 1, 2020

Written by Emmanuel Borishade (List210 & Tester Written by Prof. Bill)
WheelOfFate Project:
What it does:
    1. WheelOfFate creates a Spin-the-Wheel, where items are added to the list, then randomly selected. 
    2. When spun, items are displayed then removed from the list, ensuring all items are eventually displayed.
    3. List can be reloaded at any time, restoring all data from just before the wheel was spun.
    4. other commands are available as well; see javadocs for specifics, or run program. 

How it works:
 WheelOfFate.java:
    1. This file is run, and commands are entered into the command prompt. Available commands will 
    be displayed when program is run. 
    2. Commands are taken from Wheel.java

Wheel.java
    1. This file contains the commands to be used in WheelOfFate.java 
    2. Wheel uses the EList.java to handle items [strings].

EList.java
    1. Linked List using nodes from ENode.java
    2. Each time an item is added, a new ENode is created, and set to point to previous and next ENodes
    2. keeps track of head and tail of list, and provides copy constructor

ENode.java
    1. holds a single string as current value
    2. can point to previous and next ENode. 

