package ca.pragmaticcoding.widgetsfx.mvci;

/*
  Implementation of Model-View-Controller-Interactor for JavaFX.
  <p>
  This construct marries Model-View-Controller with
  Entity-Boundary-Controller to provide a framework to allow
  a JavaFX GUI to interact with external API's, a persistence layer
  and other non-GUI aspects of an application.  Coupling is kept to
  a minimum.
  <p>
  Elements:
  <p>
  Model -      Model should be a POJO with JavaFX Observable classes as
  the fields.
  <p>
  View -       Strictly the GUI layout, elements in the GUI should be bound
  to the fields in the Model as required.  This way the View
  and the Model are constantly in sync.
  <p>
  Controller - The Controller handles instantiation of all of the other elements
  and all of the threading required to handle non-GUI processing
  off the FXAT
  <p>
  Interactor - The Interactor contains all of the business logic and interface
  to the non-GUI aspects of the system.  The Interactor is given
  a reference to the Model, and is able to read from it and update
  it as appropriate.
  <p>
  It is recommended that JavaFX classes are extended only to broaden their functionality
  and that they are not extended merely for configuration.  For this reason, the View
  is to be constructed by an implementation of the Builder interface.
 */