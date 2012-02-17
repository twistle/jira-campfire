import com.atlassian.jira.issue.MutableIssue

class MockIssue implements MutableIssue {
  String key
  String summary
  String description

  //Junk not needed for the tests but needed to satisfy the interface
  boolean isCreated(){}
  boolean isEditable(){}
  boolean isSubTask(){}
  com.atlassian.crowd.embedded.api.User getAssigneeUser(){}
  com.atlassian.crowd.embedded.api.User getReporterUser(){}
  com.atlassian.jira.issue.fields.renderer.IssueRenderContext getIssueRenderContext(){}
  com.atlassian.jira.issue.Issue getParentObject(){}
  com.atlassian.jira.issue.issuetype.IssueType getIssueTypeObject(){}
  com.atlassian.jira.issue.priority.Priority getPriorityObject(){}
  com.atlassian.jira.issue.resolution.Resolution getResolutionObject(){}
  com.atlassian.jira.issue.status.Status getStatusObject(){}
  com.atlassian.jira.project.Project getProjectObject(){}
  com.opensymphony.user.User getAssignee(){}
  com.opensymphony.user.User getReporter(){}
  java.lang.Long getEstimate(){}
  java.lang.Long getId(){}
  java.lang.Long getLong(java.lang.String foo){}
  java.lang.Long getOriginalEstimate(){}
  java.lang.Long getParentId(){}
  java.lang.Long getSecurityLevelId(){}
  java.lang.Long getTimeSpent(){}
  java.lang.Long getVotes(){}
  java.lang.Long getWatches(){}
  java.lang.Long getWorkflowId(){}
  java.lang.Object getCustomFieldValue(com.atlassian.jira.issue.fields.CustomField cf){}
  java.lang.Object getExternalFieldValue(java.lang.String foo){}
  java.lang.String getAssigneeId(){}
  java.lang.String getEnvironment(){}
  java.lang.String getReporterId(){}
  java.lang.String getString(java.lang.String foo){}
  java.sql.Timestamp getCreated(){}
  java.sql.Timestamp getDueDate(){}
  java.sql.Timestamp getResolutionDate(){}
  java.sql.Timestamp getTimestamp(java.lang.String foo){}
  java.sql.Timestamp getUpdated(){}
  java.util.Collection getAffectedVersions(){}
  java.util.Collection getAttachments(){}
  java.util.Collection getComponentObjects(){}
  java.util.Collection getComponents(){}
  java.util.Collection getFixVersions(){}
  java.util.Collection getSubTaskObjects(){}
  java.util.Collection getSubTasks(){}
  java.util.Map getModifiedFields(){}
  java.util.Set getLabels(){}
  org.ofbiz.core.entity.GenericValue getGenericValue(){}
  org.ofbiz.core.entity.GenericValue getIssueType(){}
  org.ofbiz.core.entity.GenericValue getParent(){}
  org.ofbiz.core.entity.GenericValue getPriority(){}
  org.ofbiz.core.entity.GenericValue getProject(){}
  org.ofbiz.core.entity.GenericValue getResolution(){}
  org.ofbiz.core.entity.GenericValue getSecurityLevel(){}
  org.ofbiz.core.entity.GenericValue getStatus(){}
  void resetModifiedFields(){}
  void setAffectedVersions(java.util.Collection c){}
  void setAssignee(com.atlassian.crowd.embedded.api.User u){}
  void setAssignee(com.opensymphony.user.User u){}
  void setAssigneeId(java.lang.String s){}
  void setComponents(java.util.Collection c){}
  void setCreated(java.sql.Timestamp ts){}
  void setCustomFieldValue(com.atlassian.jira.issue.fields.CustomField cf, java.lang.Object o){}
  void setDueDate(java.sql.Timestamp ts){}
  void setEnvironment(java.lang.String s){}
  void setEstimate(java.lang.Long l){}
  void setExternalFieldValue(java.lang.String s, java.lang.Object o){}
  void setExternalFieldValue(java.lang.String s, java.lang.Object o, java.lang.Object o2){}
  void setFixVersions(java.util.Collection c){}
  void setIssueType(org.ofbiz.core.entity.GenericValue gv){}
  void setIssueTypeId(java.lang.String s){}
  void setLabels(java.util.Set s){}
  void setOriginalEstimate(java.lang.Long l){}
  void setParentId(java.lang.Long l){}
  void setParentObject(com.atlassian.jira.issue.Issue i){}
  void setPriority(org.ofbiz.core.entity.GenericValue gv){}
  void setPriorityId(java.lang.String s){}
  void setProject(org.ofbiz.core.entity.GenericValue gv){}
  void setProjectId(java.lang.Long l){}
  void setReporter(com.atlassian.crowd.embedded.api.User u){}
  void setReporter(com.opensymphony.user.User u){}
  void setReporterId(java.lang.String s){}
  void setResolution(org.ofbiz.core.entity.GenericValue gv){}
  void setResolutionDate(java.sql.Timestamp ts){}
  void setResolutionId(java.lang.String s){}
  void setSecurityLevel(org.ofbiz.core.entity.GenericValue gv){}
  void setSecurityLevelId(java.lang.Long l){}
  void setStatus(org.ofbiz.core.entity.GenericValue gv){}
  void setStatusId(java.lang.String s){}
  void setTimeSpent(java.lang.Long l){}
  void setUpdated(java.sql.Timestamp ts){}
  void setVotes(java.lang.Long l){}
  void setWatches(java.lang.Long l){}
  void setWorkflowId(java.lang.Long l){}
  void store(){}
}
