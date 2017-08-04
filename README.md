git add .
git commit -m "message"
git push origin feature_A

创建分支： $ git branch mybranch
切换分支： $ git checkout mybranch
创建并切换分支： $ git checkout -b mybranch origin/dev
合并分支：(merge from) $ git checkout master
                     $ git merge mybranch (merge from mybranch)
删除分支： $ git branch -d mybranch  注意：如果当前删除的分支有当前分支没有的点，则不能删除
强制本地删除分支： $ git branch -D mybranch
强制删除远程分支：$ git push origin:mybranch
将当前id所提交的内容合并到当前分支下：git cherry-pick id
cherry-pick 冲突解决：查看冲突的文件，解决冲突，add - commit 正常的流程提交，主要用于线上bug修复后当前分支拿到修复的点，目的是让当前的分支也有master分支的点

push：git push origin feature_A
pull：git pull origin feature_A

git tag version 给当前的commit打标签
git tag -a  version commitId  给任意节点打标签
git push origin version-name  推到服务器节点标签
git push origin --tags   将本地所有的标签都推到源端
git show version-name  查看标签内容
git tag  查看所有标签
git tag -d version-name 删除标签]
git checkout tag   切换到tag分支

git rebase -i HEAD~x  修改commit点的 （git rebase -i commitId,commitId为下一个点）
git commit --amend  修改commit信息，   直接输入为修改最后一个commitId信息
如果先git rebase -i commitId 中将pick设置为edit，退出 。 git commit --amend 为修改此时commitId的信息，最后记得 commit rebase --continue

git rebase 分支，将分支的内容rebase到当前的分支
git rebase --continue   确定修改
git rebase --abort   撤销修改
git cherry-pick commitId  一般是将master上修复的一些commitId点合并到本地开发这样在合代码的时候，master和当前的分支上都有这个点，不会造成冲突


.git文件目录
1.HEAD 文件中存放 。  当前checkout的分支
2.refs目录中 heads中存放了本地的分支，remotes中存放了远程分支 tags 存放了所有标签       stash存放git栈
3.git show-ref(中间空格，查看refs目录信息)


git创建分支：git branch branchName master .  从master分支创建branchName分支
git branch -m branchName branchName2  将branchName重命名为branchName2
git checkout

log命令
git log
git log --oneline   简单的图示
git log --graph   图表形式
git log --decorate 查看当前分支从哪个分支拉取
git branch -vv 。 查看当前分支从哪个分支拉取