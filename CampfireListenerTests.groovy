import groovy.util.GroovyTestCase

import com.atlassian.jira.event.AbstractEvent
import com.atlassian.jira.event.issue.IssueEvent
//import org.ofbiz.core.util.GeneralException

import static com.atlassian.jira.event.type.EventType.*
 
class CampfireListenerTest extends GroovyTestCase{

 void testPasteToCampfire(){
   def cfListener = new CampfireListener();
   cfListener.campfireKey=""
   cfListener.campfireRoom="000000"
   cfListener.campfireBaseUrl="https://COMAPNY.campfirenow.com/"
   cfListener.issueBaseUrl="http://jira.COMPANY.com/browse"
   
   def mIssue = new MockIssue()
   mIssue.key = "MOCK-001"
   mIssue.summary = "Mock Summary"
   mIssue.description = "Mock description"

   def mUser = new MockUser()
   mUser.setDisplayName("Mock User")

   def mWorklog = new MockWorklog()
   def mComment = new MockComment()
   mComment.body = "Mock Comment"

//   org.ofbiz.core.entity.GenericValue mChangeGroup = null
//   def issueEvent = new IssueEvent(mIssue, mUser, mComment, mWorklog, null, new java.util.HashMap(), ISSUE_COMMENTED_ID)
   def issueEvent = new IssueEvent(mIssue, new java.util.HashMap(), mUser, ISSUE_COMMENTED_ID)
   cfListener.workflowEvent(issueEvent)
 }

 void testIssueCreatedToCampfire(){
   def cfListener = new CampfireListener();
   cfListener.campfireKey=""
   cfListener.campfireRoom="000000"
   cfListener.campfireBaseUrl="https://COMAPNY.campfirenow.com/"
   cfListener.issueBaseUrl="http://jira.COMPANY.com/browse"
   
   def mIssue = new MockIssue()
   mIssue.key = "MOCK-001"
   mIssue.summary = "Mock Summary"
   mIssue.description = "Mock description"

   def mUser = new MockUser()
   mUser.setDisplayName("Mock User")

   def mWorklog = new MockWorklog()
   def mComment = new MockComment()
   mComment.body = "Mock Comment"

//   org.ofbiz.core.entity.GenericValue mChangeGroup = null
//   def issueEvent = new IssueEvent(mIssue, mUser, mComment, mWorklog, null, new java.util.HashMap(), ISSUE_COMMENTED_ID)
   def issueEvent = new IssueEvent(mIssue, new java.util.HashMap(), mUser, ISSUE_CREATED_ID)
   cfListener.workflowEvent(issueEvent)
 }


}
