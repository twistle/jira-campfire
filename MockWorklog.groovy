import com.atlassian.jira.issue.worklog.Worklog

class MockWorklog implements Worklog{

  //Junk not needed for the tests but needed to satisfy the interface
  com.atlassian.jira.issue.Issue getIssue(){}
  com.atlassian.jira.security.roles.ProjectRole getRoleLevel(){}
  java.lang.Long getId(){}
  java.lang.Long getRoleLevelId(){}
  java.lang.Long getTimeSpent(){}
  java.lang.String getAuthor(){}
  java.lang.String getAuthorFullName(){}
  java.lang.String getComment(){}
  java.lang.String getGroupLevel(){}
  java.lang.String getUpdateAuthor(){}
  java.lang.String getUpdateAuthorFullName(){}
  java.util.Date getCreated(){}
  java.util.Date getStartDate(){}
  java.util.Date getUpdated(){}
}
