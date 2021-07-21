### How to run with terminal commands
Remote run for web config using file
```bash
gradle clean test --tests WebTests -Dstage=remote
```
Local run for web config using file
```bash
gradle clean test --tests WebTests -Dstage=local
```

Run for api config using system properties
```bash
gradle clean test --tests ApiTests -Dbase.url=localhost -Dtoken=12345
```

Run for api config using file
```bash
gradle clean test --tests ApiTests
```