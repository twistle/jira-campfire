Send Jira event notifications to Campfire using the Jira [Script Runner](https://plugins.atlassian.com/plugin/details/6820) plugin.

Installation
------------
In the Jira administration naviage to the Script Listeners page (under the Plugins dropdown, or by searching).
Create a new "Custom listener" and follow the provided instructions. You can select all of the events and only
the ones implimented in the CampfireListener class will actually trigger anything. The others will be silently
ignored by the class.

More generic details can be found on the [Script Runner wiki](https://studio.plugins.atlassian.com/wiki/display/GRV/Listeners).

Testing
-------

Misc.
-----
Original inspiration: [belchak.com](http://www.belchak.com/2012/01/21/jira-and-campfire-integration/). The biggest
difference from this version is the use of the Apache Commons HttpClient instead of HTTPBuilder. Using HTTPBuilder is a
little bit prettier, but means that the listener has external dependencies. Jira already relies on HttpClient so
we're guaranteed to have that available.