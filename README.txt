****README File for DataLayerUpdateServer Repository
****Version: 1.0, May 30, 2015

****Overview
The DataLayerUpdateServer repository contains a web service for determining if data sources that are used by FITTEST Location Services are out of date. 

****Technical Details

1) The web service is being developed in Eclipse.
2) Java is the programming language.

****Work Completed to Date

1) The web service currently allows the user to get the date of datasets hosted on the Humanitarian Response and the HDX web sites. This date can be used to determine if the date of the dataset hosted on FITTEST Location Services is the most recent one.

****Other Notes:

1) The endpoint publisher is currently hardcoded, in the file DataLayerUpdatePublisher.java, so that the web service is run from the developer's local host. This will have to be altered when the tool is deployed. 