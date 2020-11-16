# My code

## Branch

- vue-front:   Front-end code,about blogs management.

- springboot-back:   Back-end code.

- springboot2vue:   Intergrating the front end with the back end

## Clone

```bash
git clone [repositories_address]

git checkout [brancs_name]
```

## Commit

### commit local code

```bash
cd [code_directory]

git init 

git remote add origin [repositories_address]

git checkout -b [branch_name]

git add .

git commit -m [commit_infomation]

git push --set-upstream origin [branch_name]
```

### update commit message
```bash
cd [code_directory]

git commit --amend

//update your message directly
//then,save and exit

git push -f
```
