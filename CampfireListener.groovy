/*
* Copyright (c) 2012 Steve Stodola
*
* Permission is hereby granted, free of charge, to any person obtaining a copy 
* of this software and associated documentation files (the "Software"), to deal 
* in the Software without restriction, including without limitation the rights 
* to use, copy, modify, merge, publish, distribute, sublicense, and/or sell 
* copies of the Software, and to permit persons to whom the Software is
* furnished to do so, subject to the following conditions:
*
* The above copyright notice and this permission notice shall be included in 
* all copies or substantial portions of the Software.
*
* THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
* IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
* FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL
* THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
* LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
* OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
* THE SOFTWARE.
*/

package org.plytro.jira.Listener

import static com.atlassian.jira.event.type.EventType.*

import com.atlassian.jira.event.issue.AbstractIssueEventListener
import com.atlassian.jira.event.issue.IssueEvent

import org.apache.log4j.Category

import org.apache.commons.httpclient.HttpClient
import org.apache.commons.httpclient.UsernamePasswordCredentials
import org.apache.commons.httpclient.auth.AuthScope
import org.apache.commons.httpclient.methods.PostMethod

class CampfireListener extends AbstractIssueEventListener {
    def Category log = Category.getInstance("com.onresolve.jira.groovy.PostFunction")

    // Your campfire API key
    String campfireKey = "YOUR KEY GOES HERE"
    // The room you want to post to in numeric format 
    String campfireRoom = "000000"
    // The base url for your campfire instance
    // https://COMPANY.campfirenow.com/
    String campfireBaseUrl = "https://COMPANY.campfirenow.com/"
    // Jira base url for browsing 
    // https://jira.COMPANY.com/browse
    String issueBaseUrl = "https://jira.COMPANY.com/browse/"

    String speakUrlPath = "speak.json"

    @Override
    void workflowEvent(IssueEvent event) {
      processIssueEvent(event)
    }

    // This is so testing with return values can be done
    String processIssueEvent(IssueEvent event){
        def campfireUrl = campfireBaseUrl + "room/" + campfireRoom + "/"
        def campfireSpeakUrl = campfireUrl + speakUrlPath
        def httpClient = new HttpClient()
        def authScope = new AuthScope(AuthScope.ANY_HOST, 443)
        def upc = new UsernamePasswordCredentials(campfireKey, "X")
        httpClient.getState().setCredentials(authScope, upc)
        httpClient.getParams().setAuthenticationPreemptive(true)

        switch (event.getEventTypeId()) {
            case ISSUE_COMMENTED_ID:
              def content = String.format("%s added a comment to %s (%s%s):",
                              event.user.displayName,
                              event.issue.key,
                              issueBaseUrl,
                              event.issue.key)

              def msgBody = '{ "message": { "type": "TextMessage", "body": "' + content + '"} }'
              campfirePost(campfireSpeakUrl, msgBody, httpClient)

              content = String.format("%s", event.comment.body)
              msgBody = '{ "message": { "type": "PasteMessage", "body": "' + content + '"} }'

              campfirePost(campfireSpeakUrl, msgBody, httpClient)

              break
            case ISSUE_CREATED_ID:
              def content = String.format("%s created a new issue: %s (%s%s):",
                              event.user.displayName,
                              event.issue.summary,
                              issueBaseUrl,
                              event.issue.key)

              def msgBody = '{ "message": { "type": "TextMessage", "body": "' + content + '"} }'

              campfirePost(campfireSpeakUrl, msgBody, httpClient)

              content = String.format("%s", event.issue.description)
              msgBody = '{ "message": { "type": "PasteMessage", "body": "' + content + '"} }'

              campfirePost(campfireSpeakUrl, msgBody, httpClient)

              break
        }
    }

    void campfirePost(String campfireSpeakUrl, String content, HttpClient httpClient){
        PostMethod postMethod = new PostMethod(campfireSpeakUrl)
        postMethod.setDoAuthentication(true)
        postMethod.setRequestHeader("Content-Type", "application/json")
      
        postMethod.setRequestBody(content)
        def respCode = httpClient.executeMethod(postMethod)
        def resp = postMethod.getResponseBodyAsString()
        postMethod.releaseConnection();
    }
}
