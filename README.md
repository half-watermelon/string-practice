# a simple quiz code

## environments

build tools: Apache Maven 3.9.6

jdk: semeru-openj9 11.0.19+7

## test me

using JUnit test case or

```shell
mvn install
java -jar ./target/quiz-1.0-SNAPSHOT.jar abc123.456 cc123 2c.-3.1 3.21cc

outpus:
123.45
123.00
-3.10
failed to extract decimal from:3.21cc
```

