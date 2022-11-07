# MultiMVCI

A sample JavaFX project to demonstrate how to create an application with multiple screens and functions, focusing on techniques to connect them together.

This is the companion project to the article: http://www.pragmaticcoding.ca/multimvci.

# Introduction 

Many programmers seem to have difficulty envisioning how to construct a more complex application that has a number of different screens which are accessed via buttons or menu options, or simply contained within other layouts.  Particularly, programmers have find sharing data between different functions especially problematic.  This project, and its companion article explain how this can easily be done if you are using some kind of framework like MVC, MVP or MVVM.

This project uses my own framework, MVCI, which has similarities to both MVC and MVVM, but is structured for a Reactive design.  It also seems to be closer to how programmers generally think that MVC and MVVM should work, and splits out the responsibilities of each component in a more intuitive fashion.  You can find out more about MVCI at www.pragmaticcoding.ca/mvci

# Packages in the Project 

There are several different techniques for integrating screens and MVCI contstructs demonstrated in this project.  Each one is contained in a separate package.  They are simply numbered since the techniques don't have names:

## Function1

A fully autonomous function.  This is where an MVCI construct which is fully self contained and presents a Node which can be placed into another layout or into a Scene.  There's no communication or data sharing between this construct and the rest of the application.

## Function2 

A fully autonomous function presented as a custom Node class.  This is where an MVCI construct which is fully self contained and wrapped as an extension to a Node class which can be placed into another layout or into a Scene.  There's no communication or data sharing between this construct and the rest of the application.

## Function3

A function that presents as a custom Node class with the ability to bind a data element to one supplied by the containing screen.

## Function4

A function/screen contained within another screen with which it shares data.  

## Function5 

A screen which is launched in a new Scene by its containing screen.

## Function6

An enclosed function/screen which shares business logic with its containing screen, but also has its own business logic.


