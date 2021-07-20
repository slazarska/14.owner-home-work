### How to run with terminal commands
Remote run for web config using file
```bash
gradle clean test --tests WebTests -Dstage=remote
```
Local run for web config using file
```bash
gradle clean test --tests WebTests -Dstage=local
```

For api config using system properties
```bash
gradlew clean -Dbase.url=localhost -Dtoken=token23 test --tests "tests.ApiConfigTests"
```

For api config using file
```bash
gradlew clean  test --tests "tests.ApiConfigTests"
```