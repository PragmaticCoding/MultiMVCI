/**
 * This library contains custom JavaFX classes derived from standard JavaFX nodes
 * and controls, and static classes with convenience methods designed to make
 * creating GUI screens simple and streamlined.  It removes repetition of code
 * and elimates much of the boilerplate associated with JavaFX.<br>
 * <br>
 *
 * This library is intended to be used with a complimentary CSS file.  The supplied
 * CSS file is called "widgetsfx.css" and needs to be added to the stylesheets
 * loaded into the scene in which the custom widgets are used.  The following syntax
 * should work:<br>
 * <br>
 *
 *      <code>scene.getStylesheets().add(getClass().getResource("/css/default.css").toExternalForm());</code><br>
 * <br>
 *
 *  Colours in the style sheet are designed to work reasonably from two base colours:  -theme-colour
 *  and -contrast-colour.  Most other colours used in the widgets are derived from these two colours.
 *  Further integration with the standard widgets can be achieved by changing base colours from the
 *  standard style sheet with colours derived from -theme-colour and -contrast-colour.<br>
 */
package ca.pragmaticcoding.widgetsfx;

