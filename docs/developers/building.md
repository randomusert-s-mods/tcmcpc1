# Building
This guide shows how to compile from source.

## requirements
- JDK 21
- git


## getting the source
You need to clone the repository before you can compile.

In this guide we will use the git CLI.

```shell
git clone https://github.com/randomusert-s-mods/tcmcpc1.git
```
 
## compiling
You must have JDK 21 installed on your system before continuing. It MUST be JDK NOT JRE!

to compile go to the directory where you cloned the repo.

after that you should have a terminal open.

On windows you might be using command prompt, it is pretty much the same but without `.\`

running gradlew:

```shell
.\gradlew build
```

it might take few minutes to start doing the compilejava task.