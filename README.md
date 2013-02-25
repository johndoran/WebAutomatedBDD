About
-------
Sample project to test out some ui bdd with groovy
 - using geb for driving the web navgation + manipulation
 - tests against a js heavy site (http://m.jetstar.com)
 - feature tests for home + search flight pages

Setup
-------
'gradle clean idea'
'gradle test'
check build/cucumber for reports + json output for hudson plugin

TODO
-------
* 'gradle test' doesn't fail even a feature fails. Works in IntelliJ
