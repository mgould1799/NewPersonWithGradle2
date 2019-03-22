# WebService_Gradle

This is the latest person project with gradle. this project is to demostrate the gradle structure for CIRDLES.
The difference between this Person Project and the other is not only gradle, but the addition in the fxml. The fxml allows you to chose files to serialize and deserialize from.

Not only does this include new FXML functionality of chosing files to store Person objects in, it now includes a web service. As of right now, the web service just takes a string to in the URL to reverse it. To run this, run the Main.java within the Web Gradle. This will start the Jetty server. Next, travel to localhost/8080/service/reverse. This will will take a default string and reverse that, but if you wish to specify a specific value to reverse, type localhost/8080/service/reverse?source=some_value_you_wish_to_enter . 
