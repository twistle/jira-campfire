import groovy.util.GroovyTestCase

import com.atlassian.jira.event.AbstractEvent
import com.atlassian.jira.event.issue.IssueEvent
//import org.ofbiz.core.util.GeneralException

import static com.atlassian.jira.event.type.EventType.*
 
class CampfireListenerTest extends GroovyTestCase{

 def getCampfireListener(){
   def cfListener = new CampfireListener();
   cfListener.campfireKey=""
   cfListener.campfireRoom=000000
   cfListener.campfireBaseUrl="https://COMPANY.campfirenow.com/"
   cfListener.issueBaseUrl="http://jira.COMPANY.com/"
   return cfListener;
 }

 def getStandardIssueEvent(Long eventType){
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
//   def issueEvent = new IssueEvent(mIssue, mUser, mComment, mWorklog, null, new java.util.HashMap(), eventType)
   def issueEvent = new IssueEvent(mIssue, new java.util.HashMap(), mUser, eventType)
   return issueEvent
 }
 
 void testIssueCommentToCampfire(){
   def cfListener = getCampfireListener()
   cfListener.processIssueEvent(getStandardIssueEvent(ISSUE_COMMENTED_ID))
 }

 void testIssueCreatedToCampfire(){
   def cfListener = getCampfireListener()
   cfListener.processIssueEvent(getStandardIssueEvent(ISSUE_CREATED_ID))
 }
}
