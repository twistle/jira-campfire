import com.atlassian.jira.issue.comments.Comment

class MockComment implements Comment{
  String body

  //Junk not needed for the tests but needed to satisfy the interface
  com.atlassian.crowd.embedded.api.User getAuthorUser(){}
  com.atlassian.crowd.embedded.api.User getUpdateAuthorUser(){}
  com.atlassian.jira.issue.Issue getIssue(){}
  com.atlassian.jira.security.roles.ProjectRole getRoleLevel(){}
  com.opensymphony.user.User getAuthorObject(){}
  com.opensymphony.user.User getUpdateAuthorObject(){}
  java.lang.Long getId(){}
  java.lang.Long getRoleLevelId(){}
  java.lang.String getAuthor(){}
  java.lang.String getAuthorFullName(){}
  java.lang.String getGroupLevel(){}
  java.lang.String getUpdateAuthor(){}
  java.lang.String getUpdateAuthorFullName(){}
  java.util.Date getCreated(){}
  java.util.Date getUpdated(){}

}
