import com.atlassian.crowd.embedded.api.User

class MockUser implements User {
  String displayName

  //Junk not needed for the tests but needed to satisfy the interface
  boolean isActive(){}
  int compareTo(com.atlassian.crowd.embedded.api.User u){}
  int compareTo(java.lang.Object o){}
  java.lang.String getEmailAddress(){}
  java.lang.String getName(){}
  long getDirectoryId(){}
}
