From https://help.github.com/articles/create-a-repo


git init
# Sets up the necessary Git files

# Initialized empty Git repository in /<>/.git/

git add <file>
# Stages your file, adding it to the list of files to be committed


git commit -m 'first commit'
# Commits your file, adding the message "first commit"

So far everything you've done has been in your local repository, meaning
you still haven't done anything on GitHub yet. To connect your local
repository to your GitHub account, you will need to set a remote for
your repo and push your commits to it:

git remote add origin https://github.com/<>.git
# Creates a remote named "origin" pointing at your GitHub repo

git push origin master
# Sends your commits in the "master" branch to GitHub

