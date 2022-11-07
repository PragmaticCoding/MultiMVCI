# MultiMVCI

A sample JavaFX project to demonstrate how to create an application with multiple screens and functions, focusing on techniques to connect them together.

This is the companion project to the article: www.pragmaticcoding.ca/multimvci.

## Packages in the Project 

There are several different techniques for integrating screens and MVCI contstructs demonstrated in this project.  Each one is contained in a separate package.  They are simply numbered since the techniques don't have names:

### Function1

A fully autonomous function.  This is where an MVCI construct which is fully self contained and presents a Node which can be placed into another layout or into a Scene.  There's no communication or data sharing between this construct and the rest of the application.

### Function2 

A fully autonomous function presented as a custom Node class.  This is where an MVCI construct which is fully self contained and wrapped as an extension to a Node class which can be placed into another layout or into a Scene.  There's no communication or data sharing between this construct and the rest of the application.

### Function3



### Function4

A function/screen contained within another screen with which it shares data.  

### Function5 


### Function6
