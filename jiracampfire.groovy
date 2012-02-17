import com.atlassian.jira.event.issue.AbstractIssueEventListener
import com.atlassian.jira.event.issue.IssueEvent
import com.atlassian.jira.ComponentManager
import org.apache.log4j.Category
import org.apache.commons.httpclient.HttpClient
import org.apache.commons.httpclient.UsernamePasswordCredentials
import org.apache.commons.httpclient.auth.AuthScope
import org.apache.commons.httpclient.methods.PostMethod

import static com.atlassian.jira.event.type.EventType.*
 
class CampfireListener extends AbstractIssueEventListener {
 
    @Override
    void workflowEvent(IssueEvent event) {
        // Your campfire API key
        def campfireKey = "YOUR KEY GOES HERE"
        // The room you want to post to in numeric format 
        def campfireRoom = "000000"
        // The base url for your campfire instance
        // https://COMPANY.campfirenow.com/
        def campfireBaseUrl = "https://COMPANY.campfirenow.com/"
        // Jira base url for browsing 
        // https://jira.COMPANY.com/browse
        def issueBaseUrl = "https://jira.COMPANY.com/browse/"

        def speakUrlPath = "speak.json"

        def Category log = Category.getInstance("com.onresolve.jira.groovy.PostFunction")

        def campfireUrl = campfireBaseUrl + "/room/" + campfireRoom + "/"
        def campfireSpeakUrl = campfireUrl + "/room/" + campfireRoom + "/" + speakUrlPath

        def httpClient = new HttpClient()
        def authScope = new AuthScope(null, 443, null)
        def upc = new UsernamePasswordCredentials(campfireKey, 'X')
        httpClient.getState().setCredentials(authScope, upc)
        httpClient.getParams().setAuthenticationPreemptive(true)

        PostMethod postMethod = new PostMethod(campfireSpeakUrl)
        postMethod.setDoAuthentication(true)
        postMethod.setRequestHeader("ContentType", "application/json")

        switch (event.getEventTypeId()) {
            case ISSUE_COMMENTED_ID:
              def content = String.format("%s added a comment to %s (%s%s):",
                              event.getUser().getDisplayName(),
                              event.issue.getKey(),
                              issueBaseUrl,
                              event.issue.getKey())

              def msgBody = '[ message: [ type: "TextMessage", body: ' + content + '] ]'

              postMethod.setRequestBody(content)
              client.executeMethod(postMethod)
              def resp = postMethod.getResponseBodyAsString()

              content = String.format("%s", event.getComment().getBody())
              msgBody = '[ message: [ type: "PasteMessage", body: ' + content + '] ]'


              postMethod.setRequestBody(content)
              client.executeMethod(postMethod)
              resp = postMethod.getResponseBodyAsString()

              break
            case ISSUE_CREATED_ID:
              def content = String.format("%s created a new issue: %s (%s%s):",
                              event.getUser().getDisplayName(),
                              event.issue.getSummary(),
                              issueBaseUrl,
                              event.issue.getKey())

              def msgBody = '[ message: [ type: "TextMessage", body: ' + content + '] ]'

              postMethod.setRequestBody(content)
              client.executeMethod(postMethod)
              def resp = postMethod.getResponseBodyAsString()

              content = String.format("%s", event.getIssue().getDescription())
              msgBody = '[ message: [ type: "PasteMessage", body: ' + content + '] ]'


              postMethod.setRequestBody(content)
              client.executeMethod(postMethod)
              resp = postMethod.getResponseBodyAsString()

              break
        }
    }
}
