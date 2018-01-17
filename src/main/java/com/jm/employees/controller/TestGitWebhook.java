package com.jm.employees.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jm.utils.R;


/**
 * 
 * 
 * @author James.Mai
 * @email mjl_workhard@163.com
 */
@RestController
@RequestMapping("webhook")
public class TestGitWebhook {
	
	/**
	 * 列表
	 */
	@RequestMapping("/invoke")
	public R invoke(HttpServletRequest request){
		String headers = getHeadersInfo(request);
		String content = "";
		try {
			content = getJsonContent(request);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("headers: "+headers);
		System.out.println("content: "+content);
		
		return R.ok();
	}
	
	public String getJsonContent(HttpServletRequest request) throws IOException{
		InputStream is = request.getInputStream();
		//ByteOutputStream bos = new ByteOutputStream();
		ByteArrayOutputStream baos = new ByteArrayOutputStream(); 
		byte[] data = new byte[1024];
		int i=0;
		while((i = is.read(data)) != -1)
		{
			baos.write(data, 0, i);
		}
		
		return baos.toString("utf-8");
	}
	
	public String getHeadersInfo(HttpServletRequest request) {
		StringBuffer sb = new StringBuffer();
	    Enumeration headerNames = request.getHeaderNames();
	    while (headerNames.hasMoreElements()) {
	        String key = (String) headerNames.nextElement();
	        String value = request.getHeader(key);
	        sb.append(key+":"+ value).append("\n");
	    }
	    return sb.toString();
	  }
//	结果
//	headers: host:webhook
//	connection:close
//	content-length:7323
//	accept:*/*
//	user-agent:GitHub-Hookshot/c494ff1
//	x-github-event:push
//	x-github-delivery:f9704d80-fb5b-11e7-8a29-07ef6b19ed6f
//	content-type:application/json
//	x-hub-signature:sha1=698e4771905d5503889256c148728d3666ebee29
//
//	content: {"ref":"refs/heads/master","before":"c7e51c2d29e07a66a4d61b7a566579f13de76d79","after":"848337fae25898407526443a0bc3955c8cb0ace0","created":false,"deleted":false,"forced":false,"base_ref":null,"compare":"https://github.com/JamesMai2007/Employees/compare/c7e51c2d29e0...848337fae258","commits":[{"id":"848337fae25898407526443a0bc3955c8cb0ace0","tree_id":"ffd8b0e3c97f1a7febe7dda931494f34f14fffff","distinct":true,"message":"port 8080","timestamp":"2018-01-17T15:56:46+08:00","url":"https://github.com/JamesMai2007/Employees/commit/848337fae25898407526443a0bc3955c8cb0ace0","author":{"name":"JamesMai2007","email":"mjl_workhard@163.com","username":"JamesMai2007"},"committer":{"name":"JamesMai2007","email":"mjl_workhard@163.com","username":"JamesMai2007"},"added":[],"removed":[],"modified":["src/main/resources/application.yml"]}],"head_commit":{"id":"848337fae25898407526443a0bc3955c8cb0ace0","tree_id":"ffd8b0e3c97f1a7febe7dda931494f34f14fffff","distinct":true,"message":"port 8080","timestamp":"2018-01-17T15:56:46+08:00","url":"https://github.com/JamesMai2007/Employees/commit/848337fae25898407526443a0bc3955c8cb0ace0","author":{"name":"JamesMai2007","email":"mjl_workhard@163.com","username":"JamesMai2007"},"committer":{"name":"JamesMai2007","email":"mjl_workhard@163.com","username":"JamesMai2007"},"added":[],"removed":[],"modified":["src/main/resources/application.yml"]},"repository":{"id":117481644,"name":"Employees","full_name":"JamesMai2007/Employees","owner":{"name":"JamesMai2007","email":"mjl_workhard@163.com","login":"JamesMai2007","id":18048454,"avatar_url":"https://avatars3.githubusercontent.com/u/18048454?v=4","gravatar_id":"","url":"https://api.github.com/users/JamesMai2007","html_url":"https://github.com/JamesMai2007","followers_url":"https://api.github.com/users/JamesMai2007/followers","following_url":"https://api.github.com/users/JamesMai2007/following{/other_user}","gists_url":"https://api.github.com/users/JamesMai2007/gists{/gist_id}","starred_url":"https://api.github.com/users/JamesMai2007/starred{/owner}{/repo}","subscriptions_url":"https://api.github.com/users/JamesMai2007/subscriptions","organizations_url":"https://api.github.com/users/JamesMai2007/orgs","repos_url":"https://api.github.com/users/JamesMai2007/repos","events_url":"https://api.github.com/users/JamesMai2007/events{/privacy}","received_events_url":"https://api.github.com/users/JamesMai2007/received_events","type":"User","site_admin":false},"private":false,"html_url":"https://github.com/JamesMai2007/Employees","description":null,"fork":false,"url":"https://github.com/JamesMai2007/Employees","forks_url":"https://api.github.com/repos/JamesMai2007/Employees/forks","keys_url":"https://api.github.com/repos/JamesMai2007/Employees/keys{/key_id}","collaborators_url":"https://api.github.com/repos/JamesMai2007/Employees/collaborators{/collaborator}","teams_url":"https://api.github.com/repos/JamesMai2007/Employees/teams","hooks_url":"https://api.github.com/repos/JamesMai2007/Employees/hooks","issue_events_url":"https://api.github.com/repos/JamesMai2007/Employees/issues/events{/number}","events_url":"https://api.github.com/repos/JamesMai2007/Employees/events","assignees_url":"https://api.github.com/repos/JamesMai2007/Employees/assignees{/user}","branches_url":"https://api.github.com/repos/JamesMai2007/Employees/branches{/branch}","tags_url":"https://api.github.com/repos/JamesMai2007/Employees/tags","blobs_url":"https://api.github.com/repos/JamesMai2007/Employees/git/blobs{/sha}","git_tags_url":"https://api.github.com/repos/JamesMai2007/Employees/git/tags{/sha}","git_refs_url":"https://api.github.com/repos/JamesMai2007/Employees/git/refs{/sha}","trees_url":"https://api.github.com/repos/JamesMai2007/Employees/git/trees{/sha}","statuses_url":"https://api.github.com/repos/JamesMai2007/Employees/statuses/{sha}","languages_url":"https://api.github.com/repos/JamesMai2007/Employees/languages","stargazers_url":"https://api.github.com/repos/JamesMai2007/Employees/stargazers","contributors_url":"https://api.github.com/repos/JamesMai2007/Employees/contributors","subscribers_url":"https://api.github.com/repos/JamesMai2007/Employees/subscribers","subscription_url":"https://api.github.com/repos/JamesMai2007/Employees/subscription","commits_url":"https://api.github.com/repos/JamesMai2007/Employees/commits{/sha}","git_commits_url":"https://api.github.com/repos/JamesMai2007/Employees/git/commits{/sha}","comments_url":"https://api.github.com/repos/JamesMai2007/Employees/comments{/number}","issue_comment_url":"https://api.github.com/repos/JamesMai2007/Employees/issues/comments{/number}","contents_url":"https://api.github.com/repos/JamesMai2007/Employees/contents/{+path}","compare_url":"https://api.github.com/repos/JamesMai2007/Employees/compare/{base}...{head}","merges_url":"https://api.github.com/repos/JamesMai2007/Employees/merges","archive_url":"https://api.github.com/repos/JamesMai2007/Employees/{archive_format}{/ref}","downloads_url":"https://api.github.com/repos/JamesMai2007/Employees/downloads","issues_url":"https://api.github.com/repos/JamesMai2007/Employees/issues{/number}","pulls_url":"https://api.github.com/repos/JamesMai2007/Employees/pulls{/number}","milestones_url":"https://api.github.com/repos/JamesMai2007/Employees/milestones{/number}","notifications_url":"https://api.github.com/repos/JamesMai2007/Employees/notifications{?since,all,participating}","labels_url":"https://api.github.com/repos/JamesMai2007/Employees/labels{/name}","releases_url":"https://api.github.com/repos/JamesMai2007/Employees/releases{/id}","deployments_url":"https://api.github.com/repos/JamesMai2007/Employees/deployments","created_at":1515979119,"updated_at":"2018-01-15T08:08:49Z","pushed_at":1516175810,"git_url":"git://github.com/JamesMai2007/Employees.git","ssh_url":"git@github.com:JamesMai2007/Employees.git","clone_url":"https://github.com/JamesMai2007/Employees.git","svn_url":"https://github.com/JamesMai2007/Employees","homepage":null,"size":63,"stargazers_count":0,"watchers_count":0,"language":"Java","has_issues":true,"has_projects":true,"has_downloads":true,"has_wiki":true,"has_pages":false,"forks_count":0,"mirror_url":null,"archived":false,"open_issues_count":0,"license":null,"forks":0,"open_issues":0,"watchers":0,"default_branch":"master","stargazers":0,"master_branch":"master"},"pusher":{"name":"JamesMai2007","email":"mjl_workhard@163.com"},"sender":{"login":"JamesMai2007","id":18048454,"avatar_url":"https://avatars3.githubusercontent.com/u/18048454?v=4","gravatar_id":"","url":"https://api.github.com/users/JamesMai2007","html_url":"https://github.com/JamesMai2007","followers_url":"https://api.github.com/users/JamesMai2007/followers","following_url":"https://api.github.com/users/JamesMai2007/following{/other_user}","gists_url":"https://api.github.com/users/JamesMai2007/gists{/gist_id}","starred_url":"https://api.github.com/users/JamesMai2007/starred{/owner}{/repo}","subscriptions_url":"https://api.github.com/users/JamesMai2007/subscriptions","organizations_url":"https://api.github.com/users/JamesMai2007/orgs","repos_url":"https://api.github.com/users/JamesMai2007/repos","events_url":"https://api.github.com/users/JamesMai2007/events{/privacy}","received_events_url":"https://api.github.com/users/JamesMai2007/received_events","type":"User","site_admin":false}}

}
