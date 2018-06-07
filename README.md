# pullRequestRetriever
Simple Retriever of open pull requests in Bitbucket repositories, written on java - 31.05.18 - 7.06.18

# How To Use
1. Run the program
2. Type name of Bitbucket repository
3. Type name of owner this repository
4. Check out the list of pull requests
5. Answer a question. If you want to check reviewers, type "yes"
6. Type username of reviewer
7. Check out the list of PRs, where given user is reviewer
8. If you want check more reviewers repeat steps 5, 6, 7. If "no", type "no" and end program.

# External Libraries
In this project I have used "json-simple" library as simple .jar file.
Download please this jar file from the master branch and connect it.

To parse Json we need external libraries and dependencies. It is almost impossible to do it with built-in tools. Probably somehow it could be done, but it would be like unjustified and meaningless code complication. 

# Sources 
1. API Butbucket Documentation
https://developer.atlassian.com/bitbucket/api/2/reference/resource/repositories/%7Busername%7D/%7Brepo_slug%7D/pullrequests/%7Bpull_request_id%7D

2. Json Simple Library Documentation
https://code.google.com/archive/p/json-simple/

3. Beautifier of Json File
https://jsonlint.com/

4. Stackoverflow and many other websites and forums.
